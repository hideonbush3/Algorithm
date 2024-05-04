// BFS 예제
// 미로탈출
// 미로의 크기는 w * h 이며 (1, 1) 자리에 사람이 있다.
// (h, w) 자리에 탈출구가 있는 직사각형 미로가 있다. 
// 탈출할 수 있는 최단경로로의 이동거리를 구해라. (한칸당 1)

// 조건
// 각 칸은 함정일경우 0, 안전한 칸일경우 1의 값을 가지고있다.
// w, h 값은 4<=w, h<=100)
// 첫번째 칸과 탈출구 칸도 카운트한다.
// 탈출할 수 없는 경우의 수는 없다.
package BFS;
import java.util.*;

// 각 노드의 인덱스를 나타내기 위한 클래스
class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
}

public class Ex01 {
    static int row, column;
    static int[][] graph = new int[101][101];

    // 이동할 네 가지 방향 정의 (상, 하, 좌, 우) 
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();
            // 현재 칸을 기준으로 상하좌우를 검사
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 이동했을때 미로맵을 벗어난 경우거나
                if (nx < 0 || nx >= row || ny < 0 || ny >= column) continue;
                // 함정일 경우 다음칸 검사
                if (graph[nx][ny] == 0) continue;

                // 해당 칸을 처음 방문하는 경우에만 이동경로로 포함한다.
                // 현재 이동거리 + 1을 해당칸에 할당하고
                // 해당칸 기준으로 상하좌우를 또 검사하기 위해서 큐에 삽입한다.
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                } 
            } 
        }
        // 탈출구에 할당돼있는 값 반환
        return graph[row - 1][column - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 탈출구 위치 (row, column)
        System.out.print("탈출구가 있는 행 : ");
        row = sc.nextInt();

        System.out.print("탈출구가 있는 열 : ");
        column = sc.nextInt();

        sc.nextLine();

        // 미로 구성 입력받기
        System.out.print("미로의 구성을 한줄씩 입력하세요.\n함정일 경우 0, 그렇지 않을경우 1을 입력하세요.\n다음줄을 입력하려면 엔터를 누르세요.\n");
        for (int r = 0; r < row; r++) {
            String str = sc.nextLine();
            for (int c = 0; c < column; c++) {
                graph[r][c] = str.charAt(c) - '0';
            }
        }

        sc.close();

        // 모든 칸에 대해서 BFS를 수행했을때 탈출구에 할당된 값(최단경로 거리)
        System.out.printf("탈출구까지 최단경로로 이동한 거리는 : %d", bfs(0, 0));
    }
}