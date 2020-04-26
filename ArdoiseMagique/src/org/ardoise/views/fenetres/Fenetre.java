package org.ardoise.views.fenetres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import org.ardoise.views.menues.EditionMenue;
import org.ardoise.views.menues.FileMenue;
import org.ardoise.views.panneaux.Panneau;

public class Fenetre extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3004584483324316317L;
	private final Panneau pan = new Panneau();
	
	public Panneau getPan() {
		return pan;
	}

	public Fenetre() {
		
		Dimension dim = new Dimension(500, 300);
		this.setSize(dim);
		
		
		this.setLayout(new BorderLayout());
			
		
//		JPanel container = new JPanel();
//		container.setBackground(Color.white);
//		container.setLayout(new BorderLayout());
//		container.add(pan, BorderLayout.CENTER);
		this.setContentPane(pan);
		
		JMenuBar bar = new JMenuBar();
		bar.add(new FileMenue(this));
		bar.add(new EditionMenue(this));
		this.setJMenuBar(bar);
		
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}
