package neizhiduixiang;

import java.util.ArrayList;
import java.util.List;

public class NeizhiList {
	
	private static List<String> list = new ArrayList<String>();
	
	static {
		list.add("1");
		list.add("2");
		list.add("3");
	}

	public static List<String> getList() {
		return list;
	}

	public static void setList(List<String> list) {
		NeizhiList.list = list;
	}

}
