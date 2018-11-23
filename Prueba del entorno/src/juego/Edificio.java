package juego;
import java.awt.Color;

import entorno.Entorno;
public class Edificio {
	
	//viriables de instancia
	private int edificioX;
	private int edificioY;
	private int anchoEdificio = 150;
	private int altoEdificio = 100;
	
	public Edificio (int X, int Y) {
		this.edificioX = X;
		this.edificioY = Y;
	}
	//Getter and Setters
	
	public int getEdificioX() {
		return edificioX;
	}

	public void setEdificioX(int edificioX) {
		this.edificioX = edificioX;
	}

	public int getEdificioY() {
		return edificioY;
	}

	public void setEdificioY(int edificioY) {
		this.edificioY = edificioY;
	}
	
	public int getAnchoEdificio() {
		return anchoEdificio;
	}
	
	public int getAltoEdificio() {
		return altoEdificio;
	}
	
	
	void dibujarEdificio(Entorno entorno) 
	{
		entorno.dibujarRectangulo(getEdificioX(), getEdificioY(), this.anchoEdificio, this.altoEdificio, 0, Color.MAGENTA);
	}
	
	//Cantidad de edificio debe ser entre 4 y 8
	//nadie puede atravesar los edificios, ni araña, exterminador balas, ni tampoco las bombas pueden destruirlas

}
