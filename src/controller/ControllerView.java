package controller;

import model.ReadFileHightScore;
import view.GameView;

/**
 * @author MinhHungTr
 *
 */
public class ControllerView implements ControllerMain {

	protected ReadFileHightScore model;
	protected GameView view;
	// private HightScoreControllerExt hightScoreControllerExt;

	public ControllerView(ReadFileHightScore model, GameView view) {
		this.model = model;
		this.view = view;
	}

	public void setModel(ReadFileHightScore model) {
		this.model = model;
		hightScoreController();
	}

	public ControllerView(GameView view) {
		this.view = view;
	}

	public void displayGame() {
		view.myContainer.setShowMenu();
		menuController();
		playGameController();
		chooseActorController();
		optionController();
		// hightScoreController();
	}

	public void menuController() {
		new MenuControllerExt(view, this);
	}

	public void playGameController() {
		new PlayGameControllerExt(view);
	}

	public void chooseActorController() {
		new ChooseActorControllerExt(view);
	}

	public void optionController() {
		new OptionControllerExt(view);
	}

	public void hightScoreController() {
		new HightScoreControllerExt(model, view);
	}

}