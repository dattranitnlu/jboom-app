package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

public class Actor {
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int UP = 3;
	public static final int DOWN = 4;
	public static final int ALIVE = 1;
	public static final int DEAD = 0;
	public static final int BOMBER = 1;
	public static final int BOMB = 4;

	protected int x, y, type, orient, speed, width, height, runBomb;
	protected Image img;

	public void drawActor(Graphics2D g2d) {
	};

	public boolean move(int count, ArrayList<Bomb> arrBomb, ArrayList<Box> arrBox) {
		if (count % speed != 0) {
			return true;
		}
		switch (orient) {
		case LEFT:
			if (x < 45) {
				return false;
			}
			x = x - 1;
			for (int i = 0; i < arrBomb.size(); i++) {
				if (arrBomb.get(i).isImpactBombvsActor(this) == 1) {
					x = x + 1;
					return false;
				}
			}
			for (int i = 0; i < arrBox.size(); i++) {
				int kq = arrBox.get(i).isImpactBoxvsActor(this);
				if (kq != 0) {
					if (kq >= -20 && kq <= 20) {
						if (kq > 0) {
							y = y + 1;
						} else {
							y = y - 1;
						}
					}
					x = x + 1;
					return false;
				}
			}
			break;
		case RIGHT:
			if (x > (720 - width)) {
				return false;
			}
			x = x + 1;
			for (int i = 0; i < arrBomb.size(); i++) {
				if (arrBomb.get(i).isImpactBombvsActor(this) == 1) {
					x = x - 1;
					return false;
				}
			}
			for (int i = 0; i < arrBox.size(); i++) {
				int kq = arrBox.get(i).isImpactBoxvsActor(this);
				if (kq != 0) {
					if (kq >= -20 && kq <= 20) {
						if (kq > 0) {
							y = y + 1;
						} else {
							y = y - 1;
						}
					}
					x = x - 1;
					return false;
				}
			}
			break;
		case UP:
			if (y < 45) {
				return false;
			}
			y = y - 1;
			for (int i = 0; i < arrBomb.size(); i++) {
				if (arrBomb.get(i).isImpactBombvsActor(this) == 1) {
					y = y + 1;
					return false;
				}
			}
			for (int i = 0; i < arrBox.size(); i++) {
				int kq = arrBox.get(i).isImpactBoxvsActor(this);
				if (kq != 0) {
					if (kq >= -20 && kq <= 20) {
						if (kq > 0) {
							x = x + 1;
						} else {
							x = x - 1;
						}
					}
					y = y + 1;
					return false;
				}
			}
			break;
		case DOWN:
			if (y > 630 - height) {
				return false;
			}
			y = y + 1;
			for (int i = 0; i < arrBomb.size(); i++) {
				if (arrBomb.get(i).isImpactBombvsActor(this) == 1) {
					y = y - 1;
					return false;
				}
			}
			for (int i = 0; i < arrBox.size(); i++) {
				int kq = arrBox.get(i).isImpactBoxvsActor(this);
				if (kq != 0) {
					if (kq >= -20 && kq <= 20) {
						if (kq > 0) {
							x = x + 1;
						} else {
							x = x - 1;
						}
					}
					y = y - 1;
					return false;
				}
			}
			break;

		default:
			break;
		}
		return true;
	}

	public void changeOrient(int orient) {
		this.orient = orient;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getOrient() {
		return orient;
	}

	public void setRunBomb(int runBomb) {
		this.runBomb = runBomb;
	}

	public int getRunBomb() {
		return runBomb;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed < 1) {
			return;
		}
		this.speed = speed;
	}

	public int getType() {
		return type;
	}

}
