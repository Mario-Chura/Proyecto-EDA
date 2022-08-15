
public class ResultChecker {
	
	private boolean [] result;
	private String [] palabras;
	private int i;
	
	public ResultChecker(int n){
		result= new boolean[n];
		i= 0;
	}

	public boolean [] getResult() {
		return this.result;
	}

	public void setResult(boolean[] result_) {
		this.result = result_;
	}

	public void setResult(boolean b) {
		result[i]= b;
		i++;
	}
	
	public String [] getPalabras() {
		return this.palabras;
	}

	public void setPalabras(String[] palabras_) {
		this.palabras = palabras_;
	}
	
	public void imprimir(){
       for (int i = 0; i < result.length; i++) {
    	   if(result[i]) {
    		   System.out.println(palabras[i]+ "Entonces S� hay plagio");
    		   
    	   }else {
    		   System.out.println(palabras[i]+ "Entonces NO hay plagio");
    	   }
		
       }
       
    }
	
	
	
}
