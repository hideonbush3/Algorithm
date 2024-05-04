// 정렬 알고리즘
// 선택 정렬
// 처리되지 않은 데이터 중에서 가장 작은 데이터를 선택해 
// 맨 앞에 있는 데이터와 바꾸는 것을 반복하는 방식
package Sorting;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 0, 1};
        
        int minIndex = 0;
        for(int i = 0; i < arr.length; i++){
            minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
        
        for(int i : arr){
            System.out.println(i);
        }
    }
    
}
