package org.ardoise.views.menues;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.ardoise.views.fenetres.Fenetre;

public class FileMenue extends JMenu {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2306907894572105312L;

	public FileMenue(Fenetre fen) {
		super("Files");
		
		JMenuItem suppress = new JMenuItem("Effacer");
		suppress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.getPan().clear();			
			}
		});
		
		
		JMenuItem quit = new JMenuItem("Quitter");
		quit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    System.exit(0);
				
			}
		});
		
		this.add(suppress);
		this.add(quit);
		this.setSize(new Dimension(100, 50));
		this.setVisible(true);
	}
}
