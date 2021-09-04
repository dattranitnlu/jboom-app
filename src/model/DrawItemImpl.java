package model;

import java.awt.Graphics2D;

public class DrawItemImpl implements DrawableInterface{

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if(object instanceof Item) {
			Item item = (Item) object;
			g2d.drawImage(item.img, item.x, item.y, null);
		}
		
	}
	
}
