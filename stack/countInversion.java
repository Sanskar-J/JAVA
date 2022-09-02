import java.util.*;
public class countInversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter N: ");
        int n=sc.nextInt();
        long arr[]=new long[n];
        System.out.println("Enter arr :");
        for(int i=0;i<n;i++)
        arr[i]=sc.nextLong();

        System.out.println("No. of inversions are : "+inversionCount(arr,n));
    }
    public static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        Stack<Long> st=new Stack<>();
        int i=0,swap=0;
        while(i<N){
            if(!st.isEmpty() && arr[i]<st.peek()){
                long t=arr[i-1];
                arr[i-1]=arr[i];
                arr[i]=t;
                swap++;
                st.pop();
                i--;
            }
            else{
                st.push(arr[i++]);
            }
        }
        return swap;
    }
}
