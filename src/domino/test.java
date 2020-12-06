package domino;

import javax.swing.JOptionPane;

public class test {

	public static void main(String[] args) {
		DominoTile tile1 = new DominoTile(3,4);
		DominoTile tile2 = new DominoTile(5,4);
		DominoTile tile3 = new DominoTile(3,1); //1 3
		
		DominoTable table = new DominoTable();
		DominoTile[] tiles = {tile1, tile2, tile3};
		DominoPlayer firstPlayer = new DominoPlayer("Bob_13_17", tiles, table);
		firstPlayer.addTileAtRight(tile3);
		firstPlayer.addTileAtLeft(tile1);
		firstPlayer.addTileAtLeft(tile3);
		firstPlayer.addTileAtRight(tile2);
		firstPlayer.addTileAtLeft(tile2); 
		firstPlayer.getTable().print();
		
		String[] options= {null, "true", "false"};
		String item = (String)(JOptionPane.showInputDialog(null, "Articulated", "Choose", JOptionPane.PLAIN_MESSAGE,null,options, options[0]));
		boolean articulated = Boolean.parseBoolean(item);
		System.out.println(articulated);
		
	}

}
