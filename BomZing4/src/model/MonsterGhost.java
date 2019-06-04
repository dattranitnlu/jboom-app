package model;

import java.awt.Graphics2D;

public class MonsterGhost extends Monster {
	private DrawableInterface drawable;
	private OrientableInterface orientable;

	public MonsterGhost(int x, int y, int type, int orient, int speed, int heart, String images) {
		super(x, y, type, orient, speed, heart, images);
		height = 45;
		width = 45;
	}

	@Override
	public void drawActor(Graphics2D g2d) {
		super.drawActor(g2d);
		drawable = new DrawMonsterGhostImpl();
		drawable.draw(this, g2d);
	}

	@Override
	public void changeOrient(int orient) {
		super.changeOrient(orient);
		orientable = new OrientMonsterGhostImpl();
		orientable.changeOrient(this, orient);
	}
}
