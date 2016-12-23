package sort;

import java.util.Arrays;

public class InsertSortTest {
	
	/**
	 * 时间复杂度为：O(n^2)
	 * @param args
	 */
	public static void main(String[] args) {
		/**获取测试数组**/
//		int[] array = SortFather.getArray(30000);
		
		/**插入排序**/
		int[] array = {-39, -86, 93, -61, -27, 90, -30, 67, -93};
		System.out.println("原始数组：" + Arrays.toString(array));
//		dosort(array);
		shellSortAsc2(array);
//		optimalInsertSort(array);
		System.out.println("排序之后数组：" + Arrays.toString(array));
		
		/**折半排序**/
//		System.out.println("原始数组：" + Arrays.toString(array));
//		halfSortAsc(array);
//		binaryInsertSort(array);
//		System.out.println(Arrays.toString(array));
//		System.out.println("优化排序之后数组：" + Arrays.toString(array));
		
		/**希尔排序**/
//		int[] array = {-39, -86, 93, -61, -27, 90, -30, 67, -93, 27};
//		System.out.println("原始数组：" + Arrays.toString(array));
//		shellSortAsc(array);
//		shellSortAsc2(array);
//		System.out.println("排序之后数组：" + Arrays.toString(array));
	}
	
	//基本的插入排序  1100毫秒
	public static void dosort(int[] array) {
		long start = System.currentTimeMillis();
		for(int i = 1; i <array.length;i++) {
			int temp = array[i]; //记录下当前这个哨兵值
			int position = i; //记录哨兵的位置
			for(int j = i-1;j>=0;j--) {//从哨兵的位置往前都是已经排好序的
				if(array[j]>temp) {//这里是升序排序，只要大于哨兵的值，哨兵的位置就往前移动
					array[j+1] = array[j];//哨兵之后的数据依次往后移动
					position -= 1;//哨兵应该在的位置，每循环一次向前移一位
				} else {
					break;//如果不大于，直接跳出循环，进行下一个哨兵的排序
				}
			}
			
			array[position] = temp;//将哨兵放入新的位置
			System.out.println("变化数组：" + Arrays.toString(array));
		}
		long end = System.currentTimeMillis();
	    System.out.println("耗时：" + (end - start) + "毫秒");
	}
	
	//代码优化之后的插入排序  950毫秒
	public static void optimalInsertSort(int[] array) {
		long start = System.currentTimeMillis(); 
		for(int i = 1; i <array.length;i++) {
			for(int j = i-1; j>=0 && array[j] > array[j+1]; j--) {//j前的数据都是以排好的，后边的数据小于当前数，就交换位置，正序
				int temp = array[j+1];
				array[j+1] = array[j];
				array[j] = temp;
			}
			System.out.println("变化数组：" + Arrays.toString(array));
		}
		long end = System.currentTimeMillis();  
	    System.out.println("耗时：" + (end - start) + "毫秒");  
	}
	
	//折半排序、二分排序  O(n^2)  550毫秒
	public static void binaryInsertSort(int[] array) {
		long start = System.currentTimeMillis(); 
		for(int i =1 ;i<array.length;i++) {
			int temp = array[i];//待排序对象
			//int index = binarySearchDesc(array, temp, 0, i);//找到要插入的位置
			int index = binarySearchAsc(array, temp, 0, i);//找到要插入的位置，从0到i都是已经排好序的，在这里找到待排序的数据应该插入的位置
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
	
	//折半排序   550毫秒
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
			//high之前都是排好序的数据
			for(int j=i-1;j>high;j--) {
				ary[j+1]=ary[j];
			}
			ary[high+1]=temp;
			//System.out.println(Arrays.toString(ary));
		}  
	    long end = System.currentTimeMillis();  
	    System.out.println("耗时：" + (end - start) + "毫秒");  
	}
	
	//希尔排序，也属于插入排序  6毫秒  时间下界O(n^1.25)，上届O(n²)
	public static void shellSortAsc(int[] ary) {
		int n = ary.length;
		long start = System.currentTimeMillis();  
		for(int gap = n/2; gap>0; gap/=2) {//确定好分组步进大小，这里以每次都是上一次步进的一半取正
			for(int i=0; i<gap; i++) {//按照步进分了多少组
				for(int j = i+gap; j<n; j+=gap) {//每次循环都跨越步进的大小
					//升降序的判断  ary[j]<ary[j-gap] && ary[k]>temp 这是升序   
					if(ary[j]<ary[j-gap]) {//步进相隔的两个数比较
						/* 这种是错误的
						int temp = ary[j];
						ary[j] = ary[j-gap];
						ary[j-gap]=temp;*/
						int temp = ary[j];//哨兵的值
						int k = j -gap;//本组内，哨兵前一个数据
						while(k>=0 && ary[k]>temp) {//假设k之前的都是排好序，要用哨兵与之前的进行逐一比较然后交换位置
							ary[k+gap] = ary[k];
							k-=gap;
						}
						ary[k+gap]=temp;//因为之前已经减掉了一个步进，现在要加上然后再赋值
					}
				}
			}
			//System.out.println("变化数组："+Arrays.toString(ary));
		}
		//System.out.println(Arrays.toString(ary));
	    long end = System.currentTimeMillis();  
	    System.out.println("耗时：" + (end - start) + "毫秒");  
	}
	
	//希尔排序的第二种思路，比较每组步进的值   7毫秒
	public static void shellSortAsc2(int[] ary) {
		int n = ary.length;
		long start = System.currentTimeMillis();
		int gap , j;
		for(gap=n/2;gap>0;gap/=2) {
			for(j=gap;j<n;j++) {//从数组的第gap个元素开始，每个元素与自己组内数据进行直接插入排序
				if(ary[j]<ary[j-gap]) {//步进相隔的两个数比较
					int temp = ary[j];//哨兵的值
					int k = j -gap;
					while(k>=0 && ary[k]>temp) {//假设k之前的都是排好序，要用哨兵与之前的进行逐一比较然后交换位置
						ary[k+gap] = ary[k];
						k-=gap;
					}
					ary[k+gap]=temp;//因为之前已经减掉了一个步进，现在要加上然后再赋值
				}
			}
		}
		long end = System.currentTimeMillis();  
	    System.out.println("耗时：" + (end - start) + "毫秒");
	}

}
