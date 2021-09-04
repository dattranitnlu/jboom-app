package model;

import javax.swing.ImageIcon;

public class OrientBeBongImpl implements OrientableInterface {

	@Override
	public void changeOrient(Object object, int orient) {
		if (object instanceof BeBong) {
			BeBong beBong = (BeBong) object;
			if (beBong.status == Actor.DEAD) {
				return;
			}
			beBong.setChange(orient);
			switch (orient) {
			case Actor.LEFT:
				beBong.img = new ImageIcon(getClass().getResource("/Images/bebong_left.png")).getImage();
				break;
			case Actor.RIGHT:
				beBong.img = new ImageIcon(getClass().getResource("/Images/bebong_right.png")).getImage();
				break;
			case Actor.UP:
				beBong.img = new ImageIcon(getClass().getResource("/Images/bebong_up.png")).getImage();
				break;
			case Actor.DOWN:
				beBong.img = new ImageIcon(getClass().getResource("/Images/bebong_down.png")).getImage();
				break;
			default:
				break;
			}

		}
	}
}
