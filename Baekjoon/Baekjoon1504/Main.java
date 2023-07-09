import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	// N과 v1, v2의 번호
	static int N, v1, v2;
	// 인접 리스트로 그래프 구현
	static Node[] adjList;
	// 거리의 최솟값
	static int min;
	
	// 인접 리스트 구현을 위한 정점 클래스
	static class Node implements Comparable<Node> {
		int v;
		int dist;
		Node link;
		
		public Node(int v, int dist, Node link) {
			this.v = v;
			this.dist = dist;
			this.link = link;
		}
		
		// 다익스트라 알고리즘을 구현할 때 우선순위 큐를 사용하기 위해 구현
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	// 다익스트라 알고리즘, 결과를 dist 배열에 저장
	static void shortest_path(int v, int[] dist) {
		// 인접 리스트 및 우선순위 큐 이용
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(v, 0, null));
		Node cur;
		dist[v] = 0;
		while(!q.isEmpty()) {
			cur = q.poll();
			if(cur.dist > dist[cur.v]) {
				continue;
			}
			for(Node n=adjList[cur.v];n!=null;n=n.link) {
				if(dist[n.v] > dist[cur.v] + n.dist) {
					dist[n.v] = dist[cur.v] + n.dist;
					q.offer(n);
				}
			}
		}
	}
	
	// 정점 4개인 그래프로 변경해서 DFS를 통해 모든 순서를 고려해서 최단거리 계산
	static void dfs(int v, int sum, boolean[] visited) {
		if(sum > min) {
			return;
		}
		// v1과 v2를 방문한 적이 있을 때만 업데이트
		if(v == 3 && visited[1] && visited[2]) {
			min = sum;
		}
		for(Node n=adjList[v];n!=null;n=n.link) {
			// 길이 없는 경우 건너뜀
			if(n.dist == Integer.MAX_VALUE - 1000) {
				continue;
			}
			if(!visited[n.v]) {
				visited[n.v] = true;
				dfs(n.v, sum+n.dist, visited);
				visited[n.v] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int from, to, dist;
		adjList = new Node[N+1];
		// 입력을 받아 인접 리스트로 저장
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dist = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, dist, adjList[from]);
			adjList[to] = new Node(from, dist, adjList[to]);
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		// 1, v1, v2에 대해 다익스트라 알고리즘 실행
		int[] dist1 = new int[N+1];
		int[] distv1 = new int[N+1];
		int[] distv2 = new int[N+1];
		Arrays.fill(dist1, Integer.MAX_VALUE-1000);
		Arrays.fill(distv1, Integer.MAX_VALUE-1000);
		Arrays.fill(distv2, Integer.MAX_VALUE-1000);
		shortest_path(1, dist1);
		shortest_path(v1, distv1);
		shortest_path(v2, distv2);
		
		// 1, v1, v2, N만 존재하는 새로운 인접 리스트 생성
		adjList = new Node[4];
		boolean[] visited = new boolean[4];
		
		adjList[0] = new Node(1, dist1[v1], adjList[0]);
		adjList[1] = new Node(0, dist1[v1], adjList[1]);
		adjList[0] = new Node(2, dist1[v2], adjList[0]);
		adjList[2] = new Node(0, dist1[v2], adjList[2]);
		adjList[0] = new Node(3, dist1[N], adjList[0]);
		adjList[3] = new Node(0, dist1[N], adjList[3]);
		
		adjList[1] = new Node(2, distv1[v2], adjList[1]);
		adjList[2] = new Node(1, distv1[v2], adjList[2]);
		adjList[1] = new Node(3, distv1[N], adjList[1]);
		adjList[3] = new Node(1, distv1[N], adjList[3]);
		
		adjList[2] = new Node(3, distv2[N], adjList[2]);
		adjList[3] = new Node(2, distv2[N], adjList[3]);
		
		// 새로운 인접 리스트에서 dfs를 통해 최단거리를 계산
		dfs(0, 0, visited);
		// 최단거리가 업데이트되지 않은 경우 -1를 출력, 이외에는 최단거리를 출력
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		br.close();
	}
}
