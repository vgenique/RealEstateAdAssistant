package com.capgemini.imagereco.utils;

import java.util.List;
import java.util.Map;

public interface IApiParam {

	/**
	 * Return API key to use.
	 * 
	 * @return
	 */
	public String getApiKey();

	/**
	 * Return profile user connected
	 * 
	 * @return
	 */
	public String getUserProfile();

	/**
	 * Contains names of all files proccessed
	 * 
	 * @return
	 */
	public List<String> getFileNames();

	/**
	 * Either called 'bucket' or 'model' retrieve the container name
	 * 
	 * @return
	 */
	public String getModelName();

	/**
	 * Retrieve error messages saved while processing
	 * 
	 * @return
	 */
	public List<String> getErrorMessage();

	/**
	 * Save labels and data retrieved per API
	 * 
	 * @return Map<API-name,DataSetLabels>
	 */
	public Map<String, List<Object>> getApiResult();
	
	/**
	 * Set value withing the existing Map
	 * @param apiName
	 * @param apiContent
	 */
	public void setApiResult(String apiName, Object apiContent);

}
