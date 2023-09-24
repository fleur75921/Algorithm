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
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    int X = Integer.parseInt(st.nextToken());
	    Node[] adjList = new Node[N+1];
	    LinkedList<Integer> q = new LinkedList<>();
	    for(int i=0;i<M;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	adjList[from] = new Node(to, adjList[from]);
	    }
	    int[] dist = new int[N+1];
	    q.offer(X);
	    int cnt = -1;
	    boolean[] visited = new boolean[N+1];
	    visited[X] = true;
	    while(!q.isEmpty()) {
	    	int size = q.size();
	    	cnt++;
	    	for(int i=0;i<size;i++) {
		    	int cur = q.poll();
		    	dist[cur] = cnt;
		    	for(Node n=adjList[cur];n!=null;n=n.link) {
		    		if(!visited[n.v]) {
		    			visited[n.v] = true;
		    			q.offer(n.v);
		    		}
		    	}
	    	}
	    }
	    StringBuilder sb = new StringBuilder();
	    for(int i=1;i<=N;i++) {
	    	if(dist[i] == K) {
	    		sb.append(i+"\n");
	    	}
	    }
	    System.out.print(sb.toString().equals("") ? -1 : sb);
	    br.close();
	}
}
