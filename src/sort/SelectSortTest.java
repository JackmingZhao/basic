package sort;

import java.util.Arrays;

public class SelectSortTest {
	
	public static void main(String[] args) {
		/**��ȡ��������**/
		int[] array = SortFather.getArray(30000);
//		int[] array = {0, 16, 20, 3, 11, 17, 8};
//		System.out.println("ԭʼ���飺"+Arrays.toString(array));
//		selectSortAsc(array);
//		heapSortAsc(array);
		dualSelectAsc(array);
//		System.out.println("��������飺"+Arrays.toString(array));
	}
	
	//ѡ������ ʱ�临�Ӷ�O(n^2)  1200����
	public static void selectSortAsc(int ary[]) {
		int n = ary.length, i, j, index;
		long start = System.currentTimeMillis();
		for (i = 0; i < n; i++) {
			index = i;//��¼������Сֵ������
			for (j = i + 1; j < n; j++) {//�������ߵ�������Ƚϣ�ֻҪ������С��ֵ�ͼ�¼
				if (ary[index] > ary[j])
					index = j;
			}
			//����Сֵ������
			//��һ���ҳ�һ����С������һ��ѭ������ǰ��
			//��һ���ҳ���һС�ģ��ڶ����ҳ��ڶ�С�ģ���������
			int temp = ary[i];
			ary[i] = ary[index];
			ary[index] = temp;
			//System.out.println(Arrays.toString(ary));
		}
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��" + (end - start) + "����");
	}
	
	//������ʱ�临���O(nlogn), 8����
	public static void heapSortAsc(int array[]) {
		long start = System.currentTimeMillis();
		if (array == null || array.length <= 1) {
			return;
		}

		//�ȹ���������飬��֮���Ϊ���ѣ�����С�ѣ�
		//���Ѿ��ǹ���֮��ѵĶ����������������������
		buildMaxHeap(array);

		for (int i = array.length - 1; i >= 1; i--) {
			//����������֮�󣬽��Ѷ��ˣ�Ҳ���������һ�����ݣ������һ�����ݽ���λ�ã��������õ�һ�����������
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			//�����ѣ����ڴ�0-(i-1)��һ��������
			maxHeap(array, i, 0);
		}
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��" + (end - start) + "����");
	}

	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			//��(���-1)��ĵ�һ���ڵ㿪ʼѭ�����������ù���Ҷ�ڵ㲻������
			//ѭ����������е�ÿ��������������
			maxHeap(array, array.length, i);
		}
	}

	//�ڵ��£��ֱ�Ƚ����ӡ��Һ�����i�ڵ�˭���󣬴�������ڵ�
	private static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;//���ڵ�����ӽǱ�
		int right = index * 2 + 2;//���ڵ���Һ��ӽǱ�

		int largest = index;//��¼���Ľڵ㣬index�����ڵ�
		if (left < heapSize && array[left] > array[index]) {
			//������ӽǱ�С�����Ǳ겢�����Ӵ��ڸ��ڵ��ֵ��������ͻ���н���
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (index != largest) {
			int temp = array[index];
			array[index] = array[largest];
			array[largest] = temp;
			//���������������п��ܽ���֮����������������������
			maxHeap(array, heapSize, largest);
		}
	}
	
	//��Ԫѡ������ÿ���ҳ����˵����ֵ����Сֵ  997����
	public static void dualSelectAsc(int ary[]) {
		int n = ary.length, i, j, max, min;
		long start = System.currentTimeMillis();
		for(i =0; i<n/2; i++) {
			max=min=i;
			for(j=i; j<n-i; j++) {
				if(ary[j]<ary[min]) {
					min = j;
					//����С�˾Ͳ����ٱȽ��ǲ��������
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
		System.out.println("��ʱ��" + (end - start) + "����");
	}

}
