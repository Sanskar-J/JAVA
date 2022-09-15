import java.util.*;
public class missingRepeat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Fill array");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        Pair res=missRep(arr,n);
        System.out.println("Missing "+res.x);
        System.out.println("Repeat "+res.y);
    }
    public static Pair missRep(int arr[],int n){
        int missing=0,repeat=0;
        // Pair res;
        int ab_value=0;
        //repeat
        for(int i=0;i<n;i++){
            ab_value=Math.abs(arr[i]);
            if(arr[ab_value-1]>0)
                arr[ab_value-1]=-arr[ab_value-1];
            else
                repeat=Math.abs(arr[i]);
        }
        //missing
        for(int i=0;i<n;i++){
            if(arr[i]>0)
            missing=i+1;
        }

        Pair res=new Pair(missing,repeat);
        return res;

    }
}
class Pair{
    int x,y;
    Pair(){}
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}


