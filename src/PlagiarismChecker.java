import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
/**
*esta clase ayuda a leer archivos y verificar la frecuencia de las frases en cada documento individual
*y guardar el resultado de cada documento en archivo de texto
*/
public class PlagiarismChecker {
	
	static List<Document> results = new ArrayList<Document>();	
	static List<String> listDocuments = new ArrayList<String>();
	static List<AVLTree<String>> trees= new ArrayList<AVLTree<String>>(); //Lista de arboles
	static String respuesta="";
	
	public List<Document> getResults() {
		return results;
	}

	public PlagiarismChecker() {

	}
/*
* cargar la lista de los documentos que necesitamos procesar desde el archivo small.txt
* luego verifique la similitud de cada documento individual con el primer documento dadot
 */
	public boolean LoadFiles(String[] paths){
		//leer
		//estructurar
		System.out.println("Entrando a LoadFiles");
		Document d;
		for(String path: paths){
			if(listDocuments.contains(path)){
				continue;
			}
			d= new Document(path);
			trees.add(d.createAVL());
			listDocuments.add(path);
			if(trees.get(trees.size()-1)== null){
				return true;
			}
			System.out.println("Se agrego " + path);
		}
		return false;
	}

	/*
* este m�todo permite guardar el resultado que obtuvimos despu�s de verificar las frases coincidentes en el archivo de texto.
* La primera l�nea del archivo contiene la altura del �rbol AVL que generamos.
* Cada una de las l�neas restantes contienen el n�mero de frases comunes de un solo documento.
	 */

	public ResultChecker verifyPlagiarism(String path){
		//ingresar original
		//proceso de verificar
		System.out.println("Entrando en verifyPlagiarism");
		ResultChecker result= new ResultChecker(trees.size());
		int progress=0;
		Document d = new Document(path);
		
		for (int i = 0; i < trees.size(); i++) {
			progress=((i+1)*100)/trees.size();//progreso del procesamiento por porcentaje
			System.out.print("--> Comparando " + listDocuments.get(i) + "  -  ");
			result.setResult(d.match(trees.get(i)),listDocuments.get(i));
			System.out.println(progress+"% ");
			respuesta= respuesta+progress+"% " ;		
		}	
		return result;		
	}
}
