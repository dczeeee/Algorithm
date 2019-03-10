package topKth;

public class topKth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,3,8,4,6,9,7,1,2};
		int k = 5;
		topKth(array, k);
	}
	/*
	 * 和topK思路一样，都是用小根堆，不同的是topK要将整个堆输出，而topKth只需要输出堆顶
	 */
	private static void topKth(int[] array,int k) {
		int[] res = new int[k];
		for(int i=0;i<k;++i) {
			res[i] = array[i];
		}
		createMinHeap(res, k-1);
		for(int i = k;i<array.length;++i) {
			if(res[0]<array[i]) {
				res[0]=array[i];
				createMinHeap(res, k-1);
			}
		}
		System.out.println(res[0]);
	}
	
	private static void createMinHeap(int[] array,int lastIndex) {
		for(int i = (lastIndex-1)/2;i>=0;--i) {
			int k = i;
			while(2*k+1 <= lastIndex) {
				int bigIndex = 2*k+1;
				if(bigIndex < lastIndex) {
					if(array[bigIndex]>array[bigIndex+1]) {
						bigIndex++;
					}
				}
				if(array[k]>array[bigIndex]) {
					swap(array,k,bigIndex);
					k = bigIndex;
				}
				else {
					break;
				}
			}
		}
	}
	
	private static void swap(int[] array,int i,int j) {
		if(i==j)
			return;
		array[i] = array[i]+array[j];
		array[j] = array[i]-array[j];
		array[i] = array[i]-array[j];
	}
}
