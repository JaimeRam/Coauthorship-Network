package soc.info;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import soc.data.Author;
import soc.data.Professor;

public class dblpQuery {

	public static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	private List<String> lSitesdblp;
	private List<Professor> listProfessors;

	public dblpQuery(List<String> list) {
		lSitesdblp = list;
		listProfessors = new ArrayList<Professor>();
	}

	public void runQuery() throws ParserConfigurationException,
			MalformedURLException, SAXException, IOException {

		for (String url : lSitesdblp) {

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new URL(url).openStream());

			String professorName = doc.getDocumentElement().getAttribute(
					"author");
			NodeList nodeLst = doc.getElementsByTagName("author");
			nodeLst.toString();

			List<Author> listContributions = new ArrayList<Author>();

			for (int s = 0; s < nodeLst.getLength(); s++) {

				Node fstNode = nodeLst.item(s);

				if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
					String name = fstNode.getFirstChild().getNodeValue();
					String count = fstNode.getAttributes()
							.getNamedItem("count").getNodeValue();
					Author author = new Author(name, Integer.parseInt(count));
					listContributions.add(author);
				}
			}
			Professor prof = new Professor(professorName, listContributions);
			listProfessors.add(prof);
		}
	}

	public List<Professor> getProfessorsList() {
		return listProfessors;
	}
}
