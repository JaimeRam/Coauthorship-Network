package soc.info;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	private InputStream file;
	private List<String> lSitesOnDBLP;

	public FileReader(String fileName) throws FileNotFoundException {
		file = new FileInputStream(fileName);
		lSitesOnDBLP = new ArrayList<String>();
	}

	public void readFile() {
		Scanner reader = new Scanner(file);
		String line = null;

		while (reader.hasNext()) {
			line = reader.nextLine();
			lSitesOnDBLP.add(line);
		}
		reader.close();
	}

	public List<String> getListSitesOnDBLP() {
		return lSitesOnDBLP;
	}
}
