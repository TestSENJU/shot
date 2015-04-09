package sound;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.DataLine.Info;

public class PlaySE implements Runnable {
	// TODO 
	static double volume = 1.5;
	// TODO
	static FloatControl floatControl = null;
	String filePath = null; 
	AudioInputStream audioInputStream = null;
	SourceDataLine sourceDataLine = null;

	/**
	 * @param path
	 */
	public PlaySE(String path) {
		filePath = path;
	}

	public void run() {
		try {
			init();
			play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init() throws Exception {
		audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
		AudioFormat audioFormat = audioInputStream.getFormat();

		Info info = new Info(SourceDataLine.class, audioFormat);

		sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
		sourceDataLine.open(audioFormat);
		sourceDataLine.start();
		// TODO 
		floatControl = (FloatControl) sourceDataLine
				.getControl(FloatControl.Type.MASTER_GAIN);
		// TODO 
		setVolume(volume, false);
	}

	/**
	 */
	public void play() {
		try {
			int nByte = 0;
			final int SIZE = 1024 * 64;
			byte[] buffer = new byte[SIZE];
			while (nByte != -1) {
				sourceDataLine.write(buffer, 0, nByte);
				nByte = audioInputStream.read(buffer, 0, SIZE);
			}
			sourceDataLine.stop();
			sourceDataLine.flush();
			sourceDataLine.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param newVolume
	 * <br />
	 * @param isPercent
	 * <br />
	 * @see FloatControl.Type.MASTER_GAIN
	 */
	public static void setVolume(Double newVolume, boolean isPercent) {
		if (isPercent) {
			volume = newVolume / 50.0;
		}
		float dB = (float) (Math.log(volume == 0.0 ? 0.0001 : volume)
				/ Math.log(10.0) * 20.0);
		floatControl.setValue(dB);
	}

	public static double getVolume() {
		return volume;
	}
}
