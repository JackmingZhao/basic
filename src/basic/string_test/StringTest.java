package basic.string_test;

public class StringTest {

	public static void main(String[] args) {
		String str = "qwe";
		//�ַ���ķ��� length()
		int len = str.length();
		str = str + 100;
		//Type mismatch: cannot convert from int to String
		//���Ͳ�ƥ�䣺int����ת��Ϊ�ַ���
		//str = 100;
		
		//Invalid character constant ��Ч���ַ�����
		//str += '  a';
	}
	
}
