import java.applet.Applet;  
import java.awt.Frame;  
import java.awt.Graphics;  
  
public class MyViewer extends Frame{  
  public static void main(String[] args) throws Exception{  
    Class c=Class.forName(args[0]);  
          
    MyViewer v=new MyViewer();  
    v.setSize(800,800);  
    v.setLayout(null);  
    v.setVisible(true);  
          
    Applet a=(Applet)c.newInstance();  
    a.start();  
    Graphics g=v.getGraphics();  
    a.paint(g);  
    a.stop();  
          
  }  
  
}  