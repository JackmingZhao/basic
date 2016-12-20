package sort;

import java.util.Arrays;

public class RadixSortTest {

	public static void main(String[] args) {
		// System.out.println(getDigit(1736496234, 6));
		int[] array = {243, 3, 125, 621, 1221, 45};
		// int max = getMax(array);
		// System.out.println(max);
//		System.out.println(digit(23445));
		System.out.println("����ǰ���飺"+Arrays.toString(array));
		radixSort(array);
		System.out.println("��������飺"+Arrays.toString(array));
	}

	/**
	 * �������d��nλ������ ����d=3876465�� n=6��d�ĵ�nλ�ǣ�8
	 * **/
	public static int getDigit(int d, int n) {
		while ((--n) > 0) {// λ��ÿ�εݼ���ֱ��--n=0˵���ҵ�λ�ã�ʹ��--n��ʵ�ʵ�n=1ʱ����λ����Ҫ�ҵ�λ��
			d /= 10;// ÿ�γ�10���൱��ÿ�δӸ�Ϊ��ǰȥ��1λ
		}
		return d % 10;// ȡ10��ģ������Ǵ�����λ�������ϣ��Ǿ���ȡ�ĸ�λ������Ǹ�λ�����Ǿ��Ǳ���
	}

	public static int getMax(int[] a) {
		int n = a.length;
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (i <= n / 2 && a[i] > max)
				max = a[i];
			if ((n - 1 - i) > n / 2 && a[n - 1 - i] > max)
				max = a[n - 1 - i];
		}
		return max;
	}

	// ��ȡĳһ���ֵ�λ��
	public static int digit(int d) {
		int digit = 0;
		while (d > 0) {
			digit++;
			d /= 10;
		}
		return digit;
	}

	/**
	 * ��������
	 * **/
	public static void radixSort(int[] a) {
		int max = getMax(a);// �����
		int n = a.length;
		int digit = digit(max);// ������Ǽ�λ��
		int c = 0;
		for (int i = 1; i <= digit; i++) {
			int[][] pdigit = new int[10][n];
			int[] order = new int[10];//��10λ��Ϊһ���������ȿ���λ���Ĵ�С��Ȼ����ʮλ��
			for (int j = 0; j < n; j++) {
				int pos = getDigit(a[j], i);// ���ݵĵ�iλ������
				//����ά���鸳ֵ
				//��ά������洢���ǵ�iλ�� 
				pdigit[pos][order[pos]++] = a[j];
			}

			for (int j = 0; j < 10; j++) {
				if (order[j] != 0) {
					for (int k = 0; k < order[j]; k++) {
						a[c++] = pdigit[j][k];
					}
				}
			}
			order = null;
			pdigit = null;
			c = 0;
		}
	}

}
