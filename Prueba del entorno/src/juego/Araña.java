package juego;
import java.awt.Color;
import entorno.Entorno;

public class Araña {
	
	//variable de instancia 
	private double aranaX;
	private double aranaY;
	private double diametro;
	
	public Araña(double X, double Y) {
		aranaX = X;
		aranaY = Y;
		diametro = 25;
	}
	
	void dibujarArana(Entorno entorno) {
		entorno.dibujarCirculo(aranaX, aranaY, diametro, Color.GRAY);
	}

	public double getAranaX() {
		return aranaX;
	}

	public void setAranaX(double aranaX) {
		this.aranaX = aranaX;
	}

	public double getAranaY() {
		return aranaY;
	}

	public void setAranaY(double aranaY) {
		this.aranaY = aranaY;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	
	
	
	//Sabe donde esta nuestro exterminador y lo persiguen
	//no atraviesan edificios ni nada 
	//cada cierto tiempo las arañas, tiran su tela luego la mismas desaparencen
	//las araña ingresaran a la pantalla de cualquiera de los lados y de forma aleatoria en ubicacion y en tiempo
}
