package by.htp.classes.model;

import java.util.Date;

public class Author {

	private String name;
	private String surname;
	private Date birthDay;

	public Author() {

	}

	public Author(String name, String surname, Date birthDay) {
		this.name = name;
		this.surname = surname;
		this.birthDay = birthDay;
	}

	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public Date getDate() {
		return this.birthDay;
	}
	
}
