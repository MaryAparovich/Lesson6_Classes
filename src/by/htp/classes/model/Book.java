package by.htp.classes.model;

public class Book {

	private String title;
	private int year;
	private Author[] authors;
	private int authorCount;

	public Book() {

	}

	public Book(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public int getAuthorCount() {
		return this.authorCount;
	}

	public void setAutors(Author[] authors) {
		if (authors != null) {
			this.authors = authors;
		}
	}

	public Author[] getAuthors() {
		return this.authors;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	public void addAuthor(Author author) {

		if (this.authors != null) {
			if (authorCount < authors.length) {
				authors[authorCount] = author;
				authorCount++;
			} else {
				Author[] extendAuthors = new Author[this.authors.length + 10];
				for (int i = 0; i < this.authors.length; i++) {
					extendAuthors[i] = this.authors[i];
				}
				this.authors = extendAuthors;
				this.authors[authorCount] = author;
				authorCount++;
			}

		} else {
			this.authors = new Author[10];
			this.authors[0] = author;
			authorCount++;
		}
	}

	public void addAuthors(Author[] authors) {
		for (int i = 0; i < authors.length; i++) {
			addAuthor(authors[i]);
		}
	}
}
