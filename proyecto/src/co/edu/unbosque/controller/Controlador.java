package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Random;

import javax.swing.SwingUtilities;

import co.edu.unbosque.model.*;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.persistence.*;
import co.edu.unbosque.view.VentanaPrincipal;

public class Controlador implements ActionListener {

	private VentanaPrincipal vp;
	private ModelFacade mf;
	private Usuario usuarioActual;
	private Producto productoTemp;
	private Carrito carritoTemp;
	private ArrayList<Integer> idsExistentes;
	private double total = 0;
	private Properties prop;

	public Controlador() {
		mf = new ModelFacade();
		vp = new VentanaPrincipal();
	}

	/**
	 * Método que inicia la interfaz gráfica del usuario (GUI). Configura las
	 * propiedades iniciales de la vista y registra los oyentes de eventos.
	 */

	public void runGUI() {
		prop = new Properties();

		vp.getMp().getVis().setEnabled(false);
		vp.getMp().getVis().getUsuario().setEnabled(false);
		vp.getMp().getVis().getContrasena().setEnabled(false);
		vp.getMp().getVis().getBotonInicio().setEnabled(false);
		vp.getMp().getVis().getBotonRegistrarse().setEnabled(false);

		SwingUtilities.invokeLater(() -> {
			vp.getMp().getVis().add(vp.getMp().getSi());
			vp.getMp().getVis().setComponentZOrder(vp.getMp().getSi(), 0);
			vp.actualizar();
		});

		agregarOyentes();

	}

	/**
	 * Método que registra los oyentes para los componentes interactivos de la
	 * vista. Asocia cada componente con una acción específica que será manejada a
	 * través de eventos.
	 */

	private void agregarOyentes() {
		vp.getMp().getVis().getBotonRegistrarse().addActionListener(this);
		vp.getMp().getVis().getBotonRegistrarse().setActionCommand("Boton Registrarse");

		vp.getMp().getReg().getBotonInicioSesion().addActionListener(this);
		vp.getMp().getReg().getBotonInicioSesion().setActionCommand("Boton Iniciar Sesion");

		vp.getMp().getVis().getBotonInicio().addActionListener(this);
		vp.getMp().getVis().getBotonInicio().setActionCommand("Boton Inicio De Sesion");

		vp.getMp().getReg().getBotonRegistro().addActionListener(this);
		vp.getMp().getReg().getBotonRegistro().setActionCommand("Boton Registro");

		vp.getMp().getCom().getCambiarModo().addActionListener(this);
		vp.getMp().getCom().getCambiarModo().setActionCommand("Boton Cambiar Modo Venta");

		vp.getMp().getVen().getCambiarModo().addActionListener(this);
		vp.getMp().getVen().getCambiarModo().setActionCommand("Boton Cambiar Modo Compra");

		vp.getMp().getVen().getCerrarSesion().addActionListener(this);
		vp.getMp().getVen().getCerrarSesion().setActionCommand("Boton Cerrar Sesion");

		vp.getMp().getCom().getCerrarSesion().addActionListener(this);
		vp.getMp().getCom().getCerrarSesion().setActionCommand("Boton Cerrar Sesion");

		vp.getMp().getVen().getCategorias().addActionListener(this);
		vp.getMp().getVen().getCategorias().setActionCommand("ComboBox Ventana Vender");

		vp.getMp().getCom().getCategorias().addActionListener(this);
		vp.getMp().getCom().getCategorias().setActionCommand("ComboBox Ventana Comprar");

		vp.getMp().getVen().getRegistrarProducto().addActionListener(this);
		vp.getMp().getVen().getRegistrarProducto().setActionCommand("Boton Registrar Producto");

		vp.getMp().getPip().getVolver().addActionListener(this);
		vp.getMp().getPip().getVolver().setActionCommand("Boton Cambiar Modo Compra");

		vp.getMp().getPip().getAgregarCarrito().addActionListener(this);
		vp.getMp().getPip().getAgregarCarrito().setActionCommand("Boton Agregar Producto A Carrito");

		vp.getMp().getCar().getVolver().addActionListener(this);
		vp.getMp().getCar().getVolver().setActionCommand("Boton Cambiar Modo Compra");

		vp.getMp().getCom().getCarritos().addActionListener(this);
		vp.getMp().getCom().getCarritos().setActionCommand("Boton Carritos");

		vp.getMp().getCar().getCrearCarrito().addActionListener(this);
		vp.getMp().getCar().getCrearCarrito().setActionCommand("Boton Crear Carrito");

		vp.getMp().getCrc().getVolver().addActionListener(this);
		vp.getMp().getCrc().getVolver().setActionCommand("Boton Volver Ventana CRC");

		vp.getMp().getCrc().getCrearCarrito().addActionListener(this);
		vp.getMp().getCrc().getCrearCarrito().setActionCommand("Boton Crear Carrito Ventana CRC");

		vp.getMp().getAca().getVolver().addActionListener(this);
		vp.getMp().getAca().getVolver().setActionCommand("Boton Volver Ventana ACA");

		vp.getMp().getCar().getFiltrar().addActionListener(this);
		vp.getMp().getCar().getFiltrar().setActionCommand("Boton Filtrar");

		vp.getMp().getFac().getVolver().addActionListener(this);
		vp.getMp().getFac().getVolver().setActionCommand("Boton Volver Ventana FAC");

		vp.getMp().getCe().getVolver().addActionListener(this);
		vp.getMp().getCe().getVolver().setActionCommand("Boton Volver Ventana CE");

		vp.getMp().getFac().getComprar().addActionListener(this);
		vp.getMp().getFac().getComprar().setActionCommand("Boton Comprar Ventana FAC");

		vp.getMp().getCc().getVolver().addActionListener(this);
		vp.getMp().getCc().getVolver().setActionCommand("Boton Volver Ventana CC");

		vp.getMp().getCc().getComprar().addActionListener(this);
		vp.getMp().getCc().getComprar().setActionCommand("Boton Comprar Ventana CC");

		vp.getMp().getPa().getPagar().addActionListener(this);
		vp.getMp().getPa().getPagar().setActionCommand("Boton Pagar Ventana PA");

		vp.getMp().getPa().getVolver().addActionListener(this);
		vp.getMp().getPa().getVolver().setActionCommand("Boton Volver Ventana PA");

		vp.getMp().getRec().getVolver().addActionListener(this);
		vp.getMp().getRec().getVolver().setActionCommand("Boton Volver Ventana REC");

		vp.getMp().getSi().getContinuar().addActionListener(this);
		vp.getMp().getSi().getContinuar().setActionCommand("Boton Continuar Seleccionar Idioma");
	}

