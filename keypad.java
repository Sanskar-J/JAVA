public class keypad {
    public void printCombination(String num,int i,String comb)
    {
        String keyPat[]={" ",".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        if(i==num.length()){
            System.out.println(comb);
            return;
        }
        char c=num.charAt(i);
        String map=keyPat[c-'0'];
        System.out.println(keyPat[c-'1']);
        for(int j=0;j<map.length();j++){
            printCombination(num, i+1, comb+map.charAt(j));
        }
    }
    public static void main(String a[]){
        keypad x=new keypad();
        // x.printCombination("444055566688833099966688",0,"");
        x.printCombination("234",0,"");
    }
}
