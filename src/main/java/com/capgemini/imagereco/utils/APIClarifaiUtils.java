package com.capgemini.imagereco.utils;

import java.io.File;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;
import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Concept;

@Component("ClarifaiUtils")
public class APIClarifaiUtils extends HiveApiFw {
	

	private static String myApiKey = "a0434fa81193491194cc7878b65d74ec";
	
	public APIClarifaiUtils() {
		super(myApiKey);
	}

	public APIClarifaiUtils(String apiKey) {
		super(apiKey);
	}


	@Override
	public void detectLabels(ApiParam data, String directory) {
		super.detectLabels(data, directory);
		this.detectLabels(data);
	}

	
	@Override
	public void processImages(String imagePath) {
		ClarifaiClient client = new ClarifaiBuilder(super.getApiKey()).buildSync();
		try {
			List<ClarifaiOutput<Concept>> predictionResults = client.getDefaultModels().generalModel().predict()
					.withInputs(ClarifaiInput.forImage(new File(imagePath))).executeSync().get();

			System.out.println("CLARIFAI for picture : " + imagePath);
			for (ClarifaiOutput<Concept> prd : predictionResults) {
				List<Concept> conceptList = prd.data();
				conceptList.sort(new Comparator<Concept>() {
					@Override
					public int compare(Concept o1, Concept o2) {
						return (int) (o1.value()-o2.value());
					}
				});
				for (Concept cpt :conceptList) {
					System.out.println("label : " + cpt.name() + "- - - value : " + cpt.value());
				}
			}
		} catch (Exception e) {
			String[] errorMsg = e.getMessage().split(";");
			for (String ms : errorMsg) {
				System.out.println(ms);
			}

		} finally {
			System.out.println("Clarifai test performed");
		}
		
	}
}
