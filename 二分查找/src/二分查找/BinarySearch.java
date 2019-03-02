package 二分查找;
/*
 * 二分查找算法也称为折半搜索、二分搜索，是一种在有序数组中查找某一特定元素的搜索算法。请注意这种算法是建立在有序数组基础上的。
 * ①搜素过程从数组的中间元素开始，如果中间元素正好是要查找的元素，则搜素过程结束；
②如果某一特定元素大于或者小于中间元素，则在数组大于或小于中间元素的那一半中查找，而且跟开始一样从中间元素开始比较。
③如果在某一步骤数组为空，则代表找不到。
这种搜索算法每一次比较都使搜索范围缩小一半。

 */
public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(array, 3));
	}

	static int binarySearch(int[] array,int key) {
		int from = 0;
		int to = array.length-1;
		if(to < 0)
			return 0;
		while(from <= to) {
			int mid = (from+to)/2;
			int temp = array[mid];
			if(temp > key)
				to = mid-1;
			else if(temp < key)
				from = mid+1;
			else
				return mid;
		}
		return 0;
	}
}