	/**
	 * Método manejador de eventos que responde a las interacciones de los usuarios
	 * con los componentes de la interfaz gráfica.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		String boton = e.getActionCommand();

		if (boton.contains("Producto_")) {

			vp.getMp().getPip().limpiarLabels();
			vp.getMp().mostrarPanel("pip");

			int id = Integer.parseInt(boton.split("_")[1]);

			encontrarProducto(id);
			Producto producto = productoTemp;

			if (producto != null) {

				String atributo1 = producto.toString().split(";")[6];
				String atributo2 = producto.toString().split(";")[7];

				if (producto instanceof Belleza) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.tipoproductobelleza") + atributo1,
							prop.getProperty("vender.fechavencimiento") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Deporte) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.tipodeporte") + atributo1,
							prop.getProperty("vender.deportemarca") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Hogar) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.materialhogar") + atributo1,
							prop.getProperty("vender.tipoproductohogar") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Juguete) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.edadjuguete") + atributo1,
							prop.getProperty("vender.materialjuguete") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Libro) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.autor") + atributo1, prop.getProperty("vender.isbn") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Mascota) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.tipoanimal") + atributo1,
							prop.getProperty("vender.tamanoanimal") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Musica) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.formatomusica") + atributo1,
							prop.getProperty("vender.artista") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Ropa) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.talla") + atributo1, prop.getProperty("vender.color") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Tecnologia) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.marcatec") + atributo1,
							prop.getProperty("vender.modelotec") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Vehiculo) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.anove") + atributo1,
							prop.getProperty("vender.modelove") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				}

			} else {
				vp.mostrarError(prop.getProperty("error.producto.noencontrado"));
				return;
			}
		}

		if (boton.contains("CarritoACA-")) {

			try {
				LanzadorExcepciones.verificarUnidadesDisponibles(productoTemp.getUnidades(),
						prop.getProperty("error.unidadesinsuficientes"));
			} catch (UnidadesProductoException e1) {
				vp.mostrarError(e1.getMessage());
				return;
			}

			bajarUnidadesProductos();

			vp.mostrarMensaje(prop.getProperty("mensaje.producto.agregado") + boton.split("-")[1].split("_")[0]
					+ prop.getProperty("mensaje.producto.agregado.exito"));

			mf.getCaDAO().agregarProducto(boton.split("-")[1], productoTemp);
			vp.actualizar();

		}

		if (boton.contains("CarritoCar-")) {

			total = 0;

			// pasar codigo a view
			vp.getMp().getCar().add(vp.getMp().getFac());
			vp.getMp().getFac().setEnabled(true);
			vp.getMp().getFac().setVisible(true);
			vp.getMp().getCar().getVolver().setEnabled(false);
			vp.getMp().getCar().getCrearCarrito().setEnabled(false);
			vp.getMp().getCar().getFiltro().setEnabled(false);
			vp.getMp().getCar().getFiltrar().setEnabled(false);
			vp.getMp().getCar().limpiarBotones();
			vp.getMp().getCar().setComponentZOrder(vp.getMp().getFac(), 0);

			vp.getMp().getFac().getPanelProductos().removeAll();
			for (Carrito carrito : mf.getCaDAO().getLista()) {
				if (carrito.getNombre().equals(boton.split("-")[1])) {
					carritoTemp = carrito;
					for (Producto producto : carrito.getProductos()) {
						vp.getMp().getFac().mostrarProductos(producto.getNombre(), producto.getPrecio(),
								producto.getRutaFoto(), producto.getId(), this);
						total += producto.getPrecio();
					}
					break;

				}
			}
			vp.getMp().getFac().limpiarLabels();
			vp.getMp().getFac().mostrarTotal(total + "", prop.getProperty("factura.total.precio"));
			SwingUtilities.invokeLater(() -> {
				vp.getMp().getFac().getScroll().revalidate();
				vp.getMp().getFac().getScroll().repaint();
				vp.getMp().getCar().revalidate();
				vp.getMp().getCar().repaint();
			});

		}

		if (boton.contains("EliminarCarrito-")) {

			vp.getMp().getCar().add(vp.getMp().getCe());

			vp.getMp().getCe().setEnabled(true);
			vp.getMp().getCe().setVisible(true);
			vp.getMp().getCar().getVolver().setEnabled(false);
			vp.getMp().getCar().getCrearCarrito().setEnabled(false);
			vp.getMp().getCar().getFiltro().setEnabled(false);
			vp.getMp().getCar().getFiltrar().setEnabled(false);
			vp.getMp().getCar().limpiarBotones();
			vp.getMp().getCar().setComponentZOrder(vp.getMp().getCe(), 0);

			vp.getMp().getCe().crearBotonEliminar(boton.split("-")[1], prop.getProperty("eliminar.boton"), this);

			vp.getMp().getCe().setComponentZOrder(vp.getMp().getCe().getEliminar(), 0);

			SwingUtilities.invokeLater(() -> {
				vp.actualizar();
			});
		}

		if (boton.contains("EliminarCarritoCE-")) {

			for (Carrito carrito : mf.getCaDAO().getLista()) {
				if (carrito.getNombre().equals(boton.split("-")[1])) {
					carritoTemp = carrito;
					break;

				}
			}

			subirUnidadesProductos();

			for (Carrito carrito : mf.getCaDAO().getLista()) {
				if (carrito.getNombre().equals(boton.split("-")[1])) {
					mf.getCaDAO().eliminar(carrito);
					break;
				}
			}

			vp.mostrarMensaje(prop.getProperty("mensaje.carrito.eliminado"));

			vp.getMp().getCe().setEnabled(false);
			vp.getMp().getCe().setVisible(false);
			vp.getMp().getCar().remove(vp.getMp().getCe());
			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);
			vp.getMp().getCar().getFiltro().setEnabled(true);
			vp.getMp().getCar().getFiltrar().setEnabled(true);

			agregarCarritos();
			vp.actualizar();
		}

		if (boton.contains("EliminarProductoFac-")) {
			for (Carrito carrito : mf.getCaDAO().getLista()) {
				if (carrito.getNombre().equals(carritoTemp.getNombre())) {
					for (Producto producto : carrito.getProductos()) {
						if (producto.getId() == Integer.parseInt(boton.split("-")[1])) {
							carrito.getProductos().remove(producto);
							mf.getCaDAO().escribirArchivoSerializado();

							total = 0;

							vp.getMp().getFac().getPanelProductos().removeAll();

							for (Producto prod : carrito.getProductos()) {
								vp.getMp().getFac().mostrarProductos(prod.getNombre(), prod.getPrecio(),
										prod.getRutaFoto(), prod.getId(), this);
								total += prod.getPrecio();
							}

							break;
						}
					}
					break;
				}
			}

			vp.getMp().getFac().limpiarLabels();
			vp.getMp().getFac().mostrarTotal(total + "", prop.getProperty("factura.total.precio"));
			vp.mostrarMensaje(prop.getProperty("mensaje.producto.carrito.eliminado"));

		}

		switch (boton) {

		case "Boton Continuar Seleccionar Idioma":
			String idioma = vp.getMp().getSi().getComboBox().getSelectedItem().toString();

			switch (idioma) {
			case "Spanish":
				prop = FileHandler.cargarArchivoDePropiedades("es.properties");
				break;
			case "English":
				prop = FileHandler.cargarArchivoDePropiedades("en.properties");
				break;
			case "Portuguese":
				prop = FileHandler.cargarArchivoDePropiedades("pt.properties");
				break;
			case "Latin":
				prop = FileHandler.cargarArchivoDePropiedades("la.properties");
				break;
			}

			agregarIdioma();

			vp.getMp().getVis().setEnabled(true);
			vp.getMp().getVis().getUsuario().setEnabled(true);
			vp.getMp().getVis().getContrasena().setEnabled(true);
			vp.getMp().getVis().getBotonInicio().setEnabled(true);
			vp.getMp().getVis().getBotonRegistrarse().setEnabled(true);

			vp.getMp().getVis().remove(vp.getMp().getSi());

			break;
		case "Boton Registrarse":
			vp.getMp().mostrarPanel("reg");
			vp.actualizar();
			break;
		case "Boton Iniciar Sesion":
			vp.getMp().mostrarPanel("vis");
			vp.actualizar();
			break;
		case "Boton Inicio De Sesion":
			try {

				boolean encontrado = false;
				boolean romper = false;

				String usuario = vp.getMp().getVis().getUsuario().getText();
				String contrasena = new String(vp.getMp().getVis().getContrasena().getText());

				LanzadorExcepciones.verificarNombre(usuario, prop.getProperty("error.verificarnombre.error1"),
						prop.getProperty("error.verificarnombre.error2"),
						prop.getProperty("error.verificarnombre.error3"));
				LanzadorExcepciones.verificarContrasena(contrasena, prop.getProperty("error.verificarcontrasena"));

				for (Usuario usu : mf.getUsDAO().getLista()) {
					if (usu.getNombre().equals(usuario) && usu.getContrasena().equals(contrasena)) {
						usuarioActual = usu;
						vp.mostrarMensaje(prop.getProperty("mensaje.iniciosesion.exito"));
						vp.getMp().getCom().getCategorias().setSelectedIndex(0);
						agregarProductosVentanaComprar();
						vp.getMp().mostrarPanel("com");
						encontrado = true;
						break;
					}
				}

				if (encontrado) {
					break;
				}

				for (Usuario usu : mf.getUsDAO().getLista()) {
					if (usu.getNombre().equals(usuario)) {
						usuarioActual = usu;
						vp.mostrarError(prop.getProperty("error.contrasena.incorrecta"));
						romper = true;
						break;
					}
				}

				if (romper) {
					break;
				}

				vp.mostrarError(prop.getProperty("error.usuario.noexiste"));

			} catch (NombreException ne) {
				vp.mostrarError(ne.getMessage());
				break;
			} catch (ContrasenaException ce) {
				vp.mostrarError(ce.getMessage());
				break;
			}

			break;

		case "Boton Registro":
			try {

				boolean existe = false;

				String usuario = vp.getMp().getReg().getUsuario().getText();
				String contrasena = new String(vp.getMp().getReg().getContrasena().getText());

				LanzadorExcepciones.verificarNombre(usuario, prop.getProperty("error.verificarnombre.error1"),
						prop.getProperty("error.verificarnombre.error2"),
						prop.getProperty("error.verificarnombre.error3"));
				LanzadorExcepciones.verificarContrasena(contrasena, prop.getProperty("error.verificarcontrasena"));

				for (Usuario usu : mf.getUsDAO().getLista()) {
					if (usu.getNombre().equals(usuario)) {
						vp.mostrarError(prop.getProperty("error.usuario.yaexiste"));
						existe = true;
						return;
					}
				}

				if (existe) {
					break;
				}

				Usuario nuevoUsuario = new Usuario(usuario, contrasena);

				mf.getUsDAO().crear(nuevoUsuario);
				vp.mostrarMensaje(prop.getProperty("mensaje.registro.exito"));
				usuarioActual = nuevoUsuario;

				vp.getMp().getCom().getCategorias().setSelectedIndex(0);
				agregarProductosVentanaComprar();

				vp.getMp().mostrarPanel("com");

			} catch (NombreException ne) {
				vp.mostrarError(ne.getMessage());
			} catch (ContrasenaException ce) {
				vp.mostrarError(ce.getMessage());
			}
			break;
		case "Boton Cambiar Modo Compra":

			mf.agregarProductos();

			for (Producto producto : new ArrayList<>(mf.getProductos())) {
				boolean existeEnCarrito = false;
				for (Carrito carrito : mf.getCaDAO().getLista()) {
					for (Producto prodCarrito : carrito.getProductos()) {
						if (producto == prodCarrito) {
							existeEnCarrito = true;
							break;
						}
					}
					if (existeEnCarrito)
						break;
				}
				if (!existeEnCarrito && producto.getUnidades() == 0) {
					eliminarProducto(producto);
				}
			}

			agregarProductosVentanaComprar();

			vp.getMp().mostrarPanel("com");
			vp.actualizar();
			break;
		case "Boton Cambiar Modo Venta":
			vp.getMp().mostrarPanel("ven");
			vp.actualizar();
			break;
		case "Boton Cerrar Sesion":
			usuarioActual = null;
			vp.getMp().mostrarPanel("vis");
			vp.getMp().getVis().limpiarCampos();
			vp.getMp().getReg().limpiarCampos();
			break;

		case "ComboBox Ventana Vender":

			//////////////////////////////////////////////
			String selec = vp.getMp().getVen().getCategorias().getSelectedItem().toString();

			if (selec.equals(prop.getProperty("categoria.vender.seleccione"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarCampos();
			}

			else if (selec.equals(prop.getProperty("categoria.belleza"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarBelleza(prop.getProperty("vender.tipoproductobelleza"),
						prop.getProperty("vender.fechavencimiento"));
			} else if (selec.equals(prop.getProperty("categoria.deportes"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarDeportes(prop.getProperty("vender.tipodeporte"),
						prop.getProperty("vender.deportemarca"));

			} else if (selec.equals(prop.getProperty("categoria.hogar"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarHogar(prop.getProperty("vender.materialhogar"),
						prop.getProperty("vender.tipoproductohogar"));

			} else if (selec.equals(prop.getProperty("categoria.juguetes"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarJuguetes(prop.getProperty("vender.edadjuguete"),
						prop.getProperty("vender.materialjuguete"));

			} else if (selec.equals(prop.getProperty("categoria.libros"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarLibros(prop.getProperty("vender.autor"), prop.getProperty("vender.isbn"));

			} else if (selec.equals(prop.getProperty("categoria.mascotas"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarMascotas(prop.getProperty("vender.tipoanimal"),
						prop.getProperty("vender.tamanoanimal"));

			} else if (selec.equals(prop.getProperty("categoria.musica"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarMusica(prop.getProperty("vender.artista"),
						prop.getProperty("vender.formatomusica"));

			} else if (selec.equals(prop.getProperty("categoria.ropa"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarRopa(prop.getProperty("vender.talla"), prop.getProperty("vender.color"));

			} else if (selec.equals(prop.getProperty("categoria.tecnologia"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarTecnologia(prop.getProperty("vender.marcatec"),
						prop.getProperty("vender.modelotec"));

			} else if (selec.equals(prop.getProperty("categoria.vehiculos"))) {
				vp.getMp().getVen().limpiarLabels(prop.getProperty("vender.categorias"),
						prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
						prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
						prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
						prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
						prop.getProperty("vender.examinar"));
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarVehiculos(prop.getProperty("vender.anove"),
						prop.getProperty("vender.modelove"));
			}
			//////////////////////////////////////////////
			break;

		case "ComboBox Ventana Comprar":
			agregarProductosVentanaComprar();
			break;

		case "Boton Registrar Producto":

			//////////////////////////////////////////////

			leerIDSExistentes();
			String seleccion = vp.getMp().getVen().getCategorias().getSelectedItem().toString();

			if (seleccion.equals(prop.getProperty("categoria.vender.seleccione"))) {
				vp.mostrarError(prop.getProperty("error.categoria.invalida"));
			} else if (seleccion.equals(prop.getProperty("categoria.belleza"))) {
				Belleza belleza = leerDatosBelleza();
				if (belleza != null) {
					mf.getBeDAO().crear(belleza);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			} else if (seleccion.equals(prop.getProperty("categoria.deportes"))) {
				Deporte deporte = leerDatosDeportes();
				if (deporte != null) {
					mf.getDeDAO().crear(deporte);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			} else if (seleccion.equals(prop.getProperty("categoria.hogar"))) {
				Hogar hogar = leerDatosHogar();
				if (hogar != null) {
					mf.getHoDAO().crear(hogar);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			} else if (seleccion.equals(prop.getProperty("categoria.juguetes"))) {
				Juguete juguete = leerDatosJuguetes();
				if (juguete != null) {
					mf.getJuDAO().crear(juguete);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			} else if (seleccion.equals(prop.getProperty("categoria.libros"))) {
				Libro libro = leerDatosLibros();
				if (libro != null) {
					mf.getLiDAO().crear(libro);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			} else if (seleccion.equals(prop.getProperty("categoria.mascotas"))) {
				Mascota mascotas = leerDatosMascotas();
				if (mascotas != null) {
					mf.getMaDAO().crear(mascotas);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			} else if (seleccion.equals(prop.getProperty("categoria.musica"))) {
				Musica musica = leerDatosMusica();
				if (musica != null) {
					mf.getMuDAO().crear(musica);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			} else if (seleccion.equals(prop.getProperty("categoria.ropa"))) {
				Ropa ropa = leerDatosRopa();
				if (ropa != null) {
					mf.getRoDAO().crear(ropa);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			} else if (seleccion.equals(prop.getProperty("categoria.tecnologia"))) {
				Tecnologia tecnologia = leerDatosTecnologia();
				if (tecnologia != null) {
					mf.getTeDAO().crear(tecnologia);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			} else if (seleccion.equals(prop.getProperty("categoria.vehiculos"))) {
				Vehiculo vehiculo = leerDatosVehiculos();
				if (vehiculo != null) {
					mf.getVeDAO().crear(vehiculo);
					vp.mostrarMensaje(prop.getProperty("mensaje.producto.registrado"));
				}
			}

			//////////////////////////////////////////////

			break;
		case "Boton Agregar Producto A Carrito":

			// cambiar a ventana aca
			vp.getMp().getAca().setVisible(true);
			vp.getMp().getAca().setEnabled(true);
			vp.getMp().getPip().add(vp.getMp().getAca());

			vp.getMp().getPip().getVolver().setEnabled(false);
			vp.getMp().getPip().getAgregarCarrito().setEnabled(false);

			vp.getMp().getPip().setComponentZOrder(vp.getMp().getAca(), 0);

			agregarCarritosPip();
			SwingUtilities.invokeLater(() -> {
				vp.actualizar();
			});
			break;
		case "Boton Carritos":
			vp.getMp().mostrarPanel("car");
			agregarCarritos();

			vp.actualizar();
			break;

		case "Boton Crear Carrito":

			// pasar codigo a view
			vp.getMp().getCrc().setVisible(true);
			vp.getMp().getCrc().setEnabled(true);
			vp.getMp().getCar().add(vp.getMp().getCrc());

			vp.getMp().getCar().getVolver().setEnabled(false);
			vp.getMp().getCar().getCrearCarrito().setEnabled(false);
			vp.getMp().getCar().getFiltro().setEnabled(false);
			vp.getMp().getCar().getFiltrar().setEnabled(false);
			vp.getMp().getCar().limpiarBotones();

			vp.getMp().getCar().setComponentZOrder(vp.getMp().getCrc(), 0);

			vp.actualizar();
			break;
		case "Boton Volver Ventana CRC":
			// pasar codigo a view
			vp.getMp().getCar().remove(vp.getMp().getCrc());

			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);
			vp.getMp().getCar().getFiltro().setEnabled(true);
			vp.getMp().getCar().getFiltrar().setEnabled(true);

			vp.getMp().getCrc().getNombreC().setText("");

			agregarCarritos();

			vp.actualizar();

			break;
		case "Boton Crear Carrito Ventana CRC":

			// pasar codigo a view
			try {
				String nombreCarrito = vp.getMp().getCrc().getNombreC().getText();
				LanzadorExcepciones.verificarNombre(nombreCarrito, prop.getProperty("error.verificarnombre.error1"),
						prop.getProperty("error.verificarnombre.error2"),
						prop.getProperty("error.verificarnombre.error3"));
				if (nombreCarrito.isBlank()) {
					vp.mostrarError(prop.getProperty("error.nombre.carrito.vacio"));
					break;
				}
				nombreCarrito = nombreCarrito + "_" + usuarioActual.getNombre();

				boolean existe = false;
				for (Carrito car : mf.getCaDAO().getLista()) {
					if (car.getNombre().equals(nombreCarrito)) {
						vp.mostrarError(prop.getProperty("error.carrito.yaexiste"));
						existe = true;
						break;
					}
				}
				if (existe) {
					break;
				}

				Carrito nuevoCarrito = new Carrito(nombreCarrito, new ArrayList<>());
				mf.getCaDAO().crear(nuevoCarrito);

				vp.mostrarMensaje(prop.getProperty("mensaje.carrito.creado"));

				vp.getMp().getCar().remove(vp.getMp().getCrc());

				vp.getMp().getCar().getVolver().setEnabled(true);
				vp.getMp().getCar().getCrearCarrito().setEnabled(true);
				vp.getMp().getCar().getFiltro().setEnabled(true);
				vp.getMp().getCar().getFiltrar().setEnabled(true);

				vp.getMp().getCrc().getNombreC().setText("");

				agregarCarritos();

				vp.actualizar();
			} catch (NombreException ne) {
				vp.mostrarError(ne.getMessage());
			} catch (Exception ex) {
				vp.mostrarError(prop.getProperty("error.carrito.crear") + ex.getMessage());
			}

			break;

		case "Boton Volver Ventana ACA":
			// pasar codigo a view
			vp.getMp().getAca().setVisible(false);
			vp.getMp().getAca().setEnabled(false);
			vp.getMp().getPip().remove(vp.getMp().getAca());

			vp.getMp().getPip().getVolver().setEnabled(true);
			vp.getMp().getPip().getAgregarCarrito().setEnabled(true);

			if (productoTemp != null) {

				String atributo1 = productoTemp.toString().split(";")[6];
				String atributo2 = productoTemp.toString().split(";")[7];

				Producto producto = productoTemp;

				if (producto instanceof Belleza) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.tipoproductobelleza") + atributo1,
							prop.getProperty("vender.fechavencimiento") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Deporte) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.tipodeporte") + atributo1,
							prop.getProperty("vender.deportemarca") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Hogar) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.materialhogar") + atributo1,
							prop.getProperty("vender.tipoproductohogar") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Juguete) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.edadjuguete") + atributo1,
							prop.getProperty("vender.materialjuguete") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Libro) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.autor") + atributo1, prop.getProperty("vender.isbn") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Mascota) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.tipoanimal") + atributo1,
							prop.getProperty("vender.tamanoanimal") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Musica) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.formatomusica") + atributo1,
							prop.getProperty("vender.artista") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Ropa) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.talla") + atributo1, prop.getProperty("vender.color") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Tecnologia) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.marcatec") + atributo1,
							prop.getProperty("vender.modelotec") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				} else if (producto instanceof Vehiculo) {
					vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
							producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(),
							prop.getProperty("vender.anove") + atributo1,
							prop.getProperty("vender.modelove") + atributo2,
							prop.getProperty("producto.info.informacion"), prop.getProperty("producto.info.unidades"));
				}
			} else {
				vp.mostrarError(prop.getProperty("error.producto.noencontrado"));
				return;
			}

			vp.actualizar();
			break;
		case "Boton Filtrar":
			agregarCarritos();
			break;
		case "Boton Volver Ventana FAC":
			// pasar codigo a view
			vp.getMp().getFac().setVisible(false);
			vp.getMp().getFac().setEnabled(false);

			vp.getMp().getCar().remove(vp.getMp().getFac());

			agregarCarritos();

			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);
			vp.getMp().getCar().getFiltro().setEnabled(true);
			vp.getMp().getCar().getFiltrar().setEnabled(true);

			vp.actualizar();
			break;
		case "Boton Volver Ventana CE":
			// pasar codigo a view
			vp.getMp().getCe().setVisible(false);
			vp.getMp().getCe().setEnabled(false);
			vp.getMp().getCar().remove(vp.getMp().getCe());

			agregarCarritos();

			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);
			vp.getMp().getCar().getFiltro().setEnabled(true);
			vp.getMp().getCar().getFiltrar().setEnabled(true);

			vp.actualizar();
			break;
		case "Boton Comprar Ventana FAC":
			try {
				if (total == 0) {
					vp.mostrarError(prop.getProperty("error.carrito.vacio"));
					break;
				}
				vp.getMp().getFac().setVisible(false);
				vp.getMp().getFac().setEnabled(false);
				vp.getMp().getCar().remove(vp.getMp().getFac());

				vp.getMp().getCar().add(vp.getMp().getCc());
				vp.getMp().getCc().setEnabled(true);
				vp.getMp().getCc().setVisible(true);
				vp.getMp().getCar().setComponentZOrder(vp.getMp().getCc(), 0);

				vp.getMp().getCc().mostrarTitulo(total, prop.getProperty("confirmar.compra.mensaje"));

				vp.actualizar();
			} catch (Exception ue) {
				vp.mostrarError(ue.getMessage());
			}
			break;

		case "Boton Volver Ventana CC":
			vp.getMp().getCc().setVisible(false);
			vp.getMp().getCc().setEnabled(false);
			vp.getMp().getCar().remove(vp.getMp().getCc());

			agregarCarritos();

			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);
			vp.getMp().getCar().getFiltro().setEnabled(true);
			vp.getMp().getCar().getFiltrar().setEnabled(true);

			vp.getMp().getCc().revalidate();
			vp.getMp().getCc().repaint();
			break;

		case "Boton Comprar Ventana CC":
			vp.getMp().getCc().setVisible(false);
			vp.getMp().getCc().setEnabled(false);
			vp.getMp().getCar().remove(vp.getMp().getCc());

			vp.getMp().getPa().setVisible(true);
			vp.getMp().getPa().setEnabled(true);
			vp.getMp().getCar().add(vp.getMp().getPa());

			vp.getMp().getCar().setComponentZOrder(vp.getMp().getPa(), 0);

			vp.actualizar();
			break;
		case "Boton Pagar Ventana PA":

			try {
				LanzadorExcepciones.verificarNumeroTarjeta(vp.getMp().getPa().getNumeroTarjeta().getText(),
						prop.getProperty("error.verificarnumerotarjeta.error1"),
						prop.getProperty("error.verificarnumerotarjeta.error2"),
						prop.getProperty("error.verificarnumerotarjeta.error3"));
				LanzadorExcepciones.verificarFechaVencimiento(vp.getMp().getPa().getFechaVencimiento().getText(),
						prop.getProperty("error.verificarfechatarjeta.error1"),
						prop.getProperty("error.verificarfechatarjeta.error2"));
				LanzadorExcepciones.verificarCodigoSeguridad(vp.getMp().getPa().getCodigoSeguridad().getText(),
						prop.getProperty("error.verificarcodigoseguridad.error1"),
						prop.getProperty("error.verificarcodigoseguridad.error2"),
						prop.getProperty("error.verificarcodigoseguridad.error3"));

				vp.mostrarMensaje(prop.getProperty("mensaje.compra.exito"));

				vp.getMp().getPa().setVisible(false);
				vp.getMp().getPa().setEnabled(false);
				vp.getMp().getCar().remove(vp.getMp().getPa());

				vp.getMp().getRec().setVisible(true);
				vp.getMp().getRec().setEnabled(true);
				vp.getMp().getCar().add(vp.getMp().getRec());

				vp.getMp().getCar().setComponentZOrder(vp.getMp().getRec(), 0);

				vp.getMp().getRec().eliminarProductos();

				for (Producto producto : carritoTemp.getProductos()) {
					vp.getMp().getRec().agregarProducto(producto.getNombre(), producto.getPrecio());
				}

				SwingUtilities.invokeLater(() -> {
					mf.getCaDAO().eliminar(carritoTemp);

					String contenido = prop.getProperty("mensaje.producto") + ";" + prop.getProperty("mensaje.precio")
							+ "\n";

					for (Producto producto : carritoTemp.getProductos()) {
						contenido += producto.getNombre() + ";" + producto.getPrecio() + "\n";
					}

					contenido += prop.getProperty("mensaje.total") + ";" + total + "\n";

					Random random = new Random();
					FileHandler.escribirEnArchivoTexto(prop.getProperty("mensaje.recibo.carrito")
							+ carritoTemp.getNombre() + "_" + random.nextLong() + ".csv", contenido);

					vp.mostrarMensaje(prop.getProperty("mensaje.recibo.generado"));

					vp.getMp().getRec().eliminarTotal();
					vp.getMp().getRec().mostrarTotal(total, prop.getProperty("recibo.total.precio"));

					vp.actualizar();
				});

			} catch (NumeroTarjetaException ex) {
				vp.mostrarError(ex.getMessage());
			} catch (CodigoSeguridadException ex) {
				vp.mostrarError(ex.getMessage());
			} catch (FechaVencimientoException ex) {
				vp.mostrarError(ex.getMessage());
			}
			break;
		case "Boton Volver Ventana PA":
			vp.getMp().getPa().setVisible(false);
			vp.getMp().getPa().setEnabled(false);
			vp.getMp().getCar().remove(vp.getMp().getPa());

			agregarCarritos();

			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);
			vp.getMp().getCar().getFiltro().setEnabled(true);
			vp.getMp().getCar().getFiltrar().setEnabled(true);

			vp.actualizar();
			break;
		case "Boton Volver Ventana REC":
			vp.getMp().getRec().setVisible(false);
			vp.getMp().getRec().setEnabled(false);
			vp.getMp().getCar().remove(vp.getMp().getRec());

			agregarCarritos();

			vp.getMp().getCar().getVolver().setEnabled(true);
			vp.getMp().getCar().getCrearCarrito().setEnabled(true);
			vp.getMp().getCar().getFiltro().setEnabled(true);
			vp.getMp().getCar().getFiltrar().setEnabled(true);

			vp.actualizar();
			break;
		default:
			break;
		}
	}

	/**
	 * Busca un producto en la lista de productos disponibles utilizando su
	 * identificador único (ID). Si el producto es encontrado, se almacena en una
	 * variable temporal para su posterior uso.
	 */

