package juego;

import java.awt.Color;

import entorno.Entorno;

public class Bala {
	//variable de instancia
	private int balaX;
	private int balaY;
	private int direccion;
	
	public Bala(int x, int y, int direccion) 
	{
		this.balaX = x;
		this.balaY = y;
		this.direccion = direccion;
	}
	
	public void dibujarBala (Entorno entorno) 
	{
		entorno.dibujarRectangulo(balaX, balaY, 3, 3, 0, Color.RED);
	}
	
	public void movimientoBala()
	{
		switch (direccion) 
		{
		case 0:
				this.balaY -= 2;
				System.out.println("BALA Y" + balaY);
			break;
		case 1:
				this.balaX += 2;
			break;
		case 2:
			this.balaY += 2;
			break;
		case 3:
				this.balaX -= 2;
		default:
			break;
		}
	}
	
	
	
	
	//proyectil viaja en linea reacta a velocidad constante
	//MUERE LA ARAÑA al instante si es alcansada por el proyectil
	//cuando el proyectil toca la bomba, esta estalla como si fuera una araña quien la toco
	//los proyectiles no atraviesan los edificios
}
