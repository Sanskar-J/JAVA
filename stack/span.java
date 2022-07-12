import java.util.*;
public class span{
    public static void main(String a[])
    {
        int arr[]={12,25,35,22,57,42};
        int res[]=spanData(arr);
        for(int i=0;i<res.length;i++)
        {
            System.out.print(" "+res[i]+" ");
        }

    }

    public static int[] spanData(int arr[]){
        Stack <Integer> st=new Stack<>();
        int len=arr.length;
        int res[]=new int[len];
        st.push(0);
        res[0]=1;
        for(int i=2;i<len;i++)
        {
            while(st.size()>0  && arr[i]>arr[st.peek()])
            st.pop();

            if(st.size()==0) res[i]=i+1;
            else res[i]=i-st.peek();

            st.push(i);
        }
        return res;
    }
}