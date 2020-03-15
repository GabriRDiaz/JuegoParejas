package org.liceolapaz.des.grd;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.liceolapaz.des.Ventana;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

public class Ventana extends JFrame {
	JLabel Buscar = new JLabel("Buscar Parejas");
	JLabel Pulse = new JLabel("Pulse en la img para jugar");
	JLabel Nombre = new JLabel("Autor: Gabriel R.Díaz");
	JButton imgInicio = new JButton();
	JLabel lbNIntentos;
	JLabel lbNParejas;
	Tablero tablero;
	public int intentos = 0;
	public int parejas =6;
	private int filasCustom;
	private int colCustom;
	public Ventana() {
		super("Buscar parejas - Gabriel Rodríguez Díaz");
		setSize(1024, 768);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(getClass().getResource("/iconCelta.png"));
		this.setIconImage(img.getImage());
		botonInicio();
		labels();
	}
	public void nuevoJuego() {
		 JOptionPane.showMessageDialog(null, "Has ganado en "+intentos+" intentos. Genio, lince, figura",
					"Enhorabuena",JOptionPane.INFORMATION_MESSAGE);
	    	int respuesta = JOptionPane.showConfirmDialog(Ventana.this, "¿Quieres jugar otra partida?",
					"Nuevo documento", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				juegoSimple();
		} else {
			System.exit(0);
		}
	}
	
	public Tablero juegoCustom(int filas, int columnas) {
		this.remove(tablero);
		tablero = new Tablero(filas,columnas);
		this.add(tablero);
		parejas = filas*columnas /2;
		intentos = 0;
		lbNIntentos.setText(""+intentos);
		lbNParejas.setText(""+parejas);
		revalidate();
		return tablero;
	}
	
	public Tablero juegoSimple() {
		if(tablero == null) {
		tablero = new Tablero(4,3);
		revalidate();
		return tablero;
		}
		else {
			this.remove(tablero);
			tablero = new Tablero(4,3);
			this.add(tablero);
			parejas = 6;
			intentos = 0;
			lbNIntentos.setText(""+intentos);
			lbNParejas.setText("6");
			revalidate();
			return tablero;
		}
	}
	
