import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
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
			return this.w-o.w;
		}
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int from, to, w;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Node[] adjList = new Node[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, 1000000000);
        for(int i=0;i<m;i++) {
        	st =  new StringTokenizer(br.readLine());
        	from = Integer.parseInt(st.nextToken());
        	to = Integer.parseInt(st.nextToken());
        	w = Integer.parseInt(st.nextToken());
        	adjList[from] = new Node(to, w, adjList[from]);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dist[start] = 0;
        int[] trace = new int[n+1];
        int[] cnt = new int[n+1];
        pq.offer(new Node(start, 0, null));
        Node cur;
        while(!pq.isEmpty()) {
        	cur = pq.poll();
        	if(dist[cur.v] < cur.w) {
        		continue;
        	}
        	for(Node node=adjList[cur.v];node!=null;node=node.link) {
        		if(dist[node.v] > dist[cur.v] + node.w) {
        			dist[node.v] = dist[cur.v] + node.w;
        			pq.offer(new Node(node.v, node.w, null));
        			trace[node.v] = cur.v;
        			cnt[node.v] = cnt[cur.v] + 1;
        		}
        	}
        }
        int[] res = new int[cnt[end]+1];
        int tmp = end;
        for(int i=cnt[end];i>=0;i--) {
        	res[i] = tmp;
        	tmp = trace[tmp];
        }
        sb.append(dist[end]+"\n");
        sb.append(cnt[end]+1+"\n");
        for(int i=0;i<=cnt[end];i++) {
        	sb.append(res[i]+" ");
        }
        System.out.print(sb);
        br.close();
    }
}
