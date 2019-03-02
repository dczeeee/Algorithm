package ��������;
/*
 * ���Ե�һ���ؼ��� K1Ϊ�����֣��� [K1,K2,��,Kn]�ֳ�����������ʹ�������йؼ���С�ڵ��� K1���������йؼ��ִ��ڵ��� K1��
 * �������־����������м���ʵ�λ�á��������������д�������״̬�� 
�ڰ�������Ϊһ�����壬�âٵĲ�����д�������������ͬ�Ĵ��������ݹ飩
���ظ��ڢ١��ڲ���ֱ������������ϡ�

ʱ�临�Ӷȣ�������O(nlog2n)������O(n^2)��ƽ�����O(nlog2n)���ռ临�Ӷ�O(log2n)�����ȶ�
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
