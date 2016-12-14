package sort;

import java.util.Arrays;
import java.util.Collections;

public class MergeSortTest {
	
	public static void main(String[] args) {
		/*int[] a = {1, 4, 6, 9};
		int[] b = {2, 3, 5, 7, 8};
		int[] c = new int[a.length+b.length];
		mergeArray(a, b, c);
		System.out.println("�ϲ�֮������:"+Arrays.toString(c));*/
		
		int[] array = SortFather.getArray(30000);
//		int[] array = {0, 16, 20, 3, 11, 17, 8};
//		System.out.println("ԭʼ���飺"+Arrays.toString(array));
		dosort(array);
//		System.out.println("��������飺"+Arrays.toString(array));
	}
	
	/**
	 * �鲢���� ʱ�临�Ӷ�O(nlog2n) 5����
	 * ���η���һ��˼�룬�������ֳ��������飬������������ֱ����򣨲���������������һ���ݹ���̣���֮���ٽ��кϲ� ����֮Ϊ�鲢����
	 * **/
	public static void dosort(int[] array) {
		long start = System.currentTimeMillis();
		int[] temp = new int[array.length];
		/**
		 * ���ǵݹ�������Ĺ���
		 * tempΪ��ʱ���ڴ洢�����ݣ��������ÿս�����������
		**/
		meagesort(array, 0, array.length-1, temp);
		temp=null;
		long end = System.currentTimeMillis();
		System.out.println("��ʱ��" + (end - start) + "����");
	}
	
	private static void meagesort(int[] a, int first, int last, int[] temp) {
		/**
		 * �ݹ���������֣�����ֵ���������ֻʣһ��ʱ�����ܱȽϴ�СȻ����кϲ�
		 * ���֮����кϲ�
		 * **/
		if(first < last) {
			int mid = (last+first)/2;
			meagesort(a, first, mid, temp);
			meagesort(a, mid+1, last, temp);
			merge(a, first, mid, last, temp);
		}
	}
	
	private static void merge(int[] a, int first, int mid, int last, int[] temp) {
		/**
		 * �ϲ����飬��Ҫ�ϲ������鸳ֵ����ʱ���飬Ȼ���ٸ���֮ǰ������
		 * **/
		int i=first, j=mid+1, n=mid, m=last, k=0;
		while(i<=n && j<=m) {
			if(a[i]<=a[j])
				temp[k++]=a[i++];
			else
				temp[k++]=a[j++];
		}
		
		while(i<=n)
			temp[k++]=a[i++];
		while(j<=m)
			temp[k++]=a[j++];
		
		for(i=0;i<k;i++)
			a[first+i]=temp[i];
	}
	
	//��������������ϲ���һ����������
	public static void mergeArray(int[] a, int[] b, int[] c) {
		int i, j, k, n=a.length, m=b.length;
		i=j=k=0;
		while(i<n && j<m) {
			if(a[i]<b[j])
				c[k++]=a[i++];
			else
				c[k++]=b[j++];
		}
		
		while(i<n)
			c[k++]=a[i++];
		
		while(j<m)
			c[k++]=b[j++];
	}

}
