import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) {
		String aaa = "Ab% Cd^ Ef& Gh*";
		
		StringTokenizer st = new StringTokenizer(aaa.toString().toLowerCase(), "%^&* ");
		
		int cnt = st.countTokens();
		System.out.println(cnt);
		
		while(st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
	}

}
