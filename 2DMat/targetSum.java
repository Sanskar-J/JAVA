import java.util.*;
public class targetSum {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter length");
        int n=sc.nextInt();
        System.out.println("Enter array: ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        System.out.println("Enter target :");
        int target=sc.nextInt();
        printTSum(arr,0,"",target);
    }
    public static void printTSum(int arr[],int idx,String s,int target){
        if(idx==arr.length){
            if(target==0)
            System.out.println(s+".");
            return;
        }
        printTSum(arr, idx+1, s+" "+arr[idx]+" ,", target-arr[idx]);
        printTSum(arr, idx+1, s, target);

    }
}
