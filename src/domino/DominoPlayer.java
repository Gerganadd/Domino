package domino;

public class DominoPlayer {
	private String nickname; 
	private DominoTile[] tiles;
	private int tilesInHands; 
	private DominoTable table;
	
	public DominoPlayer(String nickname, DominoTile[] tiles, int tilesInHands, DominoTable table)
	{
		setNickname(nickname);
		this.tiles = tiles;
		setTilesInHands(tilesInHands);
		this.table = table;
	}
	
	public void setNickname(String nickname)
	{
		if (nickname != null && !nickname.isEmpty())
		{
			this.nickname = nickname;
		}
	}
	
	public void setTilesInHands(int number)
	{
		int i = 0 ;
		while(i < tiles.length && tiles[i] != null)
		{
			i++;
		}
		this.tilesInHands = i;
		
		if (number != i) 
			System.out.println("incorect input - the tiles in player " + this.nickname + " must be " + i);
	}
	
	public String getNickname()
	{
		return this.nickname;
	}
	
	public DominoTile[] gettiles()
	{
		return this.tiles;
	}
	
	public int getTilesInHands()
	{
		return this.tilesInHands;
	}
	
	public DominoTable getTable()
	{
		return this.table;
	}
	
	private int getTileIndex(DominoTile t)
	{
		for(int i = 0 ; i < tiles.length ; i++)
		{
			if (tiles[i] == null) continue;
			if (tiles[i].isEquals(t)) return i;
		}
		return -1;
	}
	
	private void minus(int index)
	{
		tiles[index] = null;
		this.tilesInHands--;
	}
	
	public void addTileAtLeft(DominoTile t)
	{
		int i = getTileIndex(t);
		
		if (i != -1 && table.addLeft(t))
		{	
			minus(i);
		}
	}
	
	public void addTileAtRight(DominoTile t)
	{
		int i = getTileIndex(t);
		
		if (i != -1 && table.addRight(t))
		{
			minus(i);	
		}
	}
}
