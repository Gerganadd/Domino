package tests;

import java.awt.Color;

import javax.swing.JFrame;

import dataStructures.LinkedList;
import domino.DominoPlayer;
import domino.DominoTile;
import views.Colors;
import views.DominoTableView;
import views.PlayerView;

public class TestPlayerview 
{
	public final static int BOARD_WIDTH = DominoTableView.BOARD_WIDTH; // 900
	public final static int BOARD_HIGHT = DominoTableView.BOARD_HIGHT; // 600
	
	public final static Color JFRAME_BACKGROUND = Colors.MEDIUM_SEA_GREEN;
	
	public static void main(String[] args) 
	{
		LinkedList<DominoTile> tilesOfPlayer1 = new LinkedList();
		tilesOfPlayer1.add(new DominoTile(1,1));
		tilesOfPlayer1.add(new DominoTile(2,2));
		tilesOfPlayer1.add(new DominoTile(3,3));
		tilesOfPlayer1.add(new DominoTile(4,4));
		
		DominoPlayer player1 = new DominoPlayer("Pesho", tilesOfPlayer1, null);
		PlayerView firstPlayer = new PlayerView(player1);
		
		JFrame app = new JFrame("Domino");
	      
		app.getContentPane().setBackground( JFRAME_BACKGROUND );
		app.setLocationRelativeTo(null);
      	app.setBounds(100, 100, BOARD_WIDTH, BOARD_HIGHT);
      	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
      
		app.add(firstPlayer);
		      
		app.repaint();
	}

}
