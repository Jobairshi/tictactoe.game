import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.interfaces.XECKey;
import java.awt.*;
public class AnimiePanel extends JPanel implements ActionListener{
    final int panel_width = 1000;
    final int panel_height = 1000;
    Image ship;
    Image backGround;
    Timer timer;
    int xVelocity = 2;
    int yVelocity = 1;
    int start_x = 0;
    int start_y = 0;
    JButton button = new JButton();
    AnimiePanel()
    {
     this.setPreferredSize(new Dimension(panel_width,panel_height));
     this.setBackground(Color.BLACK);
     backGround = new ImageIcon("D:/Wallpapers/99 Most Amazing Collection of Ultra HD 4K Computer Wallpaper - 6709 [ECLiPSE]/13.jpg").getImage();
     ship = new ImageIcon("C:/Users/USER/Pictures/Screenshots/c.png").getImage();
     timer = new Timer(10, this);
   // this.add(backGround);
   button.setBounds(500,500,20,20);
    this.add(button); 
     timer.start();
    }
    public void paint(Graphics g)
    {
        super.paint(g); // to paint the backgound
        this.add(button);
        Graphics2D g2D = (Graphics2D)g;
        g2D.drawImage(backGround,0,0,null);
        g2D.drawImage(ship,start_x, start_y,null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(start_x >= (panel_width - ship.getWidth(null)) || start_x < 0)
        {
            xVelocity = xVelocity* -1;
        }
        start_x = start_x + xVelocity;
        if(start_y >= (panel_height- ship.getHeight(null)) || start_y < 0)
        {
            yVelocity = yVelocity* -1;
        }
        start_y = start_y + yVelocity;
        repaint();
    }
}
