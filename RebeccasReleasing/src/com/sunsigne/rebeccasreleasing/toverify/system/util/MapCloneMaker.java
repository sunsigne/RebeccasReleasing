package com.sunsigne.rebeccasreleasing.toverify.system.util;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MapCloneMaker {

	public static <K, V> Map<K, V> clone(Map<K, V> map) {

		Gson gson = new Gson();
		String jsonString = gson.toJson(map);
		 
		Type type = new TypeToken<HashMap<K, V>>(){}.getType();
		Map<K, V> clonedMap = gson.fromJson(jsonString, type); 

		return clonedMap;
	}

}
