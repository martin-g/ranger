/**
 *
 */
package com.xasecure.patch;

import java.text.DecimalFormat;
import java.util.Date;

import com.xasecure.common.DateUtil;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xasecure.util.CLIUtil;

/**
 * 
 *
 */
public abstract class BaseLoader {
    static Logger logger = Logger.getLogger(BaseLoader.class);

    long startTime =  DateUtil.getUTCDate().getTime();
    long lastTime = startTime;
    int countSoFar = 0;
    int countFromLastTime = 0;
    boolean moreToProcess = true;
    boolean firstCall = true;
    int batchSize = -1;
    DecimalFormat twoDForm = new DecimalFormat("#.00");

    public BaseLoader() {
    }

    public void init(int batchSize) throws Exception {
	this.batchSize = batchSize;
	CLIUtil cliUtil = (CLIUtil) CLIUtil.getBean(CLIUtil.class);
	cliUtil.authenticate();
    }

    public void init() throws Exception {
	init(-1);
    }

    abstract public void printStats();

    public abstract void execLoad();

    public void onExit() {
	logger.info("onExit()");
    }

    /**
     * @return the moreToProcess
     */
    public boolean isMoreToProcess() {
	return moreToProcess;
    }

    /**
     * @param moreToProcess
     *            the moreToProcess to set
     */
    public void setMoreToProcess(boolean moreToProcess) {
	this.moreToProcess = moreToProcess;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void load() {
	if (firstCall) {
	    startTime =  DateUtil.getUTCDate().getTime();
	    startProgressMonitor();
	    firstCall = false;
	}
	try {
	    execLoad();
	    if (batchSize < 0) {
		moreToProcess = false;
	    }
	} catch (Throwable t) {
	    logger.error("Error while loading data.", t);
	    moreToProcess = false;
	}
	if (!moreToProcess) {
	    long endTime =  DateUtil.getUTCDate().getTime();

	    logger.info("###############################################");
	    printStats();
	    logger.info("Loading completed!!!. Time taken="
		    + formatTimeTaken(endTime - startTime) + " for "
		    + countSoFar);
	    logger.info("###############################################");
	    synchronized (twoDForm) {
		twoDForm.notifyAll();
	    }

	}
    }

    public void startProgressMonitor() {
	Thread monitorThread = new Thread("Loader Monitor") {
	    @Override
	    public void run() {
		while (isMoreToProcess()) {
		    printStats();
		    try {
			synchronized (twoDForm) {
			    if (!isMoreToProcess()) {
				break;
			    }
			    twoDForm.wait(30 * 1000);
			}
			// Thread.sleep(60 * 1000);
		    } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		}
		logger.info("Monitor Thread exiting!!!");
	    }
	};
	monitorThread.setDaemon(true);
	monitorThread.start();

    }

    public String timeTakenSoFar(int lineCount) {
	countSoFar = lineCount;
	long currTime =  DateUtil.getUTCDate().getTime();
	String retStr = formatTimeTaken(currTime - startTime);
	if (currTime - startTime > 0 && countSoFar > 0) {
	    double rateSoFar = countSoFar * 1000 / (currTime - startTime);
	    retStr = retStr + " " + ". Rate so far for " + countSoFar + " is "
		    + twoDForm.format(rateSoFar);

	    if (currTime - lastTime > 0 && lineCount - countFromLastTime > 0) {
		double rateFromLastCall = (lineCount - countFromLastTime)
			* 1000.0 / (currTime - lastTime);
		retStr = retStr + ", Last "
			+ formatTimeTaken(currTime - lastTime) + " for "
			+ (lineCount - countFromLastTime) + " is "
			+ twoDForm.format(rateFromLastCall);
	    }

	}

	lastTime = currTime;
	countFromLastTime = countSoFar;
	return retStr;
    }

    String formatTimeTaken(long totalTime) {
	if (totalTime <= 0) {
	    return "0ms";
	}
	long ms = totalTime % 1000;
	String retValue = ms + "ms";

	totalTime = totalTime / 1000;
	if (totalTime > 0) {
	    long secs = totalTime % 60;
	    retValue = secs + "secs, " + retValue;

	    totalTime = totalTime / 60;
	    if (totalTime > 0) {
		long mins = totalTime % 60;
		retValue = mins + "mins, " + retValue;

		totalTime = totalTime / 60;
		if (totalTime > 0) {
		    long hrs = totalTime % 60;
		    retValue = hrs + "hrs, " + retValue;
		}
	    }
	}

	return retValue;

    }

    protected void print(int count, String message) {
	if (count > 0) {
	    logger.info(message.trim() + " : " + count);
	}
    }
}
