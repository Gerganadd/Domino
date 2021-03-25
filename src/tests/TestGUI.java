package tests;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dataStructures.LinkedList;
import domino.DominoPlayer;
import domino.DominoTable;
import domino.DominoTile;
import views.Colors;
import views.DominoTableView;
import views.PlayerView;

public class TestGUI 
{
	
	public final static int BOARD_WIDTH = DominoTableView.BOARD_WIDTH; // 900
	public final static int BOARD_HIGHT = DominoTableView.BOARD_HIGHT; // 700
	
	public final static Color JFRAME_BACKGROUND = Colors.MEDIUM_SEA_GREEN;
	
	public static void main(String[] args) 
	{
		
		DominoTable gameBoard = new DominoTable();
		
		DominoTile tile1 = new DominoTile(5,3);
		DominoTile tile2 = new DominoTile(4,5);
		DominoTile tile3 = new DominoTile(6,3);
		
		gameBoard.addRight(tile1);
		gameBoard.addRight(tile2);
		gameBoard.addRight(tile3);
		gameBoard.addLeft(tile2);
			  
		DominoTableView board = new DominoTableView(gameBoard);
		
		LinkedList<DominoTile> tilesOfPlayer = new LinkedList();
		tilesOfPlayer.add(new DominoTile(1,1));
		tilesOfPlayer.add(new DominoTile(2,2));
		tilesOfPlayer.add(new DominoTile(3,3));
		tilesOfPlayer.add(new DominoTile(4,4));
		
		DominoPlayer dominoPlayer = new DominoPlayer("Pesho", tilesOfPlayer, gameBoard);
		PlayerView player = new PlayerView(dominoPlayer);
		
		JFrame app = new JFrame("Domino");
		      
		app.getContentPane().setBackground( JFRAME_BACKGROUND );
		app.setLayout(null);
		app.setLocationRelativeTo(null);
      	app.setBounds(100, 100, BOARD_WIDTH, BOARD_HIGHT);
      	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(0, 0, BOARD_WIDTH, BOARD_HIGHT);
		panel.setBackground(Color.black);
		
		//panel.add(player);
		//panel.add(board);
		panel.add(player, BorderLayout.SOUTH);
		panel.add(board, BorderLayout.CENTER);
		
		app.add(panel);
		//app.pack();
      
		//app.add(player);
		//app.add(board);
		//app.pack();
		      
		app.repaint();
		
	}
}
