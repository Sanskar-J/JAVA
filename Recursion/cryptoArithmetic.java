import java.util.*;

public class cryptoArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1");
        String s1 = sc.nextLine();
        System.out.println("Enter String 2");
        String s2 = sc.nextLine();
        System.out.println("Enter String 3");
        String s3 = sc.nextLine();
        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
            if (!charIntMap.containsKey(s1.charAt(i))) {
                charIntMap.put(s1.charAt(i), -1);
                unique += s1.charAt(i);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            if (!charIntMap.containsKey(s2.charAt(i))) {
                charIntMap.put(s2.charAt(i), -1);
                unique += s2.charAt(i);
            }
        }
        for (int i = 0; i < s3.length(); i++) {
            if (!charIntMap.containsKey(s3.charAt(i))) {
                charIntMap.put(s3.charAt(i), -1);
                unique += s3.charAt(i);
            }
        }
        boolean usedNos[] = new boolean[10];
        cryptSol(unique, 0, charIntMap, usedNos, s1, s2, s3);
    }

    public static void cryptSol(String unique, int idx, HashMap<Character, Integer> charIntMap, boolean[] usedNos,
            String s1, String s2, String s3) {

                char ch=unique.charAt(idx);
                for(int i=0;i<10;i++)
                {
                    if(usedNos[i]==false){
                        usedNos[i]=true;
                    }
                }
    }
}
