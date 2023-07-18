import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		int[] res = new int[n];
		int[] tmp;
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			tmp = Arrays.copyOf(res, res.length);
			for(int j=0;j<i;j++) {
				input[j] = Integer.parseInt(st.nextToken());
				if(j == 0) {
					res[j] = tmp[j] + input[j];
				} else if(j == i-1) {
					res[j] = tmp[j-1] + input[j];
				} else {
					res[j] = Math.max(tmp[j-1], tmp[j]) + input[j];
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(res[i] > max) {
				max = res[i];
			}
		}
		System.out.println(max);
		br.close();
	}
}
