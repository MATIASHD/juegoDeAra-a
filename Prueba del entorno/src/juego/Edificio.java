package juego;
import java.awt.Color;

import entorno.Entorno;
public class Edificio {
	
	//viriables de instancia
	private double edificioX;
	private double edificioY;
	private double anchoEdificio;
	private double altoEdificio;
	
	public Edificio (double X, double Y, double ancho, double largo) {
		this.edificioX = X;
		this.edificioY = Y;
		this.anchoEdificio = ancho;
		this.altoEdificio = largo;
	}
	
	
	//Getter and Setters
	
	public double getEdificioX() {
		return edificioX;
	}

	public void setEdificioX(double edificioX) {
		this.edificioX = edificioX;
	}

	public double getEdificioY() {
		return edificioY;
	}

	public void setEdificioY(double edificioY) {
		this.edificioY = edificioY;
	}

	public double getAnchoEdificio() {
		return anchoEdificio;
	}

	public void setAnchoEdificio(double anchoEdificio) {
		this.anchoEdificio = anchoEdificio;
	}

	public double getAltoEdificio() {
		return altoEdificio;
	}

	public void setAltoEdificio(double altoEdificio) {
		this.altoEdificio = altoEdificio;
	}
	
	
	void dibujarEdificio(Entorno entorno) 
	{
		entorno.dibujarRectangulo(getEdificioX(), getEdificioY(), getAnchoEdificio(), getAltoEdificio(), 0, Color.MAGENTA);
	}
	
	//Cantidad de edificio debe ser entre 4 y 8
	//nadie puede atravesar los edificios, ni araña, exterminador balas, ni tampoco las bombas pueden destruirlas

}
