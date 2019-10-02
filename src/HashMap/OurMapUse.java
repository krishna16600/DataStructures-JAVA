
public class OurMapUse {

	public static void main(String[] args) {
		Map<String,Integer>map = new Map<>();
		for(int i=0;i<20;i++)
		{
			map.insert("abc" + i, 1+i);
			System.out.println("i = "+ i +" LF = "+ map.loadFactor() + " size "+ map.size());
		}
		map.removeKey("abc3");
		map.removeKey("abc7");
		for(int i=0;i<20;i++)
		{
			System.out.println("abc"+i+": "+map.getValue("abc" + i));
		}
		System.out.println(map.size());
	}
}
