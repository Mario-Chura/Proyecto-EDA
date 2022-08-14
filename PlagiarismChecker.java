import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class PlagiarismChecker{  
    private ArrayList<String> bd;

    public static void main(String[] args){
        System.out.print("Prueba");
    }

    public boolean loadFiles(String[] paths){
        bd= new ArrayList<String>();

        String line;
        try {
            Scanner lector= new Scanner(new FileReader("Mensaje.txt"));
            while(lector.hasNextLine()) {
                line= lector.nextLine();
                System.out.println(line);
            }
            lector.close();
        }
        catch (FileNotFoundException e){
            System.out.print("Error");
            return false;
        }
    }

    public ResultChecker verifyPlagiarism(String path){
        ResultChecker obj= null;
        
        return obj.result;
    }
}
