package org.ardoise.views.menues;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import org.ardoise.views.fenetres.Fenetre;

public class FileMenue extends JMenu {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2306907894572105312L;

	public FileMenue(Fenetre fen) {
		super("Files");
		this.setMnemonic('f');

		JMenuItem suppress = new JMenuItem("Effacer");
		suppress.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
		suppress.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fen.getPan().clear();			
			}
		});
		
		
		JMenuItem quit = new JMenuItem("Quitter");
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK));

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
