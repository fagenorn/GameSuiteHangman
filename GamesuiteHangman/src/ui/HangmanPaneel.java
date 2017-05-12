package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.HangMan;

public class HangmanPaneel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField letter;
	private JLabel woord;

	private TekenVenster tekenVenster;
	private HangMan spel;

	public HangmanPaneel(HangMan spel) {
		super();
		setSpel(spel);
		init();
	}

	private void init() {
		letter = new JTextField("", 5);
		woord = new JLabel("");

		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);

		letter.addKeyListener(new RaadLuisteraar());
	}

	private void reset() {
		woord.setText(getSpel().getHint());
		getTekenVenster().teken();
	}

	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				String input = letter.getText();
				char guess = '\u0000';
				if (input.length() > 0) {
					guess = input.charAt(0);
				}

				spel.raad(guess);

				woord.setText(getSpel().getHint());
				letter.setText("");
				getTekenVenster().teken();

				if (spel.isGewonnen()) {
					int text =  JOptionPane.showConfirmDialog(null, "Gewonnen!\nNog eens?");
					shouldExit(text);

				} else if (spel.isGameOver()) {
					int text = JOptionPane.showConfirmDialog(null, "Verloren!\nNog eens?");
					shouldExit(text);
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			/* Niet nodig */}

		@Override
		public void keyTyped(KeyEvent arg0) {
			/* Niet nodig */}
	}

	private void shouldExit(int text){
		
		if (text == 0) {
			System.out.println(text);
			spel.reset();
			tekenVenster.repaint();
			woord.setText(getSpel().getHint());
		} else {
			System.exit(0);
		}
		System.out.println(text);
	}
	private void setSpel(HangMan spel) {
		this.spel = spel;
	}

	private HangMan getSpel() {
		return spel;
	}

	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;
		reset();
	}
}