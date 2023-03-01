package view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import control.GestorCorredorControl;

import java.awt.BorderLayout;

public class VGestorCorredor extends JFrame {

	private static final int ANCHO = 800;
	private static final int ALTO = 800;
	public static final int PANEL_ANCHO = ANCHO - 17;
	public static final int PANEL_ALTO = ALTO - 70;
	
	public static final String MNTM_ADD = "Introducir Corredor";
	public static final String MNTM_CONS = "Consultar Corredor";
	public static final String MNTM_SALIR = "Salir";
	private JScrollPane scrpContenedor;
	private JMenuItem mntmIntroducir;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmSalir;

	public VGestorCorredor() {
		init();
	}

	private void init() {
		setTitle("Menú Corredor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(ANCHO, ALTO);

		centrarVentana();
		crearMenu();


	}

	private void crearMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mntmIntroducir = new JMenuItem(MNTM_ADD);
		menuBar.add(mntmIntroducir);

		mntmConsultar = new JMenuItem(MNTM_CONS);
		menuBar.add(mntmConsultar);

		mntmSalir = new JMenuItem(MNTM_SALIR);
		menuBar.add(mntmSalir);
		
		scrpContenedor = new JScrollPane();
		getContentPane().add(scrpContenedor, BorderLayout.CENTER);
	}

	private void centrarVentana() {
		setPreferredSize(new Dimension(ANCHO, ALTO)); 
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               
		Dimension ventana = this.getPreferredSize();               
		setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void mostrarPanel(JPanel panel) {
		scrpContenedor.setViewportView(panel);
	}

	public void setControlador(GestorCorredorControl c) {
		mntmIntroducir.addActionListener(c);
		mntmConsultar.addActionListener(c);
		mntmSalir.addActionListener(c);
	}
	

}
