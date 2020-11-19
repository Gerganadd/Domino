package domino;

public class test {

	public static void main(String[] args) {
		DominoTile tile1 = new DominoTile(3,4);
		DominoTile tile2 = new DominoTile(5,4);
		DominoTile tile3 = new DominoTile(3,1); //1 3
		
		DominoTable table = new DominoTable();
		
		//table.addRight(tile1);
		//table.addRight(tile3); // no add because first tile has default position 
		//table.addRight(tile2);
		//table.addLeft(tile3);
		
		//table.print();
		
		DominoTile[] tiles = {tile1, tile2, tile3};
		DominoPlayer firstPlayer = new DominoPlayer("Bob_13_17", tiles, 3 , table);
		firstPlayer.addTileAtRight(tile3);
		firstPlayer.addTileAtLeft(tile1);
		firstPlayer.addTileAtLeft(tile3);// iska li da se dobawi
		firstPlayer.addTileAtRight(tile2);
		firstPlayer.addTileAtLeft(tile2); //trqbwa da se dobawi
		firstPlayer.getTable().print();
	}

}
