public class rightMostSetBit {
   public static void main(String[] args) {
     maskForRMSB(72);
   }
   public static void maskForRMSB(int n){
    int mask=n&((~n)+1);
    int altMask=(n&-n);
    System.out.println("Mask is: "+altMask);
   } 
}
