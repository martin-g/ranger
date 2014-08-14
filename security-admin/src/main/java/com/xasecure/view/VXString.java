package com.xasecure.view;
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
 * String
 * 
 */

import java.util.*;

import com.xasecure.common.*;
import com.xasecure.common.view.*;

import com.xasecure.common.*;
import com.xasecure.json.JsonDateSerializer;

import com.xasecure.view.*;

import javax.xml.bind.annotation.*;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonAutoDetect(getterVisibility=Visibility.NONE, setterVisibility=Visibility.NONE, fieldVisibility=Visibility.ANY)
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL )
@JsonIgnoreProperties(ignoreUnknown=true)
@XmlRootElement
public class VXString extends ViewBaseBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;


	/**
	 * Value
	 */
	protected String value;

	/**
	 * Default constructor. This will set all the attributes to default value.
	 */
	public VXString ( ) {
	}

	/**
	 * This method sets the value to the member attribute <b>value</b>.
	 * You cannot set null to the attribute.
	 * @param value Value to set member attribute <b>value</b>
	 */
	public void setValue( String value ) {
		this.value = value;
	}

	/**
	 * Returns the value for the member attribute <b>value</b>
	 * @return String - value of member attribute <b>value</b>.
	 */
	public String getValue( ) {
		return this.value;
	}

	@Override
	public int getMyClassType( ) {
	    return AppConstants.CLASS_TYPE_STRING;
	}

	/**
	 * This return the bean content in string format
	 * @return formatedStr
	*/
	public String toString( ) {
		String str = "VXString={";
		str += super.toString();
		str += "value={" + value + "} ";
		str += "}";
		return str;
	}
}