	private void encontrarProducto(int id) {
		mf.agregarProductos();
		for (Producto producto : mf.getProductos()) {
			if (producto.getId() == id) {
				productoTemp = producto;
			}
		}
	}

	/**
	 * Actualiza la vista con la lista de carritos asociados al usuario actual.
	 * Filtra los carritos según el texto ingresado en el campo de búsqueda.
	 */

	private void agregarCarritos() {
		vp.getMp().getCar().eliminarCarritos();
		mf.getCaDAO().getLista().forEach((carrito) -> {
			if (carrito.getNombre().split("_")[1].equals(usuarioActual.getNombre())
					&& carrito.getNombre().split("_")[0].contains(vp.getMp().getCar().getFiltro().getText())) {
				vp.getMp().getCar().mostrarProductos(carrito.getNombre(), this);
			}
		});
		vp.actualizar();
	}
	
    /**
     * Agrega los carritos del usuario actual al panel de información del producto (PIP).
     * Los carritos se muestran en una sección específica para su selección y uso.
     */

	private void agregarCarritosPip() {
		// pasar codigo a view
		vp.getMp().getAca().getPanelProductos().removeAll();
		mf.getCaDAO().getLista().forEach((carrito) -> {
			if (carrito.getNombre().split("_")[1].equals(usuarioActual.getNombre())) {
				vp.getMp().getAca().mostrarProductos(carrito.getNombre(), this);
			}
		});

		vp.getMp().getAca().getScroll().revalidate();
		vp.getMp().getAca().getScroll().repaint();
	}
	
