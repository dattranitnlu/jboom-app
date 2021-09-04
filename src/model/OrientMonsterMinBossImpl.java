package model;

import javax.swing.ImageIcon;

public class OrientMonsterMinBossImpl implements OrientableInterface {

	@Override
	public void changeOrient(Object object, int orient) {
		if (object instanceof MonsterMinBoss) {
			MonsterMinBoss minBoss = (MonsterMinBoss) object;
			minBoss.setChange(orient);
			switch (orient) {
			case Actor.LEFT:
				minBoss.img = new ImageIcon(getClass().getResource("/Images/quaivat 3_left.png")).getImage();
				break;
			case Actor.RIGHT:
				minBoss.img = new ImageIcon(getClass().getResource("/Images/quaivat 3_right.png")).getImage();
				break;
			case Actor.UP:
				minBoss.img = new ImageIcon(getClass().getResource("/Images/quaivat 3_up.png")).getImage();
				break;
			case Actor.DOWN:
				minBoss.img = new ImageIcon(getClass().getResource("/Images/quaivat 3_down.png")).getImage();
				break;
			default:
				break;
			}
		}
	}
}