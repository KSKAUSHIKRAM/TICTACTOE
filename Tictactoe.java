
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tictactoe  {
      int width=600;
      int height=650;
      JFrame frame=new JFrame("TIC TAC TOE");
      
      JLabel textLabel=new JLabel();
      JPanel textPanel=new JPanel(); 
      JPanel boardPanel=new JPanel();

    String playerX="X";
    String playerO="O";
    String currentPlayer=playerX;
    boolean gameover=false;

    JButton board[][]=new JButton[3][3];
      public Tictactoe(){
        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
         
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.WHITE);
        textLabel.setFont(new Font("Arial",Font.BOLD,50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel,BorderLayout.NORTH);
        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);
        for(int row=0;row<3;row++){
          for(int col=0;col<3;col++){

            JButton tile=new JButton();
            board[row][col]=tile;
            boardPanel.add(tile);
            tile.setBackground(Color.darkGray);
            tile.setForeground(Color.white);
            tile.setFont(new Font("Arial",Font.BOLD,120));
            tile.setFocusable(false);
            tile.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e){
                JButton tile=(JButton) e.getSource();
                if(tile.getText()==""){

                  tile.setText(currentPlayer);
                  currentPlayer=currentPlayer==playerX ? playerO:playerX;
                  textLabel.setText(currentPlayer +"s turn");

                }
                
              }
            });

          }
        }
    }
}
