package org.ardoise.views.menues;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.ardoise.listeners.mouse.ChangeColor;
import org.ardoise.listeners.mouse.RoundShape;
import org.ardoise.listeners.mouse.SquareShape;
import org.ardoise.views.fenetres.Fenetre;

public class EditionMenue extends JMenu {

	public EditionMenue(Fenetre fen) {
		super("Edtion");
		JMenu shape = new JMenu("Forme du pointeur");

		JMenuItem rond = new JMenuItem("Rond");
		rond.addActionListener(new RoundShape(fen));
		JMenuItem square = new JMenuItem("Carré");
		rond.addActionListener(new SquareShape(fen));
		shape.add(rond);
		shape.add(square);
		this.add(shape);

		JMenu color = new JMenu("Couleur du pointeur");
		JMenuItem red = new JMenuItem("Rouge");
		red.addActionListener(new ChangeColor(fen, Color.red));
		JMenuItem blue = new JMenuItem("Bleu");
		blue.addActionListener(new ChangeColor(fen, Color.blue));
		JMenuItem green = new JMenuItem("Vert");
		green.addActionListener(new ChangeColor(fen, Color.green));

		color.add(red);
		color.add(blue);
		color.add(green);
		this.add(color);
	}

}
