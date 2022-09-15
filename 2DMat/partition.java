import java.util.*;
public class partition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n");
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        display(arr);
        // int k[]=partition(arr,n);
        System.out.println();
        // qSort(arr, 0, n-1);
        part(arr);
        display(arr);
    }
    public static void qSort(int arr[],int low,int high){
        if(low>=high)
        return;

        int pivot=arr[high];
        int p=partition(arr, pivot,low,high);
        qSort(arr, low, p-1);
        qSort(arr, p+1, high);
    }
    public static int partition(int arr[],int pivot,int low,int high){
        int i=low,j=low;
        // int pivot =arr[n-1];
        while(i<=high){
            if(arr[i]>pivot){
                i++;
            }
            else{
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }
        return j-1;
    }
    public static void part(int arr[]){
        int i=0,j=0;
        int pivot =arr[arr.length-1];
        while(i<=arr.length-1){
            if(arr[i]<=pivot){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
            i++;
        }
    }
    public static void display(int a[]){
        for(int i=0;i<a.length;i++)
        System.out.print(a[i]+" ");
    }
}
