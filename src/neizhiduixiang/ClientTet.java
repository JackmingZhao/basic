package neizhiduixiang;

import java.util.ArrayList;
import java.util.List;

public class ClientTet {
	
	public static void main(String[] args) {
		// 对象引用一样
		List<String> list = NeizhiList.getList();
		list.add("4");
		list.add("5");
		list.add("6");
		System.out.println(NeizhiList.getList().toString());
	}

}
