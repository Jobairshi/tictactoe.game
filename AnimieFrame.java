import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.AttributeSet.ColorAttribute;


import java.awt.*;
import java.awt.event.*;
public class AnimieFrame implements ActionListener{
    JButton button;
    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JLabel title = new JLabel();
    ImageIcon icon = new ImageIcon("C:/Users/USER/Pictures/sss.png");
    JLabel logo = new JLabel();
    AnimieFrame()
    {
        button = new JButton("START");
        title.setText("TICTACTOE");
        title.setFont(new Font("Ink Free",Font.BOLD,70));
        title.setForeground(Color.GREEN);
        logo.setIcon(icon);
        button.setFocusable(false);
        logo.setBounds(300,150,200,200);
        logo.setOpaque(true);
        logo.setBackground(Color.BLUE);
        label.add(logo);
        title.setBackground(Color.blue);
        title.setOpaque(true);
        title.setBounds(170,0,500,200);
        label.add(title);
        label.setBounds(0,0,800,800);
        label.setSize(800,800);
        label.setBackground(Color.BLUE);
        button.setBackground(java.awt.Color.BLACK);
        button.setFont(new Font("Ink Free",Font.BOLD,20));
        button.setForeground(java.awt.Color.GREEN);
        button.setBounds(300,400,200,40);
        button.setFocusable(false);
        button.addActionListener(this);
        label.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        label.setOpaque(true);
        frame.add(label);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button)
        {
           frame.dispose();
           Tictacframe tictac = new Tictacframe();
        }
        
    }
}
