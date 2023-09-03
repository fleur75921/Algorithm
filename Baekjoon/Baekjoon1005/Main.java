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
	
	static class Building {
		int v;
		int time;
		
		public Building(int v, int time) {
			this.v = v;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	int[] D = new int[N];
        	int[] max = new int[N];
        	int[] degree = new int[N];
        	Node[] adjList = new Node[N];
        	st = new StringTokenizer(br.readLine());
        	for(int i=0;i<N;i++) {
        		D[i] = Integer.parseInt(st.nextToken());
        	}
        	for(int i=0;i<K;i++) {
        		st = new StringTokenizer(br.readLine());
        		int from = Integer.parseInt(st.nextToken())-1;
        		int to = Integer.parseInt(st.nextToken())-1;
        		adjList[from] = new Node(to, adjList[from]);
        		degree[to]++;
        	}
        	int W = Integer.parseInt(br.readLine())-1;
        	LinkedList<Building> q = new LinkedList<>();
        	for(int i=0;i<N;i++) {
        		if(degree[i] == 0) {
        			q.offer(new Building(i, D[i]));
        		}
        	}
        	for(int i=0;i<N;i++) {
        		Building cur = q.poll();
        		if(cur.v == W) {
        			sb.append(cur.time+"\n");
        			break;
        		}
        		for(Node n=adjList[cur.v];n!=null;n=n.link) {
        			degree[n.v]--;
        			max[n.v] = Math.max(max[n.v], cur.time + D[n.v]);
        			if(degree[n.v] == 0) {
        				q.offer(new Building(n.v, max[n.v]));
        			}
        		}
        	}
        }
        System.out.print(sb);
        br.close();
    }
}
