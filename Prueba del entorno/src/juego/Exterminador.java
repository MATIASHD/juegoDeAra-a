package juego;
import java.awt.Color;
import entorno.Entorno;

public class Exterminador {
	
	//Variable de instancia
	private int cuadradoX;
	private int cuadradoY;
	private double lado;
	
	//Constructor
	public Exterminador(int X, int Y) 
	{
		cuadradoX = X;
		cuadradoY = Y;
		lado = 10;
	}
	
	void dibujarExterminador(Entorno entorno) {
		entorno.dibujarRectangulo(cuadradoX, cuadradoY, lado, lado, 0, Color.BLUE);	
		}
	
	//MUERE cuando lo toca la araña o esta dentro del radio de la bomba que justo toco la araña o el disparo del arma
	//se puede mover por toda la pantalla
	//no atraviesa edificios
	//cuando toca la tela de araña se le reduce la velocidad al 10% hasta que sale
	//Nuesto exterminador comienza desde el medio de la pantalla
	//FLECHA ARRIBA hace que avance
	//FLECHA DERECHA E IZQUIERDA hace gire para el lado que quiera ir
	//BARRA ESPACIDORA hace que nuestro exterminador dispare hacia adelante
	
	//get set
	void caminaParaAdelante () {
		this.cuadradoY += 2;
	}
	
	public int getCuadradoX() {
		return cuadradoX;
	}

	public void setCuadradoX(int cuadradoX) {
		this.cuadradoX = cuadradoX;
	}

	public int getCuadradoY() {
		return cuadradoY;
	}

	public void setCuadradoY(int cuadradoY) {
		this.cuadradoY = cuadradoY;
	}

	public double getDiametro() {
		return lado;
	}

	public void setDiametro(double diametro) {
		this.lado = diametro;
	}

	void caminarParaAtras () {
		this.cuadradoY -= 2;
	}
	
	void caminarDerecha () {
		this.cuadradoX += 2;
	}
	
	void caminarIzquierda () {
		this.cuadradoX -= 2;
	}
	
	//Colisiones
	boolean colicionEdificios (Edificio[] edificios) {
		for (int i = 0; i < edificios.length; i++) {
			if (this.cuadradoX + this.lado/2 <= Math.abs(edificios[i].getAnchoEdificio()/2 - edificios[i].getEdificioX()) &&
			this.cuadradoX - this.lado/2  >= Math.abs(edificios[i].getAnchoEdificio()/2 + edificios[i].getEdificioX()) &&
			this.cuadradoY + this.lado/2  >= Math.abs(edificios[i].getAltoEdificio()/2 - edificios[i].getEdificioY()) &&
			 this.cuadradoY - this.lado/2 <= Math.abs(edificios[i].getAltoEdificio()/2 + edificios[i].getEdificioY()))
			{
				return true;

			}
		}
		return false;
	}

	public void caminar(int i)
	{
		switch (i) 
		{
		case 0:
			if(cuadradoY > 20) // CAMBIAR  NUMEROS MAGICOS
				this.cuadradoY -= 2;
			break;
		case 1:
			if(cuadradoX < 600)
				this.cuadradoX += 2;
			break;
		case 2:
			if(cuadradoY < 600)
			this.cuadradoY += 2;
			break;
		case 3:
			if(cuadradoX > 20)
				this.cuadradoX -= 2;
		default:
			break;
		}
	}

	
	public Bala disparar(int direccion, Entorno entorno)
	{
		Bala bala = new Bala(cuadradoX, cuadradoY, direccion);
		return bala;
	}
}

























