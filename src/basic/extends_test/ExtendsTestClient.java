package basic.extends_test;

import java.util.HashMap;

public class ExtendsTestClient {

	public static void main(String[] args) {
		//�������ظ���ķ��������õ���Զ�Ǹ���ķ���
		//����Ĳ�������ȸ���Ĳ���Ҫ���һ���������ͷ��������滻ԭ��
		/*Father fa = new Father();
		HashMap map = new HashMap();
		fa.test1(map);*/
		Son so = new Son();
		HashMap map = new HashMap();
		so.test1(map);
		
		System.out.println(6%2);
	}

}
