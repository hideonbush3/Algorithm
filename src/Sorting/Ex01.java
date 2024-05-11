package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// n개의 요소를 가진 arr1과 arr2라는 배열이 있다.
// arr1내 요소들의 총합을 구할건데,
// arr1과 arr2의 요소를 총 k번 바꿀 기회가 있다.
// 요소를 서로 한번 바꿀때마다 1회이며
// k번 바꿨을때 arr1의 총합이 최대가 되도록 하려면?

public class Ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("각 배열의 요소 개수는?");
        int n = sc.nextInt();

        System.out.println("서로 바꿀 수 있는 기회 몇번?");
        int k = sc.nextInt();
        sc.nextLine();

        Integer[] arr1 = new Integer[n];
        Integer[] arr2 = new Integer[n];

        System.out.println("첫번째 배열에 들어갈 요소를 하나씩 입력");
        for(int i = 0 ; i < n; i++){
            arr1[i] = sc.nextInt();
        }

        sc.nextLine();

        System.out.println("두번째 배열에 들어갈 요소를 하나씩 입력");
        for(int i = 0; i < n; i++){
            arr2[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(arr1);
        Arrays.sort(arr2, Collections.reverseOrder());

        for(int i = 0; i < n && k > 0; i++) {
            if(arr1[i] < arr2[i]) { // arr1의 값이 arr2의 값보다 작을 때만 교체
                arr1[i] = arr2[i];
                k--;    // 기회를 하나 사용
            } 
            else break;  // 더 이상 교체할 수 없는 상황이면 반복 종료
        }

        int total = 0;

        for(int num : arr1){
            total += num;
        }

        System.out.println("첫번째 배열 각 요소들의 총합 => " + total);        
    }
}
