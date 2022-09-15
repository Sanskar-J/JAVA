import java.util.*;
public class maxForce {
    

    public static void main(String[] args) {
        int maxmf=150,minmf=120,maxf=295;
        ArrayList<Integer> al=new ArrayList<>();
        minPunches(maxf,maxmf,minmf,al);
        System.out.println(al);
    }
    public static void maxPunches(int maxf,int maxPf,int minPf,ArrayList<Integer> al){
        if(minPf>maxPf)
        return;
        if(maxf==0){
            System.out.println(al);
        return;
        }
        if(maxf>minPf)
        return;
        al.add(minPf);
        maxPunches(maxf-minPf, maxPf, minPf, al);
        maxPunches(maxf-minPf, maxPf, minPf+1, al);
        al.remove(al.size()-1);
        
    }
    public static void minPunches(int maxf,int maxPf,int minPf,ArrayList<Integer> al){
        if(maxPf<minPf)
        return;
        if(maxf==0){
            System.out.println(al);
        return;
        }
        if(maxf<minPf)
        return;
        al.add(maxPf);
        maxPunches(maxf-maxPf, maxPf, minPf, al);
        maxPunches(maxf-maxPf, maxPf-1, minPf, al);
        al.remove(al.size()-1);
        
    }
}
