import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int v;
		Node link;
		public Node(int v, Node link) {
			this.v = v;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start, end, cur, res = 0;;
		Node[] adjList = new Node[N+1];
		LinkedList<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			adjList[start] = new Node(end, adjList[start]);
			adjList[end] = new Node(start, adjList[end]);
		}
		for(int i=1;i<=N;i++) {
			if(!visited[i]) {
				q.offer(i);
				res++;
				while(!q.isEmpty()) {
					cur = q.poll();
					for(Node n=adjList[cur];n != null;n = n.link) {
						if(!visited[n.v]) {
							visited[n.v] = true;
							q.offer(n.v);
						}
					}
				}
			}
		}
		System.out.println(res);
		br.close();
	}
}
