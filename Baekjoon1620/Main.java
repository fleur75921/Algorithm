import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String name;
		HashMap<Integer, String> names = new HashMap<>();
		HashMap<String, Integer> numbers = new HashMap<>();
		for(int i=1;i<=N;i++) {
			name = br.readLine();
			names.put(i, name);
			numbers.put(name, i);
		}
		StringBuilder sb = new StringBuilder();
		String input;
		for(int i=0;i<M;i++) {
			input = br.readLine();
			if(input.charAt(0) >= "0".charAt(0) && input.charAt(0) <= "9".charAt(0)) {
				sb.append(names.get(Integer.parseInt(input))+"\n");
			} else {
				sb.append(numbers.get(input)+"\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
