import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class User implements Comparable<User> {
		int age;
		String name;
		
		User(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(User user) {
			return this.age - user.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<User> list = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new User(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		list.sort(null);
		for(User user:list) {
			sb.append(user.age+" "+user.name+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
