package model;

import java.awt.Graphics2D;

public class DrawBoxImpl implements DrawableInterface {

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if(object instanceof Box) {
			Box box = (Box) object;
			g2d.drawImage(box.img, box.x, box.y, null);
		}
		
	}

}
