package sort;

import java.util.Arrays;

public class BucketSortTest {

	public static void main(String[] args) {
		/*
		 * int[] a = { 2, 4, 15, 11, 6, 3, 7, 19, 8, 5, 4 }; bucketSort(a, 19);
		 */
//		int[] data = SortFather.getArray(30000);
		int[] data = {2, 4, 15, 11, 6, 3, 7, 19, 8, 5, 47};
		System.out.println("����ǰ��" + Arrays.toString(data));
		radixSort(data, 10);
		System.out.println("�����" + Arrays.toString(data));
	}

	// Ͱʽ������
	// a��Ҫ���������
	// max��������֣���������Ĭ��������СΪ0��
	public static void bucketSort(int[] ary, int max) {
		// ����һ�����飬�����Ͱ����Ŵ�0��max��Ͱ��һ��max+1��
		int[] count = new int[max + 1];
		// �������飬��Ͱ����
		for (int i = 0; i < ary.length; i++) {
			count[ary[i]]++;
		}
		// ��Ͱ��������ֵ���
		for (int i = max; i > 0; i--) {
			while (count[i] > 0) {
				System.out.print(i + " ");
				count[i]--;
			}
		}
	}

	public static void radixSort(int[] a, int d) {
		long start = System.currentTimeMillis();
		// n������ʾ��ǰ������ǵڼ�λ
		int n = 1;
		// hasNum������ʾ�������Ƿ�������һ�����ִ��ڵ�nλ
		boolean hasNum = false;
		// ��ά����temp�������浱ǰ���������
		// ��һάd��ʾһ����d��Ͱ
		// �ڶ�άa.length��ʾÿ��Ͱ�����ܴ��a.length������
		int[][] temp = new int[d][a.length];
		int[] order = new int[d];
		while (true) {
			// �ж��Ƿ�����Ԫ�ؾ��ޱȸ���λ����Ϊ��һ��һ��Ҫ������һ�Σ�������n!=1���ж�
			if (n != 1 && !hasNum) {
				break;
			}
			hasNum = false;
			// ����Ҫ��������飬�������temp�����У����յ�nλ�ϵ����ֽ����ַ���Ͱ�У�
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
			// k����������õ�temp�������data���飨��Ͱ�е����ֵ�����
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
		System.out.println("��ʱ��" + (end - start) + "����");
	}

}
