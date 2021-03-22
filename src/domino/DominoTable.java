package domino;

import dataStructures.Deck;
import interfaces.TableEventListener;

public class DominoTable 
{
	public final int LEFT = 1;
	public final int RIGHT = 0;
	public final int TILE_SIZE_ROW = 6;
	
	private Deck<DominoTile> table; 
	private TableEventListener tableEventListener;
	
	public DominoTable()
	{
		this.table = new Deck();
	}
	
	public Deck<DominoTile> getTable()
	{
		return this.table;
	}
	
	public void addTableEventListener(TableEventListener listener)
	{
		if (listener != null) 
		{
			this.tableEventListener = listener;
		}
	}
	
	private void onChangeListener() 
	{
		if (this.tableEventListener != null) 
		{
			this.tableEventListener.onTableChanged(this);
		}
	}
	
	public void addLeft(DominoTile someDominoTile)
	{
		if (table.isEmpty() || table.getLeft().areEqualSides(someDominoTile, LEFT))
		{
			this.table.addleft(someDominoTile);
			this.onChangeListener();
		}
	}
	
	public void addRight(DominoTile someDominoTile)
	{
		if (table.isEmpty() || table.getRight().areEqualSides(someDominoTile, RIGHT))
		{
			this.table.addRight(someDominoTile);
			this.onChangeListener();
		}
		
	}
	
	public void print()
	{
		Deck<DominoTile> copy = this.table;
		
		copy.print();
	}
}
