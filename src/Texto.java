import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
* Esta clase tiene 3 variables y contiene una lista
  * de m�todos para ayudarnos a leer y verificar cada
  * documento que tenemos en la carpeta de datos
 */
public class Texto implements Comparable<Texto> {
	private String nombre;
	private Phrase conjunto; //Almacena el conjunto de palabras
	private int freq;
	final static int nMax= 10; // Controla el maximo de palabras repetidas
	//constructors
	public Texto() {

	}

	public Texto(String nombre) {
		this.nombre = nombre;
		this.freq = 0;
	}

	public Texto(String nombre, int freq) {
		this.nombre = nombre;
		this.freq = freq;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Phrase getConjunto() {
		return conjunto;
	}

	public void setConjunto(Phrase phrase) {
		this.conjunto = phrase;
	}

	public int getFrecuencia() {
		return freq;
	}

	public void setFrecuencia(int freq) {
		this.freq = freq;
	}

	/*
* este m�todo nos ayuda a dividir un archivo en frases y
* agregar insertarlos en el �rbol AVL
	 */
	public AVLTree<String> crearAVL() throws IOException {
		Scanner input = new Scanner(new File("Data/" + this.getNombre()));
		Phrase p = new Phrase();
		AVLTree<String> tree = new AVLTree<String>();
		while (input.hasNext()) {
			String word = input.next().toLowerCase(); //Minuscula
			p.addword(word);
			//insertar cada diez palabras en el nuevo nodo
			if (p.getNumbersWord() == nMax) {
				tree.setRoot(tree.insert(tree.getRoot(), new String(p.getData())));

			}
		}
		input.close();
		return tree;
	}

	//Este método determina la frecuencia con la que se contiene un conjunto de palabras
	public void matching_count(AVLTree<String> tree) throws FileNotFoundException{
		Scanner input = new Scanner(new File("Data/" + this.getNombre()));
		Phrase p = new Phrase();		
		int freq =0;

		while (input.hasNext()) {
			String word = input.next().toLowerCase();//Minuscula
			p.addword(word);
			// compruebe si el �rbol avl contiene la frase de 10 palabras
			if (p.getNumbersWord() == nMax) {
				if (tree.find(tree, p.getData().toString().trim()) != null) {
					freq++;//incrementar la frecuencia si encontramos una frase coincidente en el �rbol AVL
					this.setFrecuencia(freq);
				}
			}
		}
		input.close();
	}

//comparar documentos por el n�mero de frecuencia
	public int compareTo(Texto d1) {
		if (d1.getFrecuencia() > this.getFrecuencia()) {
			return 1;
		} else if (d1.getFrecuencia() < this.getFrecuencia()) {
			return -1;
		}
		return 0;
	}
}
