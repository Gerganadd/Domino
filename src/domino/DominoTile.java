package domino;

public class DominoTile {
	private int leftNumber;
	private int rightNumber;
	
	public final int MIN = 0;
	public final int MAX = 6;
	public final int ARR_SIZE = 3;
	
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
	
	public void swap()
	{
		int temp = this.leftNumber;
		leftNumber = this.rightNumber;
		rightNumber = temp;
	}
	
	public boolean isEquals(DominoTile someDominoTile)
	{
		if (this.leftNumber == someDominoTile.getLeftNumber()
				&& this.rightNumber == someDominoTile.getRightNumber())
		{
			return true;
		}
		else 
		{
			swap();
			if (this.leftNumber == someDominoTile.getLeftNumber()
					&& this.rightNumber == someDominoTile.getRightNumber()) return true;
			else return false;
		}

	}
	
	public char[][] makeDominoSide(int points)
	{
		char[][] dominoArray = new char[ARR_SIZE][ARR_SIZE];
		
		/*if (points != 1)
		{
			if(points >= 2)
			{
				dominoArray[0][0] = '*';
				dominoArray[2][2] = '*';
			}
			
			if(points >= 4)
			{
				dominoArray[0][2] = '*';
				dominoArray[2][0] = '*';
			}
			
			if(points == 6)
			{
				dominoArray[1][0] = '*';
				dominoArray[1][2] = '*';
			}
		}
		
		if (points % 2 == 1) dominoArray[1][1] = '*';
		*/
		
		if(points == 6)
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
			if(i >= 2 && points > 2)
			{
				dominoArray[0][2] = '*';
				dominoArray[2][0] = '*';
				break;
			}
		}
		
		return dominoArray;
	}
	
	public String toString()
	{
		char[][] leftSide = makeDominoSide(this.leftNumber);
		char[][] rightSide = makeDominoSide(this.rightNumber);
		String result = "";
		
		for(int row = 0 ; row < ARR_SIZE ; row++)
		{
			for(int col = 0 ; col <  2 * ARR_SIZE ; col++)
			{
				if(col < ARR_SIZE)
				{
					result += leftSide[row][col];
				}
				else 
				{
					result += rightSide[row][col - ARR_SIZE];
				}
			}
			result += "\n";
		}
		
		return result;
	}
	
}
