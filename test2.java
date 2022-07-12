import java.util.*;
 
class test2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter length of an square");
        int l=sc.nextInt();
        //int a[]=new int[l];
       // int b[]=new int[l];
       // int c[]=new int[l];
        int i,j,k;
       // System.out.println("Enter an array");
        //System.out.println("  a  "+);
         
        for(i=0;i<l;i++)
        {
            if(i==0||i==l-1)
            {
                for(j=0;j<l;j++)
                {
                    System.out.print("* ");
                }
               //System.out.println();
            }
            else
            {
                for(j=0;j<l;j++)
                {
                    if(j==0||j==l-1)
                    {
                        System.out.print("* ");
                    }
                    else
                    {
                      System.out.print("  ");
                    }
                    
                }

            }
            System.out.println();
        }

    }
}