

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
* Esta clase tiene 3 variables y contiene una lista
  * de métodos para ayudarnos a leer y verificar cada
  * documento que tenemos en la carpeta de datos
 */
public class Document implements Comparable<Document> {
	private String fileName;
	private Phrase phrase;
	private int frequency;
	final static int max_number_word=5;
	//constructors
	public Document() {

	}

	public Document(String fileName) {

		this.fileName = fileName;
		this.frequency = 0;

	}

	public Document(String fileName, int frequency) {

		this.fileName = fileName;
		this.frequency = frequency;
	}
	
//getters and setters
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Phrase getPhrase() {
		return phrase;
	}

	public void setPhrase(Phrase phrase) {
		this.phrase = phrase;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/*
* este método nos ayuda a dividir un archivo en frases y
* agregar insertarlos en el árbol AVL
	 */
	public AVLTree<String> createAVL() throws IOException {
		Scanner input = new Scanner(new File("Data/" + this.getFileName()));
		Phrase p = new Phrase();
		AVLTree<String> tree = new AVLTree<String>();
		while (input.hasNext()) {
			String word = input.next().toLowerCase();
			p.addword(word);
			//insertar cada cinco palabras en el nuevo nodo
			if (p.getNumbersWord() == max_number_word) {
				tree.setRoot(tree.insert(tree.getRoot(), new String(p.getData())));

			}
		}

		input.close();
		return tree;

	}

	/*
	 *this method  read an avl tree and count the frequency of phrases in  the current document
	 */
	public void matching_count(AVLTree<String> tree) throws FileNotFoundException

	{
		Scanner input = new Scanner(new File("Data/" + this.getFileName()));

		Phrase p = new Phrase();
		
		int frequency =0;
		while (input.hasNext()) {

			String word = input.next().toLowerCase();
			p.addword(word);
			// compruebe si el árbol avl contiene la frase de 5 palabras
			if (p.getNumbersWord() == max_number_word) {

				if (tree.find(tree, p.getData().toString().trim()) != null) {

					frequency++;//incrementar la frecuencia si encontramos una frase coincidente en el árbol AVL
					this.setFrequency(frequency);

				}
			}
		}

		input.close();
	}
//comparar documentos por el número de frecuencia
	@Override
	public int compareTo(Document d1) {
		if (d1.getFrequency() > this.getFrequency()) {
			return 1;
		} else if (d1.getFrequency() < this.getFrequency()) {
			return -1;
		}
		return 0;
	}

}
