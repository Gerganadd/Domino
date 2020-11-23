package domino;

import java.awt.Color;

public enum JFrameBackgroundColors {
	
	MEDIUM_SEA_GREEN (new Color(60,179,113)),
	MEDIUM_AQUA_MARINE(new Color(102,205,170)),
	LIGHT_SEA_GREEN(new Color(32,178,170)),
	SKY_BLUE(new Color(135,206,235)),
	THISTLE(new Color(216,191,216)),
	SANDY_BROWN(new Color(244,164,96));
	
	private Color backgrownd;
	private JFrameBackgroundColors(Color color)
	{
		this.backgrownd = color;
	}
	
	public Color getColor()
	{
		return this.backgrownd;
	}
	
	
}
