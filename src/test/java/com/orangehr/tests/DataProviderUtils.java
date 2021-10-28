package com.orangehr.tests;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cwg.utils.ExcelUtils;

public class DataProviderUtils {

	private static List<Map<String, String>> list = new ArrayList<>();

	public static Object[] getData(Method method) {
		List<Map<String, String>> data = new ArrayList<>();

		String testname = method.getName();
		if (list.isEmpty()) {
			list = ExcelUtils.getTestData("DATA");
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("TestCaseName").equalsIgnoreCase(testname)) {
				if (list.get(i).get("Execute").equalsIgnoreCase("yes")) {
					data.add(list.get(i));
				}
			}
		}

		list.removeAll(data);

		return data.toArray();
	}

}
