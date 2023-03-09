package crm.vtiger.practice;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class Xyz {
	
	public static void main(String[] args) {
		Map<String, String> m=new HashedMap<>();
		m.put("a", "1");
		System.out.println(m.get("ab"));
	}
	
	
}
