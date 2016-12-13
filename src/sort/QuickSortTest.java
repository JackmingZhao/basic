package sort;

import java.util.Arrays;

public class QuickSortTest {
	
	public static void main(String[] args) {
		int[] array = SortFather.getArray(30000);
//		int[] array = {0, 16, 20, 3, 11, 17, 8};
//		System.out.println("ԭʼ���飺"+Arrays.toString(array));
		dosort(array);
//		System.out.println("��������飺"+Arrays.toString(array));
	}
	
	//��������ʹ�÷��η���ʹ��һ����׼���������ڵķ����ұߣ���С�ڵķ�����ߣ� ʱ�临�Ӷ�O(nlog2n)��4����
	public static void dosort(int[] array) {
		long start = System.currentTimeMillis();
		quickSort(array, 0, array.length-1);
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��" + (end - start) + "����");
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
