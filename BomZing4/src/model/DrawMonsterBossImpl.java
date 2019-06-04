package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class DrawMonsterBossImpl implements DrawableInterface {

	@Override
	public void draw(Object object, Graphics2D g2d) {
		if (object instanceof MonsterBoss) {
			MonsterBoss boss = (MonsterBoss) object;
			g2d.drawImage(boss.img, boss.x, boss.y - 38, null);
			g2d.setColor(Color.WHITE);
			g2d.drawRect(boss.x + 13, boss.y - 54, boss.width - 26, 12);
			Image imgHeartBoss = new ImageIcon(getClass().getResource("/Images/heart_boss.png")).getImage();
			int a = 0;
			for (int i = 0; i < (boss.heart - 1) / 250 + 1; i++) {
				g2d.drawImage(imgHeartBoss, boss.x + 18 + a, boss.y - 52, null);
				a = a + 10;
			}
		}
	}
}
