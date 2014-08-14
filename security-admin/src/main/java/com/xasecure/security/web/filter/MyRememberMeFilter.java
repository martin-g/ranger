/**
 *
 */
package com.xasecure.security.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;

/**
 * 
 *
 */
@SuppressWarnings("deprecation")
public class MyRememberMeFilter extends RememberMeAuthenticationFilter {

    static Logger logger = Logger.getLogger(MyRememberMeFilter.class);

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.rememberme.
     * RememberMeAuthenticationFilter#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() {
	// TODO Auto-generated method stub
	super.afterPropertiesSet();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.rememberme.
     * RememberMeAuthenticationFilter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
	    FilterChain arg2) throws IOException, ServletException {
	// TODO Auto-generated method stub
	super.doFilter(arg0, arg1, arg2);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.rememberme.
     * RememberMeAuthenticationFilter#getRememberMeServices()
     */
    @Override
    public RememberMeServices getRememberMeServices() {
	// TODO Auto-generated method stub
	return super.getRememberMeServices();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.rememberme.
     * RememberMeAuthenticationFilter
     * #onSuccessfulAuthentication(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.Authentication)
     */
    @Override
    protected void onSuccessfulAuthentication(HttpServletRequest request,
	    HttpServletResponse response, Authentication authResult) {
	super.onSuccessfulAuthentication(request, response, authResult);
	// if (logger.isDebugEnabled()) {
	logger.info("onSuccessfulAuthentication() authResult=" + authResult);
	// }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.rememberme.
     * RememberMeAuthenticationFilter
     * #onUnsuccessfulAuthentication(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.AuthenticationException)
     */
    @Override
    protected void onUnsuccessfulAuthentication(HttpServletRequest request,
	    HttpServletResponse response, AuthenticationException failed) {
	logger.error("Authentication failure. failed=" + failed,
		new Throwable());
	super.onUnsuccessfulAuthentication(request, response, failed);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.rememberme.
     * RememberMeAuthenticationFilter
     * #setApplicationEventPublisher(org.springframework
     * .context.ApplicationEventPublisher)
     */
    @Override
    public void setApplicationEventPublisher(
	    ApplicationEventPublisher eventPublisher) {
	// TODO Auto-generated method stub
	super.setApplicationEventPublisher(eventPublisher);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.rememberme.
     * RememberMeAuthenticationFilter
     * #setAuthenticationManager(org.springframework
     * .security.authentication.AuthenticationManager)
     */
    @Override
    public void setAuthenticationManager(
	    AuthenticationManager authenticationManager) {
	// TODO Auto-generated method stub
	super.setAuthenticationManager(authenticationManager);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.rememberme.
     * RememberMeAuthenticationFilter
     * #setAuthenticationSuccessHandler(org.springframework
     * .security.web.authentication.AuthenticationSuccessHandler)
     */
    @Override
    public void setAuthenticationSuccessHandler(
	    AuthenticationSuccessHandler successHandler) {
	// TODO Auto-generated method stub
	super.setAuthenticationSuccessHandler(successHandler);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.rememberme.
     * RememberMeAuthenticationFilter
     * #setRememberMeServices(org.springframework.security
     * .web.authentication.RememberMeServices)
     */
    @Override
    public void setRememberMeServices(RememberMeServices rememberMeServices) {
	// TODO Auto-generated method stub
	super.setRememberMeServices(rememberMeServices);
    }

}
