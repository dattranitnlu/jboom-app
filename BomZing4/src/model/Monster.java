package model;

import javax.swing.ImageIcon;

public abstract class Monster extends Actor {
	protected int heart;
	public static final int MonMIN = 5;
	public static final int MonMAX = 6;
	public static final int MinBOSS = 7;
	public static final int BOSS = 8;
	public static final int GHOST = 9;

	public Monster(int x, int y, int type, int orient, int speed, int heart, String images) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.runBomb = Bomber.DISALLOW_RUN;
		this.orient = orient;
		this.speed = speed;
		this.heart = heart;
		this.img = new ImageIcon(getClass().getResource(images)).getImage();
		width = img.getWidth(null);
	}

	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart = heart;
	}

	public void setChange(int orient) {
		super.changeOrient(orient);
	}
}
