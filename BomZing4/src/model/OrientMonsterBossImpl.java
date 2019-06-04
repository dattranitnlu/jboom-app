package model;

import javax.swing.ImageIcon;

public class OrientMonsterBossImpl implements OrientableInterface {

	@Override
	public void changeOrient(Object object, int orient) {
		if (object instanceof MonsterBoss) {
			MonsterBoss boss = (MonsterBoss) object;
			boss.setChange(orient);
			switch (orient) {
			case Actor.LEFT:
				boss.img = new ImageIcon(getClass().getResource("/Images/boss_left.png")).getImage();
				break;
			case Actor.RIGHT:
				boss.img = new ImageIcon(getClass().getResource("/Images/boss_right.png")).getImage();
				break;
			case Actor.UP:
				boss.img = new ImageIcon(getClass().getResource("/Images/boss_up.png")).getImage();
				break;
			case Actor.DOWN:
				boss.img = new ImageIcon(getClass().getResource("/Images/boss_down.png")).getImage();
				break;
			default:
				break;
			}
		}
	}
}