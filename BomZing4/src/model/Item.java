package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Item {
	DrawableInterface drawable;
	public static int Item_Bomb=1;
	public static int Item_BombSize=2;
	public static int Item_Shoe=3;
	
	protected int x, y, type, width, height, timeLine;
	protected Image img;
	
	public Item(int x, int y, int type, String image) {
		super();
		this.x = x;
		this.y = y;
		this.type = type;
		this.img = new ImageIcon(getClass().getResource(image)).getImage();
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		timeLine=250;
	}
	
	public void drawItem(Graphics2D g2d){
		drawable = new DrawItemImpl();
		drawable.draw(this, g2d);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getType() {
		return type;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
		
	public int getTimeLine() {
		return timeLine;
	}
	
	public void setTimeLine(int timeLine) {
		this.timeLine = timeLine;
	}

	public boolean isImpactItemVsBomber(Bomber bomber){
		Rectangle rec1 = new Rectangle(x, y, width, height);
		Rectangle rec2 = new Rectangle(bomber.getX(), bomber.getY(), bomber.getWidth(), bomber.getHeight());
		return rec1.intersects(rec2);
	}

}
