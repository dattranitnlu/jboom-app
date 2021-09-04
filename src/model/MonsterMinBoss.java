package model;

import java.awt.Graphics2D;

public class MonsterMinBoss extends Monster {
	private DrawableInterface drawable;
	private OrientableInterface orientable;

	public MonsterMinBoss(int x, int y, int type, int orient, int speed, int heart, String images) {
		super(x, y, type, orient, speed, heart, images);
		height = 45;
		width = 45;
	}

	@Override
	public void drawActor(Graphics2D g2d) {
		super.drawActor(g2d);
		drawable = new DrawMonsterMinBossImpl();
		drawable.draw(this, g2d);
	}

	@Override
	public void changeOrient(int orient) {
		super.changeOrient(orient);
		orientable = new OrientMonsterMinBossImpl();
		orientable.changeOrient(this, orient);
	}
}
