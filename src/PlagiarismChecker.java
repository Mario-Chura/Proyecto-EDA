import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PlagiarismChecker{  
    static ArrayList<String> bd= new ArrayList<String>();
    static ArrayList<ArrayList> list= new ArrayList<ArrayList>();

    public static void main(String[] args){
        PlagiarismChecker nom = new PlagiarismChecker();
        nom.loadFiles();
         System.out.println(bd.toString());
    }
    public boolean loadFiles(){

        String line;
        try {
            Scanner lector= new Scanner(new FileReader("D:\\Semestre_3\\Estructura_de_Datos_Algoritmos\\Proyecto\\Proyecto-EDA\\Bdatos\\texto1.txt"));
            while(lector.hasNextLine()) {
                line= lector.next();
                line= line.replace(",","");
                bd.add(line);
                System.out.println(line);
        
            }
            lector.close();
           
        }
        catch (FileNotFoundException e){
            System.out.print("Error");
            return false;
        }
		return false;
    }

    public ResultChecker verifyPlagiarism(String path){
        ResultChecker obj= null;
        
        return obj;
    }
}