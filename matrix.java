import java.util.*;  
public class matrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>(); 
        int k=0,i=0,j=0,round=1,rowLen=matrix.length,colLen=matrix[0].length,chU=0,chD=0;
        while(k<rowLen*colLen){
            if(round %2==0)
            {
                while(j<colLen)
                {
                    System.out.print(matrix[i][j]+" ");
                    list.add(matrix[i][j++]);
                }
                
                j--;i++;
                round++;
            }
            else{
                while(i<rowLen)
                {
                    list.add(matrix[i++][j]);
                }
                round++;
            }
            k++;
        }
        return list;
   }
    public static void main (String a[])
    {
        int b[][]={{1,2,3,22},{4,5,6,48},{7,8,9,69}};
        System.out.println(spiralOrder(b));
        // System.out.println(b[3].length);
    }
}
