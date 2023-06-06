import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt_two = 0;
		int cnt_five = 0;
		int tmp;
		for(int i=2;i<=N;i++) {
			tmp = i;
			while(tmp % 2 == 0) {
				cnt_two++;
				tmp /= 2;
			}
			while(tmp % 5 == 0) {
				cnt_five++;
				tmp /= 5;
			}
		}
		System.out.println(Math.min(cnt_two, cnt_five));
		br.close();
	}
}
