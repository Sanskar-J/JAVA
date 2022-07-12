public class stringPrblem1 {

    public String removeBracs(String str){
        String res="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '[')
            {
                while(str.charAt(i+1) != ']'){
                    res+=str.charAt(i+1);
                    i++;
                }
            }
        }
        return res;
    }
    public int getNumeric(String s){
        int i=0;String w="";
        while(s.charAt(i)!='['){
            w+=s.charAt(i);
            i++;
        }
        i=Integer.parseInt(w);
        return i;
    }

    public String decodeString(String s) {
        String res = "",finRes="";
        int i = 0;
        while (i < s.length()) {
            while (s.charAt(i) != ']') {
                res += s.charAt(i);
                i++;
            }
            res+="]";
            String p=removeBracs(res);
            int x=getNumeric(res);
            for(int j=0;j<x;j++)
            finRes+=p;

            res="";
            // s=s.substring(i+1,s.length());
            i++;
        }
        return finRes;
    }
    public static void main(String []a){
        stringPrblem1 q=new stringPrblem1();
        System.out.println(q.removeBracs("365[abc]"));
        System.out.println(q.getNumeric("365[abc]"));
        System.out.println(q.decodeString("3[aasd]2[faf]"));
    }
}
