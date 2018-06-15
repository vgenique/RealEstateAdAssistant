package com.capgemini.imagereco.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.util.Arrays;

public class ApiParam implements IApiParam {

	private String nonAssigned = "NA";
	private String apiKey;
	private String userProfile;
	private String modelName;
	private List<String> fileNameList;
	private List<String> errorMsg;
	private Map<String, List<Object>> apiResult;

	public ApiParam(String apiKey, String userProfile, String modelName, List<String> fileNameList) {
		super();
		this.apiKey = apiKey;
		this.userProfile = userProfile;
		this.modelName = modelName;
		this.fileNameList = fileNameList;
		this.errorMsg = new ArrayList<String>();
		this.apiResult = new HashMap<String, List<Object>>();
	}

	@Override
	public void setApiResult(String apiName, Object apiContent) {
		if(this.apiResult.containsKey(apiName)) {
			this.apiResult.get(apiName).add(apiContent);
		}else {
			List<Object> myNewList = Arrays.asList(apiContent);
			this.apiResult.put(apiName, myNewList);
		}
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

	@Override
	public Map<String, List<Object>> getApiResult() {
		return this.apiResult;
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

	@Override
	public List<String> getErrorMessage() {
		return this.errorMsg;
	}

}
