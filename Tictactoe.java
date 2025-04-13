
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tictactoe  {
      int width=600;
      int height=650;
      int turns=0;
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
                if(gameover) return;
                JButton tile=(JButton) e.getSource();
                if(tile.getText()==""){
                  tile.setText(currentPlayer);
                  turns++;
                  checkwinner();
                  if(!gameover){
                  currentPlayer=(currentPlayer==playerX ? playerO:playerX);
                  textLabel.setText(currentPlayer +"s turn");
                  }

                }
                
              }
            });

          }
        }
    }
    void checkwinner(){
      //horizontal
      for(int row=0;row<3;row++){
        
        if(board[row][0].getText()=="")continue;
        
        if(board[row][0].getText()==board[row][1].getText()&& 
        board[row][1].getText()==board[row][2].getText()){
          for(int i=0;i<3;i++){
            setWinner(board[row][i]);
          }
          gameover=true;
          return;
        }
      }
        //vertically
        for(int col=0;col<3;col++){
          if(board[0][col].getText()=="") continue;

          if(board[0][col].getText()==board[1][col].getText() &&
           board[1][col].getText()==board[2][col].getText()
          ){
            for(int i=0;i<3;i++){
              setWinner(board[i][col]);

            }
            gameover=true;
            return;
          }
        }
        if(board[0][0].getText()==board[1][1].getText() &&
           board[1][1].getText()==board[2][2].getText() &&
           board[0][0].getText() !=""
        ){
          for(int i=0;i<3;i++){
            setWinner(board[i][i]);
          }
          gameover=true;
          return;
        }
       
        if (board[0][2].getText() == board[1][1].getText() &&
        board[1][1].getText() == board[2][0].getText() &&
        board[0][2].getText() != "") {
        setWinner(board[0][2]);
        setWinner(board[1][1]);
        setWinner(board[2][0]);
        gameover = true;
        return;
    }
     if(turns==9){
      for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
           settie(board[i][j]);
        }
      }
     }
    }
    void setWinner(JButton tile){
      tile.setBackground(Color.green);
      tile.setForeground(Color.gray);
      textLabel.setText(currentPlayer + "is the winner!");
    }
    void settie(JButton t){
      t.setForeground(Color.ORANGE);
      t.setBackground(Color.gray);
      textLabel.setText("Tie");
    }
}
