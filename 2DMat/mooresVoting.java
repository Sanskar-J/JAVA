import java.util.*;
public class mooresVoting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // System.out.println("Enter n");
        // int n=sc.nextInt();
        // int arr[]=new int[n];
        // System.out.println("Fill array");
        // for(int i=0;i<n;i++)
        // arr[i]=sc.nextInt();
        int arr[]={1,1,2,2,2};
        System.out.println("result: "+majorityElement(arr,5));
    }
    public static int majorityElement(int arr[],int n){
        int count =0,index=0;
        for(int i=0;i<n;i++){
            if(arr[index]==arr[i])
            count++;
            else
            count--;
            if(count==0)
            {
                index=i;
                count++;
            }
        }
        // System.out.println(count);

        if(count>0){
            count=0;
            for(int i=0;i<n;i++){
                if(arr[index]==arr[i])
                count++;
            }
            // System.out.println(count);
            if(count > Math.floor(n/2))
            return arr[index];
        }
        return -1;
    }
}
