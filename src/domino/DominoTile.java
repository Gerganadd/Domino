package domino;

public class DominoTile {
	private int leftNumber;
	private int rightNumber;
	
	public final int MIN = 0;
	public final int MAX = 6;
	public final int ARR_SIZE = 3;
	
	public final int LEFT = 1;
	public final int RIGHT = 0;
	
	public DominoTile()
	{
		this.leftNumber = MIN;
		this.rightNumber = MIN;
	}
	
	public DominoTile(int left, int right)
	{
		setLeftNumber(left);
		setRightNumber(right);
	}
	
	private void setLeftNumber(int number)
	{
		if (MIN <= number && number <= MAX)
		{
			this.leftNumber = number;
		}
	}
	
	public int getLeftNumber()
	{
		return this.leftNumber;
	}
	
	private void setRightNumber(int number)
	{
		if (MIN <= number && number <= MAX)
		{
			this.rightNumber = number;
		}
	}
	
	public int getRightNumber()
	{
		return this.rightNumber;
	}
	
	private void swap() 
	{
		int temp = this.leftNumber;
		this.leftNumber = this.rightNumber;
		this.rightNumber = temp;
	}
	
	public boolean isEquals(DominoTile someDominoTile)
	{
		if (this.leftNumber == someDominoTile.getLeftNumber()
				&& this.rightNumber == someDominoTile.getRightNumber())
		{
			return true;
		}
		else if (this.leftNumber == someDominoTile.getRightNumber()
				&& this.rightNumber == someDominoTile.getLeftNumber())
		{
			 return true;
		}
		
		return false;
	}
	
	public boolean areEqualSides(DominoTile someDominoTile, int side)
	{
		if (side == LEFT)
		{
			if (this.leftNumber == someDominoTile.getRightNumber())
			{
				return true;
			}
			else if (this.leftNumber == someDominoTile.getLeftNumber())
			{
				someDominoTile.swap();
				return true;
			}
		}
		else if (side == RIGHT)
		{
			if (this.rightNumber == someDominoTile.getLeftNumber())
			{
				return true;
			}
			else if (this.rightNumber == someDominoTile.getRightNumber())
			{
				someDominoTile.swap();
				return true;
			}
		}
		return false;
		
	}
	
	private char[][] makeDominoSide(int points) 
	{
		char[][] dominoArray = new char[ARR_SIZE][ARR_SIZE];
		
		if (points == 6)
		{
			dominoArray[1][0] = '*';
			dominoArray[1][2] = '*';
		}
		
		if (points % 2 == 1)
		{
			dominoArray[1][1] = '*';
			points--;
		}
		
		for(int i = 0 ; i <= points && points != 0; i+=2)
		{
			dominoArray[i][i] = '*';
			if (i >= 2 && points > 2)
			{
				dominoArray[0][2] = '*';
				dominoArray[2][0] = '*';
				break;
			}
		}
		
		return dominoArray;
	}

	public char[][] makeTile()
	{
		char[][] leftSide = makeDominoSide(this.leftNumber);
		char[][] rightSide = makeDominoSide(this.rightNumber);
		char[][] tile = new char[ARR_SIZE][ARR_SIZE * 2];
		
		for(int row = 0 ; row < ARR_SIZE ; row++)
		{
			for(int col = 0 ; col <  2 * ARR_SIZE ; col++)
			{
				if (col < ARR_SIZE)
				{
					tile[row][col] = leftSide[row][col];
				}
				else 
				{
					tile[row][col] = rightSide[row][col - ARR_SIZE];
				}
			}
		}
		
		return tile;
	}
	
	public String toString()
	{
		char[][] tile = makeTile();
		String result = "";
		
		for(int row = 0 ; row < ARR_SIZE ; row++)
		{
			for(int col = 0 ; col <  2 * ARR_SIZE ; col++)
			{
				result += tile[row][col];
			}
			
		    result += "\n";
		}
		
		return result;
	}
	
}
