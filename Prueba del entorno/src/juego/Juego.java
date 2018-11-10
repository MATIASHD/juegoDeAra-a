package juego;


//import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	Exterminador heroe;
	Araña[] arana;
	Edificio[] edificios;
	Pics pics;
	private int direccion;
	public Bala bala;
	private int lateralesReservado;
	// Variables y métodos propios de cada grupo
	// ...
	int tiempo = 0;
	int limiteTiempo = 50;
	String tiempoTextos = "";
	
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Prueba del entorno", 800, 600);
		pics = new Pics();
		// Inicializar lo que haga falta para el juego
		// ...
		
		this.heroe = new Exterminador(400,500);
		this.arana = new Araña[50];
		this.crearArana(this.arana);
		this.edificios = new Edificio[8];
		this.crearEdificios(this.edificios);
		direccion = 0;
		lateralesReservado = 20;
		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		//Si toca la araña o la bomba, agregar
			//Nuestro objet
			
		accionesExterminador();	
		
			
	}
		
	//METODOS

	
	//Aranas
	void crearArana(Araña[] arana) {
		int ejeY = 50;
		int ejeX = 30;
		for(int i = 0; i < arana.length; i++) {
			arana[i] = new Araña(ejeX,ejeY);
			if( i >= 25) {
				ejeY = 100;
				ejeX -= 30;
			} else {
				ejeX += 30;
			}
		}
	}
	
	void dibujarArana(Araña[] arana) {
		for(int i = 0; i < arana.length; i++) {
			arana[i].dibujarArana(entorno);
		}
	}
	
	//bombas
	void crearBombas(Mina[] bombas) {
		int ejeX = 20;
		for(int i = 0; i < bombas.length; i++) {
			bombas[i] = new Mina(ejeX,325, 20,20);
			ejeX += 80;
		}
	}
	
	void dibujarBombas(Mina[] bombas) {
		for(int i = 0; i < bombas.length; i++) {
			bombas[i].dibujarBomba(entorno);
		}
	}
	
	//Edificios
	void crearEdificios(Edificio[] edificios) {
		int largoX = 80;
		int largoY = 200;
		for(int i =0; i < edificios.length; i++) {
			edificios[i] = new Edificio(largoX,largoY,78,98);
			
			if (i >= 4) {
				largoX -= 200;
				largoY = 400;
			}else {
				largoX += 200;
			}
		}
	}
	
	void dibujarEdificios(Edificio[] edificios) {
		for(int i = 0; i < edificios.length; i++){
			edificios[i].dibujarEdificio(entorno);
		}
	}
	
	private void accionesExterminador() 
	{
		this.heroe.dibujarExterminador(entorno);
		movimientosExterminador();
		exterminadorDispara();
	}
	
	//Movimientos termineitor
	private void movimientosExterminador () 
	{
		
		if ( entorno.sePresiono(entorno.TECLA_DERECHA) )
		{	
			if(direccion <= 3)
				direccion += 1;
			
			if(direccion == 4)
				direccion = 0;
		}
		
		if( entorno.sePresiono(entorno.TECLA_IZQUIERDA) )
		{
			if( direccion >= 0)
				direccion--;
			
			if( direccion == -1)
				direccion = 3;
		}
		
		if(entorno.estaPresionada(entorno.TECLA_ARRIBA))
			heroe.caminar(direccion);
	}
	
	private void exterminadorDispara()
	{
		bala = heroe.disparar(direccion, entorno);
		bala.movimientoBala();
		bala.dibujarBala(entorno);
	}
	
	/*
	void dibujarTiempo(int tiempo) {
		tiempoTexto = Integer.toString(tiempo); 
		entorno.cambiarFont(tiempoTexto, 40, Color.ORANGE);
		entorno.escribirTexto(tiempoTexto, 700, 50);
		
	}
	*/
	
	public int getLateralesReservado() {
		return lateralesReservado;
	}

	public void setLateralesReservado(int lateralesReservado) {
		this.lateralesReservado = lateralesReservado;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
