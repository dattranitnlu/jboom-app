package model;

import java.awt.Graphics2D;

public class DrawMonsterMaxImpl implements DrawableInterface {

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if (object instanceof MonsterMax) {
			MonsterMax monsterMax = (MonsterMax) object;
			g2d.drawImage(monsterMax.img, monsterMax.x, monsterMax.y - 4, null);
		}
	}
}
