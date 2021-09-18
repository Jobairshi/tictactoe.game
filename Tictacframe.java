import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;



import java.util.*;
import java.awt.event.*;
public class Tictacframe implements ActionListener {
    int draaw = 0;
    int moves = 0;
    Random random = new Random(); // for random turns
    JFrame  frame = new JFrame();
    JPanel panel = new JPanel(); // for title
    JPanel button_Panel =  new JPanel(); // to hold the buttons
    JLabel text = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean p1_turn; 
    Tictacframe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.green);
        text.setFont(new Font("Ink Free",Font.BOLD,75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("tictactoe");
        text.setOpaque(true);
       // frame.add(panel);
        panel.setLayout(new BorderLayout());
        panel.setBounds(0,0,800,100);
        panel.add(text);
        button_Panel.setLayout(new GridLayout(3,3)); // 3*3 = 9 buttons
        for(int i = 0;i<9;i++)
        {
            buttons[i] = new JButton();
            button_Panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            
        }
        frame.setResizable(false);
        frame.add(panel,BorderLayout.NORTH);
        frame.add(button_Panel);
        whoFirst();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i<9;i++)
        {
            if(e.getSource() == buttons[i])
            {
                if(p1_turn == true)
                {
                    if(buttons[i].getText()== "")
                    {
                        buttons[i].setForeground(Color.PINK);
                        buttons[i].setText("O");
                        p1_turn = false;
                        text.setText("player 2 turn");
                        moves++;
                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText()== "")
                    {
                        buttons[i].setForeground(Color.CYAN);
                        buttons[i].setText("X");
                        p1_turn = true;
                        text.setText("player 1 turn");
                        moves++;
                        check();
                    }
                }
            }
            System.out.println(moves);
        }
    }

    public void whoFirst() // randomly gives first mvoe
    {
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
       if(random.nextInt(2) == 0)
       {
           p1_turn = true;
           text.setText("Player 1 turn");
       }
       else
       {
           p1_turn = false;
           text.setText("Player 2 turn");
       }
    }
    public void check()
    {
        if((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X"))
        {
             P2Wins(0,1,2);
        }
        if((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X"))
        {
            P2Wins(3,4,5);
        }
        if((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X"))
        {
            P2Wins(6,7,8);
        }
        if((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X"))
        {
            P2Wins(0,3,6);
        }
        if((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X"))
        {
            P2Wins(1,4,7);
        }
        if((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X"))
        {
            P2Wins(2,5,8);
        }
        if((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X"))
        {
            P2Wins(0,4,8);
        }
        if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X"))
        {
            P2Wins(2,4,6);
        }


        // for p1
        if((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O"))
        {
             P1Wins(0,1,2);
        }
        if((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O"))
        {
            P1Wins(3,4,5);
        }
        if((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O"))
        {
            P1Wins(6,7,8);
        }
        if((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O"))
        {
            P1Wins(0,3,6);
        }
        if((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O"))
        {
            P1Wins(1,4,7);
        }
        if((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O"))
        {
            P1Wins(2,5,8);
        }
        if((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O"))
        {
            P1Wins(0,4,8);
        }
        if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O"))
        {
            P1Wins(2,4,6);
        }
        else if(moves == 9)
        {
            draw();
            draaw = 1;
        }
    }
    public  void P1Wins(int a,int b,int c) // if 0 00  wins
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        text.setText("PLAYER ONE WON");
        for(int i = 0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
    }
    public void P2Wins(int a,int b,int c) // X X  Xwins
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        text.setText("PLAYER TWO WON");
        for(int i = 0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
    }
    public void draw()
    {
        text.setText("DRAW");
        for(int i = 0;i<9;i++)
        {
            buttons[i].setBackground(Color.RED);
            buttons[i].setEnabled(false);
        }
    }
}
