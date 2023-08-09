import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][][] matrix;
	static int N;
	
	static void square(int n) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int tmp = 0;
				for(int k=0;k<N;k++) {
					tmp += (matrix[n-1][i][k] * matrix[n-1][k][j]) % 1000;
				}
				matrix[n][i][j] = tmp % 1000;
			}
		}
	}
	
	static int[][] multiply(int[][] a, int[][] b) {
		int[][] tmparr = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int tmp = 0;
				for(int k=0;k<N;k++) {
					tmp += (a[i][k] * b[k][j]) % 1000;
				}
				tmparr[i][j] = tmp % 1000;
			}
		}
		return tmparr;
	}
	
	static int sum(int[][] mat) {
		return 0;
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int max = (int) (Math.log10(B) / Math.log10(2)) + 1;
        boolean[] check = new boolean[max]; 
        while(B > 0) {
        	int tmp = (int) (Math.log10(B) / Math.log10(2));
        	check[tmp] = true;
        	B -= Math.pow(2, tmp);
        }
        matrix = new int[max][N][N];
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
				matrix[0][i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
        for(int i=1;i<max;i++) {
        	square(i);
        }
        int[][] res = matrix[max-1];
        for(int i=max-2;i>=0;i--) {
        	if(check[i]) {
        		res = multiply(res, matrix[i]);
        	}
        }
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		System.out.print(res[i][j]+" ");
        	}
        	System.out.println();
        }
        br.close();
    }
}
