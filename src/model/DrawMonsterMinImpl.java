package model;

import java.awt.Graphics2D;

public class DrawMonsterMinImpl implements DrawableInterface {

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if (object instanceof MonsterMin) {
			MonsterMin monsterMin = (MonsterMin) object;
			g2d.drawImage(monsterMin.img, monsterMin.x + 3, monsterMin.y + 1, null);
		}
	}
}
