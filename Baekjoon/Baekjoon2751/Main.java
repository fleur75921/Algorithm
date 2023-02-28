import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] isPrint = new boolean[2000001];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			isPrint[Integer.parseInt(br.readLine())+1000000] = true;
		}
		for(int i=0;i<=2000000;i++) {
			if(isPrint[i]) {
				sb.append(i-1000000+"\n");
			}
		}
		System.out.println(sb);
		br.close();
	}
}
