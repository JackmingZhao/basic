package sort;

import java.util.Arrays;

public class InsertSortTest {
	
	/**
	 * 时间复杂度为：O(n^2)
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = SortFather.getArray(10);
		System.out.println("原始数组：" + Arrays.toString(array));
//		dosort(array);
//		System.out.println("排序之后数组：" + Arrays.toString(array));
		optimalInsertSort(array);
		System.out.println("优化排序之后数组：" + Arrays.toString(array));
	}
	
	public static void dosort(int[] array) {
		for(int i = 1; i <array.length;i++) {
			int temp = array[i]; //记录下当前这个哨兵值
			int position = i; //记录哨兵的位置
			for(int j = i-1;j>=0;j--) {//从哨兵的位置往前都是已经排好序的
				if(array[j]>temp) {//这里是升序排序，只要大于哨兵的值，哨兵的位置就往前移动
					array[j+1] = array[j];
					position -= 1;//哨兵应该在的位置
				} else {
					break;//如果不大于，直接跳出循环
				}
			}
			
			array[position] = temp;//将哨兵放入新的位置
			System.out.println("变化数组：" + Arrays.toString(array));
		}
	}
	
	public static void optimalInsertSort(int[] array) {
		for(int i = 1; i <array.length;i++) {
			for(int j = i-1; j>=0 && array[j] > array[j+1]; j--) {
				int temp = array[j+1];
				array[j+1] = array[j];
				array[j] = temp;
			}
			System.out.println("变化数组：" + Arrays.toString(array));
		}
	}
	
	public static int binarySearch(int[] array, int target, int from, int to) {
		int range = to-from;
		if(range>0) {
			int mid = (to+from)/2;
			if(array[mid]>target) {
				return binarySearch(array, target, from, mid + 1);
			} else {
				return binarySearch(array, target, mid + 1, to);
			}
		} else {
			if(array[from]>target) {
				return from;
			} else {
				return from + 1;
			}
		}
	}

}
