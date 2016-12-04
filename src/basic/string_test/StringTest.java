package basic.string_test;

public class StringTest {

	public static void main(String[] args) {
		String str = "qwe";
		//字符类的方法 length()
		int len = str.length();
		str = str + 100;
		//Type mismatch: cannot convert from int to String
		//类型不匹配：int不能转换为字符串
		//str = 100;
		
		//Invalid character constant 无效的字符常量
		//str += '  a';
	}
	
}
