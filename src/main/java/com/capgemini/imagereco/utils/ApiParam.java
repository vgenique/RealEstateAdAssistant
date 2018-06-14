package com.capgemini.imagereco.utils;

import java.util.ArrayList;
import java.util.List;

public class ApiParam implements IApiParam {

	private String nonAssigned = "NA";
	private String apiKey;
	private String userProfile;
	private String modelName;
	private List<String> fileNameList;

	public ApiParam(String apiKey, String userProfile, String modelName, List<String> fileNameList) {
		super();
		this.apiKey = apiKey;
		this.userProfile = userProfile;
		this.modelName = modelName;
		this.fileNameList = fileNameList;
	}

	@Override
	public String getApiKey() {
		return this.apiKey != null ? this.apiKey : this.nonAssigned;
	}

	@Override
	public String getUserProfile() {
		return this.userProfile != null ? this.userProfile : this.nonAssigned;
	}

	@Override
	public List<String> getFileNames() {
		return this.fileNameList != null ? this.fileNameList : new ArrayList<String>();
	}

	@Override
	public String getModelName() {
		return this.modelName != null ? this.modelName : this.nonAssigned;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public void setFileNameList(List<String> fileNameList) {
		this.fileNameList = fileNameList;
	}

}
