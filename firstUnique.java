
class firstUnique {
    public static int firstUniqChar(String s) {
        int ans = s.length();
        for(char c = 'a';c <= 'z';c++){
            // System.out.println(c+"---");
            int res = s.indexOf(c);
            System.out.println(s.lastIndexOf(c));
            if(res!=-1 && res==s.lastIndexOf(c))
                ans = Math.min(ans, res);
        }
        return ans==s.length() ? -1:ans;
    }
    public static void main(String a[]){
        System.out.println(firstUniqChar("asdasdascqqadb"));
    }
}

// class Solution {
//     public boolean canConstruct(String r, String m) {
//         boolean check=false;
//         HashMap<Character,Integer> hm=new HashMap<>();
//         HashMap<Character,Integer> hm2=new HashMap<>();
//         for(char ch:m.toCharArray())
//             hm.put(ch,hm.getOrDefault(ch,0)+1);
//         for(char ch:r.toCharArray())
//             hm2.put(ch,hm2.getOrDefault(ch,0)+1);
        
//         for(int i=0;i<r.length();i++){
            
//             if(hm.get(r.charAt(i))==null ||hm2.get(r.charAt(i))> hm.get(r.charAt(i)) )
//                 return false;
//         }
//         return true;
//     }
// }