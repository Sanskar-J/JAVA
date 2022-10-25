public class pattern {
    public static void main(String[] args) {
        int n=5;
        n=n*2;

        for(int i=0;i<=n/2;i++){
            for(int j=i;j<=i+i;j++){
                
                System.out.print((j+1)+" ");
            }
            System.out.println();
        }
    }
}
