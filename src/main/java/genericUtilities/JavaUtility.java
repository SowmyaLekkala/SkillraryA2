package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class contains reusable methods to perform java related operations
 * @author sowmya lekkala
 */

public class JavaUtility {
	/**
	 * This method fetches current date and time in specified format
	 * @return
	 */
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_yy_hh_mm_ss");//date month year hour min sec
		return sdf.format(date);
	}

}
