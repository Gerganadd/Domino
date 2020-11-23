package domino;

import java.awt.Color;

public enum TileColor {
	PALE_GOLDEN_ROD(new Color(238,232,170)),
	LIGHT_GOLDEN_ROD_YELLOW(new Color(250,250,210)),
	LEMON_CHIFFON(new Color(255,250,205)),
	CORN_SILK(new Color(255,248,220)),
	LIGHT_YELLOW(new Color(255,255,224));
	
	private Color backgrownd;
	private TileColor(Color color)
	{
		this.backgrownd = color;
	}
	
	public Color getColor()
	{
		return this.backgrownd;
	}
}
