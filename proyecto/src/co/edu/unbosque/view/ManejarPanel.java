package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class ManejarPanel extends JPanel{
	
	private CardLayout cl;
	private InicioSesion vis;
	private Registrarse reg;
	private VentanaCompra com;
	private VentanaVenta ven;
	private ProductoInfoPanel pip;
	private VentanaCarritos car;
	private AgregarACarrito aca;
	private CrearCarrito crc;
	private VentanaFactura fac;
	private ConfirmarEliminar ce;
	private ConfirmarCompra cc;
	
	public ManejarPanel() {
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		
		cl = new CardLayout();
		this.setLayout(cl);
		
		vis = new InicioSesion();
		reg = new Registrarse();
		com = new VentanaCompra();
		ven = new VentanaVenta();
		pip = new ProductoInfoPanel();
		car = new VentanaCarritos();
		aca = new AgregarACarrito();
		crc = new CrearCarrito();
		fac = new VentanaFactura();
		ce = new ConfirmarEliminar();
		cc = new ConfirmarCompra();
		
		this.add(vis, "vis");
		this.add(reg, "reg");
		this.add(com, "com");
		this.add(ven, "ven");
		this.add(pip, "pip");
		this.add(car, "car");
		this.add(fac, "fac");
		
	}
	
	public void mostrarPanel(String nombre) {
		cl.show(this, nombre);
	}

	public CardLayout getCl() {
		return cl;
	}

	public void setCl(CardLayout cl) {
		this.cl = cl;
	}

	public InicioSesion getVis() {
		return vis;
	}

	public void setVis(InicioSesion vis) {
		this.vis = vis;
	}

	public Registrarse getReg() {
		return reg;
	}

	public void setReg(Registrarse reg) {
		this.reg = reg;
	}

	public VentanaCompra getCom() {
		return com;
	}

	public void setCom(VentanaCompra com) {
		this.com = com;
	}

	public VentanaVenta getVen() {
		return ven;
	}

	public void setVen(VentanaVenta ven) {
		this.ven = ven;
	}

	public ProductoInfoPanel getPip() {
		return pip;
	}

	public void setPip(ProductoInfoPanel pip) {
		this.pip = pip;
	}

	public VentanaCarritos getCar() {
		return car;
	}

	public void setCar(VentanaCarritos car) {
		this.car = car;
	}

	public AgregarACarrito getAca() {
		return aca;
	}

	public void setAca(AgregarACarrito aca) {
		this.aca = aca;
	}

	public CrearCarrito getCrc() {
		return crc;
	}

	public void setCrc(CrearCarrito crc) {
		this.crc = crc;
	}

	public VentanaFactura getFac() {
		return fac;
	}

	public void setFac(VentanaFactura fac) {
		this.fac = fac;
	}

	public ConfirmarEliminar getCe() {
		return ce;
	}

	public void setCe(ConfirmarEliminar ce) {
		this.ce = ce;
	}

	public ConfirmarCompra getCc() {
		return cc;
	}

	public void setCc(ConfirmarCompra cc) {
		this.cc = cc;
	}
	
}
