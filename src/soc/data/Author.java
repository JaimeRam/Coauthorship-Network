package soc.data;

public class Author {

	private String name;
	private int contributions;

	public Author(String name, int contributions) {
		super();
		this.name = name;
		this.contributions = contributions;
	}

	public String getName() {
		return name;
	}

	public int getContributions() {
		return contributions;
	}
}
