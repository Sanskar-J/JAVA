import java.util.*;

public class towelLoader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // String str[] = new String[n];
        // for (int i = 0; i < n; i++)
        //     str[i] = sc.next();
        String str[]={"6","T","+","R"};
        System.out.println(noTowels(4, str));
    }

    public static int noTowels(int n, String s[]) {
        ArrayList<Integer> loader=new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            ins: switch (s[i]) {
                case "R":
                loader.remove(loader.size()-1);
                    break ins;
                case "T":
                loader.add(loader.get(loader.size()-1)*2);
                    break ins;
                case "+":
            
                int x=loader.get(loader.size()-1);
                int y=loader.get(loader.size()-2);
                
                loader.add(x+y);
                
                break ins;
                default:
                loader.add(Integer.valueOf(s[i]));
                    break ins;
            }

        }
        int sum=0;
        for( int a:loader){
            sum+=a;
        }
        return sum;
    }
}
