package it.polito.tdp.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import it.polito.tdp.lab05.DAO.AnagrammaDAO;

public class Model {

	

	AnagrammaDAO anagrammaDAO = new AnagrammaDAO();

	

	public Set<String> calcolaAnagrammi(String parola){

		Set<String> anagrammi = new HashSet<String>();

		String parziale = "";

		calcola(parziale,parola,0,anagrammi);

		return anagrammi;

	}

	

	public boolean isCorrect(String anagramma){
		return anagrammaDAO.isCorrect(anagramma);

	}

	

	private void calcola(String parziale,String parola, int passo, Set<String> anagrammi){

		if(passo == parola.length()){

			anagrammi.add(parziale);

			return;

		}

		

		for(int i = 0; i< parola.length(); i++){

			if(charCounter(parziale, parola.charAt(i))< charCounter(parola, parola.charAt(i))){

				parziale += parola.charAt(i);

				calcola(parziale, parola, passo + 1,anagrammi);

				parziale = parziale.substring(0,parziale.length()-1);

			}

		}

			

	}

	



	private static int charCounter(String string, char c){

		int count = 0;

	    for (int i=0; i < string.length(); i++)

	    {

	        if (string.charAt(i) == c)

	        {

	             count++;

	        }

	    }

	    return count;

	}

	

	

	

}