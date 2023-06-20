import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String op;
		int num;
		HashSet<Integer> set = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			op = st.nextToken();
			if(op.equals("add")) {
				num = Integer.parseInt(st.nextToken());
				set.add(num);
			} else if(op.equals("check")) {
				num = Integer.parseInt(st.nextToken());
				sb.append(set.contains(num) ? 1 : 0);
				sb.append("\n");
			} else if(op.equals("remove")) {
				num = Integer.parseInt(st.nextToken());
				set.remove(num);
			} else if(op.equals("all")) {
				set = new HashSet<>();
				for(int j=1;j<=20;j++) {
					set.add(j);
				}
			} else if(op.equals("toggle")) {
				num = Integer.parseInt(st.nextToken());
				if(set.contains(num)) {
					set.remove(num);
				} else {
					set.add(num);
				}
			} else {
				set = new HashSet<>();
			}
		}
		System.out.print(sb);
		br.close();
	}
}
