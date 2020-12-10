package domino;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class testGUI {
	
	public final static int BOARD_WIDTH = 900;
	public final static int BOARD_HIGHT = 600;
	
	public final static Color JFRAME_BACKGROUND = Colors.LIGHT_SEA_GREEN;
	
	public static void main(String[] args) {
		   DominoTable gameBoard = new DominoTable();
			  DominoTile tile1 = new DominoTile(5,3);
			  DominoTile tile2 = new DominoTile(4,5);
			  DominoTile tile3 = new DominoTile(6,3);
			  gameBoard.addRight(tile1);
			  gameBoard.addRight(tile2);
			  gameBoard.addRight(tile3);
			  gameBoard.addLeft(tile2);
			  
			  DominoTableView board = new DominoTableView(gameBoard);
		      JFrame app = new JFrame("Domino");
		      
		      app.getContentPane().setBackground( JFRAME_BACKGROUND );
		      app.setLocationRelativeTo(null);
		      app.setBounds(100, 100, BOARD_WIDTH, BOARD_HIGHT);
		      app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      app.setVisible(true);
		      
		      app.add(board);
		      /*
		      JButton btnAddLeft = new JButton("Add Left");
		      btnAddLeft.setBounds(70, 480, 100, 30);
		      //btnAddLeft.setDefaultLocale(null);
		      app.add(btnAddLeft);
		      
		      JButton btnAddRight = new JButton("Add Right");
		      btnAddRight.setBounds(730, 480, 100, 30);
		     // btnAddRight.setLocation(730, 480);
		      app.add(btnAddRight);
		      DominoTile[] tiles1 = {tile1, tile2, tile3};
		      DominoPlayer player1 = new DominoPlayer("Angela", tiles1, gameBoard);
		      String nickname = player1.getNickname();
		      JLabel lblNickname = new JLabel(nickname);
		      int nicknameLenght = lblNickname.getText().length();
		      int x = ((BOARD_WIDTH / 2) - 7*(nicknameLenght / 2));
		      lblNickname.setBounds(x, 500, 100, 30);
		      app.add(lblNickname);*/
		      
		      app.repaint();
	   }
}
