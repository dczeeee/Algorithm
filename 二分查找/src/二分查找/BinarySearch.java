package ���ֲ���;
/*
 * ���ֲ����㷨Ҳ��Ϊ�۰�������������������һ�������������в���ĳһ�ض�Ԫ�ص������㷨����ע�������㷨�ǽ�����������������ϵġ�
 * �����ع��̴�������м�Ԫ�ؿ�ʼ������м�Ԫ��������Ҫ���ҵ�Ԫ�أ������ع��̽�����
�����ĳһ�ض�Ԫ�ش��ڻ���С���м�Ԫ�أ�����������ڻ�С���м�Ԫ�ص���һ���в��ң����Ҹ���ʼһ�����м�Ԫ�ؿ�ʼ�Ƚϡ�
�������ĳһ��������Ϊ�գ�������Ҳ�����
���������㷨ÿһ�αȽ϶�ʹ������Χ��Сһ�롣

 */
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(array, 3));
	}

	static int binarySearch(int[] array,int key) {
		int left = 0;
		int right = array.length-1;
		if(right < 0)
			return 0;
		while(left <= right) {
			int mid = (left+right)/2;
			int temp = array[mid];
			if(temp > key)
				right = mid-1;
			else if(temp < key)
				left = mid+1;
			else
				return mid;
		}
		return 0;
	}
}
