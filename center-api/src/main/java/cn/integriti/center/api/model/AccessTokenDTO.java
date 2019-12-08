package cn.integriti.center.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class AccessTokenDTO {

	@JsonProperty("access_token")
	private String accessToken;
	
	@JsonProperty("token_type")
	private String tokenType;
	
	
	@JsonProperty("expires_in")
	private Long expiresIn;
	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	public String getTokenType() {
		return tokenType;
	}


	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}


	public Long getExpiresIn() {
		return expiresIn;
	}


	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
}
