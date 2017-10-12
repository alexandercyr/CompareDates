import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.Math;

public class CompareDates {
	public static void main(String[] args) {
		// Expected date formats
		String[] formats = new String[] { "MM-dd-yyyy", "M-dd-yyyy", "MM/dd/yyyy", "M/dd/yyyy", "dd-MM-yy",
				"dd-MM-yyyy", "yyyy-MM-dd", "dd/MM/yy", "dd/MM/yyyy", "yyyy/MM/dd" };

		// Initialize scanner
		Scanner scnr = new Scanner(System.in);

		String dateString1;
		String dateString2;

		Date date1;
		Date date2;

		long timeMillis;

		// Prompt user to enter info
		System.out.println("Enter two dates to compare (MM-dd-yyyy):");
		dateString1 = scnr.next();
		dateString2 = scnr.next();

		date1 = parseDate(dateString1, formats);
		date2 = parseDate(dateString2, formats);

		timeMillis = Math.abs(date1.getTime() - date2.getTime());
		secondsToString(timeMillis);

		System.out.println(timeMillis);
		System.out.println(Character.isDigit(dateString1.charAt(0)));
		System.out.println(date1);
	}

	// Method matches user input with possible date formats
	public static Date parseDate(String dateString, String[] formats) {
		Date date = null;

		// for each date variation in formats, try to parse date
		for (int i = 0; i < formats.length; ++i) {

			SimpleDateFormat formatter = new SimpleDateFormat(formats[i]);
			try {
				date = formatter.parse(dateString);
				break;
			} catch (ParseException e) {
				// date parse for current format fails, try another
				// let loop continue to run
			}
		}

		return date;

	}

	//Convert from milliseconds to readable years, months, and days
	public static void secondsToString(long seconds) {
		long time = seconds / 1000;
		int numyears = (int) Math.floor(time / 31536000);
		int numdays = (int) Math.floor((time % 31536000) / 86400);
		int months = numdays / 30;
		numdays = numdays % 30;
		System.out.println(numyears + " years " + months + " months " + numdays + " days ");

	}
}
