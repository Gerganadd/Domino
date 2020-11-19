package domino;

import java.awt.Graphics;

import javax.swing.JComponent;

public class DominoTableView extends JComponent {
	
	private DominoTable gameBoard;
	
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
        g.drawOval(0, 0, getWidth(), getHeight());//not finish
	}

}
