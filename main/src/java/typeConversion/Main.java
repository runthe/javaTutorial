package typeConversion;

import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Object obj = Calendar.getInstance();
		long time = 0;

		if (obj instanceof Calendar) {
			time = ((Calendar)obj).getTimeInMillis();
		}

		if (obj instanceof Date) {
			time = ((Date)obj).getTime();
		}
	}
}
