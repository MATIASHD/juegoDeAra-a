package juego;

import java.awt.Color;

import entorno.Entorno;

public class Bala {
	//variable de instancia
	private int balaX;
	private int balaY;
	private int direccion;
	
	public Bala(int x, int y) 
	{
		this.balaX = x;
		this.balaY = y;
	}
	
	//Getter and Setter
	public int getBalaX() {
		return balaX;
	}

	public void setBalaX(int balaX) {
		this.balaX = balaX;
	}

	public int getBalaY() {
		return balaY;
	}

	public void setBalaY(int balaY) {
		this.balaY = balaY;
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}
	
	void disparo() {
		this.balaX += 2;
	}
	
	public void dibujarBala (Entorno entorno) 
	{
		entorno.dibujarRectangulo(balaX, balaY, 3, 3, 0, Color.RED);
	}
	
	public void movimientoBala(int direccion)
	{
		if (direccion == 0 || direccion == 2 ) {
			if (direccion == 2) {
				this.balaX += 2;
			} else {
				this.balaX -= 2;
			}
		} 
		if (direccion == 1 || direccion == 3 ) {
			if (direccion == 1) {
				this.balaY += 2;
			} else {
				this.balaY -= 2;
			}
		}
	}
	
	
	
	
	//proyectil viaja en linea reacta a velocidad constante
	//MUERE LA ARAÑA al instante si es alcansada por el proyectil
	//cuando el proyectil toca la bomba, esta estalla como si fuera una araña quien la toco
	//los proyectiles no atraviesan los edificios
}
