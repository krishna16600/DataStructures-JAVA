import java.util.HashMap;

public class ExtractUniqueCharacters {

	public static String getUnique(String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String result = "";
		for (char ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				int freq = map.get(ch);
				freq++;
				map.put(ch, freq);

			} else {
				map.put(ch, 1);
				result += ch;
			}

		}
		return result;
	}

	public static void main(String[] args) {
		String str = "aabbczsddeass";
		System.out.println(getUnique(str));

	}
}
