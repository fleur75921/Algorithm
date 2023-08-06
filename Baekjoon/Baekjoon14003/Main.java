import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] LIS = new int[N];
        int[] trace = new int[N];
        int[] prev = new int[N];
        int max = 0;
        for(int i=0;i<N;i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	int pos = Arrays.binarySearch(LIS, 0, max, arr[i]);
        	if(pos < 0) {
	        	pos = -1 * (pos + 1);
	        	LIS[pos] = arr[i];
	        	trace[pos] = i;
	        	if(pos != 0) {
	        		prev[i] = trace[pos - 1];
	        	}
	        	if(pos == max) {
	        		max++;
	        	}
        	}
        }
        sb.append(max+"\n");
        int[] result = new int[max];
        for(int i=max-1, j=trace[max-1];i>=0;i--) {
        	result[i] = arr[j];
        	j = prev[j];
        }
        for(int i : result) {
        	sb.append(i + " ");
        }
        System.out.print(sb);
        br.close();
    }
}
