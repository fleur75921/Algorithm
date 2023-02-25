import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=1;i<N;i++) {
			int pos_sum = 0;
			int self = i;
			int logarithm = (int)Math.log10(i);
			while(logarithm >= 0) {
				pos_sum += (self / (int)Math.pow(10, logarithm));
				self = self % (int)Math.pow(10, logarithm);
				logarithm--;
			}
			if(pos_sum + i == N) {
				System.out.println(i);
				System.exit(0);
			}
		}
		System.out.println(0);
		br.close();
	}
}
