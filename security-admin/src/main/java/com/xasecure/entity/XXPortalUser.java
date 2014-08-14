package com.xasecure.entity;
/*
 * Copyright (c) 2014 XASecure
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * XASecure ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with XASecure
 */

/**
 * User details
 * 
 */

import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;
import com.xasecure.common.*;
import com.xasecure.entity.*;


@Entity
@Table(name="x_portal_user")
@XmlRootElement
public class XXPortalUser extends XXDBBase implements java.io.Serializable {
	private static final long serialVersionUID = 1L;



	/**
	 * First name of the user
	 * <ul>
	 * <li>The maximum length for this attribute is <b>1022</b>.
	 * </ul>
	 *
	 */
	@Column(name="FIRST_NAME"   , length=1022)
	protected String firstName;

	/**
	 * Last name of the user
	 * <ul>
	 * <li>The maximum length for this attribute is <b>1022</b>.
	 * </ul>
	 *
	 */
	@Column(name="LAST_NAME"   , length=1022)
	protected String lastName;

	/**
	 * Public screen name for the user
	 * <ul>
	 * <li>The maximum length for this attribute is <b>2048</b>.
	 * </ul>
	 *
	 */
	@Column(name="PUB_SCR_NAME"   , length=2048)
	protected String publicScreenName;

	/**
	 * Login ID of the user
	 * <ul>
	 * <li>The maximum length for this attribute is <b>767</b>.
	 * </ul>
	 *
	 */
	@Column(name="LOGIN_ID" , unique=true  , length=767)
	protected String loginId;

	/**
	 * <ul>
	 * <li>The maximum length for this attribute is <b>512</b>.
	 * </ul>
	 *
	 */
	@Column(name="PASSWORD"  , nullable=false , length=512)
	protected String password;

	/**
	 * Email address of the user
	 * <ul>
	 * <li>The maximum length for this attribute is <b>512</b>.
	 * </ul>
	 *
	 */
	@Column(name="EMAIL" , unique=true  , length=512)
	protected String emailAddress;

	/**
	 * Status of the user
	 * <ul>
	 * <li>This attribute is of type enum CommonEnums::ActivationStatus
	 * </ul>
	 *
	 */
	@Column(name="STATUS"  , nullable=false )
	protected int status = XAConstants.ACT_STATUS_DISABLED;

	/**
	 * Source of the user
	 * <ul>
	 * <li>This attribute is of type enum CommonEnums::UserSource
	 * </ul>
	 *
	 */
	@Column(name="USER_SRC"  , nullable=false )
	protected int userSource = XAConstants.USER_APP;

	/**
	 * Note
	 * <ul>
	 * <li>The maximum length for this attribute is <b>4000</b>.
	 * </ul>
	 *
	 */
	@Column(name="NOTES"   , length=4000)
	protected String notes;

	/**
	 * Default constructor. This will set all the attributes to default value.
	 */
	public XXPortalUser ( ) {
		status = XAConstants.ACT_STATUS_DISABLED;
		userSource = XAConstants.USER_APP;
	}

	@Override
	public int getMyClassType( ) {
	    return AppConstants.CLASS_TYPE_USER_PROFILE;
	}

	/**
	 * This method sets the value to the member attribute <b>firstName</b>.
	 * You cannot set null to the attribute.
	 * @param firstName Value to set member attribute <b>firstName</b>
	 */
	public void setFirstName( String firstName ) {
		this.firstName = firstName;
	}

	/**
	 * Returns the value for the member attribute <b>firstName</b>
	 * @return String - value of member attribute <b>firstName</b>.
	 */
	public String getFirstName( ) {
		return this.firstName;
	}

	/**
	 * This method sets the value to the member attribute <b>lastName</b>.
	 * You cannot set null to the attribute.
	 * @param lastName Value to set member attribute <b>lastName</b>
	 */
	public void setLastName( String lastName ) {
		this.lastName = lastName;
	}

	/**
	 * Returns the value for the member attribute <b>lastName</b>
	 * @return String - value of member attribute <b>lastName</b>.
	 */
	public String getLastName( ) {
		return this.lastName;
	}

	/**
	 * This method sets the value to the member attribute <b>publicScreenName</b>.
	 * You cannot set null to the attribute.
	 * @param publicScreenName Value to set member attribute <b>publicScreenName</b>
	 */
	public void setPublicScreenName( String publicScreenName ) {
		this.publicScreenName = publicScreenName;
	}

	/**
	 * Returns the value for the member attribute <b>publicScreenName</b>
	 * @return String - value of member attribute <b>publicScreenName</b>.
	 */
	public String getPublicScreenName( ) {
		return this.publicScreenName;
	}

	/**
	 * This method sets the value to the member attribute <b>loginId</b>.
	 * You cannot set null to the attribute.
	 * @param loginId Value to set member attribute <b>loginId</b>
	 */
	public void setLoginId( String loginId ) {
		this.loginId = loginId;
	}

