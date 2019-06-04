package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sound.GameSound;
import view.GameView;
import view.PlayGame;

public class PlayGameControllerExt extends ControllerView {
	private PlayGame playGame;

	public PlayGameControllerExt(GameView view) {
		super(view);
		playGame = this.view.myContainer.getPlay();
		playGame.addPlayGameListener(new PlayGameListener());
	}

	class PlayGameListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == playGame.getBtn_Menu()) {
				playGame.getmMagager().setRound(1);
				playGame.getmMagager().innitManager();
//				playGame.getmMagager().getCountdown().getTimer().stop();
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				view.myContainer.setShowMenu();
			}
		}
	}
}
