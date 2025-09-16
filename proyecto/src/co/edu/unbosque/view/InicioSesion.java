package co.edu.unbosque.view;

import java.awt.Color;
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
    private JTextField contraseña;
    private JButton botonRegistrarse;
    private JButton botonInicio;
    private JPanel cajaFondoInicio;

    public InicioSesion() {
        iniciarComponente();
    }

    private void iniciarComponente() {
        this.setBounds(0, 0, 1280, 720);
        this.setLayout(null);
        this.setBackground(new Color(245, 245, 245)); 

        JPanel mercadoLibre = new JPanel();
        mercadoLibre.setBounds(0, 0, 1280, 80);
        mercadoLibre.setBackground(new Color(255, 230, 0));
        mercadoLibre.setLayout(null);

        JLabel logo = new JLabel(new ImageIcon(
                new ImageIcon("logoMercadoLibre.png")
                        .getImage()
                        .getScaledInstance(140, 70, Image.SCALE_SMOOTH)
        ));
        logo.setBounds(20, 10, 140, 70);
        mercadoLibre.add(logo);

        cajaFondoInicio = new JPanel();
        cajaFondoInicio.setBounds(400, 150, 480, 400); 
        cajaFondoInicio.setBackground(Color.WHITE);
        cajaFondoInicio.setLayout(null);
        cajaFondoInicio.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        
        crearLabel("Inicio de sesión", 140, 30, 300, 40, Color.BLACK, 26);
        crearLabel("Usuario", 40, 100, 200, 25, Color.BLACK, 16);

        usuario = new JTextField();
        usuario.setBounds(40, 130, 400, 40);
        usuario.setFont(new Font("Arial", Font.PLAIN, 18));
        usuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        cajaFondoInicio.add(usuario);
        
        crearLabel("Contraseña", 40, 190, 200, 25, Color.BLACK, 16);

        contraseña = new JTextField();
        contraseña.setBounds(40, 220, 400, 40);
        contraseña.setFont(new Font("Arial", Font.PLAIN, 18));
        contraseña.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        cajaFondoInicio.add(contraseña);

        botonInicio = new JButton("Iniciar sesión");
        botonInicio.setBounds(40, 280, 400, 50);
        botonInicio.setFont(new Font("Arial", Font.BOLD, 20));
        botonInicio.setBackground(new Color(52, 131, 250));
        botonInicio.setForeground(Color.WHITE);
        botonInicio.setFocusPainted(false);
        botonInicio.setBorder(BorderFactory.createEmptyBorder());
        cajaFondoInicio.add(botonInicio);
        
        crearLabel("¿No tiene una cuenta?", 40, 340, 200, 30, Color.DARK_GRAY, 14);

        botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setBounds(240, 340, 120, 30);
        botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 14));
        botonRegistrarse.setForeground(new Color(0, 102, 204));
        botonRegistrarse.setContentAreaFilled(false);
        botonRegistrarse.setBorderPainted(false);
        botonRegistrarse.setFocusPainted(false);
        cajaFondoInicio.add(botonRegistrarse);

        this.add(mercadoLibre);
        this.add(cajaFondoInicio);
    }
    
    private void crearLabel(String texto, int x, int y, int ancho, int alto, Color color, int tamañoTexto) {
		JLabel label = new JLabel(texto);
		label.setBounds(x, y, ancho, alto);
		label.setForeground(color);
		label.setFont(new Font("Arial", Font.BOLD, tamañoTexto));
		cajaFondoInicio.add(label);
	}

	public JTextField getUsuario() {
		return usuario;
	}

	public void setUsuario(JTextField usuario) {
		this.usuario = usuario;
	}

	public JTextField getContraseña() {
		return contraseña;
	}

	public void setContraseña(JTextField contraseña) {
		this.contraseña = contraseña;
	}

	public JButton getBotonRegistrarse() {
		return botonRegistrarse;
	}

	public void setBotonRegistrarse(JButton botonRegistrarse) {
		this.botonRegistrarse = botonRegistrarse;
	}

	public JButton getBotonInicio() {
		return botonInicio;
	}

	public void setBotonInicio(JButton botonInicio) {
		this.botonInicio = botonInicio;
	}


}