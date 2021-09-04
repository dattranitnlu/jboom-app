package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import sound.GameSound;
import view.ChooseActor;
import view.GameView;

public class ChooseActorControllerExt extends ControllerView {
	private ChooseActor chooseActor;

	public ChooseActorControllerExt(GameView view) {
		super(view);
		chooseActor = this.view.myContainer.getChooseActor();
		chooseActor.addChooseActorMouseListener(new ChooseActorListener());
	}

	class ChooseActorListener extends MouseAdapter {

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource() == chooseActor.getLbCancel()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/Images/cancel2.png"));
				chooseActor.getLbCancel().setIcon(cancelIcon);
			}
			if (e.getSource() == chooseActor.getLbKhoKho()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				ImageIcon khoKhoIcon = new ImageIcon(getClass().getResource("/Images/khoKho2.png"));
				ImageIcon khoKho = new ImageIcon(getClass().getResource("/Images/opkhokho.png"));
				chooseActor.getLbKhoKho().setIcon(khoKhoIcon);
				chooseActor.getLbOption().setIcon(khoKho);

			}
			if (e.getSource() == chooseActor.getLbBeBong()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				ImageIcon beBongIcon = new ImageIcon(getClass().getResource("/Images/beBong2.png"));
				ImageIcon beBong = new ImageIcon(getClass().getResource("/Images/opbebong.png"));
				chooseActor.getLbBeBong().setIcon(beBongIcon);
				chooseActor.getLbOption().setIcon(beBong);
			}
			if (e.getSource() == chooseActor.getLbTiaChop()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				ImageIcon tiaChopIcon = new ImageIcon(getClass().getResource("/Images/tiaChop2.png"));
				ImageIcon tiaChop = new ImageIcon(getClass().getResource("/Images/optiachop.png"));
				chooseActor.getLbTiaChop().setIcon(tiaChopIcon);
				chooseActor.getLbOption().setIcon(tiaChop);
			}
			if (e.getSource() == chooseActor.getLbTiBanh()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				ImageIcon tiBanhIcon = new ImageIcon(getClass().getResource("/Images/tiBanh2.png"));
				ImageIcon tiBanh = new ImageIcon(getClass().getResource("/Images/optibanh.png"));
				chooseActor.getLbTiBanh().setIcon(tiBanhIcon);
				chooseActor.getLbOption().setIcon(tiBanh);
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource() == chooseActor.getLbCancel()) {
				ImageIcon cancelIcon = new ImageIcon(getClass().getResource("/Images/cancel1.png"));
				chooseActor.getLbCancel().setIcon(cancelIcon);
			}
			if (e.getSource() == chooseActor.getLbKhoKho()) {
				ImageIcon khoKhoIcon = new ImageIcon(getClass().getResource("/Images/khoKho1.png"));
				chooseActor.getLbKhoKho().setIcon(khoKhoIcon);
			}
			if (e.getSource() == chooseActor.getLbBeBong()) {
				ImageIcon beBongIcon = new ImageIcon(getClass().getResource("/Images/beBong1.png"));
				chooseActor.getLbBeBong().setIcon(beBongIcon);
			}
			if (e.getSource() == chooseActor.getLbTiaChop()) {
				ImageIcon tiaChopIcon = new ImageIcon(getClass().getResource("/Images/tiaChop1.png"));
				chooseActor.getLbTiaChop().setIcon(tiaChopIcon);
			}
			if (e.getSource() == chooseActor.getLbTiBanh()) {
				ImageIcon tiBanhIcon = new ImageIcon(getClass().getResource("/Images/tiBanh1.png"));
				chooseActor.getLbTiBanh().setIcon(tiBanhIcon);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource() == chooseActor.getLbCancel()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				view.myContainer.setShowMenu();
			}
			if (e.getSource() == chooseActor.getLbKhoKho()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				view.myContainer.setShowPlay(1);
			}
			if (e.getSource() == chooseActor.getLbBeBong()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				view.myContainer.setShowPlay(2);
			}
			if (e.getSource() == chooseActor.getLbTiaChop()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				view.myContainer.setShowPlay(3);
			}
			if (e.getSource() == chooseActor.getLbTiBanh()) {
				GameSound.getIstance().getAudio(GameSound.BOMB).play();
				view.myContainer.setShowPlay(4);
			}
		}
	};

}
