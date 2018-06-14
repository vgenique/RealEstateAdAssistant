package com.capgemini.imagereco.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class HiveApiFw implements IApiUtils<ApiParam> {
	private static final String DEF_USER = "default";
	protected String apiKey;
	protected String userProfilName;

	public HiveApiFw(String apiKey) {
		super();
		this.apiKey = apiKey;
		this.userProfilName = DEF_USER;
	}

	@Override
	public void detectLabels(ApiParam data, String directory) {
		// IApiUtils.super.detectLabels(data, directory);
		data.setFileNameList(this.setFilesPictureName(directory));
	}

	@Override
	public void detectLabels(ApiParam data) {
		if (data.getFileNames().size() > 0) {
			data.getFileNames().forEach((v) -> {
				this.processImages(v);

			});
		}
	}

	@Override
	public List<String> setFilesPictureName(String directory) {
		List<String> myList = new ArrayList<String>();
		File[] myDir = new File(directory).listFiles();
		for (File file : myDir) {
			if (file.isFile())
				myList.add(file.getAbsolutePath());
		}
		return myList;
	}

	/**
	 * Process images according differents api
	 * 
	 * @param apiKey
	 * @param imageFullName
	 */
	public abstract void processImages(String imageFullName);

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getUserProfilName() {
		return userProfilName;
	}

	public void setUserProfilName(String userProfilName) {
		this.userProfilName = userProfilName;
	}

}
