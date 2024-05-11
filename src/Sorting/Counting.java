package Sorting;

public class Counting {
    public static void main(String[] args) {
        int max = 9;
        int[] datas = {7, 0, 2, 9, 3, 0, 4, 8, 7, 2, 5, 1, 1};
        
        int[] conuntedArr = new int[max + 1];
        
        for(int data : datas){
            conuntedArr[data] += 1;
        }

        for(int i = 0; i <= 9; i++){
            for(int j = 0; j < conuntedArr[i]; j++){
                System.out.print(i + " ");
            }
        }
    }
}
