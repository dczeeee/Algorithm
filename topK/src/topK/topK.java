package topK;
/*
 * 数组元素个数为n，取出最大的k个元素
 */
public class topK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,3,8,4,6,9,7,1,2};
		topk1(array, 5, 0, array.length-1);
		System.out.println();
		topk2(array, 5);
	}
	//利用快速排序的特点，一次排序后标识前面的都比它大，后面的都比它小，当标识+1等于k的时候输出前k个
	public static void topk1(int[] array,int k,int left,int right) {
		int dp = partition(array, left, right);
		if(dp+1==k) {
			for (int i=0;i<k;i++){
                System.out.print(array[i]+" ");
            }
		}
		else if(dp+1<k) {
            topk1(array,k,dp+1,array.length-1);
        }
		else {
            topk1(array,k,0,dp);
        }
    }
	
	private static int partition(int[] array,int left,int right) {
		int temp = array[left];
		while(left<right) {
			while(left<right && temp>array[right])
				right--;
			if(left<right)
				array[left++] = array[right];
			while(left<right && temp<array[left])
				left++;
			if(left<right)
				array[right--] = array[left];
		}
		array[left] = temp;
		return left;
	}
	
	/*
	 * 使用最小堆保存数组中最大的K个数，我们取数组前K个数，作为最大的K个数，建最小堆，这个堆中堆顶元素是这个K个数中最小的数，
	 * 遍历数组，与堆顶元素比较，如果大于堆顶元素，我们就替换堆顶元素，然后调整堆为最小堆。
	 * 当循环结束时，我们堆中保存的，也就是数组中最大的K个数了
	 */
	public static void topk2(int[] array,int k) {
		int[] res = new int[k];
		for(int i = 0;i < k;++i) {
			res[i] = array[i];
		}
		createMinHeap(res, k-1);
		for(int i = k;i < array.length;++i) {
			if(array[i]>res[0]) {
				res[0] = array[i];
				createMinHeap(res, k-1);
			}
		}
		for(int i:res)
			System.out.print(i+" ");
	}
	
	//建立小根堆
	private static void createMinHeap(int[] array,int lastIndex) {
		for(int i = (lastIndex-1)/2;i>=0;--i) {
			int k = i;
			while(2*k+1 <= lastIndex) {
				int bigIndex = 2*k+1;
				if(bigIndex < lastIndex) {
					bigIndex++;
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
	//交换
	private static void swap(int[] array,int i,int j) {
		if(i==j)
			return;
		array[i] = array[i]+array[j];
		array[j] = array[i]-array[j];
		array[i] = array[i]-array[j];
	}
}
