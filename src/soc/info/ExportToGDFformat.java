package soc.info;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import soc.data.Author;
import soc.data.Professor;

public class ExportToGDFformat {

	public static void export(List<Professor> lProfessors) {

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter("network.gdf");
			pw = new PrintWriter(fichero);

			pw.println("nodedef> name VARCHAR"); // Defines the node format on GDF file

			for (Professor prf : lProfessors)
				pw.println(prf.getName());
			
			pw.println("edgedef>node1 VARCHAR,node2 VARCHAR, weight INTEGER"); // Defines the edges format on GDF file

			for (Professor prf : lProfessors) 
				for (Author auth: prf.getlCoauthorship())
					pw.println(prf.getName()+","+auth.getName()+"," + auth.getContributions());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
