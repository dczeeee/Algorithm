package topK;
/*
 * ����Ԫ�ظ���Ϊn��ȡ������k��Ԫ��
 */
public class topK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {5,3,8,4,6,9,7,1,2};
		topk1(array, 5, 0, array.length-1);
		System.out.println();
		topk2(array, 5);
	}
	//���ÿ���������ص㣬һ��������ʶǰ��Ķ������󣬺���Ķ�����С������ʶ+1����k��ʱ�����ǰk��
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
	 * ʹ����С�ѱ�������������K����������ȡ����ǰK��������Ϊ����K����������С�ѣ�������жѶ�Ԫ�������K��������С������
	 * �������飬��Ѷ�Ԫ�رȽϣ�������ڶѶ�Ԫ�أ����Ǿ��滻�Ѷ�Ԫ�أ�Ȼ�������Ϊ��С�ѡ�
	 * ��ѭ������ʱ�����Ƕ��б���ģ�Ҳ��������������K������
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
	
	//����С����
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
	//����
	private static void swap(int[] array,int i,int j) {
		if(i==j)
			return;
		array[i] = array[i]+array[j];
		array[j] = array[i]-array[j];
		array[i] = array[i]-array[j];
	}
}
