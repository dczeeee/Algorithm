package topK;
/*
 * ����Ԫ�ظ���Ϊn��ȡ������k��Ԫ��
 */
public class topK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void topk1(int[] array,int k,int left,int right) {
		int dp = partition(array, left, right);
		if(dp+1==k) {
			for (int i=0;i<k;i++){
                System.out.print(array[i]+" ");
            }
		}
		else if(dp+1>k) {
			for (int i=0;i<dp+1;i++){
                System.out.print(array[i]);
                System.out.print("\t");
            }
            topk1(array,k-dp,dp,array.length-1);
        }else {
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
		//���������ǰk��������Ҫ�ģ�Ȼ����֮���n-k������k���Ƚϴ�С
	}
}
