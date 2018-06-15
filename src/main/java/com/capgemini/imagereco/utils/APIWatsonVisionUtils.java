package com.capgemini.imagereco.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.service.security.IamOptions.Builder;
import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

public class APIWatsonVisionUtils extends HiveApiFw {

	private static String myApiKey = "";
	private String versionDate = "2018-01-01";

	public APIWatsonVisionUtils() {
		super(myApiKey);
		this.setApiName("IBM_WATSON");
	}

	public APIWatsonVisionUtils(String apiKey) {
		super(apiKey);
		this.setApiName("IBM_WATSON");
	}

	@Override
	public void setLocalPictureList(ApiParam data, String directory) {
		super.setLocalPictureList(data, directory);
		super.detectWebLabels(data);
	}

	@Override
	public void processImages(String imageFullName, ApiParam data) {
		Builder myOptions = new IamOptions.Builder().apiKey(this.apiKey);
		VisualRecognition service = new VisualRecognition(this.versionDate, myOptions.build());
		try {
			File imagesStream = new File(imageFullName);
			List<String> owners = new ArrayList<String>();
			owners.add(super.getUserProfilName());
			ClassifyOptions classifyOpitons = new ClassifyOptions.Builder().imagesFile(imagesStream)
					.imagesFilename(imagesStream.getName()).threshold((float) 0.6).owners(owners).build();
			ClassifiedImages result = service.classify(classifyOpitons).execute();
			APIWatsonVisionUtils.HiveApiFwLogger.info("IBM WATSON DETAIL TEST");
			APIWatsonVisionUtils.HiveApiFwLogger.info(result.toString());
			data.setApiResult(this.getApiName(), result);
		} catch (FileNotFoundException e) {
			APIWatsonVisionUtils.HiveApiFwLogger.info(e.getMessage());
		} finally {
			APIWatsonVisionUtils.HiveApiFwLogger.info("IBM WATSON TEST OVER");
		}
	}

}
