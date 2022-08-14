package com.asmaa.DataStructure;

import java.io.IOException;



/**
 * CSC 245 Main.java
 * 
	Prop�sito: este programa proporcionar� experiencia en la implementaci�n de un �rbol AVL
 	Determinar la similitud observada en un conjunto de documentos con base en el n�mero de
 	Frases de 5 palabras que comparten los documentos.
 * 
 * @version 1.0 04/07/18
 * @author Asmaa khaloua
 */ 
public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		long startTime = System.currentTimeMillis();

		System.out.println("#Procesando");

		Detector d = new Detector();
		d.ReadFiles();

		System.out.println("100% \n#Procesamiento: �Listo!");

		System.out.println("#el resultado se guarda en el archivo 'Data/Output/result.txt'");

		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("Tiempo de procesamiento en milisegundos: "+elapsedTime);

	}
}
