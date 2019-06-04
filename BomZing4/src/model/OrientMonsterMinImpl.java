package model;

import javax.swing.ImageIcon;

public class OrientMonsterMinImpl implements OrientableInterface {

	@Override
	public void changeOrient(Object object, int orient) {
		if (object instanceof MonsterMin) {
			MonsterMin monsterMin = (MonsterMin) object;
			monsterMin.setChange(orient);
			switch (orient) {
			case Actor.LEFT:
				monsterMin.img = new ImageIcon(getClass().getResource("/Images/quaivat 1_left.png")).getImage();
				break;
			case Actor.RIGHT:
				monsterMin.img = new ImageIcon(getClass().getResource("/Images/quaivat 1_right.png")).getImage();
				break;
			case Actor.UP:
				monsterMin.img = new ImageIcon(getClass().getResource("/Images/quaivat 1_up.png")).getImage();
				break;
			case Actor.DOWN:
				monsterMin.img = new ImageIcon(getClass().getResource("/Images/quaivat 1_down.png")).getImage();
				break;
			default:
				break;
			}
		}
	}
}