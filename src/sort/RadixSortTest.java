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
	 * 获得数字d第n位的数字 
	 * 例：d=3876465， n=6，d的第n位是：8
	 * **/
	public static int getDigit(int d, int n) {
		long start = System.currentTimeMillis();
		while ((--n) > 0) {// 位数每次递减，直至--n=0说明找到位置，使用--n，实际当n=1时，个位既是要找的位置
			d /= 10;// 每次除10，相当于每次从个为往前去掉1位
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start) + "毫秒");
		return d % 10;// 取10的模，如果是大于两位数字以上，那就是取的各位，如果是个位数，那就是本身
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

	// 获取某一数字的位数
	public static int digit(int d) {
		int digit = 0;
		while (d > 0) {
			digit++;
			d /= 10;
		}
		return digit;
	}

	public static void radixSort(int[] a) {
		int max = getMax(a);// 最大数
		int n = a.length;
		int digit = digit(max);// 最大数是几位数
		int[][] pdigit = new int[10][n];
		int[] order = new int[a.length];
		boolean hasNum = false;
		while (true) {
			if(!hasNum)
				break;
			hasNum = false;
			for (int i = 0; i < digit; i++) {
				for (int j = 0; j < n; j++) {
					int pos = getDigit(a[j], i);// 数据的第i位的数字
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
