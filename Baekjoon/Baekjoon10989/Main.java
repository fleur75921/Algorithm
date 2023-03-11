import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int num;
		int[] exist = new int[10001];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			num = Integer.parseInt(br.readLine());
			exist[num]++;
		}
		for(int i=1;i<=10000;i++) {
			for(int j=0;j<exist[i];j++) {
				sb.append(i+"\n");
			}
			System.out.print(sb);
			sb = new StringBuilder();
		}
		br.close();
	}
}
