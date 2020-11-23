package domino;

import javax.swing.JComponent;

public class test {

	public static void main(String[] args) {
		DominoTile tile1 = new DominoTile(3,4);
		DominoTile tile2 = new DominoTile(5,4);
		DominoTile tile3 = new DominoTile(3,1); //1 3
		
		DominoTable table = new DominoTable();
		DominoTile[] tiles = {tile1, tile2, tile3};
		DominoPlayer firstPlayer = new DominoPlayer("Bob_13_17", tiles, 3 , table);
		firstPlayer.addTileAtRight(tile3);
		firstPlayer.addTileAtLeft(tile1);
		firstPlayer.addTileAtLeft(tile3);
		firstPlayer.addTileAtRight(tile2);
		firstPlayer.addTileAtLeft(tile2); 
		firstPlayer.getTable().print();
		
	}

}
