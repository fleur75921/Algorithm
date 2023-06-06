import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Point implements Comparable<Point> {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point p) {
			if(x != p.x) {
				return x-p.x;
			} else {
				return y-p.y;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> list = new ArrayList<>();
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		list.sort(null);
		Point point;
		for(int i=0;i<N;i++) {
			point = list.get(i);
			sb.append(point.x+" "+point.y+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
