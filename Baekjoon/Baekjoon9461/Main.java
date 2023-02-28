import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int max = Integer.MIN_VALUE;
		int[] input = new int[T];
		int[] given = {1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
		for(int t=0;t<T;t++) {
			input[t] = Integer.parseInt(br.readLine());
			if(input[t] > max) {
				max = input[t];
			}
		}
		if(max <= 10) {
			for(int i=0;i<T;i++) {
				System.out.println(given[input[i]-1]);
			}
		}
		else {
			long[] P = new long[max];
			for(int i=0;i<10;i++) {
				P[i] = given[i];
			}
			for(int i=10;i<max;i++) {
				P[i] = P[i-5] + P[i-1];
			}
			for(int i=0;i<T;i++) {
				System.out.println(P[input[i]-1]);
			}
		}
		br.close();
	}
}
