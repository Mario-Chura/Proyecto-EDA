

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
*esta clase ayuda a leer archivos y verificar la frecuencia de las frases en cada documento individual
*y guardar el resultado de cada documento en archivo de texto
*/
public class PlagiarismChecker {
	
	static List<Texto> results = new ArrayList<Texto>();
	
	static List<String> listDocuments = new ArrayList<String>();
	static AVLTree<String> tree =null; 
	
	static int heightAVL;// altura del �rbol avl generado
	final static int max_number_word=5;
	
	public List<Texto> getResults() {
		return results;
	}

	public int getHeightAVL() {
		return heightAVL;
	}

	public void setHeightAVL(int heightAVL) {
		this.heightAVL = heightAVL;
	}

	public void setResults(List<Texto> results) {
		this.results = results;
	}

	public PlagiarismChecker() {

	}
/*
* cargar la lista de los documentos que necesitamos procesar desde el archivo small.txt
* luego verifique la similitud de cada documento individual con el primer documento dadot
 */
	public void ReadFiles() throws IOException {
		//leer
		//estructurar
		
		String l;
		
		int progress=0;
		
		//este documento contiene los nombres de los documentos que queremos procesar
		BufferedReader smallfile = new BufferedReader(new FileReader("Data/small.txt"));

		while ((l = smallfile.readLine()) != null) {
			listDocuments.add(l);
		}
		smallfile.close();

		//la primera l�nea contiene el nombre del documento principal que queremos comparar con el resto de otros documentos
		Texto d1 = new Texto(listDocuments.get(0));
		tree = d1.crearAVL();//cargar el primer documento y agregarlo al �rbol avl
		this.heightAVL=tree.height(tree.getRoot());// cuenta la altura del �rbol generado
		
		
	}
	
	/*
* este m�todo permite guardar el resultado que obtuvimos despu�s de verificar las frases coincidentes en el archivo de texto.
* La primera l�nea del archivo contiene la altura del �rbol AVL que generamos.
* Cada una de las l�neas restantes contienen el n�mero de frases comunes de un solo documento.
	 */
	
	public static ResultChecker verifyPlagiarism() throws IOException{
		//ingresar original
		//proceso de verificar
		
		ResultChecker resultado3= new  ResultChecker();
		String l;
		int progress=0;
		
		for (int i = 1; i < listDocuments.size(); i++) {
			progress=(i*100)/listDocuments.size();//progreso del procesamiento por porcentaje
			
			Texto d = new Texto(listDocuments.get(i));
		
			d.matching_count(tree); //compara
			results.add(d);//a�adir el resultado del documento actual a la lista de matrices
			
			System.out.print(progress+"% ");
	
			
		}
		
		resultado(resultado3);
		
		return resultado3;
		
	}
	
	public static void resultado(ResultChecker resultado5){
		
		boolean[] resultados2 = new boolean[results.size()];
		String[] result6 = new String[results.size()];
		System.out.println(" Height AVL:" + heightAVL+"\n");
		for (int i = 0; i < results.size(); i++) {
			if(results.get(i).getFrecuencia() != 0) {
				result6[i]=results.get(i).getNombre()+" n� de frases coincidentes :"+results.get(i).getFrecuencia()+"\n";
				resultados2[i]=true;
			}else {
				result6[i]=results.get(i).getNombre()+" n� de frases coincidentes :"+results.get(i).getFrecuencia()+"\n";
				resultados2[i]=false;
			}
			
		}		
		resultado5.setResult(resultados2);
		resultado5.setPalabras(result6);
		
	}

	
	 public static void main(String[] args) throws IOException, InterruptedException {

		 long startTime = System.currentTimeMillis();

		 System.out.println("#Procesando");

		 PlagiarismChecker d = new PlagiarismChecker();
		 d.ReadFiles();
		 
		 try {
			ResultChecker rre1 = verifyPlagiarism();
			rre1.imprimir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 System.out.println("100% \n#Procesamiento: �Listo!");

		 System.out.println("#el resultado se guarda en el archivo 'Data/Output/result.txt'");

		 long stopTime = System.currentTimeMillis();
		 long elapsedTime = stopTime - startTime;
		 System.out.println("Tiempo de procesamiento en milisegundos: "+elapsedTime);

	 }

}
