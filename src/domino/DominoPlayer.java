package domino;

import dataStructures.LinkedList;

public class DominoPlayer 
{
	private String nickname; 
	private LinkedList<DominoTile> tilesOfPlayer; 
	private DominoTable table;
	
	public DominoPlayer(String nickname, LinkedList<DominoTile> tiles, DominoTable table)
	{
		setNickname(nickname);
		this.tilesOfPlayer = tiles;
		this.table = table;
	}
	
	public void setNickname(String nickname)
	{
		if (nickname != null && !nickname.isEmpty())
		{
			this.nickname = nickname;
		}
	}
	
	public String getNickname()
	{
		return this.nickname;
	}
	
	public LinkedList<DominoTile> getTiles()
	{
		return this.tilesOfPlayer;
	}
	
	public DominoTable getTable()
	{
		return this.table;
	}
	
	public void addTileAtLeft(DominoTile t)
	{
		this.table.addLeft(t);
		tilesOfPlayer.remove(t);
	}
	
	public void addTileAtRight(DominoTile t)
	{
		this.table.addRight(t);
		tilesOfPlayer.remove(t);
	}
}
