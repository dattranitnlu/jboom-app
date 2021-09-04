package model;

import javax.swing.ImageIcon;

public class OrientTiBanhImpl implements OrientableInterface {

	@Override
	public void changeOrient(Object object, int orient) {
		if (object instanceof TiBanh) {
			TiBanh tiBanh = (TiBanh) object;
			if (tiBanh.status == Actor.DEAD) {
				return;
			}
			tiBanh.setChange(orient);
			switch (orient) {
			case Actor.LEFT:
				tiBanh.img = new ImageIcon(getClass().getResource("/Images/tibanh_left.png")).getImage();
				break;
			case Actor.RIGHT:
				tiBanh.img = new ImageIcon(getClass().getResource("/Images/tibanh_right.png")).getImage();
				break;
			case Actor.UP:
				tiBanh.img = new ImageIcon(getClass().getResource("/Images/tibanh_up.png")).getImage();
				break;
			case Actor.DOWN:
				tiBanh.img = new ImageIcon(getClass().getResource("/Images/tibanh_down.png")).getImage();
				break;
			default:
				break;
			}
		}
	}
}
