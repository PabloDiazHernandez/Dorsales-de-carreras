package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import model.Corredor;
import model.FuenteDeDatos;
import view.PAddCorredor;
import view.PConsultaCorredor;
import view.VGestorCorredor;

public class GestorCorredorControl implements ActionListener {
	
	VGestorCorredor v;
	PAddCorredor pac;
	PConsultaCorredor pcc;
	FuenteDeDatos datos;

	public GestorCorredorControl(VGestorCorredor v, PAddCorredor pac, PConsultaCorredor pcc, FuenteDeDatos datos) {
		this.v = v;
		this.pac = pac;
		this.pcc = pcc;
		this.datos = datos;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JMenuItem) {
			// Menú
			if(e.getActionCommand().equals(VGestorCorredor.MNTM_ADD)) {
				v.mostrarPanel(pac);
			} else if(e.getActionCommand().equals(VGestorCorredor.MNTM_CONS)) {
				v.mostrarPanel(pcc);
			} else if (e.getActionCommand().equals(VGestorCorredor.MNTM_SALIR)) {
				int resp = JOptionPane.showConfirmDialog(v, "Se va a cerrar la aplicación, ¿desea continuar?",
						"Confirmación cierre de aplicación", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				
				if (resp == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
			
		} else if(e.getSource() instanceof JButton) {
			// Botón
			if(e.getActionCommand().equals(PAddCorredor.BTN_GUARDAR)) {
				Corredor cr = pac.obtenerCorredor();
				
				if(cr != null) {
					datos.addCorredor(cr);
					pac.mostrarResultado("Se ha guardado el corredor");
				}
			} else if(e.getActionCommand().equals(PAddCorredor.BTN_LIMPIAR)) {
				pac.limpiarComponentes();
			} else if (e.getActionCommand().equals(PConsultaCorredor.BTN_CONSULTAR)) {
				pcc.rellenarTabla(datos.getColeccion());
			}
			
		} else if (e.getSource() instanceof JRadioButton) {
			// Radio buttons
			if(e.getActionCommand().equals(PConsultaCorredor.RDBTN_TODOS)) {
				pcc.rellenarTabla(datos.getColeccion());
			} else if(e.getActionCommand().equals(PConsultaCorredor.RDBTN_HOMBRE)) {

			}
		}
	}
}
