import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int remove = (int)Math.round(N * 0.15);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		list.sort(null);
		int sum = 0;
		for(int i=remove;i<N-remove;i++) {
			sum += list.get(i);
		}
		int avg = (int)Math.round(sum*1.0 / (N - 2 * remove));
		System.out.println(avg);
		br.close();
	}
}
