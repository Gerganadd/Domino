package tests;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
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
	public final static int BOARD_HIGHT = DominoTableView.BOARD_HIGHT; // 650
	public final static int PNL_PLAYER_HIGHT = 200; 
	
	public final static Color JFRAME_BACKGROUND = Colors.MEDIUM_SEA_GREEN;
	
	public static void main(String[] args) 
	{
		DominoTable gameBoard = addElementsInDominoTable();
		DominoTableView board = new DominoTableView(gameBoard);
		
		LinkedList<DominoTile> tilesOfPlayer = addTilesInPlayer();
		DominoPlayer dominoPlayer = new DominoPlayer("Player", tilesOfPlayer, gameBoard);
		PlayerView player = new PlayerView(dominoPlayer);
		
		JFrame app = new JFrame("Domino");
		app.getContentPane().setBackground( JFRAME_BACKGROUND );
		app.setLayout(new BoxLayout(app.getContentPane(), 1));
		app.setLocationRelativeTo(null);
      	app.setBounds(100, 100, BOARD_WIDTH, BOARD_HIGHT);
      	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
		
		JPanel playerPanel = new JPanel();
		playerPanel.setBackground(JFRAME_BACKGROUND);
		playerPanel.setLayout(new BorderLayout());
		playerPanel.add(player, BorderLayout.CENTER);
		
		Dimension d = new Dimension(BOARD_WIDTH, PNL_PLAYER_HIGHT);
		playerPanel.setSize(d);
		playerPanel.setMaximumSize(d);
		playerPanel.setMinimumSize(d);
		playerPanel.setPreferredSize(d);
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBackground(JFRAME_BACKGROUND);	
		boardPanel.setLayout(new BorderLayout());
		boardPanel.add(board, BorderLayout.CENTER);
		
		app.add(playerPanel);
		app.add(boardPanel);

		app.repaint();
		
	}
	
	private static DominoTable addElementsInDominoTable()
	{
		DominoTable gameBoard = new DominoTable();
		
		DominoTile tile1 = new DominoTile(5,3);
		DominoTile tile2 = new DominoTile(4,5);
		DominoTile tile3 = new DominoTile(6,3);
		
		gameBoard.addRight(tile1);
		gameBoard.addRight(tile2);
		gameBoard.addRight(tile3);
		gameBoard.addLeft(tile2);
		
		return gameBoard;
	}

	private static LinkedList<DominoTile> addTilesInPlayer()
	{
		LinkedList<DominoTile> tilesOfPlayer = new LinkedList();
		tilesOfPlayer.add(new DominoTile(1,1));
		tilesOfPlayer.add(new DominoTile(2,2));
		tilesOfPlayer.add(new DominoTile(3,3));
		tilesOfPlayer.add(new DominoTile(4,4));
		
		return tilesOfPlayer;
	}
	
}
