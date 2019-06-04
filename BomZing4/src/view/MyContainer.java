package view;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

import sound.GameSound;

public class MyContainer {

	protected JPanel myContainer;
	private static final String TAG_MENU = "tag_menu";
	private static final String TAG_PLAYGAME = "tag_playgame";
	private static final String TAG_OPTION = "tag_option";
	private static final String TAG_HIGHTSCORE = "tag_hightscore";
	private static final String TAG_ACTOR = "tag_actor";
	private CardLayout mCardLayout;
	private GameView gameView;
	private MenuView menu;
	private PlayGame play;
	private Option mOption;
	private HightScorePanel mHightScorePanel;
	private ChooseActor chooseActor;
	// private Countdown countdown;

	public MyContainer(GameView gameView) {
		myContainer = new JPanel();
		// countdown = new CouFntdown();
		this.gameView = gameView;
		myContainer.setBackground(Color.WHITE);
		mCardLayout = new CardLayout();
		myContainer.setLayout(mCardLayout);
		menu = new MenuView();
		myContainer.add(menu.menuPanel, TAG_MENU);
		play = new PlayGame(this);
		myContainer.add(play.playGamePanel, TAG_PLAYGAME);
		mOption = new Option();
		myContainer.add(mOption.optionPanel, TAG_OPTION);
		mHightScorePanel = new HightScorePanel();
		myContainer.add(mHightScorePanel.hightScorePanel, TAG_HIGHTSCORE);
		chooseActor = new ChooseActor();
		myContainer.add(chooseActor.chooseActor, TAG_ACTOR);
	}

	public MenuView getMenu() {
		return menu;
	}

	public PlayGame getPlay() {
		return play;
	}

	public Option getmOption() {
		return mOption;
	}

	public GameView getGui() {
		return gameView;
	}

	public HightScorePanel getmHightScorePanel() {
		return mHightScorePanel;
	}

	public ChooseActor getChooseActor() {
		return chooseActor;
	}

	public void setShowMenu() {
		mCardLayout.show(this.myContainer, TAG_MENU);
		menu.menuPanel.requestFocus();
		play.getmMagager().getCountdown().getTimer().stop();
		GameSound.getIstance().stop();
		GameSound.getIstance().getAudio(GameSound.MENU).loop();
	}

	public void setShowPlay(int type) {
		play.chooseActor(type);
		// play.countdown.update(2, 0);
		mCardLayout.show(this.myContainer, TAG_PLAYGAME);
		play.playGamePanel.requestFocus();
		GameSound.getIstance().stop();
		// GameSound.getIstance().getAudio(GameSound.MENU).stop();
		GameSound.getIstance().getAudio(GameSound.PLAYGAME).loop();
	}

	public void getAudio() {
		mCardLayout.show(this.myContainer, TAG_OPTION);
		mOption.optionPanel.requestFocus();
	}

	public void setShowHightScore() {
		mCardLayout.show(this.myContainer, TAG_HIGHTSCORE);
		mHightScorePanel.hightScorePanel.requestFocus();
	}

	public void setShowOption() {
		mCardLayout.show(this.myContainer, TAG_OPTION);
		mOption.optionPanel.requestFocus();
	}

	public void setShowActor() {
		mCardLayout.show(this.myContainer, TAG_ACTOR);
		chooseActor.chooseActor.requestFocus();
	}
}
