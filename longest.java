package info1103;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

public class longest {
	public static String[] cutOne(String[] m) {
		String[] j = new String[m.length-1];
		List<String> al = new ArrayList<String>();
		for (String i : m) {
			al.add(i);
		}
		al.remove(al.size()-1);
		al.toArray(j);
		return j;
	}
	public static int findLCSlength(String[] m, String[] n) {
		if (m.length == 1 || n.length == 1) {
			if (m[m.length-1].equals(n[n.length-1])) {
				return 1;
			}
			if (m.length > n.length) {
				String[] j = cutOne(m);
				return findLCSlength(j,n);
			}
			if (n.length > m.length) {
				String[] k = cutOne(n);
				return findLCSlength(k,m);
			}
				return 0;
		}
		String[] j = cutOne(m);
		String[] k = cutOne(n);
		if (m[m.length-1].equals(n[n.length-1])) {
			return 1 + findLCSlength(j,k);
		}
		else {
			return Math.max(findLCSlength(j,n),findLCSlength(k,m));
		}
	}
	public static String[] findLCS(String[] m, String[] n) {
		if (m.length == 1 || n.length == 1) {
			if (m[m.length-1].equals(n[n.length-1])) {
				String[] r = {m[m.length-1]};
				return r;
			}
			if (m.length > n.length) {
				String[] j = cutOne(m);
				return findLCS(j,n);
			}
			if (n.length > m.length){
				String[] k = cutOne(n);
				return findLCS(k,m);
			}
			return null;
		}
		String[] j = cutOne(m);
		String[] k = cutOne(n);
		if (m[m.length-1].equals(n[n.length-1])) {
			int lengthjk = findLCSlength(j,k);
			String[] LCS = new String[lengthjk + 1];
			for (int i = 0; i < lengthjk; i++) {
				LCS[i] = findLCS(j,k)[i];
			}
			String x = m[m.length-1];
			LCS[lengthjk] = x;
			return LCS;
		}
		else {
			if (findLCSlength(j,n) > findLCSlength(k,m)) {
				return findLCS(j,n);
			}
			return findLCS(k,m);
		}
	}
	public static void main(String[] args) {
		String[] a,b;
		if (args.length > 2 || args.length == 0) {
			return;
		}
		a = args[0].split(",");
		b = args[1].split(",");
		System.out.println(findLCSlength(a,b));
		String[] LCS = findLCS(a,b);
		System.out.print("{");
		if (LCS != null) {
			for (int i = 0; i < LCS.length - 1; i++) {
				System.out.print(LCS[i] + ", ");
			}
			System.out.print(LCS[LCS.length - 1]);
		}
		System.out.print("}");
	}
}
