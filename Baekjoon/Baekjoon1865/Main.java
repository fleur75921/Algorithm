import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	
	static int[] dist;
	static ArrayList<Edge> edges;
	static int INF = 1250000;
	static int N, M, W;
	
	static class Edge {
		int S;
		int E;
		int T;
		
		public Edge(int s, int e, int t) {
			S = s;
			E = e;
			T = t;
		}
	}
	
	static boolean bellmanFord(int start) {
		boolean update;
		for(int i=0;i<N;i++) {
			update = false;
			for(Edge e:edges) {
				if(dist[e.E] + e.T < dist[e.S]) {
					update = true;
					dist[e.S] = dist[e.E] + e.T;
					if(i == N-1) {
						return true;
					}
				}
			}
			if(!update) {
				break;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		int S, E, T;
		for(int t=0;t<TC;t++) {
			edges = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = Integer.parseInt(st.nextToken());
				edges.add(new Edge(S, E, T));
				edges.add(new Edge(E, S, T));
			}
			for(int i=0;i<W;i++) {
				st = new StringTokenizer(br.readLine());
				S = Integer.parseInt(st.nextToken());
				E = Integer.parseInt(st.nextToken());
				T = -1 * Integer.parseInt(st.nextToken());
				edges.add(new Edge(S, E, T));
			}
			dist = new int[N+1];
			for(int i=2;i<=N;i++) {
				dist[i] = INF;
			}
			if(bellmanFord(1)) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
