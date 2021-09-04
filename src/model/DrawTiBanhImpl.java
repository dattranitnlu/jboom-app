package model;

import java.awt.Graphics2D;

public class DrawTiBanhImpl implements DrawableInterface{

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if(object instanceof TiBanh) {
			TiBanh tiBanh = (TiBanh) object;
			g2d.drawImage(tiBanh.img, tiBanh.x, tiBanh.y - 15, null);
		}
	}
}
