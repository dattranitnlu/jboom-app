package model;

import javax.swing.ImageIcon;

public class OrientMonsterMaxImpl implements OrientableInterface {

	@Override
	public void changeOrient(Object object, int orient) {
		if (object instanceof MonsterMax) {
			MonsterMax monsterMax = (MonsterMax) object;
			monsterMax.setChange(orient);
			switch (orient) {
			case Actor.LEFT:
				monsterMax.img = new ImageIcon(getClass().getResource("/Images/quaivat 2_left.png")).getImage();
				break;
			case Actor.RIGHT:
				monsterMax.img = new ImageIcon(getClass().getResource("/Images/quaivat 2_right.png")).getImage();
				break;
			case Actor.UP:
				monsterMax.img = new ImageIcon(getClass().getResource("/Images/quaivat 2_up.png")).getImage();
				break;
			case Actor.DOWN:
				monsterMax.img = new ImageIcon(getClass().getResource("/Images/quaivat 2_down.png")).getImage();
				break;
			default:
				break;
			}
		}
	}
}