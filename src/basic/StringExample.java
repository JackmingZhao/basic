package basic;

public class StringExample {

	int n = 5;
	String str = "good";
	char[] ch = { 'a', 'b', 'c' };
	
	private String value = "value";

	public static void main(String[] args) {
		StringExample value1 = new StringExample();
		System.out.println("Before modify, HashCode = " + value1.hashCode() + ", value = " + value1.getValue()); 
		newValue(value1);
		System.out.println("After modify, HashCode = " + value1.hashCode() + ", value = " + value1.getValue() + "\n"); 
		StringExample value2 = new StringExample();
		System.out.println("Before modify, HashCode = " + value2.hashCode() + ", value = " + value2.getValue()); 
		modifyValue(value2);
		System.out.println("After modify, HashCode = " + value2.hashCode() + ", value = " + value2.getValue() + "\n"); 
		System.out.println("\r\n=====================================================================\r\n");
		StringExample e = new StringExample();
		e.change(e.str, e.ch, e.n);
		System.out.print(7 + " and " + e.str + " and ");
		System.out.print(e.ch);
	}

	public void change(String str, char ch[], int m) {
		str = "test ok";
		ch[0] = 'g';
		n=m;
	}
	
	public static void newValue(StringExample value) {
		value = new StringExample();
		value.setValue("new value");
		System.out.println("In newValue, HashCode = " + value.hashCode() + ", value = " + value.getValue());
	}
	
	public static void modifyValue(StringExample value) {
		value.setValue("modify vlaue");
		System.out.println("In modifyValue, HashCode = " + value.hashCode() + ", value = " + value.getValue()); 
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
