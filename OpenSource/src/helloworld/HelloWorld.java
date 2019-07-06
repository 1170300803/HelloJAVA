package helloworld;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class HelloWorld {
  //main process draw the frame 
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        FontFrame frame = new FontFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}


class FontFrame extends JFrame {
  private static final long serialVersionUID = 1L;

  public FontFrame() {
    setTitle("JAVA");//set title
    setSize(Constant.DEFAULT_WIDTH, Constant.DEFAULT_HEIGHT);
    FontComponent component = new FontComponent();//create components
    add(component);//add components
  }
}

//add various components 
class FontComponent extends JComponent {
  private static final long serialVersionUID = 1L;

  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    String message = "Hello World!";

    Font font = new Font("Serif", Font.BOLD, Constant.FONT_SIZE);
    g2.setFont(font);

    FontRenderContext context = g2.getFontRenderContext();
    Rectangle2D bounds = font.getStringBounds(message, context);

    double x = (getWidth() - bounds.getWidth()) / 2;
    double y = (getHeight() - bounds.getHeight()) / 2;

    double ascent = -bounds.getY();
    double baseY = y + ascent;

    g2.drawString(message, (int) x, (int) baseY);

  }
}


