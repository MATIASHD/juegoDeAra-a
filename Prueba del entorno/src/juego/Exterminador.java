package juego;
import java.awt.Color;
import entorno.Entorno;

public class Exterminador {
	
	//Variable de instancia
	private int cuadradoX;
	private int cuadradoY;
	private int lado;
	
	//Limita los parametros de la pantalla
	private int limitarPantallaDeInicio = 10;
	private int limitarAncho = 1024;
	private int limitarAlto = 620;
	
	//Limite de edificio de izquierda y derecha
	private int limitarEjeX = 1;
	
	
	
	//Constructor
	public Exterminador(int X, int Y) 
	{
		cuadradoX = X;
		cuadradoY = Y;
		lado = 20;
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

	public double getLado() {
		return lado;
	}

	public void setDiametro(int lado) {
		this.lado = lado;
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
	public boolean colicionEdificios (Edificio edificio)
	{
		int bordeIzquierdo = Math.abs((this.lado/2) - this.cuadradoX); 
		int bordeDerecho = Math.abs(this.cuadradoX + (this.lado/2));
		int bordeSuperior = Math.abs((this.lado/2) - this.cuadradoY);
		int bordeInferior = Math.abs(this.cuadradoY + (this.lado/2));
		
		int ladoIzqEdificio = Math.abs((edificio.getAnchoEdificio()/2) - edificio.getEdificioX());
		double ladoDerEdificio = Math.abs(edificio.getEdificioX() + (edificio.getAnchoEdificio() /2));
		double ladoSupEdificio = Math.abs((edificio.getAltoEdificio() /2) - edificio.getEdificioY());
		double ladoInfEdidicio = Math.abs(edificio.getEdificioY() + (edificio.getAltoEdificio() /2));
		
		boolean y = bordeInferior > ladoSupEdificio && bordeSuperior < ladoInfEdidicio;
		boolean x = bordeDerecho > ladoIzqEdificio && bordeIzquierdo < ladoDerEdificio;
		if ( x && y ) 
			return true;
		return false;
	}
	
	public int dondeColisiono(Edificio edificio)
	{
		int bordeIzquierdo = Math.abs((this.lado/2) - this.cuadradoX); 
		int bordeDerecho = Math.abs(this.cuadradoX + (this.lado/2));
		int bordeSuperior = Math.abs((this.lado/2) - this.cuadradoY);
		int bordeInferior = Math.abs(this.cuadradoY + (this.lado/2));
		
		int ladoIzqEdificio = Math.abs((edificio.getAnchoEdificio()/2) - edificio.getEdificioX());
		double ladoDerEdificio = Math.abs(edificio.getEdificioX() + (edificio.getAnchoEdificio() /2));
		double ladoSupEdificio = Math.abs((edificio.getAltoEdificio() /2) - edificio.getEdificioY());
		double ladoInfEdidicio = Math.abs(edificio.getEdificioY() + (edificio.getAltoEdificio() /2));
		
		boolean colSup = ladoSupEdificio >= bordeInferior && ladoSupEdificio <= bordeInferior && ladoDerEdificio >= bordeIzquierdo && ladoIzqEdificio <= bordeDerecho;
		boolean colInf = ladoInfEdidicio <= bordeSuperior && ladoInfEdidicio >= bordeSuperior && ladoDerEdificio >= bordeIzquierdo && ladoIzqEdificio <= bordeDerecho;
		boolean colDer = ladoDerEdificio <= bordeIzquierdo && ladoDerEdificio + this.limitarEjeX>= bordeIzquierdo && ladoSupEdificio <= bordeInferior && ladoInfEdidicio >= bordeSuperior;
		boolean colIzq = ladoIzqEdificio >= bordeDerecho && ladoIzqEdificio - this.limitarEjeX <= bordeDerecho && ladoSupEdificio <= bordeInferior && ladoInfEdidicio >= bordeSuperior;
		
		if(colSup)
			return 1;
		if(colInf)
			return 3;
		if(colDer)
			return 0;
		if(colIzq)
			return 2;
		return -1;
	}

	public void caminar(int i, Entorno entorno, Edificio edificio)
	{
		switch (i) 
		{
		case 0:
			if(cuadradoY > this.limitarPantallaDeInicio )
				if(entorno.estaPresionada(entorno.TECLA_ARRIBA) && dondeColisiono(edificio) != 3)
					this.cuadradoY -= 2;
			break;
		case 1:
			if(cuadradoX < this.limitarAncho)
				if(entorno.estaPresionada(entorno.TECLA_ARRIBA) && dondeColisiono(edificio) != 2)
					this.cuadradoX += 2;
			break;
		case 2:
			if(cuadradoY < this.limitarAlto)
				if(entorno.estaPresionada(entorno.TECLA_ARRIBA) && dondeColisiono(edificio) != 1)
					this.cuadradoY += 2;
			break;
		case 3:
			if(cuadradoX > this.limitarPantallaDeInicio)
				if(entorno.estaPresionada(entorno.TECLA_ARRIBA) && dondeColisiono(edificio) != 0)
					this.cuadradoX -= 2;
		default:
			break;
		}
	}
	
	public boolean colicionConArana (Araña arana) {
		int bordeIzq = Math.abs((this.lado/2) - this.cuadradoX); 
		int bordeDer = Math.abs(this.cuadradoX + (this.lado/2));
		int bordeSup = Math.abs((this.lado/2) - this.cuadradoY);
		int bordeInf = Math.abs(this.cuadradoY + (this.lado/2));
		
		//araña
		double aranaSup = Math.abs((arana.getDiametro()/2) - arana.getAranaY());
		double aranaInf = Math.abs((arana.getDiametro()/2) + arana.getAranaY());
		double aranaDer = Math.abs((arana.getDiametro()/2) + arana.getAranaX());
		double aranaIzq = Math.abs((arana.getDiametro()/2) - arana.getAranaX());
		
		if(bordeIzq <= aranaDer && bordeDer >= aranaIzq && bordeInf >= aranaSup && bordeSup <= aranaInf ) {
			return true;
		}
		return false;
	}

	
	
}

























