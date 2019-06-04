package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import model.ReadFileHightScore;
import sound.GameSound;
import view.GameView;
import view.HightScorePanel;

public class HightScoreControllerExt extends ControllerView {
	private HightScorePanel scorePanel;
	private ReadFileHightScore model;

	public HightScoreControllerExt(ReadFileHightScore model, GameView view) {
		super(view);
		this.model = model;
		scorePanel = this.view.myContainer.getmHightScorePanel();
		scorePanel.addHightScoreActorMouseListener(new HightScoreActionListener());
		drawScore();
	}

	private void drawScore() {
		scorePanel.setArrHightScore(model.getArrHightScore());
	}

	class HightScoreActionListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == scorePanel.getLbCancel()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/Images/cancel2.png"));
				scorePanel.getLbCancel().setIcon(cancelIcon);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() == scorePanel.getLbCancel()) {
				ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/Images/cancel1.png"));
				scorePanel.getLbCancel().setIcon(cancelIcon);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == scorePanel.getLbCancel()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				view.myContainer.setShowMenu();
			}

		};
	}
}
