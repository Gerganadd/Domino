package domino;

import java.awt.Color;

import javax.swing.JFrame;

public class testGUI {
	
	public final static int BOARD_WIDTH = 900;
	public final static int BOARD_HIGHT = 600;
	public final static JFrameBackgroundColors background = JFrameBackgroundColors.MEDIUM_SEA_GREEN;
	public final static Color JFRAME_BACKGROUND = background.getColor();
	
	public static void main(String[] args) {
		   DominoTable gameBoard = new DominoTable();
			  DominoTile tile1 = new DominoTile(5,3);
			  DominoTile tile2 = new DominoTile(3,3);
			  DominoTile tile3 = new DominoTile(3,6);
			  gameBoard.addRight(tile1);
			  gameBoard.addRight(tile2);
			  gameBoard.addRight(tile3);
			  
			  DominoTableView board = new DominoTableView(gameBoard);
		      JFrame app = new JFrame("Domino");
		      
		      app.getContentPane().setBackground( JFRAME_BACKGROUND );
		      app.setLocationRelativeTo(null);
		      app.setBounds(100, 100, BOARD_WIDTH, BOARD_HIGHT);
		      app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      app.setVisible(true);
		      app.add(board);
		      
		      app.repaint();
	   }
}
