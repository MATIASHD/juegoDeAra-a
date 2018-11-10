package juego;
import java.awt.Color;
import entorno.Entorno;

public class Araña {
	
	//variable de instancia 
	public double aranaX;
	public double aranaY;
	public double diametro;
	
	public Araña(double X, double Y) {
		aranaX = X;
		aranaY = Y;
		diametro = 25;
	}
	
	void dibujarArana(Entorno entorno) {
		entorno.dibujarCirculo(aranaX, aranaY, diametro, Color.GRAY);
	}
	
	//Sabe donde esta nuestro exterminador y lo persiguen
	//no atraviesan edificios ni nada 
	//cada cierto tiempo las arañas, tiran su tela luego la mismas desaparencen
	//las araña ingresaran a la pantalla de cualquiera de los lados y de forma aleatoria en ubicacion y en tiempo
}
