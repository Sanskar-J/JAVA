import java.util.*;
public class mergeWithoutExtraSpace {
    public static void main(String[] args) {
        int arr1[]={1,4,7,9};
        int arr2[]={2,2,3,8};

        for(int x:arr1)
        System.out.print(x+" ");
        for(int x:arr2)
        System.out.print(x+" ");
        System.out.println();
        merge(arr1,arr2);
        for(int x:arr1)
        System.out.print(x+" ");
        for(int x:arr2)
        System.out.print(x+" ");
    }
    public static void merge(int a[],int b[]){
        int n=a.length;
        int m=b.length;
        int l=0;
        for(int i=0;i<n;){
            if(a[i]<=b[l]){
                i++;
            }
            else{
                int t=a[i];
                a[i]=b[l];
                b[l]=t;
                int k=l+1;
                while(k<m){
                    if(b[l]>b[k]){
                        t=b[l];
                        b[l]=b[k];
                        b[k]=t;
                        l++;
                    }
                k++;
                }
                l=0;
            }
        }
    }
    public static void correctPos(int val,int b[]){
        int i=1;
        while(val>b[i]){
            i++;
        }
        swap(b[0],b[i]);
    }
    public static void swap(int a,int b){
        int t=a;
        a=b;
        b=t;
    }
}
