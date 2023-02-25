import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE;
		int[] numbers = new int[N];
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			if(max < numbers[i]) {
				max = numbers[i];
			}
		}
		boolean[] isNotPrime = new boolean[max+1];
		isNotPrime[1] = true;
		for(int i=2;i<=Math.sqrt(max);i++) {
			if(!isNotPrime[i]) {
				for(int j=2*i;j<=max;j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
		int result = 0;
		for(int i=0;i<N;i++) {
			if(!isNotPrime[numbers[i]]) {
				result++;
			}
		}
		System.out.println(result);
		br.close();
	}
}
