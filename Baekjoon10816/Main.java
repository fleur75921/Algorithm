import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		int input;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input = Integer.parseInt(st.nextToken());
			if(map.containsKey(input)) {
				map.put(input, map.get(input)+1);
			} else {
				map.put(input, 1);
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			input = Integer.parseInt(st.nextToken());
			sb.append(map.containsKey(input) ? map.get(input)+" " : 0+" ");
		}
		System.out.println(sb);
		br.close();
	}
}