	private JMenuBar barra() {
		JMenuBar barra = new JMenuBar();
		//Menú Partida
		JMenu menuPartida = new JMenu("Partida");
		menuPartida.setMnemonic(KeyEvent.VK_P);
		barra.add(menuPartida);
		//Menú Opciones
		JMenu menuOpciones = new JMenu("Opciones");
		menuOpciones.setMnemonic(KeyEvent.VK_P);
		barra.add(menuOpciones);
		
		//Nueva
		JMenuItem nuevaPartida = new JMenuItem("Nueva Partida");
		//archivoNuevo.setIcon(new ImageIcon(getClass().getResource("/nuevo.png")));
		nuevaPartida.setMnemonic(KeyEvent.VK_N);
		nuevaPartida.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		menuPartida.add(nuevaPartida);
		
		//Guardar
		JMenuItem guardarPartida = new JMenuItem("Guardar Partida");
		//archivoNuevo.setIcon(new ImageIcon(getClass().getResource("/nuevo.png")));
		guardarPartida.setMnemonic(KeyEvent.VK_N);
		guardarPartida.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
		menuPartida.add(guardarPartida);
		
		//Cargar
		JMenuItem cargarPartida = new JMenuItem("Cargar Partida");
		//archivoNuevo.setIcon(new ImageIcon(getClass().getResource("/nuevo.png")));
		cargarPartida.setMnemonic(KeyEvent.VK_N);
		cargarPartida.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
		menuPartida.add(cargarPartida);
		
		//Salir
		JMenuItem salirJuego = new JMenuItem("Salir");
		//archivoNuevo.setIcon(new ImageIcon(getClass().getResource("/nuevo.png")));
		salirJuego.setMnemonic(KeyEvent.VK_N);
		salirJuego.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
		menuPartida.add(salirJuego);
		
		//Almacenar
		JMenuItem almacenarRes = new JMenuItem("Almacenar Resultado");
		//archivoNuevo.setIcon(new ImageIcon(getClass().getResource("/nuevo.png")));
		almacenarRes.setMnemonic(KeyEvent.VK_N);
		menuOpciones.add(almacenarRes);
		
		//Dificultad
		JMenuItem dificultadJuego = new JMenuItem("Dificultad");
		//archivoNuevo.setIcon(new ImageIcon(getClass().getResource("/nuevo.png")));
		dificultadJuego.setMnemonic(KeyEvent.VK_N);
		dificultadJuego.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
		menuOpciones.add(dificultadJuego);
		
		dificultadJuego.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Dialogo dialogo = new Dialogo(Ventana.this);
			}
		});
		
		guardarPartida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		cargarPartida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		salirJuego.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		almacenarRes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		nuevaPartida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				juegoSimple();
			}
		});
		return barra;
	}

	public JPanel footer() {
		JPanel footer = new JPanel();
			footer.setLayout(new FlowLayout(FlowLayout.LEFT));
			//Intentos
			JLabel lbIntentos = new JLabel("Intentos");
			lbIntentos.setBorder(new LineBorder(Color.BLACK, 2));
			lbIntentos.setPreferredSize(new Dimension(200, 100));
			lbIntentos.setHorizontalAlignment(SwingConstants.CENTER);
			footer.add(lbIntentos);
			//N intentos
			lbNIntentos = new JLabel(""+intentos);
			lbNIntentos.setBorder(new LineBorder(Color.BLACK, 3));
			lbNIntentos.setPreferredSize(new Dimension(150, 100));
			lbNIntentos.setHorizontalAlignment(SwingConstants.CENTER);
			footer.add(lbNIntentos);
			//Parejas
			JLabel lbParejas= new JLabel("Parejas");
			lbParejas.setBorder(new LineBorder(Color.BLACK, 3));
			lbParejas.setPreferredSize(new Dimension(150, 100));
			lbParejas.setHorizontalAlignment(SwingConstants.CENTER);
			footer.add(lbParejas);
			// N Parejas
			lbNParejas = new JLabel(""+parejas);
			lbNParejas.setBorder(new LineBorder(Color.BLACK, 3));
			lbNParejas.setPreferredSize(new Dimension(150, 100));
			lbNParejas.setHorizontalAlignment(SwingConstants.CENTER);
			footer.add(lbNParejas);
			// Img
			JButton celta = new JButton();
			celta.setIcon(new ImageIcon(getClass().getResource("/CeltaV.png")));
			celta.setBorderPainted(false);
			celta.setFocusPainted(false);
			celta.setContentAreaFilled(false);
			footer.add(celta);
			// Tiempo
			JLabel lbTiempo = new JLabel("56");
			lbTiempo.setBorder(new LineBorder(Color.BLACK, 3));
			lbTiempo.setPreferredSize(new Dimension(150, 100));
			lbTiempo.setHorizontalAlignment(SwingConstants.CENTER);
			footer.add(lbTiempo);
		return footer;
	}
	
	public void botonInicio() {
		imgInicio.setIcon(new ImageIcon(getClass().getResource("/FTP.jpg")));
		imgInicio.setBorderPainted(false);
		imgInicio.setFocusPainted(false);
		imgInicio.setContentAreaFilled(false);
		imgInicio.setBounds(250, 100, 500, 420);
		imgInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(Buscar);
				remove(Pulse);
				remove(Nombre);
				remove(imgInicio);
				crearInterfaz();
			}
		});
	    add(imgInicio);
	}
	public void crearInterfaz() {
		setLayout(new BorderLayout());
		add(juegoSimple(), BorderLayout.CENTER);
		add(barra(), BorderLayout.PAGE_START);
		add(footer(), BorderLayout.PAGE_END);
		revalidate();
	}
	public void labels() {
//		Buscar
		Buscar.setFont(new Font("Default", 1, 20));
		Buscar.setBounds(410, 50, 300, 50);
		add(Buscar);
//		Pulse
		Pulse.setFont(new Font("Default", 4, 20));
		Pulse.setBounds(370, 520, 300, 50);
		add(Pulse);
//		Nombre
		Nombre.setFont(new Font("Default", 1, 15));
		Nombre.setBounds(410, 590, 300, 50);
		add(Nombre);
	}
	
	public void setIntentos(int intentos) {
		lbNIntentos.setText(""+intentos);
		revalidate();
	}

	public void setParejas(int parejas) {
		lbNParejas.setText(""+parejas);
		if(parejas == 0) {
			nuevoJuego();
		} else {
			revalidate();
		}
	}

	public int getIntentos() {
		intentos++;
		return intentos;
	}

	public int getParejas() {
		parejas--;
		return parejas;
	}

}
