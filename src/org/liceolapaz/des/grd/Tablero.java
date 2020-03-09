package org.liceolapaz.des.grd;

import java.awt.GridLayout;
import java.util.Random;

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
		valoresCartas();
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
	private void pulsarComprobar{
		if 
	}
	private void valoresCartas() {
		Random random = new Random();
		int repetir = 0;
		while (repetir < 1) {
			int valor = 1;
			while (valor < (this.filas * this.columnas) / 2) {
				int fila = random.nextInt(this.filas);
				int columna = random.nextInt(this.columnas);
				if (this.botones[fila][columna].getValor() == 0) {
					this.botones[fila][columna].setValor(valor);
					valor++;
				}
			}
			repetir++;
		}
	}
}
