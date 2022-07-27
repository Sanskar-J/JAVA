import java.util.*;

class test {
    public static void main(String ars[]) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        ArrayList<String> r = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            r.add("");
        int k = 0;
        for (int i = 0; i < s.length();) {
            while (k < numRows && i < s.length())
                r.set(k, r.get(k++) + s.charAt((i++)));

            k = numRows - 2;
            while (k >= 0 && i < s.length())
                r.set(k, r.get(k--) + s.charAt((i++)));

            k = 1;

        }
        s = "";
        for (String m : r)
            s += m;

        return s;

    }
}