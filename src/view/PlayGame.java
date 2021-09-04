package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Bomber;
import model.Manager;
import sound.GameSound;

public class PlayGame implements Observer, Runnable {
	public static boolean IS_RUNNING = true;
	protected JPanel playGamePanel;
	private MyContainer mContainer;
	Observable observable;
	Bomber bomber;
	private BitSet traceKey = new BitSet();
	private Manager mMagager;
	private int count = 0;
	// private int deadlineBomb = 0;
	private int move = 0;
	private int timeDead = 0;
	private int timeLose = 0;
	private int timeNext = 0;
	private int i = 0;
	private JButton btn_Menu;
	private Thread mytheard;

	public PlayGame(MyContainer mContainer) {
		playGamePanel = pnGame;
		this.mContainer = mContainer;
		mMagager = new Manager(1);
		playGamePanel.setBackground(Color.WHITE);
		playGamePanel.setLayout(null);
		playGamePanel.setFocusable(true);
		playGamePanel.addKeyListener(keyAdapter);
		mytheard = new Thread(this);
		// thuc hien tien trinh run
		mytheard.start();
		// add button menu
		innitCompts();

		// initScore();

	}

	public void chooseActor(int type) {
		mMagager = new Manager(type);
		mMagager.getCountdown().getTimer().start();
	}

	private void innitCompts() {
		btn_Menu = new JButton();
		btn_Menu.setText("Menu");
		btn_Menu.setBackground(Color.WHITE);
		btn_Menu.setForeground(Color.BLUE);
		btn_Menu.setFont(new Font("", Font.ITALIC, 25));
		btn_Menu.setBounds(755, 630, 175, 38);
		playGamePanel.add(btn_Menu);
	}

	public void initScore() {
		JTextField textField = new JTextField();
		playGamePanel.add(textField);
		textField.setBounds(400, 11, 150, 41);
		textField.setText(mMagager.getSore() + "");
		textField.setAlignmentX(JPanel.RIGHT_ALIGNMENT);

	}

	@SuppressWarnings("serial")
	private JPanel pnGame = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setStroke(new java.awt.BasicStroke(2));
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			mMagager.draWBackground(g2d);
			mMagager.drawAllItem(g2d);
			mMagager.drawAllBomb(g2d);
			mMagager.drawAllBox(g2d);
			mMagager.drawAllMonster(g2d);
			mMagager.getmBomber().drawActor(g2d);
			mMagager.drawInfo(g2d);
			mMagager.drawAllShawDow(g2d);
			mMagager.drawBoss(g2d);
			mMagager.drawTimer(g2d);
			if (mMagager.getStatus() == 1) {
				mMagager.drawDialog(g2d, 1);
			}
			if (mMagager.getStatus() == 2) {
				mMagager.drawDialog(g2d, 2);
			}
			if (mMagager.getStatus() == 3) {
				mMagager.drawDialog(g2d, 3);
			}
		}
	};
	private KeyAdapter keyAdapter = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			traceKey.set(e.getKeyCode());
		}

		@Override
		public void keyReleased(KeyEvent e) {
			traceKey.clear(e.getKeyCode());
		}
	};

	@Override
	public void run() {
		while (IS_RUNNING) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (traceKey.get(KeyEvent.VK_A) || traceKey.get(KeyEvent.VK_LEFT)) {
				mMagager.getmBomber().changeOrient(Bomber.LEFT);
				mMagager.getmBomber().move(count, mMagager.getArrBomb(), mMagager.getArrBox());
				runActor();
			}
			if (traceKey.get(KeyEvent.VK_D) || traceKey.get(KeyEvent.VK_RIGHT)) {
				mMagager.getmBomber().changeOrient(Bomber.RIGHT);
				mMagager.getmBomber().move(count, mMagager.getArrBomb(), mMagager.getArrBox());
				runActor();
			}
			if (traceKey.get(KeyEvent.VK_W) || traceKey.get(KeyEvent.VK_UP)) {
				mMagager.getmBomber().changeOrient(Bomber.UP);
				mMagager.getmBomber().move(count, mMagager.getArrBomb(), mMagager.getArrBox());
				runActor();
			}
			if (traceKey.get(KeyEvent.VK_S) || traceKey.get(KeyEvent.VK_DOWN)) {
				mMagager.getmBomber().changeOrient(Bomber.DOWN);
				mMagager.getmBomber().move(count, mMagager.getArrBomb(), mMagager.getArrBox());
				runActor();
			}
			if (traceKey.get(KeyEvent.VK_J) || traceKey.get(KeyEvent.VK_SPACE)) {
				mMagager.innitBomb();
				mMagager.getmBomber().setRunBomb(Bomber.ALLOW_RUN);
				runActor();
			}
			mMagager.setRunBomer();
			mMagager.checkWinAndLose();
			mMagager.deadLineAllBomb();
			mMagager.checkTimeOut();
			mMagager.checkDead();
			mMagager.checkImpactItem();

			if (mMagager.getStatus() == 1) {
				timeLose++;
				if (timeLose == 3000) {
					mMagager.innitManager();
					mContainer.setShowMenu();
					timeLose = 0;
				}
			}

			if (mMagager.getStatus() == 2) {
				timeNext++;
				mMagager.getCountdown().getTimer().stop();
				if (timeNext == 5000) {
					mMagager.innitManager();
					timeNext = 0;
				}
			}

			if (mMagager.getStatus() == 3) {
				timeNext++;
				if (timeNext == 3000) {
					mMagager.innitManager();
					mContainer.setShowMenu();
					timeNext = 0;
				}
			}

			if (mMagager.getmBomber().getStatus() == Bomber.DEAD) {
				timeDead++;
				if (timeDead == 3000) {
					mMagager.setNewBomb();
					timeDead = 0;
				}
			}

			if (move == 0) {
				mMagager.changeOrientAll();
				move = 5000;
			}
			if (move > 0) {
				move--;
			}
			mMagager.moveAllMonster(count);
			playGamePanel.repaint();
			count++;
			if (count == 1000000) {
				count = 0;
			}
		}

	}

	private void runActor() {
		i++;
		if (i == 200) {
			GameSound.getIstance().getAudio(GameSound.FOOT).play();
			i = 0;
		}
	}

	public Manager getmMagager() {
		return mMagager;
	}

	public void addPlayGameListener(ActionListener actionListener) {
		btn_Menu.addActionListener(actionListener);
	}

	public JButton getBtn_Menu() {
		return btn_Menu;
	}

	@Override
	public void update(Observable o, Object arg) {
		// if (o instanceof CountDown) {
		// countDown = (CountDown) o;
		// this.minute = countDown.getMinute();
		// this.second = countDown.getSecond();
		// display();
		// }

	}
}
