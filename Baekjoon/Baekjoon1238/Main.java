import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	// 인접 리스트 생성을 위한 정점 클래스 정의
	static class Node implements Comparable<Node> {
		int v;
		int w;
		Node link;
		
		public Node(int v, int w, Node link) {
			this.v = v;
			this.w = w;
			this.link = link;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 학생 수(1부터 시작)
		int N = Integer.parseInt(st.nextToken());
		// 간선 수
		int M = Integer.parseInt(st.nextToken());
		// 목표 정점
		int X = Integer.parseInt(st.nextToken());
		// 반대 방향으로 다익스트라 알고리즘을 실행할 인접 리스트
		Node[] adjGo = new Node[N+1];
		// 정방향으로 다익스트라 알고리즘을 실행할 인접 리스트
		Node[] adjBack = new Node[N+1];
		// 입력용 변수 선언
		int from, to, weight;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			// 정방향은 그대로 인접 리스트를 만듦
			adjBack[from] = new Node(to, weight, adjBack[from]);
			// 역방향은 간선 방향을 반대로 한다.(X로부터 출발점을 찾아갈 수 있도록)
			adjGo[to] = new Node(from, weight, adjGo[to]);
		}
		// 최소 힙(우선순위 큐)을 이용한 다익스트라 알고리즘 구현
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(X, 0, null));
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE - 100);
		dist[X] = 0;
		Node cur;
		// 다익스트라 알고리즘으로 X에서 돌아오는 최단거리를 구한다.
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(dist[cur.v] < cur.w) {
				continue;
			}
			for(Node n=adjBack[cur.v];n!=null;n=n.link) {
				if(dist[n.v] > dist[cur.v] + n.w) {
					dist[n.v] = dist[cur.v] + n.w;
					pq.offer(new Node(n.v, dist[n.v], null));
				}
			}
		}
		pq.offer(new Node(X, 0, null));
		int[] dist2 = new int[N+1];
		Arrays.fill(dist2, Integer.MAX_VALUE - 100);
		dist2[X] = 0;
		// 다익스트라 알고리즘으로 X에서 각 정점까지의 거리를 구한다.(방향이 반대이기 때문에 각 정점에서 X까지의 거리와 같다.)
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(dist2[cur.v] < cur.w) {
				continue;
			}
			for(Node n=adjGo[cur.v];n!=null;n=n.link) {
				if(dist2[n.v] > dist2[cur.v] + n.w) {
					dist2[n.v] = dist2[cur.v] + n.w;
					pq.offer(new Node(n.v, dist2[n.v], null));
				}
			}
		}
		// 가는 방향과 오는 방향의 최단거리를 더한 것 중 최댓값을 찾는다.
		int max = Integer.MIN_VALUE;
		int sum;
		for(int i=1;i<=N;i++) {
			sum = dist[i] + dist2[i];
			if(sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
		br.close();
	}
}
