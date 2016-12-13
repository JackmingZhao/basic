package sort;

import java.util.Arrays;

public class SelectSortTest {
	
	public static void main(String[] args) {
		/**获取测试数组**/
		int[] array = SortFather.getArray(30000);
//		int[] array = {0, 16, 20, 3, 11, 17, 8};
//		System.out.println("原始数组："+Arrays.toString(array));
//		selectSortAsc(array);
//		heapSortAsc(array);
		dualSelectAsc(array);
//		System.out.println("排序后数组："+Arrays.toString(array));
	}
	
	//选择排序 时间复杂度O(n^2)  1200毫秒
	public static void selectSortAsc(int ary[]) {
		int n = ary.length, i, j, index;
		long start = System.currentTimeMillis();
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
	
	//堆排序，时间复查度O(nlogn), 8毫秒
	public static void heapSortAsc(int array[]) {
		long start = System.currentTimeMillis();
		if (array == null || array.length <= 1) {
			return;
		}

		//先构建这个数组，将之变成为最大堆（或最小堆）
		//最大堆就是构建之后堆的顶端是这个数组里组大的数据
		buildMaxHeap(array);

		for (int i = array.length - 1; i >= 1; i--) {
			//构建成最大堆之后，将堆顶端（也就是数组第一个数据）与最后一个数据交换位置，这样最后得到一个升序的数组
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			//修正堆，现在从0-(i-1)不一定是最大堆
			maxHeap(array, i, 0);
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}

	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			//从(深度-1)层的第一个节点开始循环，避免无用功，叶节点不用修正
			//循环这个堆树中的每个子树都是最大堆
			maxHeap(array, array.length, i);
		}
	}

	//节点下，分别比较左孩子、右孩子与i节点谁更大，大的做父节点
	private static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;//父节点的左孩子角标
		int right = index * 2 + 2;//父节点的右孩子角标

		int largest = index;//记录最大的节点，index代表父节点
		if (left < heapSize && array[left] > array[index]) {
			//如果左孩子角标小于最大角标并且左孩子大于父节点的值，则次树就会进行交换
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (index != largest) {
			int temp = array[index];
			array[index] = array[largest];
			array[largest] = temp;
			//继续进行修正，有可能交换之后其他子树或整个树变了
			maxHeap(array, heapSize, largest);
		}
	}
	
	//二元选择排序，每次找出这趟的最大值和最小值  997毫秒
	public static void dualSelectAsc(int ary[]) {
		int n = ary.length, i, j, max, min;
		long start = System.currentTimeMillis();
		for(i =0; i<n/2; i++) {
			max=min=i;
			for(j=i; j<n-i; j++) {
				if(ary[j]<ary[min]) {
					min = j;
					//是最小了就不用再比较是不是最大了
					continue;
				}
				if(ary[j]>ary[max]) {
					max = j;
				}
			}
			int maxtemp = ary[max];
			int mintemp = ary[min];
			ary[min] = ary[i];
			ary[max] = ary[n-i-1];
			ary[i] = mintemp;
			ary[n-i-1] = maxtemp;
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}

}
