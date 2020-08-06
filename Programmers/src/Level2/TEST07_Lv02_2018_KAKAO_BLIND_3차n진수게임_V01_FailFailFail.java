package Level2;

//3개 맞음. -> 틀린 이유 : 원래 진법을 잘 몰랐기 때문 즉, 16진법에서의 26은 1A인데, 나는 110으로 출력 애초에 잘못 짜였다...
//13진수 130->A0 인데 나는 100으로 출력 -> 망
public class TEST07_Lv02_2018_KAKAO_BLIND_3차n진수게임_V01_FailFailFail {
	public static void main(String[] args) {
		int n = 5;
		int t = 20;
		int m = 4;
		int p = 3;
		String result = solution(n, t, m, p);
		
		System.out.println(result);

	}
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        if(n>10) {
        	for(int i=0;i<10;i++) {
        		sb.append(String.valueOf(i));
        	}
        	for(int i=10;i<n;i++) {
        		sb.append(Integer.toHexString(i).toUpperCase());
        	}
        }else {
        	for(int i=0;i<n;i++) {
        		sb.append(String.valueOf(i));
        	}
        }
        
        for(int i=n;sb.length()<t*m;i++) {
        	int num = i;
        	int cnt = 1;
        	do {
        		int share = num/n;
        		num/=n;
        		if(share%n==0) {
        			cnt++;
        			continue;
        		}else {
        			sb.append(share);
        			break;
        		}
        	}while(true);
        	
        	num = i;
        	if((num/n)%n==0) {
        		while(cnt!=0) {
        			sb.append(num%n);
        			cnt--;
        		}
        	}else {
        		sb.append(num%n);
        	}
        }
        
        //System.out.println(sb);
        int count = 0;
        int idx = p-1;
        while(count!=t) {
        	answer+=sb.charAt(idx);
        	idx+=m;
        	count++;
        }
        
        return answer;
    }
}
