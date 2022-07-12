import java.io.*;

public class FileOutputStreamExample {
    public static void main(String args[]){    
           try{    
             FileOutputStream fout=new FileOutputStream("C:\\Users\\Sanskar\\Documents\\java\\lets try applet\\testout.txt");    
             String s="Welcome to javaTpoint.";    
             byte b[]=s.getBytes();//converting string into byte array    
             fout.write(b);    
             fout.close();    
             System.out.println("success...");    

             //
             FileInputStream fin = new FileInputStream("C:\\Users\\Sanskar\\Documents\\java\\lets try applet\\testout.txt");
             int i = fin.read();
             System.out.print((char) i);
     
             fin.close();

            }catch(Exception e){System.out.println(e);}    
      

}}