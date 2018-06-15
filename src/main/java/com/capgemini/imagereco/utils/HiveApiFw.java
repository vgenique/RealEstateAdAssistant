package com.capgemini.imagereco.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public abstract class HiveApiFw implements IApiUtils<ApiParam> {
	private static final String DEF_USER = "default";
	protected static final Logger HiveApiFwLogger = Logger.getLogger(HiveApiFw.class.getName());
	protected String apiKey;
	protected String userProfilName;
	protected String apiName;

	public HiveApiFw(String apiKey) {
		super();
		this.apiKey = apiKey;
		this.userProfilName = DEF_USER;
	}

	@Override
	public boolean execImageApiQuery(String directory, ApiParam data) {
		boolean isSuccess = true;
		String myException = null;
		try {
			this.setLocalPictureList(data, directory);
			this.detectWebLabels(data);
		} catch (Exception e) {
			myException = e.getMessage();
			isSuccess = false;
		} finally {
			if (myException != null)
				HiveApiFw.HiveApiFwLogger.warning(myException);
		}

		return isSuccess;
	}

	@Override
	public void setLocalPictureList(ApiParam data, String directory) {
		data.setFileNameList(this.setFilesPictureName(directory));
	}

	@Override
	public void detectWebLabels(ApiParam data) {
		if (data.getFileNames().size() > 0) {
			data.getFileNames().forEach((v) -> {
				// Dedicated to specifics APIs
				this.processImages(v,data);
			});
		}
	}

	@Override
	public List<String> setFilesPictureName(String directory) {
		List<String> myList = new ArrayList<String>();
		try {
			File[] myDir = new File(directory).listFiles();
			for (File file : myDir) {
				if (file.isFile())
					myList.add(file.getAbsolutePath());
			}
		} catch (Exception e) {
			HiveApiFw.HiveApiFwLogger.warning(e.getMessage());
		}
		return myList;
	}

	/**
	 * Process images according differents api
	 * 
	 * @param apiKey
	 * @param imageFullName
	 */
	public abstract void processImages(String imageFullName,ApiParam data);

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

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	

}
