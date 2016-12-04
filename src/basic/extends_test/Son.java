package basic.extends_test;

import java.util.Map;

public class Son extends Father {
	
	public void test() {
		super.test();
		//super.test1(); 子类不能调用父类的private的属性或方法，可以调用protected修饰的属性或方法
	}

	@Override
	public void test3() {
		super.test3();
		System.out.println("son test3");
	}

	public void test1(Map a) {
		System.out.println("son map");
	}

}
