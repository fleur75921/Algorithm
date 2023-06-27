import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Point implements Comparable<Point>{
		int idx;
		int val;
		
		public Point(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

		@Override
		public int compareTo(Point o) {
			return this.val-o.val;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Point[] arr = new Point[N];
		int[] answer = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = new Point(i, Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		int cnt = -1;
		int cur = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			if(arr[i].val > cur) {
				cur = arr[i].val;
				cnt++;
			}
			answer[arr[i].idx] = cnt;
		}
		for(int i=0;i<N;i++) {
			sb.append(answer[i]+" ");
		}
		System.out.print(sb);
		br.close();
	}
}
