package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuView {
	protected JPanel menuPanel;
	// private int padding = 15;;
	private JLabel lbbackground;
	private JLabel lbPlayGame;
	private JLabel lbOption;
	private JLabel lbHigthScore;
	private JLabel lbExit;
	private ImageIcon backgroundIcon;

	public MenuView() {
		menuPanel = new JPanel();
		menuPanel.setBackground(Color.YELLOW);
		menuPanel.setLayout(null);
		initComps();
		initbackground();
	}

	public JLabel getLbbackground() {
		return lbbackground;
	}

	public JLabel getLbPlayGame() {
		return lbPlayGame;
	}

	public JLabel getLbOption() {
		return lbOption;
	}

	public JLabel getLbHigthScore() {
		return lbHigthScore;
	}

	public JLabel getLbExit() {
		return lbExit;
	}

	public void initComps() {
		lbPlayGame = setLabel(500, 110, "/Images/Play.png");
		lbOption = setLabel(620, 230, "/Images/Option.png");
		lbHigthScore = setLabel(680, 350, "/Images/HightScore.png");
		lbExit = setLabel(620, 470, "/Images/Exit.png");

		menuPanel.add(lbPlayGame);
		menuPanel.add(lbOption);
		menuPanel.add(lbHigthScore);
		menuPanel.add(lbExit);
	}

	public void initbackground() {
		lbbackground = new JLabel();
		lbbackground.setBounds(0, -15, GameView.WIDTHJF, GameView.HEIGHTJF);
		lbbackground.setBackground(Color.BLACK);
		backgroundIcon = new ImageIcon(getClass().getResource("/Images/background_Menu.png"));
		lbbackground.setIcon(backgroundIcon);
		menuPanel.add(lbbackground);
	}

	public JLabel setLabel(int x, int y, String ImageIcon) {
		JLabel label = new JLabel();
		ImageIcon Icon = new ImageIcon(getClass().getResource(ImageIcon));
		label.setBounds(x, y, Icon.getIconWidth(), Icon.getIconHeight());
		label.setIcon(Icon);
		return label;
	}

	public void addMenuMouseListener(MouseAdapter adapter) {
		lbPlayGame.addMouseListener(adapter);
		lbOption.addMouseListener(adapter);
		lbHigthScore.addMouseListener(adapter);
		lbExit.addMouseListener(adapter);
	}
}
