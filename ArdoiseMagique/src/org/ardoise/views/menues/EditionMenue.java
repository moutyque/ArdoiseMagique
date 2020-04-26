package org.ardoise.views.menues;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import org.ardoise.listeners.mouse.ChangeColor;
import org.ardoise.listeners.mouse.RoundShape;
import org.ardoise.listeners.mouse.SquareShape;
import org.ardoise.views.fenetres.Fenetre;

public class EditionMenue extends JMenu {

	public EditionMenue(Fenetre fen) {
		super("Edtion");
		this.setMnemonic('e');
		JMenu shape = new JMenu("Forme du pointeur");
		shape.setMnemonic('o');
		
		JMenuItem rond = new JMenuItem("Rond");
		rond.addActionListener(new RoundShape(fen));
		rond.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));

		JMenuItem square = new JMenuItem("Carré");
		square.addActionListener(new SquareShape(fen));
		square.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));

		shape.add(rond);
		shape.add(square);
		this.add(shape);

		JMenu color = new JMenu("Couleur du pointeur");
		color.setMnemonic('u');

		JMenuItem red = new JMenuItem("Rouge");
		red.addActionListener(new ChangeColor(fen, Color.red));
		red.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));

		JMenuItem blue = new JMenuItem("Bleu");
		blue.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
		blue.addActionListener(new ChangeColor(fen, Color.blue));
		JMenuItem green = new JMenuItem("Vert");
		green.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));

		green.addActionListener(new ChangeColor(fen, Color.green));

		color.add(red);
		color.add(blue);
		color.add(green);
		this.add(color);
	}

}
