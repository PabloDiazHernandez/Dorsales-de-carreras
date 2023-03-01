package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import control.GestorCorredorControl;
import model.Corredor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JButton;

public class PAddCorredor extends JPanel {
	public static final String BTN_GUARDAR = "Guardar";
	public static final String BTN_LIMPIAR = "Limpiar";
	
	private JTextField txtNombre;
	private JTextField txtDorsal;
	private final ButtonGroup btngSexo = new ButtonGroup();
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JSpinner spnEdad;
	private JComboBox<String> cmbModalidad;
	private JButton btnGuardar;
	private JButton btnLimpiar;
	public PAddCorredor() {
		init();
	}

	private void init() {
		setLayout(null);
		setSize(VGestorCorredor.PANEL_ANCHO, VGestorCorredor.PANEL_ALTO);
		
		JLabel lblTitulo = new JLabel("Introducir Corredor");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(286, 49, 198, 32);
		add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(79, 140, 76, 24);
		add(lblNombre);
		
		JLabel lblDorsal = new JLabel("Dorsal");
		lblDorsal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDorsal.setBounds(79, 200, 76, 24);
		add(lblDorsal);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(79, 267, 76, 24);
		add(lblSexo);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdad.setBounds(79, 320, 76, 24);
		add(lblEdad);
		
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Introduce un nombre");
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNombre.setBounds(196, 145, 198, 19);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDorsal = new JTextField();
		txtDorsal.setText("1");
		txtDorsal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDorsal.setColumns(10);
		txtDorsal.setBounds(196, 205, 198, 19);
		add(txtDorsal);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setSelected(true);
		btngSexo.add(rdbtnHombre);
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnHombre.setBounds(196, 271, 103, 21);
		add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		btngSexo.add(rdbtnMujer);
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMujer.setBounds(331, 271, 103, 21);
		add(rdbtnMujer);
		
		spnEdad = new JSpinner();
		spnEdad.setModel(new SpinnerNumberModel(0, 0, 125, 1));
		spnEdad.setBounds(196, 320, 30, 24);
		add(spnEdad);
		
		JLabel lblModalidad = new JLabel("Modalidad");
		lblModalidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModalidad.setBounds(79, 380, 76, 24);
		add(lblModalidad);
		
		cmbModalidad = new JComboBox<String>();
		cmbModalidad.setModel(new DefaultComboBoxModel<String>(Corredor.MODALIDAD));
		cmbModalidad.setBounds(196, 384, 89, 21);
		add(cmbModalidad);
		
		btnGuardar = new JButton(BTN_GUARDAR);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setBounds(79, 457, 85, 21);
		add(btnGuardar);
		
		btnLimpiar = new JButton(BTN_LIMPIAR);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLimpiar.setBounds(225, 457, 85, 21);
		add(btnLimpiar);

	}
	
	public Corredor obtenerCorredor() {
        Corredor cr = null;
        

        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            mostrarError("El nombre es obligatorio");
        } else {
            String dorsal = txtDorsal.getText().trim();

            if (dorsal.length() > 5) {
                
                mostrarError("El Dorsal  no puede tener menos de 5 caracteres tampoco "
                        + "puede ser un numero negativo y tiene que ser un valor numerico");
                
            } else {
                try {
                    
                    int dorsalnum = Integer.parseInt(dorsal);
                    if(dorsalnum <0 && dorsalnum >= 1000000) {
                    }
                } catch (NumberFormatException e) {
                    mostrarError("El Dorsal tiene que ser un valor numerico");
                    
                }
                
                String sexo = "Hombre";
                if (rdbtnMujer.isSelected()) {
                    sexo = "Mujer";
                }
                    int edad = (int) spnEdad.getValue();
                    String modalidad = (String) cmbModalidad.getSelectedItem();
                    
                    cr = new Corredor(nombre, dorsal, sexo, edad, modalidad);
                    
            }
        }
        return cr;
    }

	private void mostrarError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error de datos", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarResultado(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Resultado de la operación", 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void limpiarComponentes() {
		txtNombre.setText("");
		txtDorsal.setText("1");
		rdbtnHombre.isSelected();
		spnEdad.setValue(0);
		cmbModalidad.setSelectedIndex(0);
	}

	public void setControlador(GestorCorredorControl c) {
		btnGuardar.addActionListener(c);
		btnLimpiar.addActionListener(c);
	}
	
}