	/**
     * Elimina un producto del modelo y actualiza la lista de productos disponibles.
     */

	private void eliminarProducto(Producto producto) {
		if (producto instanceof Belleza) {
			mf.getBeDAO().eliminar((Belleza) producto);
		} else if (producto instanceof Deporte) {
			mf.getDeDAO().eliminar((Deporte) producto);
		} else if (producto instanceof Hogar) {
			mf.getHoDAO().eliminar((Hogar) producto);
		} else if (producto instanceof Juguete) {
			mf.getJuDAO().eliminar((Juguete) producto);
		} else if (producto instanceof Libro) {
			mf.getLiDAO().eliminar((Libro) producto);
		} else if (producto instanceof Mascota) {
			mf.getMaDAO().eliminar((Mascota) producto);
		} else if (producto instanceof Musica) {
			mf.getMuDAO().eliminar((Musica) producto);
		} else if (producto instanceof Ropa) {
			mf.getRoDAO().eliminar((Ropa) producto);
		} else if (producto instanceof Tecnologia) {
			mf.getTeDAO().eliminar((Tecnologia) producto);
		} else if (producto instanceof Vehiculo) {
			mf.getVeDAO().eliminar((Vehiculo) producto);
		}
		mf.agregarProductos();
	}
	
    /**
     * Reduce el número de unidades disponibles de un producto en el modelo.
     * Actualiza la información en el almacenamiento persistente.
     */
	
