package com.capgemini.imagereco.utils;

import java.util.List;

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

}
