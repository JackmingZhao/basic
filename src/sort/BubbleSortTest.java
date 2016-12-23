package sort;

import java.util.Arrays;

public class BubbleSortTest {
	
	public static void main(String[] args) {
//		int[] array = SortFather.getArray(30000);
		int[] array = {0, 16, 20, 3, 11, 17, 8, 21, 22, 23, 24, 25, 26};
		System.out.println("原始数组："+Arrays.toString(array));
//		bubbleSortAsc(array);
		bubbleSortAsc2(array);
		System.out.println("排序后数组："+Arrays.toString(array));
	}
	
	//冒泡排序  时间复杂度O(n^2)  2083毫秒
	public static void bubbleSortAsc(int[] ary) {
		long start = System.currentTimeMillis();
		for(int i = 0; i<ary.length; i++) {
			for(int j=1; j<ary.length-i; j++) {
				if(ary[j-1]>ary[j]) {
					int temp = ary[j-1];
					ary[j-1] = ary[j];
					ary[j] = temp;
				}
//				System.out.println(Arrays.toString(ary));
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}
	
	//2194毫秒
	public static void bubbleSortAsc2(int[] ary) {
		//设置一个标记，当没有发生交换的时候，说明排序已完成，后面的就不用再进行比较了
		boolean flag = true;
		int n = ary.length;
		long start = System.currentTimeMillis();
		while(flag) {
			flag = false;
			for(int j = 1; j<n; j++) {
				if(ary[j-1]>ary[j]) {
					int temp = ary[j-1];
					ary[j-1] = ary[j];
					ary[j] = temp;
					flag = true;
				}
			}
			n--;
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}

}
