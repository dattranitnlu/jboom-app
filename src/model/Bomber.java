package model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Bomber extends Actor {

	public static int ALLOW_RUN = 0;
	public static int DISALLOW_RUN = 1;

	protected int sizeBomb, quantityBomb, status, score, heart;

	public Bomber(int x, int y, int type, int orient, int speed, int sizebomb, int quantityBomb) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.orient = orient;
		this.speed = speed;
		this.sizeBomb = sizebomb;
		this.quantityBomb = quantityBomb;
	}

	public abstract void setNew(int x, int y);

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getQuantityBomb() {
		return quantityBomb;
	}

	public abstract void setQuantityBomb(int quantityBomb);

	public abstract void setSizeBomb(int sizeBomb);

	public int getSizeBomb() {
		return sizeBomb;
	}

	public int getType() {
		return type;
	}

	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart = heart;
	}

	@Override
	public boolean move(int count, ArrayList<Bomb> arrBomb, ArrayList<Box> arrBox) {
		if (status == DEAD) {
			return false;
		}
		return super.move(count, arrBomb, arrBox);
	}

	public boolean isImpactBomberVsActor(Actor actor) {
		if (status == DEAD) {
			return false;
		}
		Rectangle rec1 = new Rectangle(x, y, width, height);
		Rectangle rec2 = new Rectangle(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
		return rec1.intersects(rec2);
	}

	public void setChange(int orient) {
		super.changeOrient(orient);
	}
}
