import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[][] input = new int[T][2];
		int maxK = Integer.MIN_VALUE;
		int maxN = Integer.MIN_VALUE;
		for(int t=0;t<T;t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			input[t][0] = k;
			input[t][1] = n;
			if(k > maxK) {
				maxK = k;
			}
			if(n > maxN) {
				maxN = n;
			}
		}
		int[][] apt = new int[maxK+1][maxN];
		for(int i=0;i<maxN;i++) {
			apt[0][i] = i+1;
		}
		for(int i=0;i<=maxK;i++) {
			apt[i][0] = 1;
		}
		for(int i=1;i<=maxK;i++) {
			for(int j=1;j<maxN;j++) {
				apt[i][j] = apt[i][j-1] + apt[i-1][j];
			}
		}
		for(int i=0;i<T;i++) {
			System.out.println(apt[input[i][0]][input[i][1]-1]);
		}
		br.close();
	}
}
