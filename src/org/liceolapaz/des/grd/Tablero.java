package org.liceolapaz.des.grd;

import java.awt.GridLayout;

import javax.swing.JPanel;

import org.liceolapaz.des.grd.Boton;
import org.liceolapaz.des.grd.Ventana;

public class Tablero extends JPanel {
	private int columnas;
	private int filas;
	private Boton[][] botones;
	
	public Ventana vTablero;
	
	public Tablero(Ventana vTablero, int filas, int columnas) {
		super();
		this.vTablero = vTablero;
		this.filas = filas;
		this.columnas = columnas;
		setLayout(new GridLayout(filas, columnas));
		crearBotones();
	}
	
	private void crearBotones() {
		this.botones = new Boton[this.filas][this.columnas];
		for (int fila = 0; fila < this.filas; fila++) {
			for (int columna = 0; columna < this.columnas; columna++) {
				this.botones[fila][columna] = new Boton(this, fila, columna, 0);
				add(this.botones[fila][columna]);
			}
}
	}
}
