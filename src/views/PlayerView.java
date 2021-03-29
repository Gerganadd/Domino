package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import dataStructures.LinkedList;
import domino.DominoPlayer;
import domino.DominoTile;
import interfaces.Iterator;

public class PlayerView extends JComponent
{
	private DominoPlayer player;
	
	
	public final int TILE_WIDTH = DominoTableView.TILE_WIDGTH;
	public final int TILE_HIGHT = DominoTableView.TILE_HIGHT;
	  
	public final int POINT_R = DominoTableView.POINT_R;
	public final int SPACE = DominoTableView.SPACE;
	   
	public final Color TILE_COLOR = DominoTableView.TILE_COLOR;
	 
	public final int DEFAULT_POINT_X = 5;
	public final int DEFAULT_POINT_Y = 5;
	 
	public final int BOARD_WIDTH = DominoTableView.BOARD_WIDTH;
	public final int DEFAULT_TILE_X = (BOARD_WIDTH / 2) - (2 * (TILE_HIGHT + SPACE)); 
	public final int DEFAULT_TILE_Y = 15;
	   
	 //may add TileView
	
	public PlayerView()
	{
		//add listener
	}
	
	public PlayerView(DominoPlayer player)
	{
		this.player = player;
	}
	
	@Override
	public void paintComponent(Graphics graphics)
	{
		Graphics2D g = (Graphics2D) graphics;
		super.paintComponent(g);
		
		String nickname = this.player.getNickname();
		g.setFont(new Font("Serif", Font.PLAIN, 18));
		g.drawString(nickname, DEFAULT_POINT_Y, DEFAULT_POINT_Y + SPACE);
		
		LinkedList playersTiles = this.player.getTiles();
	    int tileX = DEFAULT_TILE_X;
		int tileY = DEFAULT_TILE_Y;
		  
		  //draw tiles
		  Iterator<DominoTile> i = playersTiles.getIterator();
		 
		  while (i.hasNext())
		  {
			  drawTile(tileX, tileY, g);
	    	  makePointsOnTile(tileX , tileY , i.next(), g);
	    	  tileX += TILE_HIGHT + SPACE;  
		  }
		
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
		   
		   for (int col = 0 ; col < points.length ; col++)
		   {
			   for (int row = 0 ; row < points[col].length ; row++)
			   {
				   if (points[col][row] == '*')
				   {
					   drawPoint(x, y, g);
				   }
				   y += POINT_R + SPACE;
			   }
			   x += POINT_R + SPACE;
			   y = (tileY + DEFAULT_POINT_Y);
		   }
	   }
	   
	   private void drawTile(int tileX, int tileY, Graphics g)
	   {
		   g.setColor(TILE_COLOR);
		   g.fill3DRect(tileX, tileY, TILE_HIGHT, TILE_WIDTH, true);
	   }
	   
	  
}
