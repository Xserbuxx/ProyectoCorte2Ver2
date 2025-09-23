package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 * Panel que muestra el formulario de pago.
 */
public class Pago extends JPanel {

	private JButton volver;
	private JButton pagar;
	private JTextField numeroTarjeta;
	private JTextField fechaVencimiento;
	private JTextField codigoSeguridad;

	/**
	 * Crea la vista de pago y configura los componentes.
	 */
	public Pago() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(211, 211, 211, 200));

		JPanel arriba = new JPanel();
		arriba.setBounds(400, 175, 500, 300);
		arriba.setBackground(Color.WHITE);

		volver = new JButton(new ImageIcon(
				new ImageIcon("volver.png").getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		volver.setBounds(325, 175, 50, 50);
		volver.setBorder(new LineBorder(Color.GRAY, 1, true));
		volver.setBackground(Color.WHITE);
		volver.setFocusPainted(false);
		volver.setBorderPainted(false);

		pagar = new JButton();
		pagar.setBounds(600, 410, 100, 40);
		pagar.setFont(new Font("Arial", Font.BOLD, 16));
		pagar.setBackground(new Color(255, 230, 0));
		pagar.setFocusPainted(false);
		pagar.setBorderPainted(false);

		numeroTarjeta = new JTextField();
		numeroTarjeta.setBounds(475, 275, 350, 40);

		fechaVencimiento = new JTextField();
		fechaVencimiento.setBounds(475, 350, 150, 40);

		codigoSeguridad = new JTextField();
		codigoSeguridad.setBounds(675, 350, 150, 40);

		this.add(volver);
		this.add(pagar);
		this.add(numeroTarjeta);
		this.add(fechaVencimiento);
		this.add(codigoSeguridad);
		this.add(arriba);
	}

	/**
	 * Inicializa los textos visibles del formulario.
	 */
	public void iniciarLabels(String pagarLabel, String ingreseDatos, String numeroTarjeta, String fechaVencimiento,
			String codigoSeguridad) {
		pagar.setText(pagarLabel);
		crearLabel(ingreseDatos, 475, 200, 400, 30, Color.BLACK, 20);
		crearLabel(numeroTarjeta, 475, 235, 200, 40, Color.BLACK, 16);
		crearLabel(fechaVencimiento, 475, 315, 200, 40, Color.BLACK, 16);
		crearLabel(codigoSeguridad, 675, 315, 200, 40, Color.BLACK, 16);
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

	/** Devuelve el botón volver. */
	public JButton getVolver() {
		return volver;
	}

	/** Establece el botón volver. */
	public void setVolver(JButton volver) {
		this.volver = volver;
	}

	/** Devuelve el botón pagar. */
	public JButton getPagar() {
		return pagar;
	}

	/** Establece el botón pagar. */
	public void setPagar(JButton pagar) {
		this.pagar = pagar;
	}

	/** Devuelve el campo número de tarjeta. */
	public JTextField getNumeroTarjeta() {
		return numeroTarjeta;
	}

	/** Establece el campo númeroTarjeta. */
	public void setNumeroTarjeta(JTextField numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	/** Devuelve el campo fecha de vencimiento. */
	public JTextField getFechaVencimiento() {
		return fechaVencimiento;
	}

	/** Establece el campo fechaVencimiento. */
	public void setFechaVencimiento(JTextField fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/** Devuelve el campo código de seguridad. */
	public JTextField getCodigoSeguridad() {
		return codigoSeguridad;
	}

	/** Establece el campo codigoSeguridad. */
	public void setCodigoSeguridad(JTextField codigoSeguridad) {
		this.codigoSeguridad = codigoSeguridad;
	}

}