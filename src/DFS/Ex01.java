package DFS;

import java.util.Scanner;
// DFS 기초문제
// 행 * 열 크기의 얼음틀이 있다.
// 각 칸중에서 칸막이가 존재하며 물을 채울 수 없는 부분은 1, 그렇지 않은 부분은 0으로 표시된다.
// 얼음틀의 모양이 주어졌을때 생성되는 얼음의 총 개수를 구하는 프로그램을 작성해라.

// ex)
// 3 * 3 얼음틀의 모양이
// 0 0 0
// 1 0 1
// 0 1 0
// 일때 총 생성되는 얼음의 개수는 3개이다.

public class Ex01 {
    static int w, h;
    static int[][] graph = new int[1000][1000];

    static boolean dfs(int x, int y){
        if(x < 0 || x >= h || y < 0 || y >= w){
            return false;
        }
        if(graph[x][y] == 0){
            // 방문처리
            graph[x][y] = 1;
            
            // 탐색
            dfs(x - 1, y);  // 상
            dfs(x + 1, y);  // 하
            dfs(x, y - 1);  // 좌
            dfs(x, y + 1);  // 우
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("몇 행?");
        h = sc.nextInt();
        System.out.print("몇 열?");
        w = sc.nextInt();
        sc.nextLine();
        System.out.println("얼음틀의 모양을 입력하세요.\n맨 윗줄부터 입력하고 다음 줄을 입력하려면 엔터를 누르세요.");
        for(int i = 0; i < h; i++){
            String str = sc.nextLine();
            for(int j = 0; j < w; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        sc.close();

        int result = 0;
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                // 값이 0인 인덱스에 접근했을때 해당 요소에 1을 할당해서 방문처리하고
                // 해당 요소의 상하좌우 모든 요소들에 접근해서 그중 값이 0일 경우 1을 할당하고
                // 또 그 요소들의 상하좌우...
                // 이 과정을 재귀 함수로 반복하고 마지막에 true를 반환받으면
                // 만들어질 얼음 덩어리가 1개 증가한다.
                if(dfs(i, j)){
                    result += 1;
                }
            }
        }
        System.out.printf("만들어진 얼음 수 : %d", result); // 정답 출력 
    }
    
}
