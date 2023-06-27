import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node implements Comparable<Node> {
		int v;
		int dist;
		Node link;
		
		public Node(int v, int dist, Node link) {
			this.v = v;
			this.dist = dist;
			this.link = link;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] adjList = new Node[101];
		int[] dist = new int[101];
		for(int i=2;i<=100;i++) {
			dist[i] = Integer.MAX_VALUE - 100;
		}
		for(int i=1;i<=94;i++) {
			for(int j=1;j<=6;j++) {
				adjList[i] = new Node(i+j, 1, adjList[i]);
			}
		}
		for(int i=95;i<=99;i++) {
			for(int j=1;j<=6-i+94;j++) {
				adjList[i] = new Node(i+j, 1, adjList[i]);
			}
		}
		int from, to;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dist[from] = Integer.MIN_VALUE;
			for(int j=from-6;j<=from-1;j++) {
				if(j >= 0) {
					adjList[j] = new Node(to, 1, adjList[j]);
				}
			}
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			dist[from] = Integer.MIN_VALUE;
			for(int j=from-6;j<=from-1;j++) {
				if(j >= 0) {
					adjList[j] = new Node(to, 1, adjList[j]);
				}
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node cur;
		pq.offer(new Node(1, 0, null));
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(dist[cur.v] < cur.dist) {
				continue;
			}
			for(Node n=adjList[cur.v];n!=null;n=n.link) {
				if(dist[n.v] > dist[cur.v] + n.dist) {
					dist[n.v] = dist[cur.v] + n.dist;
					pq.offer(new Node(n.v, dist[cur.v] + n.dist, null));
				}
			}
		}
		System.out.println(dist[100]);
		br.close();
	}
}
