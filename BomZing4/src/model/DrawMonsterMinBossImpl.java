package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class DrawMonsterMinBossImpl implements DrawableInterface {

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if (object instanceof MonsterMinBoss) {
			MonsterMinBoss minBoss = (MonsterMinBoss) object;
			g2d.drawImage(minBoss.img, minBoss.x, minBoss.y - 13, null);
			g2d.setColor(Color.WHITE);
			g2d.drawRect(minBoss.x + 12, minBoss.y - 23, minBoss.width - 24, 10);
			Image imgHeartBoss = new ImageIcon(getClass().getResource("/Images/heart_boss.png")).getImage();
			int a = 0;
			for (int i = 0; i < (minBoss.heart - 1) / 250 + 1; i++) {
				g2d.drawImage(imgHeartBoss, minBoss.x + 13 + a, minBoss.y - 22, null);
				a = a + 10;
			}
		}
	}
}
