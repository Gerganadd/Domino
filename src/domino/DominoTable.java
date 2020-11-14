package domino;

public class DominoTable {
	public final int ARRAY_LENGHT = 28;
	public final int LEFT = 1;
	public final int RIGHT = 0;
	public final int TILE_SIZE_ROW = 6;
	
	private DominoTile[] table;
	private int lastElement;
	
	public DominoTable()
	{
		this.table = new DominoTile[ARRAY_LENGHT];
		lastElement = 0; 
	}
	
	public boolean isPosible()
	{
		if (lastElement + 1  < ARRAY_LENGHT) return true;
		else return false;
	}
	
	public boolean addRight(DominoTile someDominoTile)
	{
		if (isPosible())
		{
			if (table[lastElement] == null)
			{
				table[lastElement] = someDominoTile;
			}
			else if (table[lastElement].areEqualSides(someDominoTile, RIGHT))
			{		
				lastElement++;
				table[lastElement] = someDominoTile;
			}
			
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void move()
	{
		for(int i = lastElement + 1 ; i > 0 ; i--)
		{
			table[i] = table[i-1];
		}
		lastElement++;
	}
	
	public boolean addLeft(DominoTile someDominoTile)
	{
		if (isPosible() && table[0].areEqualSides(someDominoTile, LEFT))
		{
			move();
			table[0] = someDominoTile;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void print()
	{
		
		String firstRow = "";
		String secondRow = "";
		String thirdRow = "";
		
		for(int i = 0 ; i <= this.lastElement ; i++)
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
