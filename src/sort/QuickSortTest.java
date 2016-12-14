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
//		quickSort(array, 0, array.length-1);
		quickSort2(array, 0, array.length-1);
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}
	
	private static void quickSort(int[] ary, int low, int high) {
		//进行递归排序，使用分治法找到基准点所在位置，然后再进行递归排序，当low不大于high时退出递归排序结束
		if(low < high) {
			int index = partion(ary, low, high);
			quickSort(ary, low, index-1);
			quickSort(ary, index+1, high);
		}
	}
	
	//分治法
	private static int partion(int[] ary, int low, int high) {
		int temp = ary[low];//基准点的数据，这相当于是一个坑
		while(low<high) {//循环条件是low不大于high
			while(low<high && ary[high]>=temp)//从右向左，如果找到小于基准点数据就挖个坑
				high--;
			if(low < high) {
				ary[low] = ary[high];//将这个小于基准数据赋值给之前挖的坑，（挖了一个high的坑）
				low++;
			}
			
			while(low<high && ary[low] < temp)//从左向右找，找到大于基准点的数据，然后挖坑
				low++;
			if(low < high) {
				ary[high] = ary[low];//将这个大于基准点值，赋值给之前挖的坑（挖了一个low的坑）
				high--;
			}
		}
		//退出时，将low=high，将这个坑填上，赋值temp
		ary[low]=temp;
		return low;
	}
	
	//将分治法和递归融合到一起了
	public static void quickSort2(int[] ary, int low, int high) {
		if(low<high) {
			int temp = ary[low], l=low, h=high;
			while(l<h) {
				while(l<h && ary[h]>=temp)
					h--;
				if(l < h) {
					ary[l] = ary[h];
					l++;
				}
				
				while(l<h && ary[l] < temp)
					l++;
				if(l < h) {
					ary[h] = ary[l];
					h--;
				}
			}
			ary[l]=temp;
			//l就是基准点现在的位置
			quickSort2(ary, low, l-1);
			quickSort2(ary, l+1, high);
		}
	}

}
