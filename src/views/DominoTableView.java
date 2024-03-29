package views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import dataStructures.Deck;
import domino.DominoTable;
import domino.DominoTile;
import interfaces.Iterator;
import interfaces.TableEventListener;

public class DominoTableView extends JComponent 
{
	
	   private DominoTable gameBoard;
	  
	   public final static int BOARD_WIDTH = 900;
	   public final static int BOARD_HIGHT = 650;
	   
	   public final static int TILE_WIDGTH = 150;
	   public final static int TILE_HIGHT = 70;
	   public final static int POINT_R = 10;
	   public final static int SPACE = 15;
	   
	   public final static Color TILE_COLOR = Colors.CORN_SILK;
	   
	   public final int DEFAULT_TILE_X = 10;
	   public final int DEFAULT_TILE_Y = 50;
	   public final int DEFAULT_POINT_X = 5;
	   public final int DEFAULT_POINT_Y = 5;
	   
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
	   
	   private void drawPoint(int pointX, int pointY, Graphics2D g)
	   {
		   g.fillOval(pointX, pointY, POINT_R, POINT_R);
	   }
	   
	   private void makePointsOnTile(int tileX, int tileY, DominoTile tile, Graphics2D g)
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
	   public void paintComponent(Graphics graphics)
	   {
		   
		   Graphics2D g = (Graphics2D) graphics;
		   super.paintComponent(g);
		   
		   Deck<DominoTile> table = this.gameBoard.getTable();
		   int tileX = DEFAULT_TILE_X;
		   int tileY = DEFAULT_TILE_Y;
		  
		   //print tiles
		   Iterator<DominoTile> i = table.getIterator();
		 
		   while (i.hasNext())
		   {
			   drawTile(tileX, tileY, g);
	    	   makePointsOnTile(tileX , tileY , i.next(), g);
	    	   tileX += TILE_WIDGTH + 3; 
		   }
		  
	   }
}
