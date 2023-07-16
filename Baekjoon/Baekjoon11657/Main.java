import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] Edges = new int[M][3];
		long[] dist = new long[N+1];
		int INF = 999999999;
		for(int i=2;i<=N;i++) {
			dist[i] = INF;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			Edges[i][0] = Integer.parseInt(st.nextToken());
			Edges[i][1] = Integer.parseInt(st.nextToken());
			Edges[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(dist[Edges[j][0]] != INF && dist[Edges[j][0]] + Edges[j][2] < dist[Edges[j][1]]) {
					dist[Edges[j][1]] = dist[Edges[j][0]] + Edges[j][2];
					if(i == N-1) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		for(int i=2;i<=N;i++) {
			sb.append(dist[i] == INF ? -1 : dist[i]);
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}
}
