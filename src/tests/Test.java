package tests;

import javax.swing.JOptionPane;

import domino.DominoPlayer;
import domino.DominoTable;
import domino.DominoTile;
import interfaces.Iterator;

public class Test
{
	public static void main(String[] args) 
	{
		DominoTile tile1 = new DominoTile(5,3);
		DominoTile tile2 = new DominoTile(4,5);
		DominoTile tile3 = new DominoTile(6,3);
		
		DominoTable gameBoard = new DominoTable();
		gameBoard.addRight(tile1);
		gameBoard.addRight(tile2);
		gameBoard.addRight(tile3);
		gameBoard.addLeft(tile2);
		
		Iterator<DominoTile> i = gameBoard.getTable().getIterator(); 
		while(i.hasNext())
		{
			DominoTile t = i.next();
			System.out.println(t);
		}
	}
}
