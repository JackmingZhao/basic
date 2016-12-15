package sort;

public class RadixSortTest {

	public static void main(String[] args) {
		// System.out.println(getDigit(1736496234, 6));
		// int[] array = {2, 4, 15, 11, 47, 6, 3, 7, 19, 8, 5};
		// int max = getMax(array);
		// System.out.println(max);
		System.out.println(digit(23445));
	}

	/**
	 * �������d��nλ������ 
	 * ����d=3876465�� n=6��d�ĵ�nλ�ǣ�8
	 * **/
	public static int getDigit(int d, int n) {
		long start = System.currentTimeMillis();
		while ((--n) > 0) {// λ��ÿ�εݼ���ֱ��--n=0˵���ҵ�λ�ã�ʹ��--n��ʵ�ʵ�n=1ʱ����λ����Ҫ�ҵ�λ��
			d /= 10;// ÿ�γ�10���൱��ÿ�δӸ�Ϊ��ǰȥ��1λ
		}
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��" + (end - start) + "����");
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

	public static void radixSort(int[] a) {
		int max = getMax(a);// �����
		int n = a.length;
		int digit = digit(max);// ������Ǽ�λ��
		int[][] pdigit = new int[10][n];
		int[] order = new int[a.length];
		boolean hasNum = false;
		while (true) {
			if(!hasNum)
				break;
			hasNum = false;
			for (int i = 0; i < digit; i++) {
				for (int j = 0; j < n; j++) {
					int pos = getDigit(a[j], i);// ���ݵĵ�iλ������
					pdigit[pos][order[pos]++] = a[j];
				}

				int c = 0;
				for (int j = 0; j < 10; j++) {
					if (order[j] != 0) {
						for (int k = 0; k < order[j]; k++) {
							a[c++] = pdigit[j][k];
						}
					}
				}
			}
		}
	}

}