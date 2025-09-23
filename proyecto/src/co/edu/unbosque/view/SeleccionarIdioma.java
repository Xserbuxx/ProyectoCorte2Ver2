package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel que permite seleccionar el idioma de la aplicación.
 */
public class SeleccionarIdioma extends JPanel {		private JComboBox<String> comboBox;	private JButton continuar;	/**	 * Crea la vista de selección de idioma y sus componentes.	 */	public SeleccionarIdioma() {		this.setBounds(0, 0, 1280, 720);		this.setLayout(null);		this.setBackground(new Color(211, 211, 211, 200));				JPanel panel = new JPanel();		panel.setBounds(390, 225, 500, 200);		panel.setBackground(Color.WHITE);				JLabel label = new JLabel("Select the language");		label.setBounds(500, 250, 460, 50);		label.setFont(new Font("Arial", Font.BOLD, 30));				String[] idiomas = {"Spanish", "English", "Portuguese", "Latin"};				comboBox = new JComboBox<>(idiomas);		comboBox.setBounds(540, 320, 200, 30);				continuar = new JButton("Continue");		continuar.setBounds(565, 370, 150, 30);		continuar.setBackground(new Color(52, 131, 250));		continuar.setForeground(Color.WHITE);				this.add(label);		this.add(comboBox);		this.add(continuar);		this.add(panel);			}	/**	 * Devuelve el combo con los idiomas.	 */	public JComboBox<String> getComboBox() {		return comboBox;	}	/**	 * Establece el combo con los idiomas.	 */	public void setComboBox(JComboBox<String> comboBox) {		this.comboBox = comboBox;	}	/**	 * Devuelve el botón continuar.	 */	public JButton getContinuar() {		return continuar;	}	/**	 * Establece el botón continuar.	 */	public void setContinuar(JButton continuar) {		this.continuar = continuar;	}	}