package soc.data;

import java.util.List;

public class Professor {

	private String name;
	private List<Author> lCoauthorship;

	public Professor(String name, List<Author> lCoauthorship) {
		super();
		this.name = name;
		this.lCoauthorship = lCoauthorship;
	}

	public String getName() {
		return name;
	}

	public List<Author> getlCoauthorship() {
		return lCoauthorship;
	}
}