	private void bajarUnidadesProductos() {
		if (productoTemp instanceof Belleza) {
			mf.getBeDAO().bajarUnidades((Belleza) productoTemp);
		} else if (productoTemp instanceof Deporte) {
			mf.getDeDAO().bajarUnidades((Deporte) productoTemp);
		} else if (productoTemp instanceof Hogar) {
			mf.getHoDAO().bajarUnidades((Hogar) productoTemp);
		} else if (productoTemp instanceof Juguete) {
			mf.getJuDAO().bajarUnidades((Juguete) productoTemp);
		} else if (productoTemp instanceof Libro) {
			mf.getLiDAO().bajarUnidades((Libro) productoTemp);
		} else if (productoTemp instanceof Mascota) {
			mf.getMaDAO().bajarUnidades((Mascota) productoTemp);
		} else if (productoTemp instanceof Musica) {
			mf.getMuDAO().bajarUnidades((Musica) productoTemp);
		} else if (productoTemp instanceof Ropa) {
			mf.getRoDAO().bajarUnidades((Ropa) productoTemp);
		} else if (productoTemp instanceof Tecnologia) {
			mf.getTeDAO().bajarUnidades((Tecnologia) productoTemp);
		} else if (productoTemp instanceof Vehiculo) {
			mf.getVeDAO().bajarUnidades((Vehiculo) productoTemp);
		}
		mf.agregarProductos();

	}
	
