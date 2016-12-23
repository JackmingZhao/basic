package sort;

import java.util.Arrays;

public class BubbleSortTest {
	
	public static void main(String[] args) {
//		int[] array = SortFather.getArray(30000);
		int[] array = {0, 16, 20, 3, 11, 17, 8, 21, 22, 23, 24, 25, 26};
		System.out.println("ԭʼ���飺"+Arrays.toString(array));
//		bubbleSortAsc(array);
		bubbleSortAsc2(array);
		System.out.println("��������飺"+Arrays.toString(array));
	}
	
	//ð������  ʱ�临�Ӷ�O(n^2)  2083����
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
		System.out.println("��ʱ��" + (end - start) + "����");
	}
	
	//2194����
	public static void bubbleSortAsc2(int[] ary) {
		//����һ����ǣ���û�з���������ʱ��˵����������ɣ�����ľͲ����ٽ��бȽ���
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
		System.out.println("��ʱ��" + (end - start) + "����");
	}

}
