
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
*esta clase ayuda a leer archivos y verificar la frecuencia de las frases en cada documento individual
*y guardar el resultado de cada documento en archivo de texto
*/
public class PlagiarismChecker {
	
	static List<Document> results = new ArrayList<Document>();	
	static List<String> listDocuments = new ArrayList<String>();
	static List<AVLTree<String>> trees= new ArrayList<AVLTree<String>>(); //Lista de arboles
	
	
	final static int max_number_word=10;
	static String respuesta="";
	
	public List<Document> getResults() {
		return results;
	}
/*
	public int getHeightAVL() {
		return heightAVL;
	}

	public void setHeightAVL(int heightAVL) {
		this.heightAVL = heightAVL;
	}*/

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

		//la primera l�nea contiene el nombre del documento principal que queremos comparar con el resto de otros documentos
		Document d1 = new Document(listDocuments.get(0));
		tree = d1.createAVL();//cargar el primer documento y agregarlo al �rbol avl
		//this.heightAVL=tree.height(tree.getRoot());// cuenta la altura del �rbol generado
	}
	*/
	/*
* este m�todo permite guardar el resultado que obtuvimos despu�s de verificar las frases coincidentes en el archivo de texto.
* La primera l�nea del archivo contiene la altura del �rbol AVL que generamos.
* Cada una de las l�neas restantes contienen el n�mero de frases comunes de un solo documento.
	 */

	public static ResultChecker verifyPlagiarism(String path){
		//ingresar original
		//proceso de verificar
		System.out.println("Entrando en verifyPlagiarism");
		ResultChecker result= new ResultChecker(trees.size());
		int progress=0;
		Document d = new Document(path);
		
		for (int i = 0; i < trees.size(); i++) {
			progress=((i+1)*100)/trees.size();//progreso del procesamiento por porcentaje
			System.out.print("--> Comparando " + listDocuments.get(i) + "  -  ");
			result.setResult(d.matching_count(trees.get(i)));
			System.out.println(progress+"% ");
			respuesta= respuesta+progress+"% " ;		
		}	
		return result;		
	}
/* 
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
			results.add(d);//a�adir el resultado del documento actual a la lista de matrices
			
			System.out.print(progress+"% ");
			respuesta= respuesta+progress+"% " ;
	
			
		}
		
		resultado(resultado3);
		
		return resultado3;
		
	}*/
	
	public static void resultado(ResultChecker results){		
		/*
		System.out.println(" Height AVL:" + heightAVL+"\n");
		respuesta= respuesta+" Height AVL:" + heightAVL+"\n" ;*/
		System.out.println("Entrando a Result Checker");
		String[] result6= new String[trees.size()];
		for (int i = 0; i < results.getResults().length; i++) {			
			result6[i]=listDocuments.get(i) + " Plagio :"+results.getResult(i) +"\n";
			System.out.println("-->" + result6[i]);
		}		
	}

	
	 public static void main(String[] args) throws IOException, InterruptedException {
		 
		//long startTime = System.currentTimeMillis();
		System.out.println("#Procesando");
		respuesta= respuesta+"#Procesando"+"\n" ;

		PlagiarismChecker d = new PlagiarismChecker();
		String[] paths={"Data/bmu5.txt","Data/abf076.txt","Data/abf386.txt","Data/abf70402.txt","Data/bef1121.txt","Data/bef1121.txt"};
		System.out.println(d.LoadFiles(paths) + " en Load");
		 
		String simple= "Data/simple.txt"; //archivo a examinar 
	
		ResultChecker rre1 = verifyPlagiarism(simple);
		resultado(rre1);
		/*
		 System.out.println("100% \n#Procesamiento: �Listo!");
		 respuesta= respuesta+"100% \n#Procesamiento: �Listo!"+"\n" ;

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
			*/
		
	}
}
