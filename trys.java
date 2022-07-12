public class trys {
    static int x=11;
    private int y=33;
    public void method1(int x){
        trys t=new trys();
       
        y=44;
        System.out.println(trys.x);
 this.x=22;
        System.out.println(t.x);
        System.out.println(t.y);
        System.out.println(y);
    }
    public static void main(String a[]){
        trys t=new trys();
        t.method1(5);
    }
}
