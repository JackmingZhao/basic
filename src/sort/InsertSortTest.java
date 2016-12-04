package sort;

import java.util.Arrays;

public class InsertSortTest {
	
	/**
	 * ʱ�临�Ӷ�Ϊ��O(n^2)
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = SortFather.getArray(10);
		System.out.println("ԭʼ���飺" + Arrays.toString(array));
//		dosort(array);
//		System.out.println("����֮�����飺" + Arrays.toString(array));
		optimalInsertSort(array);
		System.out.println("�Ż�����֮�����飺" + Arrays.toString(array));
	}
	
	public static void dosort(int[] array) {
		for(int i = 1; i <array.length;i++) {
			int temp = array[i]; //��¼�µ�ǰ����ڱ�ֵ
			int position = i; //��¼�ڱ���λ��
			for(int j = i-1;j>=0;j--) {//���ڱ���λ����ǰ�����Ѿ��ź����
				if(array[j]>temp) {//��������������ֻҪ�����ڱ���ֵ���ڱ���λ�þ���ǰ�ƶ�
					array[j+1] = array[j];
					position -= 1;//�ڱ�Ӧ���ڵ�λ��
				} else {
					break;//��������ڣ�ֱ������ѭ��
				}
			}
			
			array[position] = temp;//���ڱ������µ�λ��
			System.out.println("�仯���飺" + Arrays.toString(array));
		}
	}
	
	public static void optimalInsertSort(int[] array) {
		for(int i = 1; i <array.length;i++) {
			for(int j = i-1; j>=0 && array[j] > array[j+1]; j--) {
				int temp = array[j+1];
				array[j+1] = array[j];
				array[j] = temp;
			}
			System.out.println("�仯���飺" + Arrays.toString(array));
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
