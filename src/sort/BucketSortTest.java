package sort;

import java.util.Arrays;

public class BucketSortTest {

	public static void main(String[] args) {
		/*
		 * int[] a = { 2, 4, 15, 11, 6, 3, 7, 19, 8, 5, 4 }; bucketSort(a, 19);
		 */
//		int[] data = SortFather.getArray(30000);
		int[] data = {2, 4, 15, 11, 6, 3, 7, 19, 8, 5, 47};
		System.out.println("排序前：" + Arrays.toString(data));
		radixSort(data, 10);
		System.out.println("排序后：" + Arrays.toString(data));
	}

	// 桶式排序函数
	// a是要排序的数组
	// max是最大数字（这里我们默认数字最小为0）
	public static void bucketSort(int[] ary, int max) {
		// 声明一个数组，这就是桶，编号从0到max的桶，一共max+1个
		int[] count = new int[max + 1];
		// 遍历数组，用桶计数
		for (int i = 0; i < ary.length; i++) {
			count[ary[i]]++;
		}
		// 将桶里面的数字倒出
		for (int i = max; i > 0; i--) {
			while (count[i] > 0) {
				System.out.print(i + " ");
				count[i]--;
			}
		}
	}

	public static void radixSort(int[] a, int d) {
		long start = System.currentTimeMillis();
		// n用来表示当前排序的是第几位
		int n = 1;
		// hasNum用来表示数组中是否有至少一个数字存在第n位
		boolean hasNum = false;
		// 二维数组temp用来保存当前排序的数字
		// 第一维d表示一共有d个桶
		// 第二维a.length表示每个桶最多可能存放a.length个数字
		int[][] temp = new int[d][a.length];
		int[] order = new int[d];
		while (true) {
			// 判断是否所有元素均无比更高位，因为第一遍一定要先排序一次，所以有n!=1的判断
			if (n != 1 && !hasNum) {
				break;
			}
			hasNum = false;
			// 遍历要排序的数组，将其存入temp数组中（按照第n位上的数字将数字放入桶中）
			for (int i = 0; i < a.length; i++) {
				int x = a[i] / (n * 10);
				if (x != 0) {
					hasNum = true;
				}
				int lsd = (x % 10);
				System.out.println("i="+i+";n="+n+";x="+x+";lsd="+lsd);
				temp[lsd][order[lsd]] = a[i];
				order[lsd]++;
			}
			// k用来将排序好的temp数组存入data数组（将桶中的数字倒出）
			int k = 0;
			for (int i = 0; i < d; i++) {
				if (order[i] != 0) {
					for (int j = 0; j < order[i]; j++) {
						a[k] = temp[i][j];
						k++;
					}
				}
				order[i] = 0;
			}
			n++;
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}

}
