package basic.classload_test;

public class Child extends Parent {
	
	{
		System.out.println("child`s init block");
	}
	
	static {
		System.out.println("child`s static block");
	}
	
	public Child() {
		System.out.println("child`s gouzao block");
	}
	
	public int childStaticMethod() {
		System.out.println("child`s childStaticMethod()");
		return 8;		
	}

}
