package com.cwg.utils;

import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

	public static Map<String, String> getKeyValues(String data) {

		Map<String, String> map = new HashMap<>();

		for (String testdata : data.split(";")) {
			String[] str = testdata.split("=");
			map.put(str[0], str[1]);
		}

		return map;

	}

}
