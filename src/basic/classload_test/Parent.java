package basic.classload_test;

public class Parent {
	public static int t = parentStaticMethod2();
	
	static {
		System.out.println("parent`s static block");
	}
	
	{
		System.out.println("parent`s init block");
	}
	
	public Parent() {
		System.out.println("parent`s gouzao block");
	}
	
	public static int parentStaticMethod2() {
		System.out.println("parent`s parentStaticMethod2()");
		return 9;
	}

	public static int parentStaticMethod() {
		System.out.println("parent`s parentStaticMethod()");
		return 3;
	}
	
}
