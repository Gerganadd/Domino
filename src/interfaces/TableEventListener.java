package interfaces;

import domino.DominoTable;

public interface TableEventListener 
{
	public void onTableChanged(DominoTable dominotable);
}
