import java.util.*;
public class minDevsNeeded {
    static ArrayList<Integer> sol=new ArrayList<>(); 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<String,Integer> hs=new HashMap<>();
        for(int i=0;i<n;i++)
        hs.put(sc.next(),i);

        int np=sc.nextInt();
        int []people=new int[np];
        for(int i=0;i<np;i++){
            int personSkills=sc.nextInt();
            for(int j=0;j<personSkills;j++){
                String skill=sc.next();
                int snum=hs.get(skill);
                people[i]=people[i]|(1<<snum);
            }
        }
        minNeeded(people,n,0,new ArrayList<>(),0);
        System.out.println(sol);
    }
    public static void minNeeded(int people[],int nskills,int cp,ArrayList<Integer> onesol,int smask){
        if(cp==people.length){
            if(smask==((1<<nskills)-1)){
                if(sol.size()==0 || onesol.size()<sol.size()){
                    sol=new ArrayList<>(onesol);
                }
            }
            return;
        }

        //if dev says no
        minNeeded(people, nskills, cp+1, onesol, smask);
        //if yes
        onesol.add(cp);
        minNeeded(people, nskills, cp+1, onesol, (smask|people[cp]));
        onesol.remove(onesol.size()-1);
    }
}
