import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String command;
		int N;
		int[] list;
		String str;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			command = br.readLine();
			N = Integer.parseInt(br.readLine());
			str = br.readLine();
			st = new StringTokenizer(str.substring(1, str.length()-1), ",");
			list = new int[N];
			boolean reversed = false;
			boolean isError = false;
			for(int j=0;j<N;j++) {
				list[j] = Integer.parseInt(st.nextToken());
			}
			int front = 0;
			int back = N-1;
			for(int j=0;j<command.length();j++) {
				if(command.charAt(j) == 'R') {
					reversed = !reversed;
				} else {
					if(reversed) {
						back--;
					} else {
						front++;
					}
					if(front > back + 1) {
						isError = true;
						break;
					}
				}
			}
			if(isError) {
				sb.append("error\n");
			} else {
				if(reversed) {
					sb.append("[");
					for(int j=back;j>front;j--) {
						sb.append(list[j]+",");
					}
					if(front != back + 1) {
						sb.append(list[front]);
					}
					sb.append("]");
					sb.append("\n");
				}
				else {
					sb.append("[");
					for(int j=front;j<back;j++) {
						sb.append(list[j]+",");
					}
					if(back != front - 1) {
						sb.append(list[back]);
					}
					sb.append("]");
					sb.append("\n");
				}
			}
		}
		System.out.print(sb);
		br.close();
	}
}
