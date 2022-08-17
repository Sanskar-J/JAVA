import java.util.*;
public class crossword {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // System.out.println("Enter puzzle");
        // char[][]board=new char[10][10];
        // for(int i=0;i<board[0].length;i++){
        //     for(int j=0;j<board.length;j++)
        //     board[i][j]=sc.next().charAt(0);
        // }
        char board[][]={
            {'+','-','+','+','+','+','+','+','+','+'},
            {'+','-','+','+','+','+','+','+','+','+'},
            {'+','-','+','+','+','+','+','+','+','+'},
            {'+','-','-','-','-','-','+','+','+','+'},
            {'+','-','+','+','+','-','+','+','+','+'},
            {'+','-','+','+','+','-','+','+','+','+'},
            {'+','+','+','+','+','-','+','+','+','+'},
            {'+','+','-','-','-','-','-','-','+','+'},
            {'+','+','+','+','+','-','+','+','+','+'},
            {'+','+','+','+','+','-','+','+','+','+'}
        };
        String words[]={"DELHI","LONDON","ICELAND","ANKARA"};
        display(board);

        solution(board,words,0);
    }
    public static void solution(char board[][],String words[],int idx){
        if(idx==words.length){
            display(board);
            return;
        }
        String word=words[idx];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(board[i][j]=='-' || board[i][j]==word.charAt(0)){
                    if(canPlaceHor(board,word,i,j)){
                        boolean wePlaced[]=placeWordHor(board,word,i,j);
                        solution(board, words, idx+1);
                        unplaceWordHor(board,wePlaced,i,j);
                    }
                    if(canPlaceVer(board,word,i,j)){
                        boolean wePlaced[]=placeWordVer(board,word,i,j);
                        solution(board, words, idx+1);
                        unplaceWordVer(board,wePlaced,i,j);
                    }
                    
                }
            }
        }
    }
    public static boolean[] placeWordHor(char board[][],String word,int i,int j){
        boolean wePlaced[]=new boolean[word.length()];
        for(int jj=0;jj<word.length();jj++){
            if(board[i][j+jj]=='-'){
                board[i][j+jj]=word.charAt(jj);
                wePlaced[jj]=true;
            }
        }
        return wePlaced;
    }
    public static void unplaceWordHor(char board[][],boolean wePlaced[],int i,int j){
        for(int jj=0;jj<wePlaced.length;jj++){
            if(wePlaced[jj]==true){
                board[i][j+jj]='-';
            }
        }
    }
    public static boolean[] placeWordVer(char board[][],String word,int i,int j){
        boolean wePlaced[]=new boolean[word.length()];
        for(int ii=0;ii<word.length();ii++){
            if(board[i+ii][j]=='-'){
                board[i+ii][j]=word.charAt(ii);
                wePlaced[ii]=true;
            }
        }
        return wePlaced;
    }
    public static void unplaceWordVer(char board[][],boolean wePlaced[],int i,int j){
        for(int ii=0;ii<wePlaced.length;ii++){
            if(wePlaced[ii]==true){
                board[i+ii][j]='-';
            }
        }
    }
    public static boolean canPlaceHor(char board[][],String word,int i,int j){
        if(j-1>=0 && board[i][j-1]!='+'){
            return false;
        }
        else if(j+word.length()<board[0].length && board[i][j+word.length()]!='+'){
            return false;
        }
        for(int jj=0;jj<word.length();jj++){
            if(j+jj>=board[0].length)
            return false;
            if(board[i][j+jj]=='-' || board[i][j+jj]==word.charAt(jj)){
                continue;
            }
            else return false;
        }
        return true;
    }
    public static boolean canPlaceVer(char board[][],String word,int i,int j){
        if(i-1>=0 && board[i-1][j]!='+'){
            return false;
        }
        else if(i+word.length()<board[0].length && board[i+word.length()][j]!='+'){
            return false;
        }
        for(int ii=0;ii<word.length();ii++){
            if(i+ii>=board[0].length)
            return false;
            if(board[i+ii][j]=='-' || board[i+ii][j]==word.charAt(ii)){
                continue;
            }
            else return false;
        }
        return true;
    }
    public static void display(char board[][]){
        for(int i=0;i<board[0].length;i++){
            for(int j=0;j<board.length;j++)
            System.out.print(board[i][j]+" ");
        System.out.println();
        }
    }
}
