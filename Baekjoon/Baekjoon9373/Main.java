import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n, cnt;
		StringTokenizer st;
		HashMap<String, Integer> map;
		String type;
		ArrayList<String> types;
		for(int t=0;t<T;t++) {
			n = Integer.parseInt(br.readLine());
			cnt = 1;
			map = new HashMap<>();
			types = new ArrayList<>();
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				type = st.nextToken();
				map.put(type, map.getOrDefault(type, 0)+1);
				if(map.get(type) == 1) {
					types.add(type);
				}
			}
			for(int i=0;i<types.size();i++) {
				cnt *= (map.get(types.get(i))+1);
			}
			sb.append(cnt-1+"\n");
		}
		System.out.print(sb);
		br.close();
	}
}
