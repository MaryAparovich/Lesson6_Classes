package by.htp.classes.model;

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

	// найти книгу по автору

	public Book findBookByAuthor(Author author) {
		for (int i = 0; i < booksCount; i++) {
			Book book = books[i];// берем i-тую книгу
			Author[] authors = book.getAuthors();
			for (int j = 0; j < book.getAuthorCount(); j++)// взяли у конкретной книги авторов
			{
				Author bookAuthor = authors[j];
				if (author.getName() == bookAuthor.getName()) {
					return book;
				}
			}
		}
		return null;
	}
	
	public Book[] booksSort() {
		for (int i = 0; i < booksCount - 1; i++) {
			for (int j = 0; j < booksCount - 1; j++) {
				if (books[j].getYear() < books[j + 1].getYear()) {
					Book minYear = books[j];
					books[j] = books[j + 1];
					books[j + 1] = minYear;
				}
			}
		}
		return this.books;
	}

	public void deleteBook(int index) {
		boolean isDeleted = false;

		for (int i = index; i < booksCount; i++) {
			if (booksCount != i + 1) {
				books[i] = books[i + 1];
				books[i + 1] = null;
				isDeleted = true;
			} else {
				if (index == booksCount - 1) {
					books[index] = null;
					isDeleted = true;
				}
			}
		}
		if (isDeleted == true) {
			booksCount--;
		}
	}

	public void deleteBook(String title) {
		for (int i = 0; i < booksCount; i++) {
			Book book = books[i];
			if (title == book.getTitle()) {
				deleteBook(i);
			}
		}
	}
}
