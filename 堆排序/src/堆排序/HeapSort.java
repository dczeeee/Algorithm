package ������;
/*
 * �ѻ�����(Heapsort)��ָ���öѻ������ѣ��������Ͻṹ����Ƶ�һ�������㷨����������������ص���ٶ�λָ��������Ԫ�ء�
 * �������ǲ��ȶ������򷽷��������ռ�ΪO(1)�� �ʱ�临�Ӷ�ΪO(nlog2n) ��������Ķ����ƽ�����ܽϽӽ�������ܡ� 
�����������˴����(��С����)�Ѷ���¼�Ĺؼ������(����С)��һ������ʹ���ڵ�ǰ��������ѡȡ���(����С)�ؼ��ֵļ�¼��ü򵥡�
1���ô��������Ļ���˼��
�� �Ƚ���ʼ�ļ�R[1..n]����һ�������,�˶�Ϊ��ʼ��������
�� �ٽ��ؼ������ļ�¼R[1](���Ѷ�)�������������һ����¼R[n]�������ɴ˵õ��µ�������R[1..n-1]��������R[n]��
������R[1..n-1].keys��R[n].key
�����ڽ������µĸ�R[1]����Υ�������ʣ���Ӧ����ǰ������R[1..n-1]����Ϊ�ѡ�
Ȼ���ٴν�R[1..n-1]�йؼ������ļ�¼R[1]�͸���������һ����¼R[n-1]������
�ɴ˵õ��µ�������R[1..n-2]��������R[n-1..n]��
���������ϵR[1..n-2].keys��R[n-1..n].keys��ͬ��Ҫ��R[1..n-2]����Ϊ�ѡ�
����
ֱ��������ֻ��һ��Ԫ��Ϊֹ��
2������������㷨�Ļ��������� 
�� ��ʼ����������R[1..n]����Ϊ��ʼ�ѣ�
�� ÿһ������Ļ�������������ǰ�������ĶѶ���¼R[1]�͸���������һ����¼������Ȼ���µ�����������Ϊ��(����ؽ���)��
ע�⣺ 
��ֻ����n-1������ѡ���ϴ��n-1���ؼ��ּ�����ʹ���ļ���������
����С�������������ô�������ƣ�ֻ�������������ǵݼ�����ġ�
�������ֱ��ѡ�������෴�����κ�ʱ�̶�������������������������֮ǰ��������������ԭ������β���ɺ���ǰ����������������Ϊֹ��

 */
public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {5,3,6,2,1,9,4,8,7};  
        print(data);  
        heapSort(data);  
        System.out.println("���������飺");  
        print(data);  
	}

	public static void heapSort(int[] data) {
		for(int i=0;i<data.length;++i) {
			createMaxdHeap(data, data.length-1-i);
			swap(data, 0, data.length-1-i);
			print(data);
		}
	}
	
	public static void createMaxdHeap(int[] data, int lastIndex) {
		for(int i=(lastIndex-1)/2;i>=0;--i) {
			//���浱ǰ�����жϵĽڵ�
			int k = i;
			//����ǰ�ڵ���ӽڵ����
			while(2*k+1<=lastIndex) {
				//biggerIndex���Ǽ�¼�ϴ�ڵ��ֵ,�ȸ�ֵΪ��ǰ�жϽڵ�����ӽڵ�
				int biggerIndex = 2*k+1;
				//�����ӽڵ����
				if(biggerIndex<lastIndex) {
                    //�����ӽڵ�ֵ�����ӽڵ�ֵ����biggerIndex��¼�������ӽڵ��ֵ  
					if (data[biggerIndex] < data[biggerIndex + 1]) {  
                        biggerIndex++;
					}
				}
				if(data[k]<data[biggerIndex]) {
					swap(data,k,biggerIndex);
					k = biggerIndex;
				}
				else {
					break;
				}
			}
		}
	}
	
	public static void swap(int[] data,int i,int j) {
		if(i==j)
			return;
		data[i] = data[i]+data[j];
		data[j] = data[i]-data[j];
		data[i] = data[i]-data[j];
	}
	
	public static void print(int[] data) {  
        for (int i = 0; i < data.length; i++) {  
            System.out.print(data[i] + " ");  
        }  
        System.out.println();  
    }
}
