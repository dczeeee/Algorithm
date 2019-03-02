package 快速排序;
/*
 * ①以第一个关键字 K1为控制字，将 [K1,K2,…,Kn]分成两个子区，使左区所有关键字小于等于 K1，右区所有关键字大于等于 K1，
 * 最后控制字居两个子区中间的适当位置。在子区内数据尚处于无序状态。 
②把左区作为一个整体，用①的步骤进行处理，右区进行相同的处理。（即递归）
③重复第①、②步，直到左区处理完毕。

时间复杂度：最好情况O(nlog2n)，最坏情况O(n^2)，平均情况O(nlog2n)，空间复杂度O(log2n)，不稳定
 */
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {5,4,8,2,9,1,3,6};
		quicksort(n, 0, n.length-1);
		for(int i:n)
			System.out.print(i+" ");
	}

	static void quicksort(int[] n,int left,int right) {
		int dp;
		if(left < right) {
			dp = partition(n, left, right);
			quicksort(n, left, dp-1);
			quicksort(n, dp+1, right);
		}
	}
	
	static int partition(int[] n,int left,int right) {
		int pivot = n[left];
		while(left < right) {
			while(left<right && n[right]>=pivot)
				right--;
			if(left < right)
				n[left++] = n[right];
			while(left<right && n[left]<=pivot)
				left++;
			if(left < right)
				n[right--] = n[left];
		}
		n[left] = pivot;
		return left;
	}
}
