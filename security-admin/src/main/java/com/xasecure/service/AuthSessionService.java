package com.xasecure.service;

import java.util.ArrayList;
import java.util.List;

import com.xasecure.common.XAConstants;
import com.xasecure.common.SearchCriteria;
import com.xasecure.common.SearchField;
import com.xasecure.common.SortField;
import com.xasecure.common.StringUtil;
import com.xasecure.common.db.BaseDao;
import com.xasecure.entity.XXAuthSession;
import com.xasecure.entity.XXPortalUser;
import com.xasecure.view.VXAuthSession;
import com.xasecure.view.VXAuthSessionList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class AuthSessionService extends
		AbstractBaseResourceService<XXAuthSession, VXAuthSession> {
	@Autowired
	StringUtil stringUtil;

	public static final String NAME = "AuthSession";

	public static final List<SortField> AUTH_SESSION_SORT_FLDS = new ArrayList<SortField>();
	static {
		AUTH_SESSION_SORT_FLDS.add(new SortField("id", "obj.id"));
		AUTH_SESSION_SORT_FLDS.add(new SortField("authTime", "obj.authTime",
				true, SortField.SORT_ORDER.DESC));
	}

	public static List<SearchField> AUTH_SESSION_SEARCH_FLDS = new ArrayList<SearchField>();
	static {
		AUTH_SESSION_SEARCH_FLDS.add(SearchField.createLong("id", "obj.id"));
		AUTH_SESSION_SEARCH_FLDS.add(SearchField.createString("loginId",
				"obj.loginId", SearchField.SEARCH_TYPE.PARTIAL,
				StringUtil.VALIDATION_LOGINID));
		AUTH_SESSION_SEARCH_FLDS.add(SearchField.createLong("userId",
				"obj.userId"));
		AUTH_SESSION_SEARCH_FLDS.add(SearchField.createEnum("authStatus",
				"obj.authStatus", "statusList", XXAuthSession.AuthStatus_MAX));
		AUTH_SESSION_SEARCH_FLDS.add(SearchField.createEnum("authType",
				"obj.authType", "Authentication Type",
				XXAuthSession.AuthType_MAX));
		AUTH_SESSION_SEARCH_FLDS.add(SearchField.createEnum("deviceType",
				"obj.deviceType", "Device Type", XAConstants.DeviceType_MAX));
		AUTH_SESSION_SEARCH_FLDS.add(SearchField.createString("requestIP",
				"obj.requestIP", SearchField.SEARCH_TYPE.PARTIAL,
				StringUtil.VALIDATION_IP_ADDRESS));
		AUTH_SESSION_SEARCH_FLDS.add(SearchField.createString(
				"requestUserAgent", "obj.requestUserAgent",
				SearchField.SEARCH_TYPE.PARTIAL, null));
		AUTH_SESSION_SEARCH_FLDS.add(new SearchField("firstName",
				"obj.user.firstName", SearchField.DATA_TYPE.STRING,
				SearchField.SEARCH_TYPE.PARTIAL));
		AUTH_SESSION_SEARCH_FLDS.add(new SearchField("lastName",
				"obj.user.lastName", SearchField.DATA_TYPE.STRING,
				SearchField.SEARCH_TYPE.PARTIAL));
		AUTH_SESSION_SEARCH_FLDS.add(SearchField.createString("requestIP",
				"obj.requestIP", SearchField.SEARCH_TYPE.PARTIAL,
				StringUtil.VALIDATION_IP_ADDRESS));	
		AUTH_SESSION_SEARCH_FLDS.add(new SearchField("startDate", "obj.createTime",
				SearchField.DATA_TYPE.DATE, SearchField.SEARCH_TYPE.GREATER_EQUAL_THAN));
		AUTH_SESSION_SEARCH_FLDS.add(new SearchField("endDate", "obj.createTime",
				SearchField.DATA_TYPE.DATE, SearchField.SEARCH_TYPE.LESS_EQUAL_THAN));
	}

	@Override
	protected String getResourceName() {
		return NAME;
	}

	@Override
	protected int getClassType() {
		return XAConstants.CLASS_TYPE_AUTH_SESS;
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected BaseDao<XXAuthSession> getDao() {
		return daoMgr.getXXAuthSession();
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected XXAuthSession createEntityObject() {
		return new XXAuthSession();
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected VXAuthSession createViewObject() {
		return new VXAuthSession();
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected void validateForCreate(VXAuthSession vXAuthSession) {
		logger.error("This method is not required and shouldn't be called.",
				new Throwable().fillInStackTrace());
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected void validateForUpdate(VXAuthSession vXAuthSession,
			XXAuthSession mObj) {
		logger.error("This method is not required and shouldn't be called.",
				new Throwable().fillInStackTrace());
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected XXAuthSession mapViewToEntityBean(VXAuthSession vXAuthSession,
			XXAuthSession t, int OPERATION_CONTEXT) {
		logger.error("This method is not required and shouldn't be called.",
				new Throwable().fillInStackTrace());
		return null;
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	protected VXAuthSession mapEntityToViewBean(VXAuthSession viewObj,
			XXAuthSession resource) {
		viewObj.setLoginId(resource.getLoginId());
		viewObj.setAuthTime(resource.getAuthTime());
		viewObj.setAuthStatus(resource.getAuthStatus());
		viewObj.setAuthType(resource.getAuthType());
		viewObj.setDeviceType(resource.getDeviceType());
		viewObj.setExtSessionId(resource.getExtSessionId());
		viewObj.setId(resource.getId());
		viewObj.setRequestIP(resource.getRequestIP());

		viewObj.setRequestUserAgent(resource.getRequestUserAgent());

		if (resource.getUserId() != null) {
			XXPortalUser gjUser = daoMgr.getXXPortalUser().getById(resource.getUserId());
			viewObj.setEmailAddress(gjUser.getEmailAddress());
			viewObj.setFamilyScreenName(gjUser.getEmailAddress());
			viewObj.setFirstName(gjUser.getFirstName());
			viewObj.setLastName(gjUser.getLastName());
			viewObj.setLastName(gjUser.getLastName());
			viewObj.setPublicScreenName(gjUser.getPublicScreenName());
			viewObj.setUserId(resource.getUserId());
		}

		return viewObj;
	}

	/**
	 * @param searchCriteria
	 * @return
	 */
	public VXAuthSessionList search(SearchCriteria searchCriteria) {
		VXAuthSessionList returnList = new VXAuthSessionList();
		List<VXAuthSession> viewList = new ArrayList<VXAuthSession>();

		List<XXAuthSession> resultList = searchResources(searchCriteria,
				AUTH_SESSION_SEARCH_FLDS, AUTH_SESSION_SORT_FLDS, returnList);

		// Iterate over the result list and create the return list
		for (XXAuthSession gjObj : resultList) {
			VXAuthSession viewObj = populateViewBean(gjObj);
			viewList.add(viewObj);
		}

		returnList.setVXAuthSessions(viewList);
		return returnList;
	}
}
