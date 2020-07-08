package com.lagm.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {

	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

	public static Map<String, String> getParameters(String url) {
		
		LOGGER.info("url: {}", url);
		Map<String, String> parameters = new HashMap<String, String>();

		if (url == null) {
			return parameters;
		}
		
		try {
			int index = url.indexOf("?");
			String strParameters = "";
			String[] arrayParameterValue;

			if (index != -1) {
				strParameters = url.substring(index + 1);
				LOGGER.info("strParameters: {}", strParameters);
				
				arrayParameterValue = strParameters.split("&");
				for (String parameterValue : arrayParameterValue) {
					parameters.put(parameterValue.split("=")[0], parameterValue.split("=")[1]);
				}

			}
		} catch (Exception e) {
			parameters = new HashMap<String, String>();
			LOGGER.error(e.getMessage(), e);
		}
		
		LOGGER.info("parameters: {}", parameters);
		return parameters;
	}
}
