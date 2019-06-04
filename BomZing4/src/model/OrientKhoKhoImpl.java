package model;

import javax.swing.ImageIcon;

public class OrientKhoKhoImpl implements OrientableInterface {

	@Override
	public void changeOrient(Object object, int orient) {
		if (object instanceof KhoKho) {
			KhoKho khoKho = (KhoKho) object;
			if (khoKho.status == Actor.DEAD) {
				return;
			}
			khoKho.setChange(orient);
			switch (orient) {
			case Actor.LEFT:
				khoKho.img = new ImageIcon(getClass().getResource("/Images/khokho_left.png")).getImage();
				break;
			case Actor.RIGHT:
				khoKho.img = new ImageIcon(getClass().getResource("/Images/khokho_right.png")).getImage();
				break;
			case Actor.UP:
				khoKho.img = new ImageIcon(getClass().getResource("/Images/khokho_up.png")).getImage();
				break;
			case Actor.DOWN:
				khoKho.img = new ImageIcon(getClass().getResource("/Images/khokho_down.png")).getImage();
				break;
			default:
				break;
			}

		}
	}
}
