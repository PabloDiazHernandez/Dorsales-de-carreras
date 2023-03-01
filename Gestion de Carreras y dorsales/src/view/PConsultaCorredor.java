package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.GestorCorredorControl;
import model.Corredor;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;

public class PConsultaCorredor extends JPanel {
	public static final String BTN_CONSULTAR = "Consultar";
	public static final String RDBTN_HOMBRE = "Hombre";
	public static final String RDBTN_TODOS = "Todos";
	public static final String RDBTN_MUJER = "Mujer";
	
	private static final String COLUMN_NOM = "Nombre";
	private static final String COLUMN_DORSAL = "Dorsal";
	private static final String COLUMN_EDAD = "Edad";
	private static final String COLUMN_SEXO = "Sexo";
	private static final String COLUMN_MODALIDAD = "Modalidad";
	
	private JTable tblConsulta;
	private JRadioButton rdbtnHombre;
	private JButton btnConsultar;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnTodos;
	private final ButtonGroup btngConsultar = new ButtonGroup();
	private DefaultTableModel dtm;
	public PConsultaCorredor() {
		init();
	}

	private void init() {
		setLayout(null);
		setSize(VGestorCorredor.PANEL_ANCHO, VGestorCorredor.PANEL_ALTO);
		
		JLabel lblTitulo = new JLabel("Consultar Corredor");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(260, 53, 263, 22);
		add(lblTitulo);
		
		JScrollPane scrpContenedorConsulta = new JScrollPane();
		scrpContenedorConsulta.setBounds(173, 113, 528, 141);
		add(scrpContenedorConsulta);
		
		tblConsulta = new JTable();
		scrpContenedorConsulta.setViewportView(tblConsulta);
		
		rdbtnHombre = new JRadioButton(RDBTN_HOMBRE);
		btngConsultar.add(rdbtnHombre);
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnHombre.setBounds(30, 111, 103, 21);
		add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton(RDBTN_MUJER);
		btngConsultar.add(rdbtnMujer);
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMujer.setBounds(30, 148, 103, 21);
		add(rdbtnMujer);
		
		rdbtnTodos = new JRadioButton(RDBTN_TODOS);
		btngConsultar.add(rdbtnTodos);
		rdbtnTodos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnTodos.setBounds(30, 180, 103, 21);
		add(rdbtnTodos);
		
		btnConsultar = new JButton(BTN_CONSULTAR);
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.setBounds(349, 315, 85, 21);
		add(btnConsultar);
		
		configurarTabla();
	}

	private void configurarTabla() {
		dtm = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblConsulta.setModel(dtm);
		
		dtm.addColumn(COLUMN_NOM);
		dtm.addColumn(COLUMN_DORSAL);
		dtm.addColumn(COLUMN_EDAD);
		dtm.addColumn(COLUMN_SEXO);
		dtm.addColumn(COLUMN_MODALIDAD);
		
		tblConsulta.getColumn(COLUMN_NOM).setPreferredWidth(100);
		tblConsulta.getColumn(COLUMN_DORSAL).setPreferredWidth(100);
		tblConsulta.getColumn(COLUMN_EDAD).setPreferredWidth(100);
		tblConsulta.getColumn(COLUMN_SEXO).setPreferredWidth(100);
		tblConsulta.getColumn(COLUMN_MODALIDAD).setPreferredWidth(100);



		
	}

	public void setControlador(GestorCorredorControl c) {
		btnConsultar.addActionListener(c);
	}
	
	public void rellenarTabla(ArrayList<Corredor>lista) {
        dtm.setRowCount(0);
        
        Object[] fila = new Object[5];
        
        for (Corredor cr: lista) {
            fila[0] = cr.getNombre();
            fila[1] = cr.getDorsal();
            fila[2] = cr.getEdad();
            fila[3] = cr.getSexo();
            fila[4] = cr.getModalidad();
            dtm.addRow(fila);
        }
	}
	
	public int obtenerDescripcion(String descripcion) {
		return tblConsulta.getSelectedRow();
	}
	
}
