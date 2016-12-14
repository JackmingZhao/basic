package sort;

import java.util.Arrays;
import java.util.Collections;

public class MergeSortTest {
	
	public static void main(String[] args) {
		/*int[] a = {1, 4, 6, 9};
		int[] b = {2, 3, 5, 7, 8};
		int[] c = new int[a.length+b.length];
		mergeArray(a, b, c);
		System.out.println("合并之后数组:"+Arrays.toString(c));*/
		
		int[] array = SortFather.getArray(30000);
//		int[] array = {0, 16, 20, 3, 11, 17, 8};
//		System.out.println("原始数组："+Arrays.toString(array));
		dosort(array);
//		System.out.println("排序后数组："+Arrays.toString(array));
	}
	
	/**
	 * 归并排序 时间复杂度O(nlog2n) 5毫秒
	 * 分治法的一种思想，将数组拆分成两个数组，将这两个数组分别排序（拆分排序这个过程是一个递归过程），之后再进行合并 ，称之为归并排序
	 * **/
	public static void dosort(int[] array) {
		long start = System.currentTimeMillis();
		int[] temp = new int[array.length];
		/**
		 * 这是递归拆分数组的过程
		 * temp为临时用于存储的数据，最后可以置空进行垃圾回收
		**/
		meagesort(array, 0, array.length-1, temp);
		temp=null;
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
	}
	
	private static void meagesort(int[] a, int first, int last, int[] temp) {
		/**
		 * 递归进行数组拆分，当拆分的两个数组只剩一个时，就能比较大小然后进行合并
		 * 拆分之后进行合并
		 * **/
		if(first < last) {
			int mid = (last+first)/2;
			meagesort(a, first, mid, temp);
			meagesort(a, mid+1, last, temp);
			merge(a, first, mid, last, temp);
		}
	}
	
	private static void merge(int[] a, int first, int mid, int last, int[] temp) {
		/**
		 * 合并数组，将要合并的数组赋值给临时数组，然后再覆盖之前的数组
		 * **/
		int i=first, j=mid+1, n=mid, m=last, k=0;
		while(i<=n && j<=m) {
			if(a[i]<=a[j])
				temp[k++]=a[i++];
			else
				temp[k++]=a[j++];
		}
		
		while(i<=n)
			temp[k++]=a[i++];
		while(j<=m)
			temp[k++]=a[j++];
		
		for(i=0;i<k;i++)
			a[first+i]=temp[i];
	}
	
	//将两个有序数组合并到一个新数组中
	public static void mergeArray(int[] a, int[] b, int[] c) {
		int i, j, k, n=a.length, m=b.length;
		i=j=k=0;
		while(i<n && j<m) {
			if(a[i]<b[j])
				c[k++]=a[i++];
			else
				c[k++]=b[j++];
		}
		
		while(i<n)
			c[k++]=a[i++];
		
		while(j<m)
			c[k++]=b[j++];
	}

}
