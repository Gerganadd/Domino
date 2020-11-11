package domino;

public class DominoTile {
	private int leftNumber;
	private int rightNumber;
	
	public final int min = 0;
	public final int max = 6;
	
	public DominoTile()
	{
		this.leftNumber = min;
		this.rightNumber = min;
	}
	
	public DominoTile(int left, int right)
	{
		setLeftNumber(left);
		setRightNumber(right);
	}
	
	private void setLeftNumber(int number)
	{
		if (min <= number && number <= max)
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
		if (min <= number && number <= max)
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
	
}
