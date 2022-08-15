
/**
 *Esta clase es la estructura de la frase tipo, 
 *cada frase contiene una cantidad de palabras, cada frase 
 *tiene una cantidad m�xima de palabras
 */
public class Phrase  {
	private StringBuilder data;
	private int numbersWord;
	final static int max_number_word=10;
//Constructor
	public Phrase() {
		
	}

	//getters and setters
	public StringBuilder getData() {
		return data;
	}

	public void setData(StringBuilder data) {
		this.data = data;
	}

	public int getNumbersWord() {
		return numbersWord;
	}

	public void setNumbersWord(int numbersWord) {
		this.numbersWord = numbersWord;
	}
	
	/*
* este m�todo nos ayuda a agregar palabras a una frase dada y cada
* vez que la frase llegue a 5 palabras quitaremos la primera
* palabra y agregue la nueva palabra al final de la oraci�n
	 */
	public void addword(String word) {
		word = word.replaceAll("[!?,.:;)(]", "").trim();// remove punctuation
		if (data == null) {
			StringBuilder sb = new StringBuilder();
			sb.append(word);
			this.setData(sb);
			this.numbersWord += 1;
		} else {
			StringBuilder temp = this.getData();
			if (this.numbersWord < max_number_word) {
				if (temp.length() > 0) {
					temp.append(" ").append(word);

				} else {
					temp.append(word);
				}
				this.setData(temp);
				this.numbersWord += 1;

			} else {
				temp.delete(0, temp.indexOf(" ") + 1);
				temp.append(" ").append(word);
				this.setData(temp);
				this.numbersWord = max_number_word;

			}
		}
	}

	

	
}
