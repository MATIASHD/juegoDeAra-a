package juego;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

//import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Exterminador heroe;
	private Araña[] arana;
	private Edificio[] edificios;
	private Pics pics;
	private ArrayList<Bala> balas = new ArrayList<Bala>();
	private Mina [] minas;
	private Edificio edificioPrueba;
	private Araña aranaPrueba;
	// Variables y métodos propios de cada grupo
	// ...
	private int direccion;
	private int tiempo;
	private int limite;
	private int cantidadBala;
	private int lateralesReservado;

	String tiempoTextos = "";
	
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Prueba del entorno", 1024, 600);
		pics = new Pics();
		// Inicializar lo que haga falta para el juego
		// ...
		
		this.heroe = new Exterminador(512,300);
		this.arana = new Araña[8];
		this.crearArana(this.arana);
		this.edificios = new Edificio[8];
		this.crearEdificios(this.edificios);
		this.minas = new Mina[15];
		this.edificioPrueba = new Edificio(200, 300);
		this.aranaPrueba = new Araña( 800,560);
		this.direccion = 0;
		this.lateralesReservado = 20;
		this.tiempo = 0;
		this.limite = 50;
		this.cantidadBala = 0;
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
		if(!heroe.colicionConArana(aranaPrueba) && !cuentaRegresiva()) {
			accionesExterminador();	
			edificioPrueba.dibujarEdificio(entorno);
			aranaPrueba.dibujarArana(entorno);				
			this.dibujarTiempo();
			recorrerList(balas, entorno);
			if(!this.balas.isEmpty()) {
				this.trayectoBala();
			}
			tiempo++;
			cuentaRegresiva();
				
			//System.out.println(entorno.ancho());
		} else {
			//El exterminador perdio la vida
			entorno.dibujarImagen(pics.perdio, 512, 300, 0);
		}
		 //El exterminador Gano la partida
		if(cuentaRegresiva()) {
			entorno.dibujarImagen(pics.gano, 512, 300, 0);
		}	
			
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
	
	void recorrerList(ArrayList<Bala> a, Entorno entorno) {
		Iterator<Bala> it = a.iterator();
		while(it.hasNext()) {
			Bala item = it.next();
			item.dibujarBala(entorno);
		}
	}
	
	//Edificios
	void crearEdificios(Edificio[] edificios) {
		int largoX = 80;
		int largoY = 200;
		for(int i =0; i < edificios.length; i++) {
			edificios[i] = new Edificio(largoX,largoY);
			
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
		
		if (entorno.sePresiono(entorno.TECLA_ESPACIO)) {
			
					Bala bala = (Bala) this.crearBala();
					balas.add(bala);
					System.out.println("entro");

				
		}
		heroe.caminar(direccion, entorno, edificioPrueba);
			
	}
	
	public Bala crearBala () {
		Bala balaCreando = new Bala(heroe.getCuadradoX(),heroe.getCuadradoY());
		return balaCreando;	
	}
	
	void trayectoBala () {
		for (int i = 0; i < this.balas.size(); i++) {
			Bala recorreBala = (Bala) this.balas.get(i);
			int posicion = recorreBala.getBalaX();
			
			recorreBala.setBalaX(posicion += 5);
		}
	}
	
	void dibujarTiempo() {
		
		tiempoTextos = Integer.toString(limite);
		entorno.cambiarFont(tiempoTextos, 40, Color.BLUE);
		entorno.escribirTexto(tiempoTextos, 700, 50);
		
	}
	
	public boolean cuentaRegresiva() {
		if (tiempo >= 100) {
			limite -= 1;
			tiempo = 0;
		}
		if (limite == -1) {
			return true;
		}
		return false;
	}
	
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
