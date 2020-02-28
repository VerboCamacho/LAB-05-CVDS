package edu.eci.cvds.game;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.Random;

@ManagedBean(name="guessBean")
//@ApplicationScoped
@SessionScoped

public class Game {
	
	public static final int PREMIO=1000;
	
	private int numberToGuess;
	private int numberOfattemps;
	private int accumulated;
	private String state;
	private ArrayList<Integer> attemps;
	
	
	


	public Game() {
		 attemps=new ArrayList<Integer>();
		 restart();
	}
	public ArrayList<Integer> getIntentos() {
		return attemps;
	}


	public int getNumberToGuess() {
		return numberToGuess;
	}

	public int getNumeroIntentos() {
		return numberOfattemps;
	}

	public int getAcumulado() {
		return accumulated;
	}


	public String getEstado() {
		return state;
	}
	public void restart() {
		accumulated=PREMIO;
		numberOfattemps=0;
		Random r=new Random();
		numberToGuess=r.nextInt(1000);
		state="Welcome";
		attemps.clear();
	} 
	public void guess(int intento) {
		if(intento!=numberToGuess) {
			numberOfattemps+=1;
			accumulated-=100;
			state="Keep Trying ";
			attemps.add(intento);
		}
		else {
			state="Have you won Cute Monitor !";
		}
	} 


}
