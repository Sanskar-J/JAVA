public class KthPermutationSequence {
    static String s="";
    public static void main(String[] args) {
        int N=5;
        int k=3;
        solve(N,k,"",1);
        System.out.println("Answer is "+s);
    }
    public static void solve(int N,int k,String ansSoFar,int cur){
        if(k==0){
            s=new String(ansSoFar);
            // System.out.println(ansSoFar);
            return;
        }
        if(ansSoFar.length()==N){
            System.out.println(ansSoFar);
            return;
        }
        solve(N, k, ansSoFar+cur, cur+1);
        solve(N, k, ansSoFar, cur+1);
    }
}
