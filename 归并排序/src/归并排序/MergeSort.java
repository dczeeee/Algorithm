package 归并排序;
/*
 * 归并排序（Merge）是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。
 * 然后再把有序子序列合并为整体有序序列。
归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。 
将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
归并排序算法稳定，数组需要O(n)的额外空间，链表需要O(log(n))的额外空间，时间复杂度为O(nlog(n))，
算法不是自适应的，不需要对数据的随机读取。
工作原理：
1）申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
2）设定两个指针，最初位置分别为两个已经排序序列的起始位置
3）比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
4）重复步骤3直到某一指针达到序列尾
5）将另一序列剩下的所有元素直接复制到合并序列尾

 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {33,22,18,4,30,29,7,16,9,10};  
        print(data);  
        mergeSort(data);  
        System.out.println("排序后的数组：");  
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
		//临时数组
		int[] tempArr = new int[data.length];
		//右数组第一个元素索引
		int mid = center+1;
		//third记录临时数组的索引
		int third = left;
		//缓存左数组第一个元素的索引
		int temp = left;
		while(left<=center && mid<=right) {
			//从两个数组中选出最小的存入临时数组
			if(data[left]<=data[mid]) {
				tempArr[third++] = data[left++];
			}
			else {
				tempArr[third++] = data[mid++];
			}
		}
		//剩余部分依次放入临时数组
		while (left <= center) {  
            tempArr[third++] = data[left++];  
        }
		while(mid<=right) {
			tempArr[third++] = data[mid++];
		}
		//将临时数组中的内容拷贝回原数组中  
        //（原left-right范围的内容被复制回原数组）
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
