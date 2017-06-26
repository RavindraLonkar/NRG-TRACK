package com.nrg.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class CustomFileUtils<T> {

	Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	@SuppressWarnings("unchecked")
	public List<T> getMappedObjectList(String fileContent, T object, String headerString) {
		Map<String, String> map = null;
		List<T> dataList = new ArrayList<T>();

		String splitLines[] = fileContent.split("\\n");
		String splitHeader[] = headerString.split(",");

		for (int i = 0; i < splitLines.length; i++) {
			map = new HashMap<String, String>();
			String splitData[] = splitLines[i].split(",");
			for (int j = 0; j < splitData.length; j++) {
				map.put(splitHeader[j], splitData[j].trim());
			}

			Gson gson = new Gson();
			JsonElement json = gson.toJsonTree(map);
			object = (T) gson.fromJson(json, object.getClass());

			dataList.add(object);
		}
		return dataList;
	}

	public int getPrDay() {
		if (localCalendar.get(Calendar.DAY_OF_WEEK) == 1) {
			return 7;
		} else {
			return localCalendar.get(Calendar.DAY_OF_WEEK) - 1;
		}
	}

	public int getPrWeek() {
		return localCalendar.get(Calendar.WEEK_OF_YEAR);
	}

	public String getPrTime() {
		Date date = new Date();
		return timeFormat.format(date);
	}

	public String getDate() {
		Date date = new Date();
		return dateFormat.format(date);
	}

	public int getPrYear() {
		return Calendar.getInstance(TimeZone.getDefault()).get(Calendar.YEAR);
	}

	public int getYear(int pi_Week) {
		if (pi_Week >= 30 && pi_Week <= 52) {
			return Calendar.getInstance(TimeZone.getDefault()).get(Calendar.YEAR);
		} else {
			return Calendar.getInstance(TimeZone.getDefault()).get(Calendar.YEAR) - 1;
		}
	}

}
