package ui;


/**
 * 
 * 
 * @author 
 * @version 2014 / 3 / 16 2 : 35 AM
 * @version Jun 14, 2014  10:42:42 PM
 */
public class Sleep {

	/**
	 * 
	 * 
	 * @param time
	 *         
	 * @since 2015 / 4 / 10 11 : 16 AM
	 */
	public static void sleep (long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
