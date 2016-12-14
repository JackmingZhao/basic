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
//		quickSort(array, 0, array.length-1);
		quickSort2(array, 0, array.length-1);
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��" + (end - start) + "����");
	}
	
	private static void quickSort(int[] ary, int low, int high) {
		//���еݹ�����ʹ�÷��η��ҵ���׼������λ�ã�Ȼ���ٽ��еݹ����򣬵�low������highʱ�˳��ݹ��������
		if(low < high) {
			int index = partion(ary, low, high);
			quickSort(ary, low, index-1);
			quickSort(ary, index+1, high);
		}
	}
	
	//���η�
	private static int partion(int[] ary, int low, int high) {
		int temp = ary[low];//��׼������ݣ����൱����һ����
		while(low<high) {//ѭ��������low������high
			while(low<high && ary[high]>=temp)//������������ҵ�С�ڻ�׼�����ݾ��ڸ���
				high--;
			if(low < high) {
				ary[low] = ary[high];//�����С�ڻ�׼���ݸ�ֵ��֮ǰ�ڵĿӣ�������һ��high�Ŀӣ�
				low++;
			}
			
			while(low<high && ary[low] < temp)//���������ң��ҵ����ڻ�׼������ݣ�Ȼ���ڿ�
				low++;
			if(low < high) {
				ary[high] = ary[low];//��������ڻ�׼��ֵ����ֵ��֮ǰ�ڵĿӣ�����һ��low�Ŀӣ�
				high--;
			}
		}
		//�˳�ʱ����low=high������������ϣ���ֵtemp
		ary[low]=temp;
		return low;
	}
	
	//�����η��͵ݹ��ںϵ�һ����
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
			//l���ǻ�׼�����ڵ�λ��
			quickSort2(ary, low, l-1);
			quickSort2(ary, l+1, high);
		}
	}

}
