package timer;

import java.util.Observable;
import java.util.Observer;

public class DigitalClock implements Observer {
	// private JLabel clockLabel;
	private int minute;
	private int second;

	public DigitalClock() {
	}

	public String showTime() {
		StringBuffer text = new StringBuffer();
		if (minute < 10)
			text.append("0");
		text.append(minute + ":");
		if (second < 10)
			text.append("0");
		text.append(second);
		return text.toString();
	}

	public void update(Observable o, Object arg) {
		if (o instanceof Countdown) {
			Countdown countdown = (Countdown) o;
			minute = countdown.getMinute();
			second = countdown.getSecond();
			showTime();
		}
	}

	public void upop() {
		DigitalClock digitalClock = new DigitalClock();
		Countdown countdown = new Countdown();
		countdown.addObserver(digitalClock);
	}
}
