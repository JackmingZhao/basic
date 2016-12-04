package basic.extends_test;

import java.util.HashMap;

public class ExtendsTestClient {

	public static void main(String[] args) {
		//子类重载父类的方法，调用的永远是父类的方法
		//子类的参数必须比父类的参数要宽或一样，这样就符合里氏替换原则
		/*Father fa = new Father();
		HashMap map = new HashMap();
		fa.test1(map);*/
		Son so = new Son();
		HashMap map = new HashMap();
		so.test1(map);
		
		System.out.println(6%2);
	}

}
