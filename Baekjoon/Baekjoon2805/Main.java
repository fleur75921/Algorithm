import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean calculate(int[] trees, int N, int M, int h) {
		long sum = 0;
		int diff;
		for(int i=0;i<N;i++) {
			diff = trees[i] - h;
			if(diff > 0) {
				sum += diff;
			}
		}
		if(sum >= M) {
			return true;
		}
		return false;
	}
	
	static void bsearch(int[] trees, int N, int M, int h, int max, int min) {
		if(calculate(trees, N, M, h) == true) {
			if(h == max-1) {
				System.out.println(h);
				return;
			}
			bsearch(trees, N, M, (h+max)/2, max, h);
		} else {
			if(h == min) {
				System.out.println(h);
				return;
			}
			bsearch(trees, N, M, (min+h)/2, h, min);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] trees = new int[N];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			if(trees[i] > max) {
				max = trees[i];
			}
		}
		bsearch(trees, N, M, max/2, max, 0);
		br.close();
	}
}
