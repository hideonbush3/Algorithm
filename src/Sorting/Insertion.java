// 삽입 정렬
// 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입하는 방식
// 선택 정렬에 비해 구현 난이도가 높은 편이지만 일반적으로 더 효율적으로 동작
package Sorting;

public class Insertion {

    public static void main(String[] args) {

        int n = 5;
        int[] arr = {4, 2, 3, 0, 1};

        for (int i = 1; i < n; i++) {
            // 맨 오른쪽부터 확인
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int smaller = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = smaller;
                }
                // 자기보다 작은 데이터를 만나면 더이상 확인할 필요없음
                else break;
            }
        }

        for(int number : arr) {
            System.out.println(number);
        }
    }

}