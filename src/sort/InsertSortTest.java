package sort;

import java.util.Arrays;

public class InsertSortTest {
	
	/**
	 * 时间复杂度为：O(n^2)
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = SortFather.getArray(20000);
		/**插入排序**/
//		System.out.println("原始数组：" + Arrays.toString(array));
//		dosort(array);
//		optimalInsertSort(array);
//		System.out.println("排序之后数组：" + Arrays.toString(array));
		
		/**折半排序**/
//		System.out.println("原始数组：" + Arrays.toString(array));
//		halfSortAsc(array);
//		binaryInsertSort(array);
//		System.out.println(Arrays.toString(array));
//		System.out.println("优化排序之后数组：" + Arrays.toString(array));
		
		/**希尔排序**/
		//int[] array = {-39, -86, 93, -61, -27, 90, -30, 67, -93, 27};
		//System.out.println("原始数组：" + Arrays.toString(array));
		shellSortAsc(array);
		//System.out.println("排序之后数组：" + Arrays.toString(array));
	}
	
	//基本的插入排序
	public static void dosort(int[] array) {
		long start = System.currentTimeMillis(); 
		for(int i = 1; i <array.length;i++) {
			int temp = array[i]; //记录下当前这个哨兵值
			int position = i; //记录哨兵的位置
			for(int j = i-1;j>=0;j--) {//从哨兵的位置往前都是已经排好序的
				if(array[j]>temp) {//这里是升序排序，只要大于哨兵的值，哨兵的位置就往前移动
					array[j+1] = array[j];
					position -= 1;//哨兵应该在的位置，每循环一次向前移一位
				} else {
					break;//如果不大于，直接跳出循环，进行下一个哨兵的排序
				}
			}
			
			array[position] = temp;//将哨兵放入新的位置
			//System.out.println("变化数组：" + Arrays.toString(array));
		}
		long end = System.currentTimeMillis();  
	    System.out.println("耗时：" + (end - start) + "毫秒");  
	}
	
	//代码优化之后的插入排序
	public static void optimalInsertSort(int[] array) {
		for(int i = 1; i <array.length;i++) {
			for(int j = i-1; j>=0 && array[j] > array[j+1]; j--) {//j前的数据都是以排好的，前一个数据小于当前数，就交换位置，正序
				int temp = array[j+1];
				array[j+1] = array[j];
				array[j] = temp;
			}
			System.out.println("变化数组：" + Arrays.toString(array));
		}
	}
	
	//折半排序、二分排序  O(n*log↓2n)
	public static void binaryInsertSort(int[] array) {
		long start = System.currentTimeMillis(); 
		for(int i =1 ;i<array.length;i++) {
			int temp = array[i];//待排序对象
			//int index = binarySearchDesc(array, temp, 0, i);//找到要插入的位置
			int index = binarySearchAsc(array, temp, 0, i);//找到要插入的位置
			//System.out.println(Arrays.toString(array));
			//System.out.println("第" + i +"个索引上的元素要插入的位置是：" + index);
			for(int j = i;j>index;j--) {//前j个元素都是排序好的元素，将排序好的元素依次往后替换，直到第index结束
				array[j]=array[j-1];
			}
			array[index]=temp;//将待排序元素插入到应插入位置
		}  
	    long end = System.currentTimeMillis();  
	    System.out.println("耗时：" + (end - start) + "毫秒");  
	}
	
	public static int binarySearchDesc(int[] ary, int target, int from, int to) {
		int range = to - from; //如果范围大于0，则在两个元素以上
        if (range > 0) {  
            int mid = (from + to) / 2;  
            if (ary[mid] < target) {  //大的往左放就是降序，小的往左放就是升序
                return binarySearchDesc(ary, target, mid + 1, to);  
            } else {  
                return binarySearchDesc(ary, target, from, mid - 1);  
            }  
        } else {  
            if (ary[from] > target) {//降序大的往前放，也就是目标应该在from+1
                return from + 1;  
            } else {  
                return from;  
            }  
        }  
	}
	
	public static int binarySearchAsc(int[] ary, int target, int from, int to) {
		int range = to - from;  
        if (range > 0) {  
            int mid = (from + to) / 2;  
            if (ary[mid] > target) {  
                return binarySearchAsc(ary, target, from, mid - 1);  
            } else {  
                return binarySearchAsc(ary, target, mid + 1, to);  
            }  
        } else {  
            if (ary[from] < target) {
                return from + 1;  
            } else {  
                return from;  
            }  
        }  
	}
	
	public static void halfSortAsc(int[] ary) {
		long start = System.currentTimeMillis();  
		for(int i=1; i<ary.length; i++) {
			int temp = ary[i];
			int low = 0;
			int high = i-1;
			while(low<=high) {
				int mid = (low+high)/2;
				if(ary[mid]<temp)
					low=mid+1;
				else
					high=mid-1;
				/*降序
				 * if(ary[mid]<temp)
					high=mid-1;
				else
					low=mid+1;*/
			}
			//System.out.println("low="+low+";high="+high);
			for(int j=i-1;j>high;j--) {
				ary[j+1]=ary[j];
			}
			ary[high+1]=temp;
			//System.out.println(Arrays.toString(ary));
		}  
	    long end = System.currentTimeMillis();  
	    System.out.println("耗时：" + (end - start) + "毫秒");  
	}
	
	public static void shellSortAsc(int[] ary) {
		long start = System.currentTimeMillis();  
		int n = ary.length;
		for(int gap = n/2; gap>0; gap/=2) {
			for(int i=0; i<gap; i++) {
				for(int j = i+gap; j<n; j+=gap) {
					if(ary[j]<ary[j-gap]) {
						int temp = ary[j];
						int k = j -gap;
						while(k>=0&&ary[k]>temp) {
							ary[k+gap] = ary[k];
							k-=gap;
						}
						ary[k+gap]=temp;
					}
				}
			}
			//System.out.println("变化数组："+Arrays.toString(ary));
		}  
	    long end = System.currentTimeMillis();  
	    System.out.println("耗时：" + (end - start) + "毫秒");  
	}

}
