package main;

import controller.ControllerMain;
import controller.ControllerView;
import model.ReadFileHightScore;
import view.GameView;

public class RunGame {
	public static void main(String[] args) {
		GameView view = new GameView();
		ReadFileHightScore model = new ReadFileHightScore();
		ControllerMain controller = new ControllerView(model, view);
		controller.displayGame();

		view.getView().setVisible(true);
	}
}
