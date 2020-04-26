package org.ardoise.views.fenetres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import org.ardoise.views.panneaus.Panneau;

public class Fenetre extends JFrame{

	private final Panneau pan = new Panneau();
	
	public Fenetre() {
		
		Dimension dim = new Dimension(500, 300);
		this.setSize(dim);
		
		
		this.setLayout(new BorderLayout());
		pan.setBackground(Color.RED);
		this.add(pan,BorderLayout.CENTER);
		
		
		
		
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
