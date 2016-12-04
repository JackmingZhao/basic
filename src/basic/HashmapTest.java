package basic;

import java.util.HashMap;

public class HashmapTest {
	
	public static void main(String[] args) {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("a", 12);
		map.put("a", "34");
		System.out.println(map.get("a"));
		
		int initialCapacity = 9;
		int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1;
		System.out.println(capacity);
	}

}
