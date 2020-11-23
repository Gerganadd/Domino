package domino;

public class DominoTable {
	public final int ARRAY_LENGHT = 28;
	public final int LEFT = 1;
	public final int RIGHT = 0;
	public final int TILE_SIZE_ROW = 6;
	
	private DominoTile[] table;
	private int lastElement;
	private TableEventListener tableEventListener;
	
	public DominoTable()
	{
		this.table = new DominoTile[ARRAY_LENGHT];
		lastElement = 0; 
	}
	
	public DominoTile[] getTable()
	{
		return this.table;
	}
	
	public void addTableEventListener(TableEventListener listener)
	{
		if (this.tableEventListener != null)
		{
			this.tableEventListener = listener;
		}
	}
	
	private void changeListener() {
		if (this.tableEventListener != null) {
			this.tableEventListener.onTableChanged(this);
		}
	}
	
	private boolean isPosible()
	{
		if (lastElement + 1  < ARRAY_LENGHT) return true;
		else return false;
	}
	
	private void move()
	{
		for(int i = lastElement + 1 ; i > 0 ; i--)
		{
			table[i] = table[i-1];
		}
		lastElement++;
	}
	
	public boolean addLeft(DominoTile someDominoTile)
	{
		if (table[0] == null)
		{
			table[0] = someDominoTile;
			this.changeListener();
			return true;
		}
		else if (isPosible() && table[0].areEqualSides(someDominoTile, LEFT))
		{
			move();
			table[0] = someDominoTile;
			this.changeListener();
			return true;
		}
		
		return false;
	}
	
	public boolean addRight(DominoTile someDominoTile)
	{
		if (isPosible())
		{
			if (table[lastElement] == null)
			{
				table[lastElement] = someDominoTile; 
				this.changeListener();
				return true;
			}
			else if (table[lastElement].areEqualSides(someDominoTile, RIGHT))
			{		
				lastElement++;
				table[lastElement] = someDominoTile;
				this.changeListener();
				return true;
			}
		}
		
		return false;
	}
	
	public void print()
	{
		String firstRow = "";
		String secondRow = "";
		String thirdRow = "";
		
		for(int i = 0 ; i <= this.lastElement && table[i] != null; i++)
		{
			String element = table[i].toString();
	
			firstRow += element.substring(0, TILE_SIZE_ROW); // 0-6
			secondRow += element.substring(TILE_SIZE_ROW, TILE_SIZE_ROW * 2); // 6-12
			thirdRow += element.substring(TILE_SIZE_ROW * 2, TILE_SIZE_ROW * 3); // 12-18
		}
		
		System.out.println(firstRow);
		System.out.println(secondRow);
		System.out.println(thirdRow);
	}
}