    /**
     * Aumenta el número de unidades disponibles de un producto en el modelo.
     * Actualiza la información en el almacenamiento persistente.
     */	
	
	private void subirUnidadesProductos() {
		for (Carrito carrito : mf.getCaDAO().getLista()) {
			if (carrito.getNombre().equals(carritoTemp.getNombre())) {
				for (Producto producto : carrito.getProductos()) {
					if (producto instanceof Belleza) {
						mf.getBeDAO().subirUnidades((Belleza) producto);
					} else if (producto instanceof Deporte) {
						mf.getDeDAO().subirUnidades((Deporte) producto);
					} else if (producto instanceof Hogar) {
						mf.getHoDAO().subirUnidades((Hogar) producto);
					} else if (producto instanceof Juguete) {
						mf.getJuDAO().subirUnidades((Juguete) producto);
					} else if (producto instanceof Libro) {
						mf.getLiDAO().subirUnidades((Libro) producto);
					} else if (producto instanceof Mascota) {
						mf.getMaDAO().subirUnidades((Mascota) producto);
					} else if (producto instanceof Musica) {
						mf.getMuDAO().subirUnidades((Musica) producto);
					} else if (producto instanceof Ropa) {
						mf.getRoDAO().subirUnidades((Ropa) producto);
					} else if (producto instanceof Tecnologia) {
						mf.getTeDAO().subirUnidades((Tecnologia) producto);
					} else if (producto instanceof Vehiculo) {
						mf.getVeDAO().subirUnidades((Vehiculo) producto);
					}
				}
			}

		}

	}
	
