package com.asmaa.DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* esta clase ayuda a leer archivos y verificar la frecuencia de las frases en cada documento individual
  * y guardar el resultado de cada documento en archivo de texto
 */
public class Detector {
	private List<Document> results=new ArrayList<Document>();
	private int heightAVL;// altura del árbol avl generado
	final static int max_number_word=5;
	public List<Document> getResults() {
		return results;
	}

	public int getHeightAVL() {
		return heightAVL;
	}

	public void setHeightAVL(int heightAVL) {
		this.heightAVL = heightAVL;
	}

	public void setResults(List<Document> results) {
		this.results = results;
	}

	public Detector() {

	}
/*
* cargar la lista de los documentos que necesitamos procesar desde el archivo small.txt
* luego verifique la similitud de cada documento individual con el primer documento dadot
 */
	public void ReadFiles() throws IOException {
		List<String> listDocuments = new ArrayList<String>();
		AVLTree<String> tree = null;
		String l;
		int progress=0;
		//este documento contiene los nombres de los documentos que queremos procesar
		BufferedReader smallfile = new BufferedReader(new FileReader("Data/small.txt"));

		while ((l = smallfile.readLine()) != null) {
			listDocuments.add(l);
		}
		smallfile.close();

		//la primera línea contiene el nombre del documento principal que queremos comparar con el resto de otros documentos
		Document d1 = new Document(listDocuments.get(0));
		tree = d1.createAVL();//cargar el primer documento y agregarlo al árbol avl
		this.heightAVL=tree.height(tree.getRoot());// cuenta la altura del árbol generado
		
		for (int i = 1; i < listDocuments.size(); i++) {
			progress=(i*100)/listDocuments.size();//progreso del procesamiento por porcentaje
			
			Document d = new Document(listDocuments.get(i));
		
			d.matching_count(tree);
			this.results.add(d);//añadir el resultado del documento actual a la lista de matrices
			
			System.out.print(progress+"% ");
	
			
		}
		saveResult("Data/Ouput/result.txt");
	}
	
	/*
* este método permite guardar el resultado que obtuvimos después de verificar las frases coincidentes en el archivo de texto.
* La primera línea del archivo contiene la altura del árbol AVL que generamos.
* Cada una de las líneas restantes contienen el número de frases comunes de un solo documento.
	 */
public void saveResult(String output) throws IOException
{
Collections.sort(results);
BufferedWriter out = new BufferedWriter(new FileWriter(output));
out.write(" Height AVL:"+this.heightAVL+"\n");
for (Document d: results) {
  out.write(d.getFileName()+" # of matching phrases:"+d.getFrequency()+"\n");
}
out.close();
}
}
