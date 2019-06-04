package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Box {
	DrawableInterface drawable;
	public static int ALLROW_BANG = 0;
	public static int DISALLROW_BANG = 1;
	protected int x, y, width, height, type;
	protected Image img;

	public Box(int x, int y, int type, String images) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
		this.img = new ImageIcon(getClass().getResource(images)).getImage();
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}

	public void drawBox(Graphics2D g2d) {
		drawable = new DrawBoxImpl();
		drawable.draw(this, g2d);

	}

	public int getType() {
		return type;
	}

	@SuppressWarnings("static-access")
	public int isImpactBoxvsActor(Actor actor) {
		Rectangle rec1 = new Rectangle(x, y, width, height);
		Rectangle rec2 = new Rectangle(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
		Rectangle rec3 = new Rectangle();
		if (actor.getType() == Monster.BOSS || actor.getType() == Monster.GHOST) {
			return 0;
		}
		if (rec1.intersects(rec2)) {
			rec1.intersect(rec1, rec2, rec3);
			if (rec3.getHeight() == 1 && (actor.getOrient() == Actor.UP || actor.getOrient() == Actor.DOWN)) {
				if (actor.getX() == rec3.getX()) {
					return (int) rec3.getWidth();
				} else {
					return (int) -rec3.getWidth();
				}
			} else {
				if (actor.getY() == rec3.getY()) {
					return (int) rec3.getHeight();
				} else {
					return (int) -rec3.getHeight();
				}
			}
		}
		return 0;
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

}
