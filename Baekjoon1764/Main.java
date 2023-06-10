import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Boolean> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			map.put(br.readLine(), true);
		}
		String name;
		ArrayList<String> names = new ArrayList<>();
		for(int i=0;i<M;i++) {
			name = br.readLine();
			if(map.containsKey(name)) {
				names.add(name);
			}
		}
		names.sort(null);
		StringBuilder sb = new StringBuilder();
		sb.append(names.size()+"\n");
		for(int i=0;i<names.size();i++) {
			sb.append(names.get(i)+"\n");
		}
		System.out.print(sb);
		br.close();
	}
}
