package soc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import soc.data.Professor;
import soc.info.ExportToGDFformat;
import soc.info.FileReader;
import soc.info.dblpQuery;

public class Main {

	public static void main(String[] args) throws MalformedURLException,
			IOException, SAXException, ParserConfigurationException {

		FileReader fReader = null;
		try {
			fReader = new FileReader(args[0]);
			fReader.readFile();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}

		dblpQuery dblp = new dblpQuery(fReader.getListSitesOnDBLP());
		dblp.runQuery();
		List<Professor> lProfessors = dblp.getProfessorsList();
		ExportToGDFformat.export(lProfessors);
	}
}
