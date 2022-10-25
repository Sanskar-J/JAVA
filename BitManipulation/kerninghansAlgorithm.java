public class kerninghansAlgorithm {
    public static void main(String[] args) {
        countSetBits(31);
    }
    public static void countSetBits(int n){
        int count=0;
        int rmsbm=(n&-n);
        while(rmsbm!=0){
            rmsbm=(n&-n);
            n-=rmsbm;
            count++;
        }
        //method 2
        // while(n!=0){
        //     int rmsbm=(n&-n);
        //     n-=rmsbm;
        //     count++;
        // }

        System.out.println("No. of 1s is: "+count);
    }
}
