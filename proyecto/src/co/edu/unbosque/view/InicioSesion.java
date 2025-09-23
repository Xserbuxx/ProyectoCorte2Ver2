package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class InicioSesion extends JPanel {

	private JTextField usuario;
	private JTextField contrasena;
	private JButton botonRegistrarse;
	private JButton botonInicio;
	private JPanel cajaFondoInicio;

	public InicioSesion() {
		iniciarComponente();
	}

	/**
	 * Inicializa los componentes de la pantalla de inicio de sesión.
	 */
	private void iniciarComponente() {
		this.setBounds(0, 0, 1280, 720);
		this.setLayout(null);
		this.setBackground(new Color(245, 245, 245));

		JPanel mercadoLibre = new JPanel();
		mercadoLibre.setBounds(0, 0, 1280, 80);
		mercadoLibre.setBackground(new Color(255, 230, 0));
		mercadoLibre.setLayout(null);

		JLabel logo = new JLabel(new ImageIcon(
				new ImageIcon("logoMercadoLibre.png").getImage().getScaledInstance(140, 70, Image.SCALE_SMOOTH)));
		logo.setBounds(20, 10, 140, 70);
		mercadoLibre.add(logo);

		cajaFondoInicio = new JPanel();
		cajaFondoInicio.setBounds(400, 150, 480, 400);
		cajaFondoInicio.setBackground(Color.WHITE);
		cajaFondoInicio.setLayout(null);
		cajaFondoInicio.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

		usuario = new JTextField();
		usuario.setBounds(40, 130, 400, 40);
		usuario.setFont(new Font("Arial", Font.PLAIN, 18));
		usuario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true),
				BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		cajaFondoInicio.add(usuario);

		contrasena = new JTextField();
		contrasena.setBounds(40, 220, 400, 40);
		contrasena.setFont(new Font("Arial", Font.PLAIN, 18));
		contrasena
				.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true),
						BorderFactory.createEmptyBorder(5, 10, 5, 10)));
		cajaFondoInicio.add(contrasena);

		botonInicio = new JButton();
		botonInicio.setBounds(40, 280, 400, 50);
		botonInicio.setFont(new Font("Arial", Font.BOLD, 20));
		botonInicio.setBackground(new Color(52, 131, 250));
		botonInicio.setForeground(Color.WHITE);
		botonInicio.setFocusPainted(false);
		botonInicio.setBorder(BorderFactory.createEmptyBorder());
		cajaFondoInicio.add(botonInicio);

		botonRegistrarse = new JButton();
		botonRegistrarse.setBounds(240, 340, 200, 30);
		botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 14));
		botonRegistrarse.setForeground(new Color(0, 102, 204));
		botonRegistrarse.setContentAreaFilled(false);
		botonRegistrarse.setBorderPainted(false);
		botonRegistrarse.setFocusPainted(false);
		cajaFondoInicio.add(botonRegistrarse);

		this.add(mercadoLibre);
		this.add(cajaFondoInicio);
	}

	/**
	 * Crea y añade una etiqueta dentro del contenedor de inicio.
	 */
	private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		cajaFondoInicio.add(label);
		cajaFondoInicio.setComponentZOrder(label, 0);
	}

	/**
	 * Establece los textos visibles del formulario de inicio.
	 */
	public void mostrarLabels(String inicioDeSesion, String usuario, String contrasena, String noCuenta, String iniciarSesion,String registrarse) {
		crearLabel(inicioDeSesion, 140, 30, 300, 40, Color.BLACK, 26);
		crearLabel(usuario, 40, 100, 200, 25, Color.BLACK, 16);
		crearLabel(contrasena, 40, 190, 200, 25, Color.BLACK, 16);
		crearLabel(noCuenta, 40, 340, 200, 30, Color.DARK_GRAY, 14);
		botonInicio.setText(iniciarSesion);
		botonRegistrarse.setText(registrarse);
	}

	/**
	 * Limpia los campos de texto del formulario.
	 */
	public void limpiarCampos() {
		usuario.setText("");
		contrasena.setText("");
	}

	/**
	 * Devuelve el campo de usuario.
	 */
	public JTextField getUsuario() {
		return usuario;
	}

	/**
	 * Establece el campo de usuario.
	 */
	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	/**
	 * Devuelve el campo de contraseña.
	 */
	public JTextField getContrasena() {
		return contrasena;
	}

	/**
	 * Establece el campo de contraseña.
	 */
	public void setContrasena(JTextField contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Devuelve el botón de registrarse.
	 */
	public JButton getBotonRegistrarse() {
		return botonRegistrarse;
	}

	/**
	 * Establece el botón de registrarse.
	 */
	public void setBotonRegistrarse(JButton botonRegistrarse) {
		this.botonRegistrarse = botonRegistrarse;
	}

	/**
	 * Devuelve el botón de inicio.
	 */
	public JButton getBotonInicio() {
		return botonInicio;
	}

	/**
	 * Establece el botón de inicio.
	 */
	public void setBotonInicio(JButton botonInicio) {
		this.botonInicio = botonInicio;
	}

}