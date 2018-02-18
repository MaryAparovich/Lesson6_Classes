package by.htp.classes.input;

import java.util.Scanner;

import by.htp.classes.model.Author;

public class Input {

	Scanner MyScanner = new Scanner(System.in);

	public Author getInputAuthorForFind(Author[] authors) {
		
		printAuthors(authors);
		int authorNumber = enterAuthorNumber();
		authorNumber--;
		return authors[authorNumber];
	}

	private int enterAuthorNumber() {
		
		System.out.println();
		System.out.print("Select author's number to search for a book:");
		int number = MyScanner.nextInt();
		return number;
	}
	
	private void printAuthors(Author[] authors) {
		System.out.println("Authors for select:");
		for (int i = 0; i < authors.length; i++) {
			System.out.println((i + 1) + ". " + authors[i].getName() + " " + authors[i].getSurname());
		}
	}
}
