package by.htp.classes.runner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import by.htp.classes.input.Input;
import by.htp.classes.model.Author;
import by.htp.classes.model.Book;
import by.htp.classes.model.Library;

public class MainApp {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = df.parse("08-01-1942");
		Date date2 = df.parse("08-08-1931");
		Date date3 = df.parse("10-03-1928");

		Author ath1 = new Author("Stephen", "Hawking", date1);
		Author ath2 = new Author("Roger", "Penrose", date2);
		Author ath3 = new Author("Abner", "Shimony", date3);
		Author ath4 = new Author("Gunter", "Faure", date1);
		Author ath5 = new Author("Jochen", "Hoefs", date1);

		Book book1 = new Book("My Brief History", 2013);
		Book book2 = new Book("Hyperspace", 1999);
		Book book3 = new Book("The Story of Earth", 2003);

		Input input = new Input();

		Library library = new Library("Scientific", 3);

		Author[] authorsForbook2 = new Author[] { ath1, ath2, ath3 };
		Author[] authorsForbook3 = new Author[] { ath4, ath5 };

		Book[] books = new Book[] { book1, book2, book3 };

		book2.addAuthors(authorsForbook2);
		book3.addAuthors(authorsForbook3);
		library.addBooks(books);
		/*
		 * library.addBook(book1); library.addBook(book2);
		 */
		/*
		 * book2.addAuthor(ath5); book2.addAuthor(ath4); book2.addAuthor(ath3);
		 */

		System.out.println("Authors of the book " + "'" + book2.getTitle() + "'" + ":\n");
		for (int i = 0; i < book2.getAuthorCount(); i++) {
			System.out.println(book2.getAuthors()[i].getName() + "  " + book2.getAuthors()[i].getSurname() + "  "
					+ book2.getAuthors()[i].getDate());
		}

		System.out.println();
		System.out.println("Authors of the book " + "'" + book3.getTitle() + "'" + ":\n");
		for (int i = 0; i < book3.getAuthorCount(); i++) {
			System.out.println(book3.getAuthors()[i].getName() + "  " + book3.getAuthors()[i].getSurname() + "  "
					+ book3.getAuthors()[i].getDate());
		}

		System.out.println();
		System.out.println();
		System.out.println("Books of the library: \n");
		for (int i = 0; i < library.getBooksCount(); i++) {
			System.out.println(library.getBooks()[i].getTitle() + ", " + library.getBooks()[i].getYear() + " ");
		}
		System.out.println();

		// find a book
		// Author authorForFind = ath2;

		Author[] authorsForFind = new Author[] { ath1, ath2, ath3, ath4, ath5 };
		Author authorForFind = input.getInputAuthorForFind(authorsForFind);

		Book foundBook = library.findBookByAuthor(authorForFind);
		System.out.println("Book by " + authorForFind.getName() + " " + authorForFind.getSurname() + ": " + "'"
				+ foundBook.getTitle() + "'" + ", " + foundBook.getYear());

		System.out.println();
		System.out.println("Sorting these books:\n");
		Book[] arraySort = library.booksSort();
		for (int i = 0; i < arraySort.length; i++) {
			if (arraySort[i] != null) {
				System.out.println(arraySort[i].getTitle() + ", " + arraySort[i].getYear());
			}
		}

		System.out.println();
		// delete book
		library.deleteBook("The Story of Earth");
		System.out.println();
		System.out.println("Books of the library after delete: \n");
		for (int i = 0; i < library.getBooksCount(); i++) {
			System.out.println(library.getBooks()[i].getTitle() + ", " + library.getBooks()[i].getYear() + " ");
		}
	}
}
