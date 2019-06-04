package model;

import javax.swing.ImageIcon;

public class OrientTiaChopImpl implements OrientableInterface {

	@Override
	public void changeOrient(Object object, int orient) {
		if (object instanceof TiaChop) {
			TiaChop tiaChop = (TiaChop) object;
			if (tiaChop.status == Actor.DEAD) {
				return;
			}
			tiaChop.setChange(orient);
			switch (orient) {
			case Actor.LEFT:
				tiaChop.img = new ImageIcon(getClass().getResource("/Images/tiachop_left.png")).getImage();
				break;
			case Actor.RIGHT:
				tiaChop.img = new ImageIcon(getClass().getResource("/Images/tiachop_right.png")).getImage();
				break;
			case Actor.UP:
				tiaChop.img = new ImageIcon(getClass().getResource("/Images/tiachop_up.png")).getImage();
				break;
			case Actor.DOWN:
				tiaChop.img = new ImageIcon(getClass().getResource("/Images/tiachop_down.png")).getImage();
				break;
			default:
				break;
			}

		}
	}
}
