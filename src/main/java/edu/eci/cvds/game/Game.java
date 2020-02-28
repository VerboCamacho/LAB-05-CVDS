package edu.eci.cvds.game;

import java.util.ArrayList;
import java.util.Random;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


@ManagedBean(name = "guessBean")
@SessionScoped
public class Game {
    private int numero;
    private int intentado;
    private int intentosRealizados;
    private int premioAcumulado;
    private String estado;
    private ArrayList<Integer> numerosIntentados = new ArrayList<>();
   
    
    public Game() {
        numero = (int) (Math.random() *10 ) + 1;
        intentosRealizados = 0;
        premioAcumulado = 0;
        estado = "¿Listo para Jugar?";
      
    }
    
    public void guess(int intento) {
        estado = "No gano!";
        intentado = intento;
        if (intento >= 0 && intento <=20  && !numerosIntentados.contains(intento)){
            if (intento == numero){
                intentosRealizados ++;
                premioAcumulado = 100000-(intentosRealizados*10000);
                if(premioAcumulado < 0){
                    premioAcumulado = 0;
                }
                estado = "Ganó";
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Has Adivinado el Numero de la ronda anterior!, tu puntaje fue: "," "+premioAcumulado+" y con una cantidad de "+intentosRealizados+" intentos ;) El juego se Ha reiniciado ")); 
                restart();
            }else{
                intentosRealizados ++;
                numerosIntentados.add(intento);
            }
            
        }
        else{
            estado= "Woops! escribiste un dato invalido o un elemento repetido ;)";
        }
        
    }
    
    public void restart(){   
        numero = (int) (Math.random() *10 ) + 1;
        intentosRealizados = 0;
        premioAcumulado = 0;
        estado = "¿Listo Para Jugar?";
        numerosIntentados = new ArrayList<>();
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIntentado() {
        return intentado;
    }

    public void setIntentado(int intentado) {
        this.intentado = intentado;
    }
    
    

    public int getIntentosRealizados() {
        return intentosRealizados;
    }

    public void setIntentosRealizados(int intentosRealizados) {
        this.intentosRealizados = intentosRealizados;
    }

    public int getPremioAcumulado() {
        return premioAcumulado;
    }

    public void setPremioAcumulado(int premioAcumulado) {
        this.premioAcumulado = premioAcumulado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Integer> getNumerosIntentados() {
        return numerosIntentados;
    }

    public void setNumerosIntentados(ArrayList<Integer> numerosIntentados) {
        this.numerosIntentados = numerosIntentados;
    }


    
    
    
    
}


/**package edu.eci.cvds.game;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.Random;

@ManagedBean(name="guessBean")
@ApplicationScoped
//@SessionScoped

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

**/