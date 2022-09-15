import java.util.*;
public class splitPoints {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int n=sc.nextInt();
        int arr[]=new int[n-1];
        int k=1;
        for(int i=0;i<n-1;i++){
            if((i+1)==A)
            arr[i]=++k;
            else
            arr[i]=k;
            k++;
        }
        for(int m:arr)
        System.out.println(m);
        printTwoParts(arr, n-1);
    }
    public static int findSplitPoint(int arr[], int n)
    {
      
    int leftSum = 0 ;
  
    
    for (int i = 0; i < n; i++)
    {
        
        leftSum += arr[i] ;
        int rightSum = 0 ;
          
        for (int j = i+1 ; j < n ; j++ )
            rightSum += arr[j] ;
  
        if (leftSum == rightSum)
            return i+1 ;
    }
  
    return -1;
    }   
  
    public static void printTwoParts(int arr[], int n)
    {
      
        int splitPoint = findSplitPoint(arr, n);
      
        if (splitPoint == -1 || splitPoint == n )
        {
            System.out.println("Not Possible");
            return;
        }
          
        for (int i = 0; i < n; i++)
        {
            if(splitPoint == i)
               System.out.println();
                 
            System.out.print(arr[i] + " ");
              
        }
    }
}
