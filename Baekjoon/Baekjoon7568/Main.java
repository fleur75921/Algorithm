import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Person {
		int weight;
		int height;
		int count;
		
		Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
			this.count = 1;
		}
		
		void countUp() {
			this.count++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Person[] persons = new Person[N];
		Person person, tmp;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			persons[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i=0;i<N;i++) {
			person = persons[i];
			for(int j=0;j<N;j++) {
				tmp = persons[j];
				if(person.weight < tmp.weight && person.height < tmp.height) {
					person.countUp();
				}
			}
		}
		for(int i=0;i<N;i++) {
			System.out.print(persons[i].count+" ");
		}
		br.close();
	}
}
