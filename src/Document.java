import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
* Esta clase tiene 3 variables y contiene una lista
  * de m�todos para ayudarnos a leer y verificar cada
  * documento que tenemos en la carpeta de datos
 */

public class Document{
	private String fileName;
	private Phrase phrase;
	final static int max_number_word=10;
	//constructors
	public Document() {

	}

	public Document(String fileName) {
		this.fileName = fileName;
	}

	public Document(String fileName, int frequency) {
		this.fileName = fileName;
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

	/*
* este m�todo nos ayuda a dividir un archivo en frases y
* agregar insertarlos en el �rbol AVL
	 */
	public AVLTree<String> createAVL(){
		Scanner input;
		try{
			input = new Scanner(new FileReader(this.getFileName()));
		}
		catch(FileNotFoundException e){
			System.out.println("Error en Document/maching_count");
			return null;
		}

		Phrase p = new Phrase();
		AVLTree<String> tree = new AVLTree<String>();
		System.out.println("Creando AVL de " + fileName);
		while (input.hasNext()) {
			String word = input.next().toLowerCase();
			System.out.print(word + " ");
			p.addword(word);
			//insertar cada cinco palabras en el nuevo nodo
			if (p.getNumbersWord() == max_number_word) {
				tree.setRoot(tree.insert(tree.getRoot(), new String(p.getData())));
			}
		}
		input.close();
		System.out.println("  +++ Terminado +++");
		return tree;
	}

	/*
	 *this method  read an avl tree and count the frequency of phrases in  the current document
	 */
	public boolean matching_count(AVLTree<String> tree){
		Scanner input;
		try{
			input = new Scanner(new FileReader(this.getFileName()));
		}
		catch(FileNotFoundException e){
			System.out.println("Error en Document/maching_count");
			return false;
		}
		
		Phrase p = new Phrase();
		while (input.hasNext()) {
			String word = input.next().toLowerCase();
			p.addword(word);
			// compruebe si el �rbol avl contiene la frase de 10 palabras
			if (p.getNumbersWord() == max_number_word) {
				if (tree.find(tree, p.getData().toString().trim()) != null) {
					input.close();
					return true;
				}
			}
		}
		input.close();
		return false;
	}
}
