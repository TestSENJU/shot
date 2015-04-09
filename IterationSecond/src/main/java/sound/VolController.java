package sound;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VolController {
	final JSlider slider = new JSlider();
	static ChangeListener listener;
	static double volume;

	public JSlider init() {
		volume = (double) slider.getValue();
		listener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				volume = (double) slider.getValue();
				PlayMusic.setVolume(volume, true);
				PlaySE.setVolume(volume, true);
			}
		};

		slider.addChangeListener(listener);
		slider.setOrientation(1);
		slider.setBounds(5, 0, 30, 165);
		return slider;
	}

	public void silence(boolean bgm, boolean se) {
		volume = (double) slider.getValue();
		double vol1 = PlayMusic.getVolume();
		double vol2 = PlaySE.getVolume();
		if ((vol1 != 0.0)) {
			if (bgm) {
				PlayMusic.setVolume(0.0, true);
			}
		} else {
			if (bgm) {
				PlayMusic.setVolume(volume, true);
			}

		}
		if ((vol2 != 0.0)) {
			if (se) {
				PlaySE.setVolume(0.0, true);
			}
		} else {
			if (se) {
				PlaySE.setVolume(volume, true);
			}
		}
	}
}
