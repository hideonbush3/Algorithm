import java.util.*;

public class Bfs {

    static boolean[] visited = new boolean[9];
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int x = queue.poll();
            System.out.printf("%d번 노드 탐색완료%n", x);
            // 해당 노드와 연결된, 아직 방문하지 않은 노드들을 큐에 추가
            for(int i : graph.get(x)) {
                if(!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 각 노드에 연결된 노드
        // 가장 작은 값을 먼저 즉, 오름차순으로 탐색하도록함.
        // ex) 1번 노드에서 연결된 노드를 탐색할때 2, 3, 8 중
        // 가장 작은 값인 2를 먼저 탐색함.
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        
        graph.get(2).add(1);
        graph.get(2).add(7);
        
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        
        graph.get(4).add(3);
        graph.get(4).add(5);
        
        graph.get(5).add(3);
        graph.get(5).add(4);
        
        graph.get(6).add(7);
        
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        
        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }

}