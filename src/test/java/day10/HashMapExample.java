package day10;

import java.util.HashMap;

public class HashMapExample {

	
	public static HashMap<String, String> getLoginInfo()
	{
		HashMap<String, String> usermap = new HashMap<String, String>();
		usermap.put("admin", "Admin_admin123");
		usermap.put("ESS", "Dixit_admin123");
		return usermap;
		
	}
}
