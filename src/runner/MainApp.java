package runner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainApp {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = df.parse("08-01-1942");
		Date date2 = df.parse("08-08-1931");
		Date date3 = df.parse("10-03-1928");

		Author ath1 = new Author("Stephen", "Hawking", date1);
		Author ath2 = new Author("Roger", "Penrose", date2);
		Author ath3 = new Author("Abner", "Shimony", date3);
		Author ath4 = new Author("NameAuthor4", "SurnameAuthor4", date1);
		Author ath5 = new Author("NameAuthor5", "SurnameAuthor5", date1);

		Book book1 = new Book("My Brief History", 2013);
		Book book2 = new Book("Hyperspace", 1999);
		Book book3 = new Book("The Story of Earth", 2003);

		Library library = new Library("Scientific", 3);

		Author[] authors = new Author[] { ath1, ath2, ath3 };
		Book[] books = new Book[] { book1, book2, book3 };

		book2.addAuthors(authors);
		library.addBooks(books);

		/*library.addBook(book1);
		library.addBook(book2);*/

		/*
		 * book2.addAuthor(ath5); book2.addAuthor(ath4); book2.addAuthor(ath3);
		 */
		System.out.println("Authors of the book " + "'" + book1.getTitle() + "'" + ":\n");
		for (int i = 0; i < book2.getAuthorCount(); i++) {
			System.out.println(book2.getAuthors()[i].getName() + "  " + book2.getAuthors()[i].getSurname() + "  "
					+ book2.getAuthors()[i].getDate());
		}
		System.out.println();
		System.out.println();
		System.out.println("Books of the library: \n");
		for (int i = 0; i < library.getBooksCount(); i++) {
			System.out.println(library.getBooks()[i].getTitle() + "  " + library.getBooks()[i].getYear() + " ");
		}
	}
}
