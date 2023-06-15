import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static class Conf implements Comparable<Conf>{
		int start;
		int end;
		
		public Conf(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Conf o) {
			return this.end-o.end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Conf> list = new ArrayList<>();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Conf(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		list.sort(null);
		Conf tmp = list.get(0);
		int end = tmp.end;
		int cnt = 1;
		for(int i=1;i<N;i++ ) {
			tmp = list.get(i);
			if(tmp.start >= end) {
				end = tmp.end;
				cnt++;
			}
		}
		System.out.println(cnt);
		br.close();
	}
}
