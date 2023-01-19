public class Amazon {
    public static int minWords(String s,String t){
        int log[]=new int[26];
        int tar[]=new int[26];
        for(int i=0;i<s.length();i++)
        log[s.charAt(i)-'a']++;
        for(int i=0;i<t.length();i++)
        tar[t.charAt(i)-'a']++;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            int temp=log[i]-tar[i];
            if(temp<0)return 0;
            if(temp>0 && tar[i]!=0)ans=Math.min(ans,temp);
        }
        System.out.println();
        for(int x:log)
        System.out.print(x+" ");
        System.out.println();
        for(int x:tar)
        System.out.print(x+" ");
        System.out.println();
        return ans+1;
        
    }
    public static void main(String[] args) {
        System.out.println(minWords("abcabc", "edac"));
        System.out.println(minWords("abcabc", "abc"));
        System.out.println(minWords("mormonemonsnmon", "mon"));
    }
}
