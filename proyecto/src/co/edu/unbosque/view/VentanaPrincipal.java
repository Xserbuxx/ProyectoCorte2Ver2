package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	
	private ManejarPanel mp;
	
	public VentanaPrincipal() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
		mp = new ManejarPanel();
		this.add(mp);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1280, 720);
		this.setResizable(false);
		this.setTitle("Mercado Libre - Copia");
		
	}

	public ManejarPanel getMp() {
		return mp;
	}

	public void setMp(ManejarPanel mp) {
		this.mp = mp;
	}
	
}