	/**
	 * Returns the value for the member attribute <b>loginId</b>
	 * @return String - value of member attribute <b>loginId</b>.
	 */
	public String getLoginId( ) {
		return this.loginId;
	}

	/**
	 * This method sets the value to the member attribute <b>password</b>.
	 * You cannot set null to the attribute.
	 * @param password Value to set member attribute <b>password</b>
	 */
	public void setPassword( String password ) {
		this.password = password;
	}

	/**
	 * Returns the value for the member attribute <b>password</b>
	 * @return String - value of member attribute <b>password</b>.
	 */
	public String getPassword( ) {
		return this.password;
	}

	/**
	 * This method sets the value to the member attribute <b>emailAddress</b>.
	 * You cannot set null to the attribute.
	 * @param emailAddress Value to set member attribute <b>emailAddress</b>
	 */
	public void setEmailAddress( String emailAddress ) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Returns the value for the member attribute <b>emailAddress</b>
	 * @return String - value of member attribute <b>emailAddress</b>.
	 */
	public String getEmailAddress( ) {
		return this.emailAddress;
	}

	/**
	 * This method sets the value to the member attribute <b>status</b>.
	 * You cannot set null to the attribute.
	 * @param status Value to set member attribute <b>status</b>
	 */
	public void setStatus( int status ) {
		this.status = status;
	}

	/**
	 * Returns the value for the member attribute <b>status</b>
	 * @return int - value of member attribute <b>status</b>.
	 */
	public int getStatus( ) {
		return this.status;
	}

	/**
	 * This method sets the value to the member attribute <b>userSource</b>.
	 * You cannot set null to the attribute.
	 * @param userSource Value to set member attribute <b>userSource</b>
	 */
	public void setUserSource( int userSource ) {
		this.userSource = userSource;
	}

	/**
	 * Returns the value for the member attribute <b>userSource</b>
	 * @return int - value of member attribute <b>userSource</b>.
	 */
	public int getUserSource( ) {
		return this.userSource;
	}

	/**
	 * This method sets the value to the member attribute <b>notes</b>.
	 * You cannot set null to the attribute.
	 * @param notes Value to set member attribute <b>notes</b>
	 */
	public void setNotes( String notes ) {
		this.notes = notes;
	}

	/**
	 * Returns the value for the member attribute <b>notes</b>
	 * @return String - value of member attribute <b>notes</b>.
	 */
	public String getNotes( ) {
		return this.notes;
	}

	/**
	 * This return the bean content in string format
	 * @return formatedStr
	*/
	@Override
	public String toString( ) {
		String str = "XXPortalUser={";
		str += super.toString();
		str += "firstName={" + firstName + "} ";
		str += "lastName={" + lastName + "} ";
		str += "publicScreenName={" + publicScreenName + "} ";
		str += "loginId={" + loginId + "} ";
		str += "password={***length=" + (password == null? 0 : password.length()) + "***} ";
		str += "emailAddress={" + emailAddress + "} ";
		str += "status={" + status + "} ";
		str += "userSource={" + userSource + "} ";
		str += "notes={" + notes + "} ";
		str += "}";
		return str;
	}

	/**
	 * Checks for all attributes except referenced db objects
	 * @return true if all attributes match
	*/
	@Override
	public boolean equals( Object obj) {
		if ( !super.equals(obj) ) {
			return false;
		}
		XXPortalUser other = (XXPortalUser) obj;
        	if ((this.firstName == null && other.firstName != null) || (this.firstName != null && !this.firstName.equals(other.firstName))) {
            		return false;
        	}
        	if ((this.lastName == null && other.lastName != null) || (this.lastName != null && !this.lastName.equals(other.lastName))) {
            		return false;
        	}
        	if ((this.publicScreenName == null && other.publicScreenName != null) || (this.publicScreenName != null && !this.publicScreenName.equals(other.publicScreenName))) {
            		return false;
        	}
        	if ((this.loginId == null && other.loginId != null) || (this.loginId != null && !this.loginId.equals(other.loginId))) {
            		return false;
        	}
        	if ((this.password == null && other.password != null) || (this.password != null && !this.password.equals(other.password))) {
            		return false;
        	}
        	if ((this.emailAddress == null && other.emailAddress != null) || (this.emailAddress != null && !this.emailAddress.equals(other.emailAddress))) {
            		return false;
        	}
		if( this.status != other.status ) return false;
		if( this.userSource != other.userSource ) return false;
        	if ((this.notes == null && other.notes != null) || (this.notes != null && !this.notes.equals(other.notes))) {
            		return false;
        	}
		return true;
	}
	public static String getEnumName(String fieldName ) {
		if( fieldName.equals("status") ) {
			return "CommonEnums.ActivationStatus";
		}
		if( fieldName.equals("userSource") ) {
			return "CommonEnums.UserSource";
		}
		//Later TODO
		//return super.getEnumName(fieldName);
		return null;
	}

}
