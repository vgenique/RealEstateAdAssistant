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
	 * Testing values
	 * 
	 * @param data
	 */
	public void detectLabels(T data);

	/**
	 * Detect label for pictures found within a directory
	 * 
	 * @param data
	 * @param directory
	 */
	default void detectLabels(T data, String directory) {
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
