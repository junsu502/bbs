package function;

public class Selfnumber {

	public int dn(int j) {
		int n = j;
		int b = 0;
		String a = Integer.toString(n);
		char[] crr = new char[a.length()];
		for (int i = 0; i < crr.length; i++) {
			crr[i] = a.charAt(i);
		}
		for (int i = 0; i < crr.length; i++) {
			b += crr[i] - 48;
		}

//		System.out.println(n + b);
		
	return n+b;	
	}
	
	public static void main(String[] args) {
		int[] irr = new int[10036];
		Selfnumber sf = new Selfnumber();
	for(int i=1; i<=10000; i++) {
		irr[sf.dn(i)] = 1;
		if(irr[i] != 1) {
			System.out.println(i);
		}
	}
	}

}
