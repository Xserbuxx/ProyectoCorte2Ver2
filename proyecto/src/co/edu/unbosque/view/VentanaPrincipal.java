package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Ventana principal que contiene el manejador de paneles y funciones básicas de la UI.
 */
public class VentanaPrincipal extends JFrame {

	private ManejarPanel mp;

	/**
	 * Crea la ventana principal e inicializa componentes.
	 */
	public VentanaPrincipal() {
		iniciarComponentes();
	}

	/**
	 * Inicializa y configura los componentes de la ventana.
	 */
	private void iniciarComponentes() {

		mp = new ManejarPanel();
		this.add(mp);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1280, 720);
		this.setResizable(false);
		this.setTitle("Mercado Libre - Copia");

		this.setVisible(true);

	}

	/**
	 * Fuerza la actualización visual de la ventana.
	 */
	public void actualizar() {
		this.revalidate();
		this.repaint();
	}

	/**
	 * Muestra un cuadro de diálogo de error con el mensaje dado.
	 */
	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Muestra un cuadro de diálogo informativo con el mensaje dado.
	 */
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Devuelve el manejador de paneles.
	 */
	public ManejarPanel getMp() {
		return mp;
	}

	/**
	 * Configura el manejador de paneles.
	 */
	public void setMp(ManejarPanel mp) {
		this.mp = mp;
	}

}