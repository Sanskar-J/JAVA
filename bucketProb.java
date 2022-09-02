public class bucketProb {
   public static void main(String[] args) {
    int arr[]={1,3};
    System.out.println(bucket(5, 2, arr));
   }
   public static int bucket(int n,int m,int arr[]){
    boolean buckets[]=new boolean[n];
    int ans=0;
    
    for(int i=0;i<m;i++){
        query: switch(arr[i]){
            case 1:
            for(int k=0;k<n;k++)
            buckets[k]=true;
            break query;
            case 2:
            for(int k=0;k<n;k++){
                if((k+1)%2==0)
                buckets[k]=false;
                System.out.println(buckets[k]);
            }
            break query;
            case 3:
            for(int k=0;k<n;k++){
                if(k%2==0)
                buckets[k]=false;
            }
            break query;
            case 4:
            for(int k=0;k<n;k++)
            buckets[k]=false;
            break query;
            default:
            System.out.println("error");
            break query;
        }
    }
    for(boolean b:buckets)
    {
        // System.out.println(b);
        if(b==true)
        ans++;
    }
    return ans;
   } 
}
