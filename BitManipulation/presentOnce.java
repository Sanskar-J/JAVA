public class presentOnce {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,1,2,3,4,6};
        int n=11;
        System.out.println("No. that present only once is: "+pOnce(arr, n));

    }
    public static int pOnce(int arr[],int n){
        int r=0;
        for(int x:arr)
            x=x^x;
        return r;
    }
}
