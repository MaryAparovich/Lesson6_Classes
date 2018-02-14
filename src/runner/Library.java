package runner;

public class Library {

	private String name;
	private int number;
	private Book[] books;
	private int booksCount;

	public Library(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Book[] getBooks() {
		return this.books;
	}

	public void setBooks(Book[] books) {
		if (books != null) {
			this.books = books;
		}
	}

	public int getBooksCount() {
		return this.booksCount;
	}

	public void addBook(Book book) {
		if (this.books != null) {
			if (booksCount < books.length) {
				books[booksCount] = book;
				booksCount++;
			} else {
				Book[] extendBooks = new Book[this.books.length + 10];
				for (int i = 0; i < this.books.length; i++) {
					extendBooks[i] = this.books[i];
				}
				this.books = extendBooks;
				this.books[booksCount] = book;
				booksCount++;
			}
		} else {
			this.books = new Book[10];
			this.books[0] = book;
			booksCount++;
		}
	}

	public void addBooks(Book[] books) {
		for (int i = 0; i < books.length; i++) {
			addBook(books[i]);
		}
	}
}
