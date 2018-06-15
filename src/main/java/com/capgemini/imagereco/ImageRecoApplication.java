package com.capgemini.imagereco;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.imagereco.utils.ApiParam;
import com.capgemini.imagereco.utils.APIClarifaiUtils;
import com.capgemini.imagereco.utils.APIWatsonVisionUtils;
import com.capgemini.imagereco.utils.HiveApiFw;
import com.capgemini.imagereco.utils.APIAwsS3Utils;
import com.capgemini.imagereco.utils.APIAzurVision;

@SpringBootApplication
public class ImageRecoApplication {

	private static HiveApiFw s3Utils;
	private static HiveApiFw clarifaiUtils;
	private static APIWatsonVisionUtils ibmWatsonUtils;
	private static APIAzurVision azurVision;

	public static void main(String[] args) {
		SpringApplication.run(ImageRecoApplication.class, args);
		// Define global variables
		String directory = "C:\\Users\\jbayitou\\Documents\\myCap\\WORKING_DOC\\RUCHE\\to_skill\\airport";
		ApiParam myData = new ApiParam("", "", "", new ArrayList<String>());
		// Init APIs
		s3Utils = new APIAwsS3Utils();
		clarifaiUtils = new APIClarifaiUtils();
		ibmWatsonUtils = new APIWatsonVisionUtils();
		azurVision = new APIAzurVision();
		// Test APIs
		// s3Utils.execImageApiQuery(directory, myData);
		clarifaiUtils.execImageApiQuery(directory, myData);
		// ibmWatsonUtils.execImageApiQuery(directory, myData);
		// azurVision.execImageApiQuery(directory, myData);
	}

}
