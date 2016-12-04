package basic.extends_test;

import java.util.HashMap;

public class Father {
	
	protected void test2() {
		System.out.println("protected funtion");
	}
	
	public void test() {
		System.out.println("public function");
	}
	
	public void test3() {
		System.out.println("father test3");
	}
	
	public void test1(HashMap a) {
		System.out.println("father hashmap");
	}

}
