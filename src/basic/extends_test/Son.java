package basic.extends_test;

import java.util.Map;

public class Son extends Father {
	
	public void test() {
		super.test();
		//super.test1(); ���಻�ܵ��ø����private�����Ի򷽷������Ե���protected���ε����Ի򷽷�
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
