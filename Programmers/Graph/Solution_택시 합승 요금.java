class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        final int INF = 1000000; // 무한대, 연결이 없는 경우 
        int weight[][] = new int[n][n];
        
        int distanceFromStart[] = new int[n]; // 시작 정점에서 각 정점까지의 최단 거리
        int distanceFromA[] = new int[n]; // A의 도착 지점에서 각 정점까지의 최단 거리
        int distanceFromB[] = new int[n]; // B의 도착 지점에서 각 정점까지의 최단 거리
        boolean found[] = new boolean[n]; // 방문 여부
        
        // 모든 간선의 가중치 무한대로 저장
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[i].length; j++) {
                if (i == j) {
                    weight[i][j] = 0;
                }
                else { 
                    weight[i][j] = INF;
                }
            }
        }
        
        // 모든 간선의 가중치 저장
        for (int i = 0; i < fares.length; i++) {
            for (int j = 0; j < fares[i].length; j++) { 
                weight[fares[i][0] - 1][fares[i][1] - 1] = fares[i][2];
                weight[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2];
            }
        }
        shortestPath(distanceFromStart, found, n, weight, s - 1);
        shortestPath(distanceFromA, found, n, weight, a - 1);
        shortestPath(distanceFromB, found, n, weight, b - 1);
        
        answer = distanceFromStart[0] + distanceFromA[0] + distanceFromB[0];
        for (int i = 1; i < n; i++) {
            int distance = distanceFromStart[i] + distanceFromA[i] + distanceFromB[i];
            if (answer > distance) { 
                answer = distance;
            }
        }
        
        return answer;
    }
    public int choose(int distance[], int n, boolean found[]) { 
        int min = Integer.MAX_VALUE;
        int minpos = -1;
        for (int i = 0; i < n; i++) {
            if (distance[i] < min && !found[i]) {
                min = distance[i];
                minpos = i;
            }
        }
        return minpos;
    }
    public void shortestPath(int distance[], boolean found[], int n, int weight[][], int start) { 
        for (int i = 0; i < n; i++) { 
            distance[i] = weight[start][i];
            found[i] = false;
        }
        found[start] = true;
        distance[start] = 0;
        for (int i = 0; i  < n - 1; i++) {
            int u = choose(distance, n, found);
            found[u] = true;
            for (int w = 0; w < n; w++) { 
                if (!found[w]) {
                    if (distance[u] + weight[u][w] < distance[w]) {  
                        distance[w] = distance[u] + weight[u][w];
                    }
                }
            }
        }
    }
}