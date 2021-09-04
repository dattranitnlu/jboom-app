package model;

import java.awt.Graphics2D;

public class DrawBombBangImpl implements DrawableInterface {

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if (object instanceof BombBang) {
			BombBang bombBang = (BombBang) object;
			g2d.drawImage(bombBang.img_left, bombBang.x + 45 - bombBang.img_left.getWidth(null), bombBang.y, null);
			g2d.drawImage(bombBang.img_right, bombBang.x, bombBang.y, null);
			g2d.drawImage(bombBang.img_up, bombBang.x, bombBang.y + 45 - bombBang.img_up.getHeight(null), null);
			g2d.drawImage(bombBang.img_down, bombBang.x, bombBang.y, null);
		}

	}

}
