import java.util.*;

public class runCustomerSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of comps: ");
        int n = sc.nextInt();
        System.out.println("Enter squence");
        String s = sc.next();
        HashSet<Character> hs = new HashSet<>();

        char[] sq = s.toCharArray();
        int count = 0;
        for (char c : sq) {
            if (hs.size() >= n) {
                if (hs.add(c) == false) {
                    hs.remove(c);
                } else {
                    count++;
                }

            } else {
                if (hs.add(c) == false) {
                    hs.remove(c);
                }
            }

        }

        for (char c : hs) {
            System.out.println(c);
        }
        System.out.println("No. of peeps who didnt got to use the computer: " + count);
    }
}
