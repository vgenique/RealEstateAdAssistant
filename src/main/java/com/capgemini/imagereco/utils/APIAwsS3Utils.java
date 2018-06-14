package com.capgemini.imagereco.utils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.AmazonRekognitionException;
import com.amazonaws.services.rekognition.model.DetectLabelsRequest;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.S3Object;

public class APIAwsS3Utils extends HiveApiFw {
	
	private static String myApiKey = "";
	// Exception message about unreachable amazon content.
	private static final String ExceptionAmazonMsg = "Cannot load the credentials from the credential profiles file. "
			+ "Please make sure that your credentials file is at the correct "
			+ "location (/Users/userid/.aws/credentials), and is in a valid format.";
	private static final String bucketName = "photo_collection";
	private static AWSCredentials credentials;
	// Default profile to use
	private static String profileName = "default";

	public APIAwsS3Utils() {
		super(myApiKey);
	}

	public APIAwsS3Utils(String apiKey) {
		super(apiKey);
	}

	
	// Accessors
	public static AWSCredentials getCredentials() {
		return credentials;
	}

	public static void setCredentials(AWSCredentials credentials) {
		APIAwsS3Utils.credentials = credentials;
	}


	@Override
	public void detectLabels(ApiParam data, String directory) {
		super.detectLabels(data, directory);
		super.detectLabels(data);
	}

	@Override
	public void processImages(String imageFullName) {
		// Ensure credential retrieving is processing well.
		try {
			setCredentials(new ProfileCredentialsProvider(profileName).getCredentials());
		} catch (Exception e) {
			throw new AmazonClientException(ExceptionAmazonMsg, e);
		}
		// Define the client
		AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard()
				.withRegion(Regions.DEFAULT_REGION).withCredentials(new AWSStaticCredentialsProvider(credentials))
				.build();
		// Define the request
		DetectLabelsRequest request = new DetectLabelsRequest()
				.withImage(new Image().withS3Object(new S3Object().withName(imageFullName).withBucket(bucketName)))
				.withMaxLabels(10).withMinConfidence(75F);
		// Perform query
		try {
			DetectLabelsResult result = rekognitionClient.detectLabels(request);
			System.out.println("Detected labels for " + imageFullName);
			result.getLabels().forEach(lb -> {
				System.out.println(lb.getName() + " : " + lb.getConfidence().toString());
			});
		} catch (AmazonRekognitionException e) {
			String[] errorMsg = e.getMessage().split(";");
			for (String tt : errorMsg) {
				System.out.println(tt);
			}
			System.out.println(e.getErrorMessage());
		} finally {
			System.out.println("AWS query tested");
		}

	}

}
