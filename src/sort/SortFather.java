package sort;

import java.util.Arrays;

public class SortFather {
	
	public static int[] getArray(int length) {
		int[] r = new int[length];
		for(int i=0;i<length;i++) {
			r[i]=getRandom(100);
		}
		return r;
	}
	
	private static int getRandom(int max) {
		int[] a = {1, -1};
		int i = ((int)(Math.random()*100))%2;
		return (int)(Math.random()*max*a[i]);
	}
	
	public static void main(String[] args) {
		int[] r = getArray(20);
		System.out.println(Arrays.toString(r));
	}
	
}
