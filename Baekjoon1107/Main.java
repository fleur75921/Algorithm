import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static StringBuilder str = new StringBuilder();
	static HashSet<Integer> set;
	static int min;
	static int len;
	
	static void r_perm(int n, int R) {
		if(n == R) {
			return;
		}
		for(int i=0;i<10;i++) {
			if(set.contains(i)) {
				str.append(i);
				int tmp = Integer.parseInt(str.toString());
				if(Math.abs(tmp - N) < min) {
					min = Math.abs(tmp - N);
					if(tmp > 0) {
						len = (int)Math.log10(tmp)+1;
					} else {
						len = 1;
					}
				} else if(Math.abs(tmp - N) == min) {
					if(tmp > 0 && len > (int)Math.log10(tmp)+1) {
						len = (int)Math.log10(tmp)+1;
					} else if(tmp == 0) {
						len = 1;
					}
				}
				r_perm(n+1, R);
				str.deleteCharAt(n);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int diff = 0, direct = 0;
		min = Integer.MAX_VALUE;
		len = 0;
		if(M > 0) {
			set = new HashSet<>();
			for(int i=0;i<10;i++) {
				set.add(i);
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) {
				set.remove(Integer.parseInt(st.nextToken()));
			}
			if(N > 0) {
				r_perm(0, (int)Math.log10(N)+2);
			} else {
				r_perm(0, 2);
			}
			int res = min + len;
			System.out.println(Math.min(Math.abs(N-100), res));
		} else {
			diff = Math.abs(N-100);
			if(N > 0) {
				direct = (int)Math.log10(N)+1;
			} else {
				direct = 1;
			}
			System.out.println(Math.min(diff, direct));
		}
		br.close();
	}
}
