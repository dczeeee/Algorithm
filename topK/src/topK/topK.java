package topK;
/*
 * 数组元素个数为n，取出最大的k个元素
 */
public class topK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,3,8,4,6,9,7,1,2};
		topk1(array, 5, 0, array.length-1);
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
	
	public static void topk2(int[] array,int k) {
		//假设数组的前k个就是所要的，然后用之后的n-k个与这k个比较大小
	}
}
