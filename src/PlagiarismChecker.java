

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.SwingUtilities;

/**
*esta clase ayuda a leer archivos y verificar la frecuencia de las frases en cada documento individual
*y guardar el resultado de cada documento en archivo de texto
*/
public class PlagiarismChecker {
	
	static List<Document> results = new ArrayList<Document>();
	
	static List<String> listDocuments = new ArrayList<String>();
	static AVLTree<String> tree =null; 
	
	static int heightAVL;// altura del árbol avl generado
	final static int max_number_word=5;
	static String respuesta="";
	
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
		BufferedReader smallfile = new BufferedReader(new FileReader("Data/indice.txt"));

		while ((l = smallfile.readLine()) != null) {
			listDocuments.add(l);
		}
		smallfile.close();

		//la primera línea contiene el nombre del documento principal que queremos comparar con el resto de otros documentos
		Document d1 = new Document(listDocuments.get(0));
		tree = d1.createAVL();//cargar el primer documento y agregarlo al árbol avl
		this.heightAVL=tree.height(tree.getRoot());// cuenta la altura del árbol generado
		
		
	}
	
	/*
* este método permite guardar el resultado que obtuvimos después de verificar las frases coincidentes en el archivo de texto.
* La primera línea del archivo contiene la altura del árbol AVL que generamos.
* Cada una de las líneas restantes contienen el número de frases comunes de un solo documento.
	 */
	
	public static ResultChecker verifyPlagiarism() throws IOException{
		//ingresar original
		//proceso de verificar
		
		ResultChecker resultado3= new  ResultChecker();
		String l;
		int progress=0;
		
		for (int i = 1; i < listDocuments.size(); i++) {
			progress=(i*100)/listDocuments.size();//progreso del procesamiento por porcentaje
			
			Document d = new Document(listDocuments.get(i));
		
			d.matching_count(tree); //compara
			results.add(d);//añadir el resultado del documento actual a la lista de matrices
			
			System.out.print(progress+"% ");
			respuesta= respuesta+progress+"% " ;
	
			
		}
		
		resultado(resultado3);
		
		return resultado3;
		
	}
	
	public static void resultado(ResultChecker resultado5){
		
		boolean[] resultados2 = new boolean[results.size()];
		String[] result6 = new String[results.size()];
		System.out.println(" Height AVL:" + heightAVL+"\n");
		respuesta= respuesta+" Height AVL:" + heightAVL+"\n" ;
		for (int i = 0; i < results.size(); i++) {
			if(results.get(i).getFrequency() != 0) {
				result6[i]=results.get(i).getFileName()+" n° de frases coincidentes :"+results.get(i).getFrequency()+"\n";
				respuesta= respuesta+result6[i];
				resultados2[i]=true;
			}else {
				result6[i]=results.get(i).getFileName()+" n° de frases coincidentes :"+results.get(i).getFrequency()+"\n";
				respuesta= respuesta+ result6[i] ;
				resultados2[i]=false;
			}
			
		}		
		resultado5.setResult(resultados2);
		resultado5.setPalabras(result6);
		
	}

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		 

		 long startTime = System.currentTimeMillis();

		 System.out.println("#Procesando");
		 respuesta= respuesta+"#Procesando"+"\n" ;

		 PlagiarismChecker d = new PlagiarismChecker();
		 d.ReadFiles();
		 
		 try {
			ResultChecker rre1 = verifyPlagiarism();
			rre1.imprimir();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		 System.out.println("100% \n#Procesamiento: ¡Listo!");
		 respuesta= respuesta+"100% \n#Procesamiento: ¡Listo!"+"\n" ;

		 System.out.println("#el resultado se guarda en el archivo 'Data/Output/result.txt'");
		 respuesta= respuesta+"#el resultado se guarda en el archivo 'Data/Output/result.txt'"+"\n";

		 long stopTime = System.currentTimeMillis();
		 long elapsedTime = stopTime - startTime;
		 System.out.println("Tiempo de procesamiento en milisegundos: "+elapsedTime);
		 respuesta= respuesta+"Tiempo de procesamiento en milisegundos: "+elapsedTime+"\n";
		 System.out.println(respuesta);
		 PrintStream out = new PrintStream(new FileOutputStream("Output.txt"));
	        System.setOut(out);
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                GUI gui = new GUI(respuesta);
	                gui.Display();
	            }
	        });

	 }

}
