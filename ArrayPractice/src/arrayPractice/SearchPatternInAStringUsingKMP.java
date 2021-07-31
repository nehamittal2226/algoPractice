package arrayPractice;

public class SearchPatternInAStringUsingKMP {

	public static void main(String[] args) {
		String txt = "THIS IS A TEST TEXT";
		String pat="TEST";
		KmpSearch(txt,pat);
		

	}

	private static void KmpSearch(String txt, String pat) {
		int[] lps=new int[pat.length()];
		computeLps(lps,pat);
		for(int i=0;i<txt.length()-1;i++) {
			for(int j=-1;j<lps.length-2;) {
				if(txt.charAt(i)==pat.charAt(j+1)) {
					j++;
				}else {
					j=lps[j];
				}
				if(j==pat.length()-2) {
					System.out.println("Yes");
				}
			}
		}
		
		
	}

	private static void computeLps(int[] lps, String pat) {
		lps[0]=0;
		int count=0;
		for(int i=1;i<pat.length()-1;i++) {
			
		}
		for(int i : lps) {
			System.out.print(i);
		}
		
	}

}
