package org.liceolapaz.des.grd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Dialogo extends JDialog {
		public int filas;
		public int columnas;
		private JRadioButton easyMode = new JRadioButton("Fácil");
		private JRadioButton mediumMode = new JRadioButton("Medio");
		private JRadioButton hardMode = new JRadioButton("Difícil");
		private JRadioButton customMode = new JRadioButton("Personalizado");
		private JTextField jTxtFilas = new JTextField();
		private JTextField jTxtCol = new JTextField();
		
	public Dialogo(Frame parent) {
		super(parent, "Nivel de dificultad");
		setVisible(true);
		setSize(400,250);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		this.add(rButtons(), BorderLayout.NORTH);
		this.add(textArea(), BorderLayout.CENTER);
		this.add(okButtons(), BorderLayout.PAGE_END);
		ImageIcon img = new ImageIcon(getClass().getResource("/iconCelta.png"));
		this.setIconImage(img.getImage());
		if(easyMode.isSelected()) {
			jTxtFilas.setText("3");
			jTxtFilas.setEditable(false);
			jTxtCol.setText("4");
			jTxtCol.setEditable(false);
		}
	}

	private JPanel okButtons() {
		JPanel botones = new JPanel();
			botones.setLayout(new FlowLayout());
			JButton okBut = new JButton("Aceptar");
			botones.add(okBut);
			JButton cancelBut = new JButton("Cancelar");
			botones.add(cancelBut);
		return botones;
	}

	private JPanel textArea() {
		JPanel txtAreas = new JPanel();
		txtAreas.setLayout(null);
		JLabel lbFilas = new JLabel("Filas");
		lbFilas.setBounds(5, 20, 200, 40);
		txtAreas.add(lbFilas);
		jTxtFilas.setBounds(220, 27, 160, 30);
		txtAreas.add(jTxtFilas);
		JLabel lbCol = new JLabel("Columnas");
		lbCol.setBounds(5, 70, 200, 40);
		txtAreas.add(lbCol);
		jTxtCol.setBounds(220, 77, 160, 30);
		txtAreas.add(jTxtCol);
		return txtAreas;
	}


	private JPanel rButtons() {
		JPanel botones = new JPanel();
		botones.setLayout(new FlowLayout());
		botones.add(easyMode);
		botones.add(mediumMode);
		botones.add(hardMode);
		botones.add(customMode);
		ButtonGroup bgModes = new ButtonGroup();
		bgModes.add(easyMode);
		bgModes.add(mediumMode);
		bgModes.add(hardMode);
		bgModes.add(customMode);
		return botones;
	}
}
