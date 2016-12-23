package sort;

import java.util.Arrays;

public class SortFather {
	
	public static int[] getArray(int length) {
		int[] r = new int[length];
		for(int i=0;i<length;i++) {
			r[i]=getRandom1(20000);
		}
		return r;
	}
	
	private static int getRandom1(int max) {
		return (int)(Math.random()*max);
	}
	
	private static int getRandom(int max) {
		int[] a = {1, -1};
		int i = ((int)(Math.random()*100))%2;
		return (int)(Math.random()*max*a[i]);
	}
	
	public static void main(String[] args) {
		int i= (2+5)/2;
		System.out.println(i);
		int j = 5;
		System.out.println(j/=2);
		int[] r = getArray(20);
		System.out.println(Arrays.toString(r));
	}
	
}
