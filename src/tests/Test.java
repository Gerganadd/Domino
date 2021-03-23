package tests;

import dataStructures.LinkedList;
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
		
		LinkedList<DominoTile> tilesOfPlayer1 = new LinkedList();
		tilesOfPlayer1.add(new DominoTile(1,1));
		tilesOfPlayer1.add(new DominoTile(2,2));
		tilesOfPlayer1.add(new DominoTile(3,3));
		LinkedList<DominoTile> tilesOfPlayer2 = new LinkedList();
		tilesOfPlayer2.add(new DominoTile(1,2));
		tilesOfPlayer2.add(new DominoTile(2,3));
		tilesOfPlayer2.add(new DominoTile(3,4));
		
		DominoPlayer player1 = new DominoPlayer("Pesho", tilesOfPlayer1, gameBoard);
		System.out.println(String.format("%s's tiles: ", player1.getNickname()));
		player1.getTiles().print();
		
		DominoPlayer player2 = new DominoPlayer("Gosho", tilesOfPlayer2, gameBoard);
		System.out.println(String.format("%s's tiles: ", player2.getNickname()));
		player2.getTiles().print();
		
		System.out.println("New table: ");
		player2.addTileAtLeft(player2.getTiles().get(2));
		
		Iterator<DominoTile> it = gameBoard.getTable().getIterator(); 
		while(it.hasNext())
		{
			DominoTile t = it.next();
			System.out.println(t);
		}
		
		System.out.println(String.format("%s's tiles: ", player2.getNickname()));
		player2.getTiles().print();
		
	}
}
