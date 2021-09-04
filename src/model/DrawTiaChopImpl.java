package model;

import java.awt.Graphics2D;

public class DrawTiaChopImpl implements DrawableInterface{

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if(object instanceof TiaChop) {
			TiaChop tiaChop = (TiaChop) object;
			g2d.drawImage(tiaChop.img, tiaChop.x, tiaChop.y - 20, null);
		}
	}

}
