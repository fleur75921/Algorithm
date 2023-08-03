import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] C = new int[N];
		st = new StringTokenizer(br.readLine());
		int size = 0;
		int pos;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pos = Arrays.binarySearch(C, 0, size, arr[i]);
			if(pos >= 0) {
				continue;
			}
			pos = -1 * (pos + 1);
			C[pos] = arr[i];
			if(pos == size) {
				size++;
			}
		}
		System.out.println(size);
		br.close();
	}
}
