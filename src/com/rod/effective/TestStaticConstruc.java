package com.rod.effective;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class TestStaticConstruc {
	
	public static void main(String[] args) {
		Map<String, String> map = newInstance();
		map.put("key", "value");
		
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(map.get(key));
		}
	}

	public static <K,V> HashMap<K, V> newInstance() {
		return new HashMap<K, V>();
	}
}
