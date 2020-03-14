package org.liceolapaz.des.grd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Dialogo extends JDialog {
		public int filas;
		public int columnas;
		
	public Dialogo(Frame parent) {
		super(parent, "Nivel de dificultad");
		setVisible(true);
		setSize(400,400);
//		setResizable(true);
		setLocationRelativeTo(null);
		this.add(componentes());
		revalidate();
	}

	private JFrame componentes() {
		JFrame compos = new JFrame();
		compos.setLayout(new BorderLayout());
		compos.add(radioButtons());
		compos.add(textAreas());
		return compos;
	}

	private JPanel textAreas() {
		JPanel textAreas = new JPanel();
		textAreas.setLayout(new FlowLayout());
		JTextField txtFilas = new JTextField();
		txtFilas.setBounds(10, 110, 200, 40);
		add(txtFilas);
		JLabel lbFilas = new JLabel("Filas");
		lbFilas.setBounds(10, 110, 200, 40);
		add(lbFilas);
		return textAreas;
	}

	private JPanel radioButtons() {
		JPanel rButtons = new JPanel();
		JRadioButton easyMode = new JRadioButton("Fácil");
		add(easyMode);
		JRadioButton mediumMode = new JRadioButton("Medio");
		add(mediumMode);
		JRadioButton hardMode = new JRadioButton("Difícil");
		add(hardMode);
		JRadioButton customMode = new JRadioButton("Personalizado");
		add(customMode);
		ButtonGroup bgModes = new ButtonGroup();
		bgModes.add(easyMode);
		bgModes.add(mediumMode);
		bgModes.add(hardMode);
		bgModes.add(customMode);
		return rButtons;
	}
//	}

//	private	JFrame componentes() {
//		JFrame compos = new JFrame();
//		compos.setLayout(new BorderLayout());
//		compos.add(radioButtons(), BorderLayout.NORTH);
//		compos.add(textAreas(), BorderLayout.CENTER);
//		return compos;
//	}
//
//	private JPanel radioButtons() {
//		JPanel rButtons = new JPanel();
//		rButtons.setLayout(new FlowLayout());
//		JRadioButton easyMode = new JRadioButton("Fácil");
//		add(easyMode);
//		JRadioButton mediumMode = new JRadioButton("Medio");
//		add(mediumMode);
//		JRadioButton hardMode = new JRadioButton("Difícil");
//		add(hardMode);
//		JRadioButton customMode = new JRadioButton("Personalizado");
//		add(customMode);
//		ButtonGroup bgModes = new ButtonGroup();
//		bgModes.add(easyMode);
//		bgModes.add(mediumMode);
//		bgModes.add(hardMode);
//		bgModes.add(customMode);
//		return rButtons;
//	}
//
//	private JPanel textAreas() {
//		JPanel textAreas = new JPanel();
//		textAreas.setLayout(new FlowLayout());
//		JTextField txtFilas = new JTextField();
//		txtFilas.setBounds(10, 110, 200, 40);
//		add(txtFilas);
//		JLabel lbFilas = new JLabel("Filas");
//		lbFilas.setBounds(10, 110, 200, 40);
//		add(lbFilas);
//		return textAreas;
//	}

}
