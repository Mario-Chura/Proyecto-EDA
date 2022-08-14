
public class ResultChecker {

	
	private boolean [] result;
	private String [] palabras;
	
	public boolean [] getResult() {
		return this.result;
	}

	public void setResult(boolean[] result_) {
		this.result = result_;
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
    		   System.out.println(palabras[i]+ "Entonces SÍ hay plagio");
    	   }else {
    		   System.out.println(palabras[i]+ "Entonces NO hay plagio");
    	   }
		
       }
       
    }
	
	
	
}
