package 冒泡排序;
/*
 * 原理：比较两个相邻的元素，将值大的元素交换至右端。
思路：依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。
然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。
重复第一趟步骤，直至全部排序完成。

冒泡排序的优点：每进行一趟排序，就会少比较一次，因为每进行一趟排序都会找出一个较大值。
用时间复杂度来说：
1）如果我们的数据正序，只需要走一趟即可完成排序。所需的比较次数和记录移动次数均达到最小值，
即：Cmin=n-1;Mmin=0;所以，冒泡排序最好的时间复杂度为O(n)。
2）如果很不幸我们的数据是反序的，则需要进行n-1趟排序。每趟排序要进行n-i次比较(1≤i≤n-1)，
且每次比较都必须移动记录三次来达到交换记录位置。在这种情况下，比较和移动次数均达到最大值：冒泡排序的最坏时间复杂度为：O(n^2) 。
综上所述：冒泡排序总的平均时间复杂度为：O(n^2) 。

 */
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,3,7,1,4,6,2,9,8};
		bubbleSort(array);
		for(int i:array)
			System.out.print(i+" ");
	}

	static void bubbleSort(int[] array) {
		for(int i = 0;i < array.length-1;++i) {
			for(int j = 0;j < array.length-1-i;++j) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}
