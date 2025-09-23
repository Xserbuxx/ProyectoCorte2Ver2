package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.model.persistence.BellezaDAO;
import co.edu.unbosque.model.persistence.CarritoDAO;
import co.edu.unbosque.model.persistence.DeporteDAO;
import co.edu.unbosque.model.persistence.HogarDAO;
import co.edu.unbosque.model.persistence.JugueteDAO;
import co.edu.unbosque.model.persistence.LibroDAO;
import co.edu.unbosque.model.persistence.MascotaDAO;
import co.edu.unbosque.model.persistence.MusicaDAO;
import co.edu.unbosque.model.persistence.RopaDAO;
import co.edu.unbosque.model.persistence.TecnologiaDAO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.model.persistence.VehiculoDAO;

public class ModelFacade {
	
	private ArrayList<Producto> productos;
		private UsuarioDAO usDAO;
	private BellezaDAO beDAO;
	private DeporteDAO deDAO;
	private HogarDAO hoDAO;
	private JugueteDAO juDAO;
	private LibroDAO liDAO;
	private MascotaDAO maDAO;
	private MusicaDAO muDAO;
	private RopaDAO roDAO;
	private TecnologiaDAO teDAO;
	private VehiculoDAO veDAO;
	private CarritoDAO caDAO;
		/**
	 * Constructor que inicializa los DAO y la lista de productos.
	 */
	public ModelFacade() {
		usDAO = new UsuarioDAO();
		beDAO = new BellezaDAO();
		deDAO = new DeporteDAO();
		hoDAO = new HogarDAO();
		juDAO = new JugueteDAO();
		liDAO = new LibroDAO();
		maDAO = new MascotaDAO();
		muDAO = new MusicaDAO();
		roDAO = new RopaDAO();
		teDAO = new TecnologiaDAO();
		veDAO = new VehiculoDAO();
		caDAO = new CarritoDAO();
		productos = new ArrayList<>();
	}
		/**
	 * Llena la lista de productos agregando los elementos de cada DAO.
	 */
	public void agregarProductos() {
		productos.removeAll(productos);
		beDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		deDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		hoDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		juDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		liDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		maDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		muDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		roDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		teDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		veDAO.getLista().forEach((producto) -> {
			productos.add(producto);
		});
		
	}
	/**
	 * Devuelve la lista de productos del facade.
	 */
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	/**
	 * Configura la lista de productos del facade.
	 */
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	/**
	 * Devuelve el UsuarioDAO.
	 */
	public UsuarioDAO getUsDAO() {
		return usDAO;
	}
	/**
	 * Configura el UsuarioDAO.
	 */
	public void setUsDAO(UsuarioDAO usDAO) {
		this.usDAO = usDAO;
	}
	/**
	 * Devuelve el BellezaDAO.
	 */
	public BellezaDAO getBeDAO() {
		return beDAO;
	}
	/**
	 * Configura el BellezaDAO.
	 */
	public void setBeDAO(BellezaDAO beDAO) {
		this.beDAO = beDAO;
	}
	/**
	 * Devuelve el DeporteDAO.
	 */
	public DeporteDAO getDeDAO() {
		return deDAO;
	}
	/**
	 * Configura el DeporteDAO.
	 */
	public void setDeDAO(DeporteDAO deDAO) {
		this.deDAO = deDAO;
	}
	/**
	 * Devuelve el HogarDAO.
	 */
	public HogarDAO getHoDAO() {
		return hoDAO;
	}
	/**
	 * Configura el HogarDAO.
	 */
	public void setHoDAO(HogarDAO hoDAO) {
		this.hoDAO = hoDAO;
	}
	/**
	 * Devuelve el JugueteDAO.
	 */
	public JugueteDAO getJuDAO() {
		return juDAO;
	}
	/**
	 * Configura el JugueteDAO.
	 */
	public void setJuDAO(JugueteDAO juDAO) {
		this.juDAO = juDAO;
	}
	/**
	 * Devuelve el LibroDAO.
	 */
	public LibroDAO getLiDAO() {
		return liDAO;
	}
	/**
	 * Configura el LibroDAO.
	 */
	public void setLiDAO(LibroDAO liDAO) {
		this.liDAO = liDAO;
	}
	/**
	 * Devuelve el MascotaDAO.
	 */
	public MascotaDAO getMaDAO() {
		return maDAO;
	}
	/**
	 * Configura el MascotaDAO.
	 */
	public void setMaDAO(MascotaDAO maDAO) {
		this.maDAO = maDAO;
	}
	/**
	 * Devuelve el MusicaDAO.
	 */
	public MusicaDAO getMuDAO() {
		return muDAO;
	}
	/**
	 * Configura el MusicaDAO.
	 */
	public void setMuDAO(MusicaDAO muDAO) {
		this.muDAO = muDAO;
	}
	/**
	 * Devuelve el RopaDAO.
	 */
	public RopaDAO getRoDAO() {
		return roDAO;
	}
	/**
	 * Configura el RopaDAO.
	 */
	public void setRoDAO(RopaDAO roDAO) {
		this.roDAO = roDAO;
	}
	/**
	 * Devuelve el TecnologiaDAO.
	 */
	public TecnologiaDAO getTeDAO() {
		return teDAO;
	}
	/**
	 * Configura el TecnologiaDAO.
	 */
	public void setTeDAO(TecnologiaDAO teDAO) {
		this.teDAO = teDAO;
	}
	/**
	 * Devuelve el VehiculoDAO.
	 */
	public VehiculoDAO getVeDAO() {
		return veDAO;
	}
	/**
	 * Configura el VehiculoDAO.
	 */
	public void setVeDAO(VehiculoDAO veDAO) {
		this.veDAO = veDAO;
	}
	/**
	 * Devuelve el CarritoDAO.
	 */
	public CarritoDAO getCaDAO() {
		return caDAO;
	}
	/**
	 * Configura el CarritoDAO.
	 */
	public void setCaDAO(CarritoDAO caDAO) {
		this.caDAO = caDAO;
	}
		}