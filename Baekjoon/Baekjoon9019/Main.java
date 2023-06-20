import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int num;
		String str;
		Node parent;
		Node(int num, String str, Node parent) {
			this.num = num;
			this.str = str;
			this.parent = parent;
		}
	}
	
	static int D(int n) {
		int res = n * 2;
		if(res > 9999) {
			res %= 10000;
		}
		return res;
	}
	
	static int S(int n) {
		int res = n-1;
		if(res == -1) {
			res = 9999;
		}
		return res;
	}
	
	static int L(int n) {
		int res = n % 1000;
		res *= 10;
		res += n / 1000;
		return res;
	}
	
	static int R(int n) {
		int res = n / 10;
		res += 1000 * (n % 10);
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int A, B, d, s, l, r;
		LinkedList<Node> q;
		Node cur = null;
		StringBuilder sb = new StringBuilder();
		boolean[] visited;
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			q = new LinkedList<>();
			q.offer(new Node(A, "", null));
			StringBuilder sb2 = new StringBuilder();
			visited = new boolean[10000];
			Node last = null;
			while(!q.isEmpty()) {
				cur = q.poll();
				if(cur.num == B) {
					last = cur;
					break;
				}
				d = D(cur.num);
				s = S(cur.num);
				l = L(cur.num);
				r = R(cur.num);
				if(!visited[d]) {
					visited[d] = true;
					q.offer(new Node(d, "D", cur));
				}
				if(!visited[s]) {
					visited[s] = true;
					q.offer(new Node(s, "S", cur));
				}
				if(!visited[l]) {
					visited[l] = true;
					q.offer(new Node(l, "L", cur));
				}
				if(!visited[r]) {
					visited[r] = true;
					q.offer(new Node(r, "R", cur));
				}
			}
			for(Node n=last;n != null;n = n.parent) {
				sb2.insert(0, n.str);
			}
			sb.append(sb2+"\n");
		}
		System.out.print(sb);
		br.close();
	}
}
