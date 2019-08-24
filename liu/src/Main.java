import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] count = new int[1000];
        char[] a;
        a = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(a[i])) {
                count[a[i]]++;
            } else {
                set.add(a[i]);
                count[a[i]]++;
            }
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            char k= (char) it.next();
            for (int i = 0; i < a.length; i++) {
                if (k==(a[i])) {
                    System.out.print(k+ "_" + count[a[i]]);
                    break;
                }
            }
        }
        /*for (int i = 0; i <set.size() ; i++) {
            System.out.print(set.+"_"+count[a[i]]);
        }*/
    }
}
