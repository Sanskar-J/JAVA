import java.applet.*;
import java.awt.*;
import java.net.URL;

public class First extends Applet {

    Image pic;
    URL appletCodeDir;
    public void init()
    {
        setBackground(Color.cyan);
        // pic=getImage(getCodeBase(),"sonoo.jpg");
    }

    public void paint(Graphics g) {
        // g.setColor();
        // appletCodeDir=getDocumentBase();
        g.drawString("fuck u bich 1", 100, 50);
        g.drawLine(0, 0, 400, 400);
        g.drawRect(30, 60, 300, 300);
        g.fillRect(170, 100, 30, 30);
        g.drawOval(70, 200, 60, 60);

        g.setColor(Color.pink);
        g.fillOval(170, 200, 30, 30);
        g.drawArc(90, 150, 30, 30, 30, 270);
        g.fillArc(270, 150, 30, 30, 0, 180);

        // g.drawImage(pic, 30,30, this);  
        showStatus("fuck u bich 3");
    }
}
