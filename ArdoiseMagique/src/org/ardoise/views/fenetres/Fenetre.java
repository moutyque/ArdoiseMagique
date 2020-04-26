package org.ardoise.views.fenetres;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import org.ardoise.listeners.mouse.ChangeColor;
import org.ardoise.listeners.mouse.RoundShape;
import org.ardoise.listeners.mouse.SquareShape;
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
			
		
		JPanel container = new JPanel();
		container.setBackground(Color.white);
		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		JButton squarreButton = new JButton(createImageIcon("/org/ardoise/pictures/square.png"));
		squarreButton.addActionListener(new SquareShape(this));
		JButton roundButton = new JButton(createImageIcon("/org/ardoise/pictures/round.png"));
		roundButton.addActionListener(new RoundShape(this));

		toolBar.add(squarreButton);
		toolBar.add(roundButton);
		
		JButton red = new JButton(createImageIcon("/org/ardoise/pictures/squareRed.png"));
		red.addActionListener(new ChangeColor(this, Color.red));
		JButton green = new JButton(createImageIcon("/org/ardoise/pictures/squareGreen.png"));
		green.addActionListener(new ChangeColor(this, Color.green));
		JButton blue = new JButton(createImageIcon("/org/ardoise/pictures/squareBlue.png"));
		blue.addActionListener(new ChangeColor(this, Color.blue));

		toolBar.add(red);
		toolBar.add(green);
		toolBar.add(blue);
		
		container.add(toolBar,BorderLayout.NORTH);
		
		this.setContentPane(container);
				
		
		JMenuBar bar = new JMenuBar();
		bar.add(new FileMenue(this));
		bar.add(new EditionMenue(this));
		this.setJMenuBar(bar);
		
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}

}
