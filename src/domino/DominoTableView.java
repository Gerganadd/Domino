package domino;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class DominoTableView extends JComponent {
	
	   private DominoTable gameBoard;
	  
	   public final static int BOARD_WIDTH = 900;
	   public final static int BOARD_HIGHT = 600;
	   
	   public final int TILE_WIDGTH = 150;
	   public final int TILE_HIGHT = 70;
	   public final int DEFAULT_TILE_X = 10;
	   public final int DEFAULT_TILE_Y = (BOARD_HIGHT / 2) - TILE_HIGHT;
	   public final int DEFAULT_POINT_X = 5;
	   public final int DEFAULT_POINT_Y = 5;
	   public final int POINT_R = 10;
	   public final int SPACE = 15;
	   
	   public final Color TILE_COLOR = Colors.CORN_SILK;
	   
	   public DominoTableView()
	   {
		   gameBoard.addTableEventListener(new TableEventListener() 
		   {

			@Override
			public void onTableChanged(DominoTable dominotable) 
			{
				DominoTableView.this.repaint();
			}
		   });
	   }
	   
	   public DominoTableView(DominoTable table)
	   {
		   this.gameBoard = table;
	   }
	   
	   private void drawPoint(int pointX, int pointY, Graphics g)
	   {
		   g.fillOval(pointX, pointY, POINT_R, POINT_R);
	   }
	   
	   private void makePointsOnTile(int tileX, int tileY, DominoTile tile, Graphics g)
	   {
		   char[][] points = tile.makeTile();
		   g.setColor(Color.BLACK);
		   int x = tileX + DEFAULT_POINT_X; 
		   int y = tileY + DEFAULT_POINT_Y;
		   
		   for (int row = 0 ; row < points.length ; row++)
		   {
			   for (int col = 0 ; col < points[row].length ; col++)
			   {
				   if (points[row][col] == '*')
				   {
					   drawPoint(x, y, g);
				   }
				   x += POINT_R + SPACE;
			   }
			   x = (tileX + DEFAULT_POINT_X);
			   y += POINT_R + SPACE;
		   }
	   }
	   
	   private void drawTile(int tileX, int tileY, Graphics g)
	   {
		   g.setColor(TILE_COLOR);
		   g.fill3DRect(tileX, tileY, TILE_WIDGTH, TILE_HIGHT, true);
	   }
	   
	   @Override
	   public void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      DominoTile[] table = this.gameBoard.getTable();
	      int tileX = DEFAULT_TILE_X;
		  int tileY = DEFAULT_TILE_Y;
		   
	      for (DominoTile tile : table)
	      {
	    	  if (tile == null) break;
	    	  
	    	  drawTile(tileX, tileY, g);
	    	  makePointsOnTile(tileX , tileY , tile, g);
	    	  tileX += TILE_WIDGTH + 3;  
	      }
	   }
}
