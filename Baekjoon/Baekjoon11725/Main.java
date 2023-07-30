import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int N, parents[];
	static Node[] adjList;
	static boolean visited[];
	
	static class Node {
		int v;
		Node link;
		
		public Node(int v, Node link) {
			this.v = v;
			this.link = link;
		}
	}
	
	static void dfs(int v, int parent) {
		parents[v] = parent;
		for(Node n = adjList[v]; n != null; n = n.link) {
			if(visited[n.v]) {
				continue;
			}
			visited[n.v] = true;
			dfs(n.v, v);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		adjList = new Node[N+1];
		parents = new int[N+1];
		visited = new boolean[N+1];
		int from, to;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		dfs(1, 0);
		for(int i=2;i<=N;i++) {
			sb.append(parents[i]+"\n");
		}
		System.out.print(sb);
		br.close();
	}
}
