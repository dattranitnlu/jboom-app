package model;

import java.awt.Graphics2D;

public class DrawMonsterGhostImpl implements DrawableInterface {

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if (object instanceof MonsterGhost) {
			MonsterGhost monsterGhost = (MonsterGhost) object;
			g2d.drawImage(monsterGhost.img, monsterGhost.x, monsterGhost.y, null);
		}
	}
}
