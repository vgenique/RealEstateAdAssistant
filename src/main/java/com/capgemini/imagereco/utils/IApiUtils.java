package com.capgemini.imagereco.utils;

import java.util.List;

/**
 * 
 * @author jbayitou
 *
 * @param <T>
 *            : Objects defining properties
 */
public interface IApiUtils<T extends IApiParam> {

	/**
	 * Main method to query for image analysis through API
	 * 
	 * @param directory
	 * @param data
	 * @return boolean : to ensure every process performed successfully
	 */
	public boolean execImageApiQuery(String directory, T data);

	/**
	 * Detect labels recover from api
	 * 
	 * @param data
	 */
	public void detectWebLabels(T data);

	/**
	 * Detect label for pictures found within a directory
	 * 
	 * @param data
	 * @param directory
	 */
	default void setLocalPictureList(T data, String directory) {
		System.out.println("Handling directory path too");
	};

	/**
	 * Read the dedicated folder containing files and init the collections with
	 * picture path
	 * 
	 * @param directory
	 * @return
	 */
	public List<String> setFilesPictureName(String directory);
	

}