    /**
     * Muestra los productos disponibles en la ventana de compra según la categoría seleccionada por el usuario.
     * Si se selecciona "Todo", se muestran todos los productos.
     */
	
	private void agregarProductosVentanaComprar() {
		vp.getMp().getCom().limpiarProductos();

		if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.comprar.todo"))) {
			mf.agregarProductos();
			mf.getProductos().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.belleza"))) {
			mf.getBeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.deportes"))) {
			mf.getDeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.hogar"))) {
			mf.getHoDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.juguetes"))) {
			mf.getJuDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.libros"))) {
			mf.getLiDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.mascotas"))) {
			mf.getMaDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.musica"))) {
			mf.getMuDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.ropa"))) {
			mf.getRoDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.tecnologia"))) {
			mf.getTeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString()
				.equals(prop.getProperty("categoria.vehiculos"))) {
			mf.getVeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		}
		vp.actualizar();
	}
	
    /**
     * Lee los identificadores únicos (IDs) de los productos existentes en el sistema.
     * Los IDs se almacenan en una lista para evitar duplicados al registrar nuevos productos.
     */

	private void leerIDSExistentes() {
		mf.agregarProductos();
		idsExistentes = new ArrayList<Integer>();
		mf.getProductos().forEach((producto) -> {
			idsExistentes.add(producto.getId());
		});
	}
	
    /**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Belleza.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */

	private Belleza leerDatosBelleza() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			String tipoProducto = vp.getMp().getVen().getTipoProductoBe().getText();
			LanzadorExcepciones.verificarTextoVacio(tipoProducto, prop.getProperty("error.verificartextovacio"));
			String fechaExpiracion = vp.getMp().getVen().getFechaExpiracion().getText();
			LanzadorExcepciones.verificarFechaVencimientoBelleza(fechaExpiracion,
					prop.getProperty("error.verificarfechavencimientobelleza.error1"),
					prop.getProperty("error.verificarfechavencimientobelleza.error2"));

			return new Belleza(nombre, descripcion, rutaFoto, id, unidades, precio, tipoProducto, fechaExpiracion);

		} catch (InputMismatchException ime) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException nfe) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (FechaVencimientoException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarMensaje(e.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}
	
    /**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Deporte.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */	
	
	private Deporte leerDatosDeportes() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			String tipoDeporte = vp.getMp().getVen().getTipoDeporte().getText();
			LanzadorExcepciones.verificarTextoVacio(tipoDeporte, prop.getProperty("error.verificartextovacio"));
			String marca = vp.getMp().getVen().getMarcaDe().getText();
			LanzadorExcepciones.verificarTextoVacio(marca, prop.getProperty("error.verificartextovacio"));

			return new Deporte(nombre, descripcion, rutaFoto, id, unidades, precio, tipoDeporte, marca);

		} catch (InputMismatchException ime) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException nfe) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}
	
	/**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Hogar.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */
	
	private Hogar leerDatosHogar() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			String material = vp.getMp().getVen().getMaterialHo().getText();
			LanzadorExcepciones.verificarTextoVacio(material, prop.getProperty("error.verificartextovacio"));
			String tipoProducto = vp.getMp().getVen().getTipoProductoHo().getText();
			LanzadorExcepciones.verificarTextoVacio(tipoProducto, prop.getProperty("error.verificartextovacio"));

			return new Hogar(nombre, descripcion, rutaFoto, id, unidades, precio, material, tipoProducto);

		} catch (InputMismatchException ime) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException nfe) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}
	
	/**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Juguete.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */
	
	private Juguete leerDatosJuguetes() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			int edadRecomendada = Integer.parseInt(vp.getMp().getVen().getEdadRecomendada().getText());
			LanzadorExcepciones.verificarNumeroNegativo(edadRecomendada,
					prop.getProperty("error.verificarnumeronegativo"));
			String material = vp.getMp().getVen().getMaterialJu().getText();
			LanzadorExcepciones.verificarTextoVacio(material, prop.getProperty("error.verificartextovacio"));

			return new Juguete(nombre, descripcion, rutaFoto, id, unidades, precio, edadRecomendada, material);

		} catch (InputMismatchException ime) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException nfe) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}
	
	/**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Libro.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */
	
	private Libro leerDatosLibros() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			String autor = vp.getMp().getVen().getAutor().getText();
			LanzadorExcepciones.verificarNombre(autor, prop.getProperty("error.verificarnombre.error1"),
					prop.getProperty("error.verificarnombre.error2"), prop.getProperty("error.verificarnombre.error3"));
			long isbn = Long.parseLong(vp.getMp().getVen().getIsbn().getText());
			LanzadorExcepciones.verificarNumeroNegativo(isbn, prop.getProperty("error.verificarnumeronegativo"));

			return new Libro(nombre, descripcion, rutaFoto, id, unidades, precio, autor, isbn);

		} catch (InputMismatchException e) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException e) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException e) {
			vp.mostrarError(e.getMessage());
		} catch (NumeroNegativoException e) {
			vp.mostrarError(e.getMessage());
		} catch (NombreException e) {
			vp.mostrarError(e.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}
	
	 /**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Mascotas.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */
	
	private Mascota leerDatosMascotas() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			String tipoAnimal = vp.getMp().getVen().getTipoAnimal().getText();
			LanzadorExcepciones.verificarTextoVacio(tipoAnimal, prop.getProperty("error.verificartextovacio"));
			String tamano = vp.getMp().getVen().getTamano().getText();
			LanzadorExcepciones.verificarTextoVacio(tamano, prop.getProperty("error.verificartextovacio"));

			return new Mascota(nombre, descripcion, rutaFoto, id, unidades, precio, tipoAnimal, tamano);

		} catch (InputMismatchException ime) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException nfe) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}
	
	 /**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Música.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */	
	
	private Musica leerDatosMusica() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			String formato = vp.getMp().getVen().getFormato().getText();
			LanzadorExcepciones.verificarTextoVacio(formato, prop.getProperty("error.verificartextovacio"));
			String artista = vp.getMp().getVen().getArtista().getText();
			LanzadorExcepciones.verificarNombre(artista, prop.getProperty("error.verificarnombre.error1"),
					prop.getProperty("error.verificarnombre.error2"), prop.getProperty("error.verificarnombre.error3"));

			return new Musica(nombre, descripcion, rutaFoto, id, unidades, precio, formato, artista);

		} catch (InputMismatchException ime) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException nfe) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (NombreException ne) {
			vp.mostrarError(ne.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}

	
	/**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Tecnología.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */
	
	private Ropa leerDatosRopa() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			String talla = vp.getMp().getVen().getTalla().getText();
			LanzadorExcepciones.verificarTextoVacio(talla, prop.getProperty("error.verificartextovacio"));
			String color = vp.getMp().getVen().getColor().getText();
			LanzadorExcepciones.verificarTextoVacio(color, prop.getProperty("error.verificartextovacio"));

			return new Ropa(nombre, descripcion, rutaFoto, id, unidades, precio, talla, color);

		} catch (InputMismatchException ime) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException nfe) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}
	
	/**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Vehículos.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */
	
	private Tecnologia leerDatosTecnologia() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			String marca = vp.getMp().getVen().getMarcaTec().getText();
			LanzadorExcepciones.verificarTextoVacio(marca, prop.getProperty("error.verificartextovacio"));
			String modelo = vp.getMp().getVen().getModeloTec().getText();
			LanzadorExcepciones.verificarTextoVacio(modelo, prop.getProperty("error.verificartextovacio"));

			return new Tecnologia(nombre, descripcion, rutaFoto, id, unidades, precio, marca, modelo);

		} catch (InputMismatchException ime) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException nfe) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}
	
	/**
     * Lee los datos ingresados por el usuario para crear un producto de tipo Vehículos.
     * Valida que los datos cumplan con los requisitos antes de crear el objeto.
     */
	
	private Vehiculo leerDatosVehiculos() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			LanzadorExcepciones.verificarTextoVacio(nombre, prop.getProperty("error.verificartextovacio"));
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			LanzadorExcepciones.verificarTextoVacio(descripcion, prop.getProperty("error.verificartextovacio"));
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, prop.getProperty("error.ruta.vacia"),
					prop.getProperty("error.ruta.incorrecto"));
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes, prop.getProperty("error.verificaridexistente"));
			LanzadorExcepciones.verificarNumeroNegativo(id, prop.getProperty("error.verificarnumeronegativo"));
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades, prop.getProperty("error.verificarnumeronegativo"));
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio, prop.getProperty("error.verificarnumeronegativo"));
			int anio = Integer.parseInt(vp.getMp().getVen().getAno().getText());
			LanzadorExcepciones.verificarNumeroNegativo(anio, prop.getProperty("error.verificarnumeronegativo"));
			String modelo = vp.getMp().getVen().getModeloVE().getText();
			LanzadorExcepciones.verificarTextoVacio(modelo, prop.getProperty("error.verificartextovacio"));

			return new Vehiculo(nombre, descripcion, rutaFoto, id, unidades, precio, anio, modelo);

		} catch (InputMismatchException ime) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (NumberFormatException nfe) {
			vp.mostrarError(prop.getProperty("error.mismatch"));
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (TextoVacioException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}
	
	/**
     * Configura los textos de la vista en el idioma seleccionado por el usuario.
     * Los textos se obtienen de un archivo de propiedades según el idioma elegido.
     */
	
	private void agregarIdioma() {
		vp.getMp().getVis().mostrarLabels(prop.getProperty("iniciosesion.titulo"),
				prop.getProperty("iniciosesion.usuario"), prop.getProperty("iniciosesion.contrasena"),
				prop.getProperty("iniciosesion.nocuenta"), prop.getProperty("iniciosesion.iniciarsesion.boton"),
				prop.getProperty("iniciosesion.registro.boton"));
		vp.getMp().getReg().mostrarLabels(prop.getProperty("registro.titulo"), prop.getProperty("registro.usuario"),
				prop.getProperty("registro.contrasena"), prop.getProperty("registro.tienecuenta"),
				prop.getProperty("registro.registrarse.boton"), prop.getProperty("registro.iniciosesion.boton"));
		vp.getMp().getCom().mostrarLabels(prop.getProperty("comprar.categorias"),
				prop.getProperty("categoria.comprar.todo"), prop.getProperty("categoria.belleza"),
				prop.getProperty("categoria.deportes"), prop.getProperty("categoria.hogar"),
				prop.getProperty("categoria.juguetes"), prop.getProperty("categoria.libros"),
				prop.getProperty("categoria.mascotas"), prop.getProperty("categoria.musica"),
				prop.getProperty("categoria.ropa"), prop.getProperty("categoria.tecnologia"),
				prop.getProperty("categoria.vehiculos"), prop.getProperty("comprar.modo.vender"));
		vp.getMp().getVen().iniciarLabels(prop.getProperty("vender.precio"), prop.getProperty("vender.nombre"),
				prop.getProperty("vender.descripcion"), prop.getProperty("vender.unidades"),
				prop.getProperty("vender.rutafoto"), prop.getProperty("vender.id"),
				prop.getProperty("vender.categorias"), prop.getProperty("categoria.vender.seleccione"),
				prop.getProperty("categoria.belleza"), prop.getProperty("categoria.deportes"),
				prop.getProperty("categoria.hogar"), prop.getProperty("categoria.juguetes"),
				prop.getProperty("categoria.libros"), prop.getProperty("categoria.mascotas"),
				prop.getProperty("categoria.musica"), prop.getProperty("categoria.ropa"),
				prop.getProperty("categoria.tecnologia"), prop.getProperty("categoria.vehiculos"),
				prop.getProperty("vender.modo.comprar"), prop.getProperty("vender.registro.producto"),
				prop.getProperty("vender.examinar"));
		vp.getMp().getFac().iniciarLabels(prop.getProperty("factura.comprar.boton"),
				prop.getProperty("factura.volver.boton"));

		vp.getMp().getCar().iniciarLabels(prop.getProperty("carritos.titulo"), prop.getProperty("carritos.volver"),
				prop.getProperty("carritos.crear"), prop.getProperty("carritos.filtrar"));
		vp.getMp().getRec().iniciarLabels(prop.getProperty("recibo.titulo"), prop.getProperty("recibo.producto"),
				prop.getProperty("recibo.precio"));
		vp.getMp().getPa().iniciarLabels(prop.getProperty("pago.tarjeta.pagar"), prop.getProperty("pago.tarjeta.datos"),
				prop.getProperty("pago.tarjeta.numero"), prop.getProperty("pago.tarjeta.fecha"),
				prop.getProperty("pago.tarjeta.cvv"));
		vp.getMp().getCrc().iniciarLabels(prop.getProperty("carrito.boton.crearcarrito"),
				prop.getProperty("carrito.nombre"));
		vp.getMp().getCc().iniciarLabels(prop.getProperty("confirmar.compra.boton"));
		vp.getMp().getCe().iniciarLabels(prop.getProperty("eliminar.mensaje"));
		vp.getMp().getAca().iniciarLabels(prop.getProperty("agregar.carrito.volver"),
				prop.getProperty("agregar.carrito.mensaje"));
		vp.getMp().getPip().iniciarLabels(prop.getProperty("producto.info.volver"),
				prop.getProperty("producto.info.agregar"));
	}
}
