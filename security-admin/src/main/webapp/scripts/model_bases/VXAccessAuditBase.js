/*
 * Copyright (c) 2014 XASecure
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * XASecure. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with XASecure.
 */

define(function(require){
	'use strict';	

	var XABaseModel	= require('models/XABaseModel');
	var XAGlobals	= require('utils/XAGlobals');

	var VXGroupBase = XABaseModel.extend(
	/** @lends VXGroupBase.prototype */
	{
		urlRoot: XAGlobals.baseURL + 'xusers/authSessions',
		
		defaults: {},

		serverSchema : {
			"id" : {
				"dataType" : "Long"
			},
			"version" : {
				"dataType" : "int"
			},
			"createDate" : {
				"dataType" : "Date"
			},
			"updateDate" : {
				"dataType" : "Date"
			},
			"permList" : {
				"dataType" : "list",
				"listType" : "VNameValue"
			},
			"forUserId" : {
				"dataType" : "Long"
			},
			"status" : {
				"dataType" : "int"
			},
			"priGrpId" : {
				"dataType" : "Long"
			},
			"updatedBy" : {
				"dataType" : "String"
			},
			"isSystem" : {
				"dataType" : "boolean"
			},
			"name" : {
				"dataType" : "String"
			},
			"description" : {
				"dataType" : "String"
			},
			"groupType" : {
				"dataType" : "int"
			},
			"credStoreId" : {
				"dataType" : "Long"
			}
		},
		
		
		idAttribute: 'id',

		/**
		 * VXGroupBase initialize method
		 * @augments XABaseModel
		 * @constructs
		 */
		initialize: function() {
			this.modelName = 'VXGroupBase';
		},
		getSession : function(extSessionId,options){
			var url = this.urlRoot  + '/' +'info?extSessionId='+extSessionId;
			
			options = _.extend({
			//	data : JSON.stringify(postData),
				contentType : 'application/json',
				dataType : 'json'
			}, options);

			return this.constructor.nonCrudOperation.call(this, url, 'GET', options);
		}

	}, {
		// static class members
	});

    return VXGroupBase;
	
});


