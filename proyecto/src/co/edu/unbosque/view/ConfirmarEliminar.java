package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Panel que muestra la confirmación para eliminar un carrito.
 */
public class ConfirmarEliminar extends JPanel {

	private JButton volver;
	private JButton eliminar;

	/**
	 * Inicializa el panel de confirmación de eliminación.
	 */
	public ConfirmarEliminar() {
		iniciarComponentes();
	}

	/**
	 * Crea y posiciona los componentes del panel.
	 */
	private void iniciarComponentes() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211, 211, 211, 200));

		JPanel arriba = new JPanel();
		arriba.setBounds(400, 225, 500, 200);
		arriba.setBackground(Color.WHITE);

		volver = new JButton(new ImageIcon(
				new ImageIcon("volver.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		volver.setBounds(340, 225, 50, 50);
		volver.setBorder(new LineBorder(Color.GRAY, 1, true));
		volver.setBackground(Color.WHITE);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);

		this.add(volver);
		this.add(arriba);
	}

	/**
	 * Establece el texto del mensaje de confirmación.
	 */
	public void iniciarLabels(String mensaje) {
		crearLabel(mensaje, 425, 260, 460, 50, Color.black, 20);
	}

	/**
	 * Crea y muestra el botón de eliminar con la acción indicada.
	 */
	public void crearBotonEliminar(String nombre, String eliminarC, ActionListener e) {
		if (this.getComponents().length > 2 && this.getComponents()[2].equals(eliminar)) {
			this.remove(eliminar);
		}
		eliminar = new JButton(eliminarC + nombre.split("_")[0]);
		eliminar.setActionCommand("EliminarCarritoCE-" + nombre);
		eliminar.addActionListener(e);
		eliminar.setBounds(420, 350, 460, 50);
		eliminar.setFont(new Font("Arial", Font.BOLD, 20));
		eliminar.setBackground(new Color(255, 230, 0));
		eliminar.setFocusPainted(false);

		this.add(eliminar);
	}

	/**
	 * Crea y añade una etiqueta al panel.
	 */
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		this.add(label);
		this.setComponentZOrder(label, 0);
	}

	/**
	 * Devuelve el botón volver.
	 */
	public JButton getVolver() {
		return volver;
	}

	/**
	 * Establece el botón volver.
	 */
	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	/**
	 * Devuelve el botón eliminar.
	 */
	public JButton getEliminar() {
		return eliminar;
	}

	/**
	 * Establece el botón eliminar.
	 */
	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

}