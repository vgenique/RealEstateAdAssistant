package com.capgemini.imagereco.utils;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class APIAzurVision extends HiveApiFw {

	private static final String featureKey = "visualFeatures";
	private static final String featureVal = "Categories,Description,Color";
	private static final String langKey = "langage";
	private static final String langVal = "en";
	private static final String headerTypeKey = "Content-Type";
	private static final String headerTypeVal = "application/json";
	private static final String headerSubKey = "Ocp-Apim-Subscription-Key";
	private static final String urlPrefix = "{\"url\":\"";
	private static final String urlSuffix = "\"}";
	private static String myApiKey = "b93a62e86cb0458fbaf5339839fbbc15";
	private static String uriBase = "https://westcentralus.api.cognitive.microsoft.com/vision/v2.0/analyze";

	public APIAzurVision() {
		super(myApiKey);
	}

	public APIAzurVision(String apiKey) {
		super(apiKey);
	}
	

	@Override
	public void detectLabels(ApiParam data, String directory) {
		super.detectLabels(data, directory);
		super.detectLabels(data);
	}

	@Override
	public void processImages(String imageFullName) {
		// Init an http client
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
			// Define a query builder
			URIBuilder builder = new URIBuilder(APIAzurVision.uriBase);
			// Set request paramaters
			builder.setParameter(featureKey, featureVal);
			builder.setParameter(langKey, langVal);
			// Prepare the URI for the REST API call
			URI myUri = builder.build();
			// Prepare request
			HttpPost request = new HttpPost(myUri);
			// Set request headers
			request.setHeader(headerTypeKey, headerTypeVal);
			request.setHeader(headerSubKey, myApiKey);
			File tmpFile = new File(imageFullName);
			//TODO : Fix the issue with 'only use URL images
			String myUrlFile = tmpFile.toURI().toURL().toString();
			System.out.println(myUrlFile);
			// Set request body
			StringEntity requestEntity = new StringEntity(
					urlPrefix +myUrlFile+ urlSuffix);
			request.setEntity(requestEntity);
			
			// Make the REST API call and get the response entity
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String jsonStr = EntityUtils.toString(entity);
				System.out.println("AZUR VISION API TEST");
				System.out.println(jsonStr);
			}
		} catch (URISyntaxException e) {
			System.out.println(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// catch (JSONException e) {
		// System.out.println(e.getMessage());
		// }
		finally {
			System.out.println("AZUR TEST OVER");
		}

	}

}
