import java.util.*;

public class removeInvalidParenthesis {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        String s = "()())()";
        int mr = minRemovals(s);
        returnValid(s, hs, mr);
        System.out.println(hs);
    }

    public static void returnValid(String s, HashSet<String> res, int mr) {
        if (mr == 0 && minRemovals(s) == 0) {
            res.add(s);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            returnValid(left + right, res, mr - 1);
        }
    }
    //this function is not needed
    public static boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else if (s.charAt(i) == ')')
                count--;
            if (count < 0)
                return false;
        }
        return count == 0;
    }

    public static int minRemovals(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                st.push(ch);
            else if (ch == ')') {
                if (st.isEmpty() || st.peek() == ')')
                    st.push(ch);
                else if (st.peek() == '(')
                    st.pop();
            }
        }
        return st.size();
    }
}
