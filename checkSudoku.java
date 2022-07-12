
public class checkSudoku {

    public static boolean isItSudoku(int matrix[][]) {

        // Write your code here.
        int countH = 0, countV = 0, count3x3 = 0;
        boolean isSudoku = true;
        outer: for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                    if (matrix[j][k] == i) {
                        countH++;
                        if (countH > 1) {
                            isSudoku = false;
                            break outer;
                        }
                    }
                    if (matrix[k][j] == i) {
                        countV++;
                        if (countV > 1) {
                            isSudoku = false;
                            break outer;
                        }
                    }
                }
                countH = 0;
                countV = 0;
            }
            for (int o = 0; o < 9; o += 3) {
                for (int m = 0; m < 9; m += 3) {
                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            int x = o + j;
                            int y = m + k;
                            if (matrix[x][y] == i) {
                                count3x3++;
                                if (count3x3 > 1) {
                                    isSudoku = false;
                                    break outer;
                                }
                            }

                        }
                    }
                    count3x3 = 0;
                }
            }
        }
        return isSudoku;

    }

    public static void main(String arg[]) {
        int[][] board = {
                { 9, 4, 1, 3, 2, 6, 7, 5, 8 },
                { 6, 3, 7, 1, 5, 8, 2, 4, 9 },
                { 8, 2, 5, 4, 9, 7, 6, 1, 3 },
                { 2, 6, 8, 7, 1, 4, 3, 9, 5 },
                { 1, 7, 4, 5, 3, 9, 8, 6, 2 },
                { 3, 5, 9, 6, 8, 2, 4, 7, 1 },
                { 4, 1, 3, 2, 6, 5, 9, 8, 7 },
                { 5, 9, 6, 8, 7, 3, 1, 2, 4 },
                { 7, 8, 2, 9, 4, 1, 5, 3, 6 }
        };
        int[][] board2 = {
                { 7, 9, 2, 1, 5, 4, 3, 8, 6 },
                { 6, 4, 3, 8, 2, 7, 1, 5, 9 },
                { 8, 5, 1, 3, 9, 6, 7, 2, 4 },
                { 2, 6, 5, 9, 7, 3, 8, 4, 1 },
                { 4, 8, 9, 5, 6, 1, 2, 7, 3 },
                { 3, 1, 7, 4, 8, 2, 9, 6, 5 },
                { 1, 3, 6, 7, 4, 8, 5, 9, 2 },
                { 9, 7, 4, 2, 1, 5, 6, 3, 8 },
                { 5, 2, 8, 6, 3, 9, 4, 1, 7 }
        };

        int board3[][] = {
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                { 5, 5, 5, 5, 5, 5, 5, 5, 5 }
        };
        System.out.println(isItSudoku(board3));
    }
}

//if char

// class Solution {
//     public boolean isValidSudoku(char[][] matrix) {
//         int countH=0,countV=0,count3x3=0;
// 		boolean isSudoku=true;
//         char c[]={'0','1','2','3','4','5','6','7','8','9'};
// 		outer:for(int i=1;i<10;i++)
// 		{
// 			for(int j=0;j<9;j++)
// 			{
// 				for(int k=0;k<9;k++)
// 				{
// 					if(matrix[j][k]==c[i])
// 					{
// 						countH++;
// 						if(countH>1)
// 						{
// 							isSudoku=false;
// 							break outer;
// 						}
// 					}
// 					if(matrix[k][j]==c[i])
// 					{
// 						countV++;
// 						if(countV>1)
// 						{
// 							isSudoku=false;
// 							break outer;
// 						}
// 					}
// 				}
// 				countH=0;countV=0;
// 			}
// 			for (int o = 0; o < 9; o += 3) {
//                 for (int m = 0; m < 9; m += 3) {
//                     for (int j = 0; j < 3; j++) {
//                         for (int k = 0; k < 3; k++) {
//                             int x = o + j;
//                             int y = m + k;
//                             if (matrix[x][y] == c[i]) {
//                                 count3x3++;
//                                 if (count3x3 > 1) {
//                                     isSudoku = false;
//                                     break outer;
//                                 }
//                             }

//                         }
//                     }
//                     count3x3 = 0;
//                 }
//             }
// 		}
// 		return isSudoku;

//     }
// }