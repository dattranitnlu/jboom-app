package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseActor {
	JPanel chooseActor;
	private JLabel lbbackground;
	private JLabel lbKhoKho;
	private JLabel lbBeBong;
	private JLabel lbTiaChop;
	private JLabel lbTiBanh;
	private ImageIcon backgroundIcon;
	private JLabel lbOption;
	private JLabel lbChoose;
	private ImageIcon backgrLbChoose;
	private JLabel lbCancel;

	public ChooseActor() {
		chooseActor = new JPanel();
		chooseActor.setLayout(null);
		initComps();
		initbackground();
	}

	public void initComps() {
		lbCancel = setLabel(829, 564, "/Images/cancel1.png");
		lbKhoKho = setLabel(126, 122, "/Images/khoKho1.png");
		lbBeBong = setLabel(110, 370, "/Images/beBong1.png");
		lbTiBanh = setLabel(354, 370, "/Images/tiBanh1.png");
		lbTiaChop = setLabel(598, 370, "/Images/tiaChop1.png");

		lbOption = setLabel(407, 123, "/Images/opkhokho.png");

		chooseActor.add(lbCancel);
		chooseActor.add(lbKhoKho);
		chooseActor.add(lbBeBong);
		chooseActor.add(lbTiaChop);
		chooseActor.add(lbTiBanh);
		chooseActor.add(lbOption);
	}

	public void addChooseActorMouseListener(MouseAdapter adapter) {

		lbCancel.addMouseListener(adapter);
		lbOption.addMouseListener(adapter);
		lbKhoKho.addMouseListener(adapter);
		lbBeBong.addMouseListener(adapter);
		lbTiaChop.addMouseListener(adapter);
		lbTiBanh.addMouseListener(adapter);
	}

	public void initbackground() {
		lbbackground = new JLabel();
		lbbackground.setBounds(0, -15, GameView.WIDTHJF, GameView.HEIGHTJF);
		lbbackground.setBackground(Color.BLACK);
		backgroundIcon = new ImageIcon(getClass().getResource("/Images/background_Menu2.png"));
		lbbackground.setIcon(backgroundIcon);

		lbChoose = new JLabel();
		lbChoose.setBounds(55, -10, GameView.WIDTHJF, GameView.HEIGHTJF);
		lbChoose.setBackground(Color.BLACK);
		backgrLbChoose = new ImageIcon(getClass().getResource("/Images/background_Actor.png"));
		lbChoose.setIcon(backgrLbChoose);

		chooseActor.add(lbChoose);
		chooseActor.add(lbbackground);
	}

	public JLabel setLabel(int x, int y, String ImageIcon) {
		JLabel label = new JLabel();
		ImageIcon Icon = new ImageIcon(getClass().getResource(ImageIcon));
		label.setBounds(x, y, Icon.getIconWidth(), Icon.getIconHeight());
		label.setIcon(Icon);
		return label;
	}

	public JLabel getLbCancel() {
		return lbCancel;
	}

	public JLabel getLbOption() {
		return lbOption;
	}

	public JLabel getLbKhoKho() {
		return lbKhoKho;
	}

	public JLabel getLbBeBong() {
		return lbBeBong;
	}

	public JLabel getLbTiaChop() {
		return lbTiaChop;
	}

	public JLabel getLbTiBanh() {
		return lbTiBanh;
	}
}
