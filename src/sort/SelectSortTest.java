package sort;

import java.util.Arrays;

public class SelectSortTest {
	
	public static void main(String[] args) {
		/**��ȡ��������**/
		int[] array = SortFather.getArray(30000);
//		System.out.println("ԭʼ���飺"+Arrays.toString(array));
		selectSortAsc(array);
	}
	
	//ѡ������ ʱ�临�Ӷ�O(n^2)  1200����
	public static void selectSortAsc(int ary[]) {
		long start = System.currentTimeMillis();
		int n = ary.length, i, j, index;
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

}
