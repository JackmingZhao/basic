package sort;

import java.util.Arrays;

public class SelectSortTest {
	
	public static void main(String[] args) {
		/**获取测试数组**/
		int[] array = SortFather.getArray(30000);
//		System.out.println("原始数组："+Arrays.toString(array));
		selectSortAsc(array);
	}
	
	//选择排序 时间复杂度O(n^2)  1200毫秒
	public static void selectSortAsc(int ary[]) {
		long start = System.currentTimeMillis();
		int n = ary.length, i, j, index;
		for (i = 0; i < n; i++) {
			index = i;//记录的是最小值得坐标
			for (j = i + 1; j < n; j++) {//依次与后边的数据相比较，只要遇到更小的值就记录
				if (ary[index] > ary[j])
					index = j;
			}
			//将最小值的坐标
			//第一轮找出一个最小放在这一轮循环的最前边
			//第一轮找出第一小的，第二轮找出第二小的，依次类推
			int temp = ary[i];
			ary[i] = ary[index];
			ary[index] = temp;
			//System.out.println(Arrays.toString(ary));
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}

}
