package basic;

import java.math.BigDecimal;

public class Jingdong {
	
	public static void main(String[] args) {
		double t = 3*0.1;
		System.out.println(t);
		double a = 2.22;
		double b = 1.22;
		System.out.println(a+b);
		BigDecimal aa = new BigDecimal(Double.toString(1.22));
		BigDecimal bb = new BigDecimal(Double.toString(2.22));
		System.out.println(aa.add(bb));
		
		float f = 20014999;  
		double d = f;  
		double d2 = 20014999;  
		System.out.println("f=" + f);  
		System.out.println("d=" + d);  
		System.out.println("d2=" + d2); 
		
		long lf = Float.floatToIntBits(f);
		System.out.println(Long.toBinaryString(lf));
		long df = Double.doubleToLongBits(d2);
		System.out.println(Long.toBinaryString(df));
	}

}
