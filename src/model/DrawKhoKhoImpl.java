package model;

import java.awt.Graphics2D;

public class DrawKhoKhoImpl implements DrawableInterface{

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if(object instanceof KhoKho) {
			KhoKho khoKho = (KhoKho) object;
			g2d.drawImage(khoKho.img, khoKho.x, khoKho.y - 20, null);
		}
	}

}
