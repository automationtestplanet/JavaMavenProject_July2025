package com.automation.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginDetails {

		@JsonProperty("UserName")
		private String loginUserName;
		
		@JsonProperty("Password")
		private String loginPassword;

		public String getLoginUserName() {
			return loginUserName;
		}

		public String getLoginPassword() {
			return loginPassword;
		}
}
