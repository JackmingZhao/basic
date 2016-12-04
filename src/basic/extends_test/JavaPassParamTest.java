package basic.extends_test;

import java.util.Arrays;

public class JavaPassParamTest {

	public static void main(String[] args) {
		int num;
		String str;
		int[] array1 = {1,2};
		int[] array2 = {1,2};
		
		num = 8;
        System.out.println("before call the function, num =" + String.valueOf(num));
        testBasicDataType(num);
        System.out.println("after call the function, num = " + String.valueOf(num));

        System.out.println("before call the function, array = " + Arrays.toString(array1));
        testQuoteDataTypeOfArray1(array1);
        System.out.println("after call the function, array = " + Arrays.toString(array1));

        System.out.println("before call the function, array = " + Arrays.toString(array2));
        testQuoteDataTypeOfArray2(array2);
        System.out.println("after call the function, array = " + Arrays.toString(array2));


        str = "me";
        System.out.println("before call the function, str =" + str);
        testQuoteDataTypeString1(str);
        System.out.println("after call the function, str = " + str);

        str = "me";
        System.out.println("before call the function, str =" + str);
        testQuoteDataTypeString2(str);
        System.out.println("after call the function, str = " + str);
	}
	
	public static void testBasicDataType(int num) {
		num = 2;
		System.out.println("In the testBasicDataType(int num) function, num = " + String.valueOf(num));
	}
	
	public static void testQuoteDataTypeOfArray1(int[] array) {
		array[1]=0;
		System.out.println("In the testQuoteDataTypeOfArray1(int[] array) function, array = " + Arrays.toString(array));
	}
	
	public static void testQuoteDataTypeOfArray2(int[] array) {
		int[] array1 = new int[]{3,2};
		array = array1;
		System.out.println("In the testQuoteDataTypeOfArray2(int[] array) function, array = " + Arrays.toString(array));
	}
	
	public static void testQuoteDataTypeString1(String s) {
		s = "you";
		System.out.println("In the testQuoteDataTypeString1(String s) function, str = " + s);
	}

	public static void testQuoteDataTypeString2(String s) {
		String s1 = new String("you");
		s = s1;
		System.out.println("In the testQuoteDataTypeString2(String s) function, str = " + s);
	}
}
