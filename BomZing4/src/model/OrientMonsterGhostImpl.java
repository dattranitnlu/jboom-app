package model;

import javax.swing.ImageIcon;

public class OrientMonsterGhostImpl implements OrientableInterface {

	@Override
	public void changeOrient(Object object, int orient) {
		if (object instanceof MonsterGhost) {
			MonsterGhost monsterGhost = (MonsterGhost) object;
			monsterGhost.setChange(orient);
			switch (orient) {
			case Actor.LEFT:
				monsterGhost.img = new ImageIcon(getClass().getResource("/Images/ghost3.png")).getImage();
				break;
			case Actor.RIGHT:
				monsterGhost.img = new ImageIcon(getClass().getResource("/Images/ghost3.png")).getImage();
				break;
			case Actor.UP:
				monsterGhost.img = new ImageIcon(getClass().getResource("/Images/ghost3.png")).getImage();
				break;
			case Actor.DOWN:
				monsterGhost.img = new ImageIcon(getClass().getResource("/Images/ghost3.png")).getImage();
				break;
			default:
				break;
			}
		}
	}
}