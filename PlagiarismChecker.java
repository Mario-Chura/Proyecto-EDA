
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class PlagiarismChecker{  
    private ArrayList<String> bd;

    public static void main(String[] args){
        PlagiarismChecker nom = new PlagiarismChecker();
        nom.loadFiles();
        
    }

    public boolean loadFiles(){
        bd= new ArrayList<String>();

        String line;
        try {
            Scanner lector= new Scanner(new FileReader("Base/Mensaje.txt"));
            while(lector.hasNextLine()) {
                line= lector.next();
                line= line.replace(",","");
                bd.add(line);
               
                System.out.println(line);
        
            }
            lector.close();
            System.out.println(bd.toString());
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