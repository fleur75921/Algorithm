import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static class Abs implements Comparable<Abs>{
		int val;
		boolean isNegative;
		public Abs(int val, boolean isNegative) {
			this.val = val;
			this.isNegative = isNegative;
		}
		@Override
		public int compareTo(Abs o) {
			if(this.val == o.val) {
				if(this.isNegative) {
					return -1;
				}
				return 1;
			}
			return this.val-o.val;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int x;
		PriorityQueue<Abs> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		Abs tmp;
		for(int i=0;i<N;i++) {
			x = Integer.parseInt(br.readLine());
			if(x == 0) {
				if(q.isEmpty()) {
					sb.append(0+"\n");
				} else {
					tmp = q.poll();
					if(tmp.isNegative) {
						sb.append(-1 * tmp.val+"\n");
					} else {
						sb.append(tmp.val+"\n");
					}
				}
			} else {
				if(x >= 0) {
					q.offer(new Abs(x, false));
				} else {
					q.offer(new Abs(-1 * x, true));
				}
			}
		}
		System.out.print(sb);
		br.close();
	}
}
