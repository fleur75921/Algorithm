import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] zeros;
	static int[] ones;
	
	static int fibo(int n) {
		if(zeros[n] != -1) {
			return zeros[n];
		} else {
			zeros[n] = fibo(n-1) + fibo(n-2);
			return zeros[n];
		}
	}
	
	static int fibo2(int n) {
		if(ones[n] != -1) {
			return ones[n];
		} else {
			ones[n] = fibo2(n-1) + fibo2(n-2);
			return ones[n];
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			if(N > 1) {
				zeros = new int[N+1];
				for(int j=0;j<=N;j++) {
					zeros[j] = -1;
				}
				zeros[0] = 1;
				zeros[1] = 0;
				ones = new int[N+1];
				for(int j=0;j<=N;j++) {
					ones[j] = -1;
				}
				ones[0] = 0;
				ones[1] = 1;
				System.out.print(fibo(N)+" ");
				System.out.println(fibo2(N));
			} else if(N == 0) {
				System.out.println("1 0");
			} else {
				System.out.println("0 1");
			}
		}
		br.close();
	}
}
