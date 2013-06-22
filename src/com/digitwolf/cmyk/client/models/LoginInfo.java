package com.digitwolf.cmyk.client.models;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * Information about the current user
 * @author RyB
 *
 */
public class LoginInfo  implements IsSerializable{
	
	private static LoginInfo instance = null;
	   public LoginInfo() {
	      // Exists only to defeat instantiation.
	   }
	   public static LoginInfo getInstance() {	      
	      return instance;
	   }
	   
	   public static void setInstance(LoginInfo _instance) {	      
		      instance = _instance;
	}
	
	private boolean isLoggedIn;
	private boolean isAdmin;
	private String userId;
	private String email;
	private String login;
	private String domain;
	private String federatedIdentity;
	private String loginUrl;
	private String logoutUrl;
	
	/**
	 * @return the isLoggedIn
	 */
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	/**
	 * @param isLoggedIn the isLoggedIn to set
	 */
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * @return the federatedIdentity
	 */
	public String getFederatedIdentity() {
		return federatedIdentity;
	}
	/**
	 * @param federatedIdentity the federatedIdentity to set
	 */
	public void setFederatedIdentity(String federatedIdentity) {
		this.federatedIdentity = federatedIdentity;
	}
	/**
	 * @return the loginUrl
	 */
	public String getLoginUrl() {
		return loginUrl;
	}
	/**
	 * @param loginUrl the loginUrl to set
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}
	/**
	 * @return the logoutUrl
	 */
	public String getLogoutUrl() {
		return logoutUrl;
	}
	/**
	 * @param logoutUrl the logoutUrl to set
	 */
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}
	
	
}
