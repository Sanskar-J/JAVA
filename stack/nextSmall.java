import java.util.*;
public class nextSmall {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int [n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        for(int x:arr){
            System.out.print("  "+x);
        }
        System.out.println("max area: "+ largestAreaHistogram(arr));
        int res[]=nextSmaller(arr);
        for(int x:res){
            System.out.print("  "+x);
        }

    }
    public static int largestAreaHistogram(int a[]){
        int pse[]=prevSmaller(a);
        int nse[]=nextSmaller(a);
        int maxArea=0;
        for(int i=0;i<a.length;i++){
            int area=(nse[i]-pse[i]-1)*a[i];
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
    public static int[] prevSmaller(int a[]){
        int res[]=new int[a.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<a.length;i++){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public static int[] nextSmaller(int a[]){
        int res[]=new int[a.length];
        Stack<Integer> st=new Stack<>();
        for(int i=a.length-1;i>=0;i--){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }
            else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
}

