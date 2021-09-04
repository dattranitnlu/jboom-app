package model;

import java.awt.Graphics2D;

public class MonsterBoss extends Monster {
	private DrawableInterface drawable;
	private OrientableInterface orientable;

	public MonsterBoss(int x, int y, int type, int orient, int speed, int heart, String images) {
		super(x, y, type, orient, speed, heart, images);
		height = img.getHeight(null) - 38;
	}

	@Override
	public void drawActor(Graphics2D g2d) {
		super.drawActor(g2d);
		drawable = new DrawMonsterBossImpl();
		drawable.draw(this, g2d);
	}

	@Override
	public void changeOrient(int orient) {
		super.changeOrient(orient);
		orientable = new OrientMonsterBossImpl();
		orientable.changeOrient(this, orient);
	}
}
