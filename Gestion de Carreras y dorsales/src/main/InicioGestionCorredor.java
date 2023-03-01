package main;

import model.FuenteDeDatos;
import view.PAddCorredor;
import view.PConsultaCorredor;
import view.VGestorCorredor;

import java.awt.EventQueue;

import control.GestorCorredorControl;

public class InicioGestionCorredor {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater (new Runnable() {
			public void run() {
				VGestorCorredor v = new VGestorCorredor();
				PAddCorredor pac = new PAddCorredor();
				PConsultaCorredor pcc = new PConsultaCorredor();
				
				FuenteDeDatos datos = new FuenteDeDatos();
				GestorCorredorControl c = new GestorCorredorControl(v, pac, pcc, datos);
				
				v.setControlador(c);
				pac.setControlador(c);
				pcc.setControlador(c);
				
				v.hacerVisible();
				
				
			}
		});

	}

}
