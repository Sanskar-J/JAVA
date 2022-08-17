import java.util.*;
public class kadanesAlgorithm {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Fill array : ");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();

        System.out.println("Max sum is "+ kadanes(arr));
    }
    public static int kadanes(int arr[]){
        int max=arr[0],sum=arr[0];
        for(int i=0;i<arr.length;i++){
            if(sum>=0){
                sum+=arr[i];
            }
            else{
                sum=arr[i];
            }
            max=Math.max(sum,max);
        }
        return max;
    }
}
