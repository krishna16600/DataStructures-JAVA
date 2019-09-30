import java.util.HashMap;
import java.util.Set;

public class MapUse {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// insertion -> O(1)
		map.put("abc", 1);
		map.put("def", 2);

		// check presence -> O(1)
		if (map.containsKey("abc"))
			System.out.println("Has abc");
		
		//get value corresponding to a key -> O(1)
		int v = 0;
		if(map.containsKey("abc"))
		{
			v = map.get("abc");
		}
		System.out.println(v);
		
		
		//delete
		int s = map.remove("abc");
		System.out.println(s);
		
		//if contains value -> O(n)
		if(map.containsValue(2))
			System.out.println("has value");
		
	//printing
		Set<String> keys = map.keySet();
		for(String str: keys)
			System.out.println(str);
	}

}
