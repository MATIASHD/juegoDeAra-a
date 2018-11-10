package juego;

import java.awt.Color;

import entorno.Entorno;

public class Mina {
	//variable de instancia
	private double minaX;
	private double minaY;
	private double anchoMina;
	private double largoMina;
	
	public Mina (double X, double Y, double ancho, double largo) {
		minaX = X;
		minaY = Y;
		anchoMina = ancho;
		largoMina = largo;
	}
	
	void dibujarBomba (Entorno entorno) {
		entorno.dibujarRectangulo(minaX, minaY, anchoMina, largoMina, 0, Color.ORANGE);
	}
	
	//Bombas puede dejarla donde esta el personaje
	//Cuando la araña toca la bomba estalla
	//elimina todo lo que esta en su radio(inclusive nuestro exterminador) excepto los edificios
	//pueden hacer detonaciones sucesivas
	//nuestro heroe puede atravesarla (saltar) sin que explote o ni el que salte
	//la tecla M servira para dejar la la bomba 

}
