import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	
	static long[][] multiply (long[][] a, long[][] b) {
		long[][] res = new long[2][2];
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				for(int k=0;k<2;k++) {
					res[i][j] += (a[i][k] * b[k][j]) % 1000000007;
				}
				res[i][j] %= 1000000007;
			}
		}
		return res;
	}
	
	static long[][] calculate(long n) {
		long[][] res = {{1, 0}, {0, 1}};
		long[][] base = {{1, 1}, {1, 0}};
		
		while(n > 0) {
			if(n % 2 == 1) {
				res = multiply(res, base);
			}
			base = multiply(base, base);
			n /= 2;
		}
		return res;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(calculate(n-1)[0][0]);
        br.close();
    }
}
