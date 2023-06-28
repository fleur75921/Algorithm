import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	// 중복순열에서 입력값을 주기 위한 배열
	static String[] MBTI = {"ESTJ", "ESTP", "ESFJ", "ESFP", "ENTJ", "ENTP", "ENFJ", "ENFP", "ISTJ", "ISTP", "ISFJ", "ISFP", "INTJ", "INTP", "INFJ", "INFP"};
	// 중복순열에서 결과 저장을 위한 배열
	static String[] res;
	
	// 비트 연산을 위한 해시맵
	static HashMap<String, Integer> bit;
	// MBTI별 입력 횟수 카운팅을 위한 해시맵
	static HashMap<String, Integer> exist;
	
	// 최솟값 저장 변수
	static int min;
	
	// 중복순열 메서드
	static void r_comb(int n, int start) {
		if(n == 3) {
			int cnt;
			// 해시맵 상태 유지를 위해 복사
			HashMap<String, Integer> map = new HashMap<>();
			map.putAll(exist);
			for(int i=0;i<3;i++) {
				cnt = map.getOrDefault(res[i], 0);
				if(cnt == 0) {
					return;
				}
				map.put(res[i], cnt - 1);
			}
			cnt = getDist();
			if(cnt < min) {
				min = cnt;
			}
			return;
		}
		for(int i=start;i<16;i++) {
			res[n] = MBTI[i];
			r_comb(n+1, i);
		}
	}
	
	// 세 MBTI 사이 거리 계산 메서드
	static int getDist() {
		int dist = 0;
		int a = bit.get(res[0]);
		int b = bit.get(res[1]);
		int c = bit.get(res[2]);
		int tmp;
		int tmp2;
		// a와 b의 거리
		for(int i=0;i<4;i++) {
			// 비트연산자를 통해 각 자리가 같은 지 비교
			tmp = a & 1 << i;
			tmp2 = b & 1 << i;
			// 각 자리가 1,0 혹은 0,1인 경우(서로 다른 경우) 거리에 1 더한다.
			if((tmp > 0 && tmp2 == 0) || (tmp == 0 && tmp2 > 0)) {
				dist++;
			}
		}
		// a와 c의 거리
		for(int i=0;i<4;i++) {
			tmp = a & 1 << i;
			tmp2 = c & 1 << i;
			if((tmp > 0 && tmp2 == 0) || (tmp == 0 && tmp2 > 0)) {
				dist++;
			}
		}
		// b와  c의 거리
		for(int i=0;i<4;i++) {
			tmp = b & 1 << i;
			tmp2 = c & 1 << i;
			if((tmp > 0 && tmp2 == 0) || (tmp == 0 && tmp2 > 0)) {
				dist++;
			}
		}
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// 비트 연산을 위한 해시맵
		bit = new HashMap<>();
		// 16가지 MBTI를 이진수에 매칭(0~15)
		bit.put("ESTJ", 0b1111);
		bit.put("ESTP", 0b1110);
		bit.put("ESFJ", 0b1101);
		bit.put("ESFP", 0b1100);
		bit.put("ENTJ", 0b1011);
		bit.put("ENTP", 0b1010);
		bit.put("ENFJ", 0b1001);
		bit.put("ENFP", 0b1000);
		bit.put("ISTJ", 0b0111);
		bit.put("ISTP", 0b0110);
		bit.put("ISFJ", 0b0101);
		bit.put("ISFP", 0b0100);
		bit.put("INTJ", 0b0011);
		bit.put("INTP", 0b0010);
		bit.put("INFJ", 0b0001);
		bit.put("INFP", 0b0000);
		int T = Integer.parseInt(br.readLine());
		String input;
		res = new String[3];
		// 테스트 케이스 for문
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			// MBTI별 입력 횟수 카운팅을 위한 해시맵
			exist = new HashMap<>();
			// min값 초기화
			min = Integer.MAX_VALUE;
			// N개의 MBTI 입력을 받는 for문
			for (int i = 0; i < N; i++) {
				input = st.nextToken();
				// 존재하면 해시맵에서 가져온 값에 +1, 존재하지 않을 경우 1(기본값 + 1)
				exist.put(input, exist.getOrDefault(input, 0)+1);
			}
			// 중복순열로 16가지 MBTI중 3개를 뽑는 모든 경우의 수를 계산
			r_comb(0, 0);
			// 답 저장
			sb.append(min+"\n");
		}
		// 답 출력
		System.out.print(sb);
		br.close();
	}
}
