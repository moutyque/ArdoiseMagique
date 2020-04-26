package org.ardoise.views.menues;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.ardoise.views.fenetres.Fenetre;

public class EditionMenue extends JMenu {

	private final Fenetre fen;

	public EditionMenue(Fenetre fen) {
		super("Edtion");
		this.fen = fen;
		JMenu shape = new JMenu("Forme du pointeur");

		JMenuItem rond = new JMenuItem("Rond");
		rond.addActionListener((event)->fen.getPan().setRoundPointer(true));
		JMenuItem square = new JMenuItem("Carré");
		rond.addActionListener((event)->fen.getPan().setRoundPointer(false));
		shape.add(rond);
		shape.add(square);
		this.add(shape);

		JMenu color = new JMenu("Couleur du pointeur");
		JMenuItem red = new JMenuItem("Rouge");
		red.addActionListener((event)->fen.getPan().setColor(Color.red));
		JMenuItem blue = new JMenuItem("Bleu");
		blue.addActionListener((event)->fen.getPan().setColor(Color.BLUE));
		JMenuItem green = new JMenuItem("Vert");
		green.addActionListener((event)->fen.getPan().setColor(Color.GREEN));

		color.add(red);
		color.add(blue);
		color.add(green);
		this.add(color);
	}

}
