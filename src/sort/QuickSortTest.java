package sort;

import java.util.Arrays;

public class QuickSortTest {
	
	public static void main(String[] args) {
		int[] array = SortFather.getArray(30000);
//		int[] array = {0, 16, 20, 3, 11, 17, 8};
//		System.out.println("原始数组："+Arrays.toString(array));
		dosort(array);
//		System.out.println("排序后数组："+Arrays.toString(array));
	}
	
	//快速排序，使用分治法，使用一个基准数，将大于的放在右边，将小于的放在左边， 时间复杂度O(nlog2n)，4毫秒
	public static void dosort(int[] array) {
		long start = System.currentTimeMillis();
		quickSort(array, 0, array.length-1);
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}
	
	private static void quickSort(int[] ary, int low, int high) {
		if(low < high) {
			int index = partion(ary, low, high);
			quickSort(ary, low, index-1);
			quickSort(ary, index+1, high);
		}
	}
	
	private static int partion(int[] ary, int low, int high) {
		int temp = ary[low];
		while(low<high) {
			while(low<high && ary[high]>=temp)
				high--;
			if(low < high) {
				ary[low] = ary[high];
				low++;
			}
			
			while(low<high && ary[low] < temp)
				low++;
			if(low < high) {
				ary[high] = ary[low];
				high--;
			}
		}
		ary[low]=temp;
		return low;
	}

}
