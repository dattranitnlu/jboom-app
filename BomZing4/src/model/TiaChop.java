package model;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;

public class TiaChop extends Bomber {

	private DrawableInterface drawable;
	private OrientableInterface orientable;

	public TiaChop(int x, int y, int type, int orient, int speed, int sizebomb, int quantityBomb) {
		super(x, y, type, orient, speed, sizebomb, quantityBomb);

		this.runBomb = DISALLOW_RUN;
		this.heart = 3;
		this.score = 0;
		this.status = Actor.ALIVE;
		this.img = new ImageIcon(getClass().getResource("/Images/tiachop_down.png")).getImage();
		width = img.getWidth(null);
		height = img.getHeight(null) - 20;
	}

	@Override
	public void setNew(int x, int y) {
		this.x = x;
		this.y = y;
		this.status = ALIVE;
		this.img = new ImageIcon(getClass().getResource("/Images/tiachop_down.png")).getImage();
	}

	@Override
	public void drawActor(Graphics2D g2d) {
		super.drawActor(g2d);
		drawable = new DrawTiaChopImpl();
		drawable.draw(this, g2d);
	}

	@Override
	public void changeOrient(int orient) {
		super.changeOrient(orient);
		orientable = new OrientTiaChopImpl();
		orientable.changeOrient(this, orient);
	}

	@Override
	public void setQuantityBomb(int quantityBomb) {
		if (quantityBomb > 10) {
			return;
		}
		this.quantityBomb = quantityBomb;
	}

	@Override
	public void setSizeBomb(int sizeBomb) {
		if (sizeBomb > 7) {
			return;
		}
		this.sizeBomb = sizeBomb;
	}

	@Override
	public void setSpeed(int speed) {
		if (speed < 3) {
			return;
		}
		this.speed = speed;
	}
}