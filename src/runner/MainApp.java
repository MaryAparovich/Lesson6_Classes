package runner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainApp {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = df.parse("13-01-2006");
		Date date2 = df.parse("13-01-1993");

		Author ath1 = new Author("NameAuthor1", "SurnameAuthor1", date1);
		Author ath2 = new Author("NameAuthor2", "SurnameAuthor2", date2);
		Author ath3 = new Author("NameAuthor3", "SurnameAuthor3", date1);
		Author ath4 = new Author("NameAuthor4", "SurnameAuthor4", date1);
		Author ath5 = new Author("NameAuthor5", "SurnameAuthor5", date1);

		Book book1 = new Book("Book1", 2006);
		Book book2 = new Book("Book2", 2000);
		Book book3 = new Book("Book3", 2003);

		Author[] authors = new Author[] { ath1, ath2, ath3, ath4, ath5 };

		book2.addAuthors(authors);

		/*
		 * book2.addAuthor(ath5); book2.addAuthor(ath4); book2.addAuthor(ath3);
		 */

		for (int i = 0; i < book2.getAuthorCount(); i++) {
			System.out.println(book2.getAuthors()[i].getName() + "  " + book2.getAuthors()[i].getSurname() + "  "
					+ book2.getAuthors()[i].getDate());
		}
	}
}
