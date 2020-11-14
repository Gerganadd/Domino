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
		if (number == i + 1) this.tilesInHands = number;
		//else System.out.println("incorect input");
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
			if (tiles[i].isEquals(t)) return i;
		}
		return -1;
	}
	
	public void minus(int index)
	{
		tiles[index] = null;
		setTilesInHands(this.tilesInHands--);
	}
	
	public void addTileAtLeft(DominoTile t)
	{
		if (getTileIndex(t) != -1)
		{
			int i = getTileIndex(t);
			
			if (table.addLeft(t))
			{
				minus(i);
			}
		}
	}
	
	public void addTileAtRight(DominoTile t)
	{
		if (getTileIndex(t) != -1)
		{
			int i = getTileIndex(t);

			if (table.addRight(t))
			{
				minus(i);
			}
		}
	}
}
