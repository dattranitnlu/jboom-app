package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import sound.GameSound;
import view.GameView;
import view.Option;

public class OptionControllerExt extends ControllerView {
	private Option option;

	public OptionControllerExt(GameView view) {
		super(view);
		option = this.view.myContainer.getmOption();
		option.addOptionActorMouseListener(new OptionActionListener());
	}

	class OptionActionListener extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == option.getLbCancel()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/Images/cancel2.png"));
				option.getLbCancel().setIcon(cancelIcon);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() == option.getLbCancel()) {
				ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/Images/cancel1.png"));
				option.getLbCancel().setIcon(cancelIcon);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == option.getLbCancel()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				view.myContainer.setShowMenu();
			}

		};
	}
}
