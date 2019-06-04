package model;

import java.awt.Graphics2D;

public class DrawBeBongImpl implements DrawableInterface{

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if(object instanceof BeBong) {
			BeBong beBong = (BeBong) object;
			g2d.drawImage(beBong.img, beBong.x, beBong.y - 11, null);
		}
	}

}
