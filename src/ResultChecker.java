
public class ResultChecker {
	
	private boolean [] result;
	private String [] titulos;
	private int i;
	
	public ResultChecker(int n){
		titulos= new String[n];
		result= new boolean[n];
		i= 0;
	}

	public boolean [] getResults() {
		return this.result;
	}

	public boolean getResult(int i) {
		return this.result[i];
	}

	public void setResult(boolean[] result_) {
		this.result = result_;
	}

	public void setResult(boolean b) {
		result[i]= b;
		i++;
	}
	
	public String [] getPalabras() {
		return this.titulos;
	}

	public void setTitulo(String t, int i) {
		System.out.println("Se agrego " + t + " " + i);
		this.titulos[i]= t;
	}

	public void setPalabras(String[] palabras_) {
		this.titulos = palabras_;
	}
	
	public void imprimir(){
       for (int i = 0; i < result.length; i++) {
    	   if(result[i]) {
    		   System.out.println(titulos[i]+ "Entonces S� hay plagio");
    		   
    	   }else {
    		   System.out.println(titulos[i]+ "Entonces NO hay plagio");
    	   }
		}       
    }
}
