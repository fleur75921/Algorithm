import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int v;
		Node next;
		
		Node(int v, Node next) {
			this.v = v;
			this.next = next;
		}
	}
	
	static int cnt;
	static boolean[] visited;
	
	static void dfs(int v, Node[] adjList) {
		visited[v] = true;
		cnt++;
		for(Node node=adjList[v];node != null;node = node.next) {
			if(!visited[node.v]) {
				dfs(node.v, adjList);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Node[] adjList = new Node[N+1];
		int start, end;
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			adjList[start] = new Node(end, adjList[start]);
			adjList[end] = new Node(start, adjList[end]);
		}
		cnt = -1;
		visited = new boolean[N+1];
		dfs(1, adjList);
		System.out.println(cnt);
		br.close();
	}
}
