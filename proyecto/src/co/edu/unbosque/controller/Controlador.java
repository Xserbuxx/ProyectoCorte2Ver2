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

	public void runGUI() {
		prop = new Properties();
		;
		prop = FileHandler.cargarArchivoDePropiedades("es.properties");
		agregarIdioma();
		agregarOyentes();

	}

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
	}

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

				vp.getMp().getPip().mostrarProductoInfo(producto.getPrecio(), producto.getNombre(),
						producto.getDescripcion(), producto.getUnidades(), producto.getRutaFoto(), atributo1,
						atributo2);
			} else {
				vp.mostrarError("No se encontro el producto");
				return;
			}
		}

		if (boton.contains("CarritoACA-")) {

			try {
				LanzadorExcepciones.verificarUnidadesDisponibles(productoTemp.getUnidades(),
						"El producto no tiene unidades disponibles");
			} catch (UnidadesProductoException e1) {
				vp.mostrarError(e1.getMessage());
				return;
			}

			bajarUnidadesProductos();

			vp.mostrarMensaje("Producto agregado al carrito " + boton.split("-")[1].split("_")[0] + " exitosamente");

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
			vp.getMp().getFac().mostrarTotal(total + "");
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

			vp.getMp().getCe().crearBotonEliminar(boton.split("-")[1], this);

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

			vp.mostrarMensaje("Carrito eliminado exitosamente");

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
			vp.getMp().getFac().mostrarTotal(total + "");
			vp.mostrarMensaje("Producto eliminado del carrito exitosamente");

		}

		switch (boton) {
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

				LanzadorExcepciones.verificarNombre(usuario);
				LanzadorExcepciones.verificarContrasena(contrasena);

				for (Usuario usu : mf.getUsDAO().getLista()) {
					if (usu.getNombre().equals(usuario) && usu.getContrasena().equals(contrasena)) {
						usuarioActual = usu;
						vp.mostrarMensaje("Inicio de sesion exitoso");
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
						vp.mostrarError("La contrasena es incorrecta");
						romper = true;
						break;
					}
				}

				if (romper) {
					break;
				}

				vp.mostrarError("El usuario no existe");

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

				LanzadorExcepciones.verificarNombre(usuario);
				LanzadorExcepciones.verificarContrasena(contrasena);

				for (Usuario usu : mf.getUsDAO().getLista()) {
					if (usu.getNombre().equals(usuario)) {
						vp.mostrarError("El usuario ya existe");
						existe = true;
						return;
					}
				}

				if (existe) {
					break;
				}

				Usuario nuevoUsuario = new Usuario(usuario, contrasena);

				mf.getUsDAO().crear(nuevoUsuario);
				usuarioActual = nuevoUsuario;

				vp.getMp().getCom().getCategorias().setSelectedIndex(0);
				agregarProductosVentanaComprar();

				vp.getMp().mostrarPanel("com");

			} catch (NombreException ne) {
				vp.mostrarError(ne.getMessage());
				break;
			} catch (ContrasenaException ce) {
				vp.mostrarError(ce.getMessage());
				break;
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

			switch (selec) {

			case "Seleccione":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarCampos();
				break;

			case "Belleza":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarBelleza();
				break;

			case "Deportes":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarDeportes();
				break;

			case "Hogar":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarHogar();
				break;

			case "Juguetes":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarJuguetes();
				break;

			case "Libros":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarLibros();
				break;

			case "Mascotas":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarMascotas();
				break;

			case "Musica":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarMusica();
				break;

			case "Ropa":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarRopa();
				break;

			case "Tecnologia":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarTecnologia();
				break;

			case "Vehiculos":
				vp.getMp().getVen().limpiarLabels();
				vp.getMp().getVen().limpiarCampos();

				vp.getMp().getVen().mostrarVehiculos();
				break;
			default:
				break;
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

			switch (seleccion) {
			case "Seleccione":
				vp.mostrarError("Seleccione una categoria valida");
				break;
			case "Belleza":
				Belleza belleza = leerDatosBelleza();
				if (belleza != null) {
					mf.getBeDAO().crear(belleza);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Deportes":
				Deporte deporte = leerDatosDeportes();
				if (deporte != null) {
					mf.getDeDAO().crear(deporte);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Hogar":
				Hogar hogar = leerDatosHogar();
				if (hogar != null) {
					mf.getHoDAO().crear(hogar);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Juguetes":
				Juguete juguete = leerDatosJuguetes();
				if (juguete != null) {
					mf.getJuDAO().crear(juguete);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Libros":
				Libro libro = leerDatosLibros();
				if (libro != null) {
					mf.getLiDAO().crear(libro);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Mascotas":
				Mascotas mascotas = leerDatosMascotas();
				if (mascotas != null) {
					mf.getMaDAO().crear(mascotas);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Musica":
				Musica musica = leerDatosMusica();
				if (musica != null) {
					mf.getMuDAO().crear(musica);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Ropa":
				Ropa ropa = leerDatosRopa();
				if (ropa != null) {
					mf.getRoDAO().crear(ropa);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Tecnologia":
				Tecnologia tecnologia = leerDatosTecnologia();
				if (tecnologia != null) {
					mf.getTeDAO().crear(tecnologia);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			case "Vehiculos":
				Vehiculos vehiculo = leerDatosVehiculos();
				if (vehiculo != null) {
					mf.getVeDAO().crear(vehiculo);
					vp.mostrarMensaje("Producto registrado exitosamente");
				}
				break;
			default:
				break;
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
				LanzadorExcepciones.verificarNombre(nombreCarrito);
				if (nombreCarrito.isBlank()) {
					vp.mostrarError("El nombre del carrito no puede estar vacio");
					break;
				}
				nombreCarrito = nombreCarrito + "_" + usuarioActual.getNombre();

				boolean existe = false;
				for (Carrito car : mf.getCaDAO().getLista()) {
					if (car.getNombre().equals(nombreCarrito)) {
						vp.mostrarError("Ya existe un carrito con ese nombre");
						existe = true;
						break;
					}
				}
				if (existe) {
					break;
				}

				Carrito nuevoCarrito = new Carrito(nombreCarrito, new ArrayList<>());
				mf.getCaDAO().crear(nuevoCarrito);

				vp.mostrarMensaje("Carrito creado exitosamente");

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
				vp.mostrarError("Error al crear el carrito" + ex.getMessage());
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

				vp.getMp().getPip().mostrarProductoInfo(productoTemp.getPrecio(), productoTemp.getNombre(),
						productoTemp.getDescripcion(), productoTemp.getUnidades(), productoTemp.getRutaFoto(),
						atributo1, atributo2);
			} else {
				vp.mostrarError("No se encontro el producto");
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
					vp.mostrarError("El carrito esta vacio");
					break;
				}
				vp.getMp().getFac().setVisible(false);
				vp.getMp().getFac().setEnabled(false);
				vp.getMp().getCar().remove(vp.getMp().getFac());

				vp.getMp().getCar().add(vp.getMp().getCc());
				vp.getMp().getCc().setEnabled(true);
				vp.getMp().getCc().setVisible(true);
				vp.getMp().getCar().setComponentZOrder(vp.getMp().getCc(), 0);

				vp.getMp().getCc().mostrarTitulo(total);

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
				LanzadorExcepciones.verificarNumeroTarjeta(vp.getMp().getPa().getNumeroTarjeta().getText());
				LanzadorExcepciones.verificarFechaVencimiento(vp.getMp().getPa().getFechaVencimiento().getText());
				LanzadorExcepciones.verificarCodigoSeguridad(vp.getMp().getPa().getCodigoSeguridad().getText());

				vp.mostrarMensaje("Compra realizada exitosamente");

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

					String contenido = "Producto;Precio\n";

					for (Producto producto : carritoTemp.getProductos()) {
						contenido += producto.getNombre() + ";" + producto.getPrecio() + "\n";
					}

					contenido += "Total;" + total + "\n";

					Random random = new Random();
					FileHandler.escribirEnArchivoTexto(
							"Recivo Carrito " + carritoTemp.getNombre() + "_" + random.nextLong() + ".csv", contenido);

					vp.mostrarMensaje("Se ha generado un recibo de la compra en formato .csv");

					vp.getMp().getRec().eliminarTotal();
					vp.getMp().getRec().mostrarTotal(total);

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
		// poner boton volver Rec y borrar carrito en if de boton pagar
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

	private void encontrarProducto(int id) {
		mf.agregarProductos();
		for (Producto producto : mf.getProductos()) {
			if (producto.getId() == id) {
				productoTemp = producto;
			}
		}
	}

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
		} else if (producto instanceof Mascotas) {
			mf.getMaDAO().eliminar((Mascotas) producto);
		} else if (producto instanceof Musica) {
			mf.getMuDAO().eliminar((Musica) producto);
		} else if (producto instanceof Ropa) {
			mf.getRoDAO().eliminar((Ropa) producto);
		} else if (producto instanceof Tecnologia) {
			mf.getTeDAO().eliminar((Tecnologia) producto);
		} else if (producto instanceof Vehiculos) {
			mf.getVeDAO().eliminar((Vehiculos) producto);
		}
		mf.agregarProductos();
	}

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
		} else if (productoTemp instanceof Mascotas) {
			mf.getMaDAO().bajarUnidades((Mascotas) productoTemp);
		} else if (productoTemp instanceof Musica) {
			mf.getMuDAO().bajarUnidades((Musica) productoTemp);
		} else if (productoTemp instanceof Ropa) {
			mf.getRoDAO().bajarUnidades((Ropa) productoTemp);
		} else if (productoTemp instanceof Tecnologia) {
			mf.getTeDAO().bajarUnidades((Tecnologia) productoTemp);
		} else if (productoTemp instanceof Vehiculos) {
			mf.getVeDAO().bajarUnidades((Vehiculos) productoTemp);
		}
		mf.agregarProductos();

	}

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
					} else if (producto instanceof Mascotas) {
						mf.getMaDAO().subirUnidades((Mascotas) producto);
					} else if (producto instanceof Musica) {
						mf.getMuDAO().subirUnidades((Musica) producto);
					} else if (producto instanceof Ropa) {
						mf.getRoDAO().subirUnidades((Ropa) producto);
					} else if (producto instanceof Tecnologia) {
						mf.getTeDAO().subirUnidades((Tecnologia) producto);
					} else if (producto instanceof Vehiculos) {
						mf.getVeDAO().subirUnidades((Vehiculos) producto);
					}
				}
			}

		}

	}

	private void agregarProductosVentanaComprar() {
		vp.getMp().getCom().limpiarProductos();

		if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Todo")) {
			mf.agregarProductos();
			mf.getProductos().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Belleza")) {
			mf.getBeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Deportes")) {
			mf.getDeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Hogar")) {
			mf.getHoDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Juguetes")) {
			mf.getJuDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Libros")) {
			mf.getLiDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Belleza")) {
			mf.getBeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Mascotas")) {
			mf.getMaDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Musica")) {
			mf.getMuDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Ropa")) {
			mf.getRoDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Tecnologia")) {
			mf.getTeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		} else if (vp.getMp().getCom().getCategorias().getSelectedItem().toString().equals("Vehiculos")) {
			mf.getVeDAO().getLista().forEach((producto) -> {
				vp.getMp().getCom().mostrarProductos(producto.getNombre(), producto.getPrecio(), producto.getRutaFoto(),
						producto.getId(), this);
			});
		}
		vp.actualizar();
	}

	private void leerIDSExistentes() {
		mf.agregarProductos();
		idsExistentes = new ArrayList<Integer>();
		mf.getProductos().forEach((producto) -> {
			idsExistentes.add(producto.getId());
		});
	}

	private Belleza leerDatosBelleza() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			LanzadorExcepciones.verificarFormatoFoto(rutaFoto, "La ruta no puede estar vacia",
					"El formato de la foto es incorrecto");
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String tipoProducto = vp.getMp().getVen().getTipoProductoBe().getText();
			String fechaExpiracion = vp.getMp().getVen().getFechaExpiracion().getText();
			LanzadorExcepciones.verificarFechaVencimientoBelleza(fechaExpiracion);

			return new Belleza(nombre, descripcion, rutaFoto, id, unidades, precio, tipoProducto, fechaExpiracion);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (FechaVencimientoException e) {
			vp.mostrarError(e.getMessage());
		} catch (FormatoFotoException e) {
			vp.mostrarMensaje(e.getMessage());
		}

		return null;
	}

	private Deporte leerDatosDeportes() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String tipoDeporte = vp.getMp().getVen().getTipoDeporte().getText();
			String marca = vp.getMp().getVen().getMarcaDe().getText();

			return new Deporte(nombre, descripcion, rutaFoto, id, unidades, precio, tipoDeporte, marca);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Hogar leerDatosHogar() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String material = vp.getMp().getVen().getMaterialHo().getText();
			String tipoProducto = vp.getMp().getVen().getTipoProductoHo().getText();

			return new Hogar(nombre, descripcion, rutaFoto, id, unidades, precio, material, tipoProducto);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Juguete leerDatosJuguetes() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			int edadRecomendada = Integer.parseInt(vp.getMp().getVen().getEdadRecomendada().getText());
			LanzadorExcepciones.verificarNumeroNegativo(edadRecomendada);
			String material = vp.getMp().getVen().getMaterialJu().getText();

			return new Juguete(nombre, descripcion, rutaFoto, id, unidades, precio, edadRecomendada, material);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Libro leerDatosLibros() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String autor = vp.getMp().getVen().getAutor().getText();
			LanzadorExcepciones.verificarNombre(autor);
			long isbn = Long.parseLong(vp.getMp().getVen().getIsbn().getText());
			LanzadorExcepciones.verificarNumeroNegativo(isbn);

			return new Libro(nombre, descripcion, rutaFoto, id, unidades, precio, autor, isbn);

		} catch (InputMismatchException e) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException e) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException e) {
			vp.mostrarError(e.getMessage());
		} catch (NumeroNegativoException e) {
			vp.mostrarError(e.getMessage());
		} catch (NombreException e) {
			vp.mostrarError(e.getMessage());
		}

		return null;
	}

	private Mascotas leerDatosMascotas() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String tipoAnimal = vp.getMp().getVen().getTipoAnimal().getText();
			String tamano = vp.getMp().getVen().getTamano().getText();

			return new Mascotas(nombre, descripcion, rutaFoto, id, unidades, precio, tipoAnimal, tamano);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Musica leerDatosMusica() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String formato = vp.getMp().getVen().getFormato().getText();
			String artista = vp.getMp().getVen().getArtista().getText();
			LanzadorExcepciones.verificarNombre(artista);

			return new Musica(nombre, descripcion, rutaFoto, id, unidades, precio, formato, artista);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		} catch (NombreException ne) {
			vp.mostrarError(ne.getMessage());
		}

		return null;
	}

	private Ropa leerDatosRopa() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String talla = vp.getMp().getVen().getTalla().getText();
			String color = vp.getMp().getVen().getColor().getText();

			return new Ropa(nombre, descripcion, rutaFoto, id, unidades, precio, talla, color);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Tecnologia leerDatosTecnologia() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			String marca = vp.getMp().getVen().getMarcaTec().getText();
			String modelo = vp.getMp().getVen().getModeloTec().getText();

			return new Tecnologia(nombre, descripcion, rutaFoto, id, unidades, precio, marca, modelo);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private Vehiculos leerDatosVehiculos() {
		try {
			String nombre = vp.getMp().getVen().getNombre().getText();
			String descripcion = vp.getMp().getVen().getDescripcion().getText();
			String rutaFoto = vp.getMp().getVen().getRutaFoto().getText();
			int id = Integer.parseInt(vp.getMp().getVen().getId().getText());
			LanzadorExcepciones.verificarIDExistente(id, idsExistentes);
			LanzadorExcepciones.verificarNumeroNegativo(id);
			int unidades = Integer.parseInt(vp.getMp().getVen().getUnidades().getText());
			LanzadorExcepciones.verificarNumeroNegativo(unidades);
			double precio = Double.parseDouble(vp.getMp().getVen().getPrecio().getText());
			LanzadorExcepciones.verificarNumeroNegativo(precio);
			int anio = Integer.parseInt(vp.getMp().getVen().getAno().getText());
			LanzadorExcepciones.verificarNumeroNegativo(anio);
			String modelo = vp.getMp().getVen().getModeloVE().getText();

			return new Vehiculos(nombre, descripcion, rutaFoto, id, unidades, precio, anio, modelo);

		} catch (InputMismatchException ime) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (NumberFormatException nfe) {
			vp.mostrarError("El formato de algun numero es incorrecto");
		} catch (IDExistenteException idee) {
			vp.mostrarError(idee.getMessage());
		} catch (NumeroNegativoException nne) {
			vp.mostrarError(nne.getMessage());
		}

		return null;
	}

	private void agregarIdioma() {
		vp.getMp().getVis().mostrarLabels(prop.getProperty("iniciosesion.titulo"),
				prop.getProperty("iniciosesion.usuario"), prop.getProperty("iniciosesion.contrasena"),
				prop.getProperty("iniciosesion.nocuenta"), prop.getProperty("iniciosesion.iniciarsesion.boton"),
				prop.getProperty("iniciosesion.registro.boton"));
		vp.getMp().getReg().mostrarLabels(prop.getProperty("registro.titulo"), prop.getProperty("registro.usuario"),
				prop.getProperty("registro.contrasena"), prop.getProperty("registro.tienecuenta"),
				prop.getProperty("registro.registrarse.boton"), prop.getProperty("registro.iniciosesion.boton"));
		vp.getMp().getCom().mostrarLabels(prop.getProperty("comprar.categorias"),prop.getProperty("categoria.comprar.todo"),
				prop.getProperty("categoria.belleza"), prop.getProperty("categoria.deportes"),
				prop.getProperty("categoria.hogar"),
				prop.getProperty("categoria.juguetes"), prop.getProperty("categoria.libros"),
				prop.getProperty("categoria.mascotas"), prop.getProperty("categoria.musica"),
				prop.getProperty("categoria.ropa"), prop.getProperty("categoria.tecnologia"),
				prop.getProperty("categoria.vehiculos"),prop.getProperty("comprar.modo.vender"));
	}
}
