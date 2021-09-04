package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Option {
	protected JPanel optionPanel;
	private JLabel lbbackground;
	private ImageIcon backgroundIcon;
	private JLabel lbOption;
	private ImageIcon backgrLb;
	private JLabel lbCancel;
	private ImageIcon backgrLbOp;

	public Option() {
		optionPanel = new JPanel();
		optionPanel.setLayout(null);
		initCompts();
	}

	public void initCompts() {
		lbbackground = new JLabel();
		lbbackground.setBounds(0, -15, GameView.WIDTHJF, GameView.HEIGHTJF);
		lbbackground.setBackground(Color.BLACK);
		backgroundIcon = new ImageIcon(getClass().getResource("/Images/background_Menu2.png"));
		lbbackground.setIcon(backgroundIcon);

		lbOption = new JLabel();
		lbOption.setBounds(55, -10, GameView.WIDTHJF, GameView.HEIGHTJF);
		lbOption.setBackground(Color.BLACK);
		backgrLb = new ImageIcon(getClass().getResource("/Images/background_option.png"));
		lbOption.setIcon(backgrLb);

		lbCancel = new JLabel();
		backgrLbOp = new ImageIcon(getClass().getResource("/Images/cancel1.png"));
		lbCancel.setBounds(829, 564, backgrLbOp.getIconWidth(), backgrLbOp.getIconHeight());
		lbCancel.setIcon(backgrLbOp);

		optionPanel.add(lbCancel);
		optionPanel.add(lbOption);
		optionPanel.add(lbbackground);
	}

	public JLabel getLbCancel() {
		return lbCancel;
	}

	public void addOptionActorMouseListener(MouseAdapter adapter) {
		lbCancel.addMouseListener(adapter);
	}
}
