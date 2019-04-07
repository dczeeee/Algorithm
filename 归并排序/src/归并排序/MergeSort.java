package �鲢����;
/*
 * �鲢����Merge���ǽ����������������ϣ������ϲ���һ���µ���������Ѵ��������з�Ϊ���ɸ������У�ÿ��������������ġ�
 * Ȼ���ٰ����������кϲ�Ϊ�����������С�
�鲢�����ǽ����ڹ鲢�����ϵ�һ����Ч�������㷨�����㷨�ǲ��÷��η���Divide and Conquer����һ���ǳ����͵�Ӧ�á� 
��������������кϲ����õ���ȫ��������У�����ʹÿ��������������ʹ�����жμ������������������ϲ���һ���������Ϊ2-·�鲢��
�鲢�����㷨�ȶ���������ҪO(n)�Ķ���ռ䣬������ҪO(log(n))�Ķ���ռ䣬ʱ�临�Ӷ�ΪO(nlog(n))��
�㷨��������Ӧ�ģ�����Ҫ�����ݵ������ȡ��
����ԭ��
1������ռ䣬ʹ���СΪ�����Ѿ���������֮�ͣ��ÿռ�������źϲ��������
2���趨����ָ�룬���λ�÷ֱ�Ϊ�����Ѿ��������е���ʼλ��
3���Ƚ�����ָ����ָ���Ԫ�أ�ѡ�����С��Ԫ�ط��뵽�ϲ��ռ䣬���ƶ�ָ�뵽��һλ��
4���ظ�����3ֱ��ĳһָ��ﵽ����β
5������һ����ʣ�µ�����Ԫ��ֱ�Ӹ��Ƶ��ϲ�����β

 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {33,22,18,4,30,29,7,16,9,10};  
        print(data);  
        mergeSort(data);  
        System.out.println("���������飺");  
        print(data);  

	}

	public static void mergeSort(int[] data) {
		sort(data,0,data.length-1);
	}
	
	public static void sort(int[] data,int left,int right) {
		if(left >= right)
			return;
		int center = (left+right)/2;
		sort(data,left,center);
		sort(data,center+1,right);
		merge(data,left,center,right);
		print(data);
	}
	
	public static void merge(int[] data,int left,int center,int right) {
		//��ʱ����
		int[] tempArr = new int[data.length];
		//�������һ��Ԫ������
		int mid = center+1;
		//third��¼��ʱ���������
		int third = left;
		//�����������һ��Ԫ�ص�����
		int temp = left;
		while(left<=center && mid<=right) {
			//������������ѡ����С�Ĵ�����ʱ����
			if(data[left]<=data[mid]) {
				tempArr[third++] = data[left++];
			}
			else {
				tempArr[third++] = data[mid++];
			}
		}
		//ʣ�ಿ�����η�����ʱ����
		while (left <= center) {  
            tempArr[third++] = data[left++];  
        }
		while(mid<=right) {
			tempArr[third++] = data[mid++];
		}
		//����ʱ�����е����ݿ�����ԭ������  
        //��ԭleft-right��Χ�����ݱ����ƻ�ԭ���飩
        while (temp<=right) {  
            data[temp] = tempArr[temp++];  
        }
	}
	
	public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + " ");  
        }  
        System.out.println();  
    }

}
