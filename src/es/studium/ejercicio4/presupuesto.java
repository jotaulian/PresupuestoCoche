package es.studium.ejercicio4;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class presupuesto extends Frame implements WindowListener, ItemListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	int motor, puertas, pintura;
	//CREAMOS ETIQUETAS
	Label lblMotor = new Label("¿Tipo de motorización?");
	Label lblPuertas = new Label("¿Número de puertas?");
	Label lblPintura = new Label("¿Pintura Metalizada?");
	TextField txtTotal = new TextField(20);
	
	//DEFINIMOS GRUPOS
	CheckboxGroup chkGrupoMotor = new CheckboxGroup();
	CheckboxGroup chkGrupoPuertas = new CheckboxGroup();
	CheckboxGroup chkGrupoPintura = new CheckboxGroup();
		
	//Creamos los checkboxes indicando la etiqueta, si esta o no activo, y el grupo al que pertence
	//CHECKBOXES MOTORIZACION
	Checkbox chkGasolina = new Checkbox("Gasolina",false,chkGrupoMotor);
	Checkbox chkDiesel = new Checkbox("Diésel",false,chkGrupoMotor);
	Checkbox chkHibrido = new Checkbox("Híbrido",false,chkGrupoMotor);
	Checkbox chkElectrico = new Checkbox("Eléctrico",false,chkGrupoMotor);
	Checkbox[] motores = {chkGasolina, chkDiesel, chkHibrido, chkElectrico};
		
	//CHECKBOXES PUERTAS
	Checkbox chk3P = new Checkbox("3 puertas",false,chkGrupoPuertas);
	Checkbox chk4P = new Checkbox("4 puertas",false,chkGrupoPuertas);
	Checkbox chk5P = new Checkbox("5 puertas",false,chkGrupoPuertas);
		
	//CHECKBOXES PINTURA
	Checkbox chkMsi = new Checkbox("Pintura normal",false,chkGrupoPintura);
	Checkbox chkMno = new Checkbox("Pintura metalizada",false,chkGrupoPintura);
	
	//CREAMOS BOTON
		Button btn = new Button("Calcular Presupuesto");
	
	
	public presupuesto() {
		setLayout(new FlowLayout());
		setTitle("Vehículos");
		setSize(450,200);
		add(lblMotor);
		for (Checkbox motor : motores)
		{
			motor.addItemListener(this);
			add(motor);
		}
		
		add(lblPuertas);
		chk3P.addItemListener(this);
		chk4P.addItemListener(this);
		chk5P.addItemListener(this);
		add(chk3P);
		add(chk4P);
		add(chk5P);
		
		add(lblPintura);
		chkMsi.addItemListener(this);
		chkMno.addItemListener(this);
		add(chkMsi);
		add(chkMno);
		btn.addActionListener(this);
		add(btn);
		add(txtTotal);
		
		addWindowListener(this);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new presupuesto();
	}

	public void windowActivated(WindowEvent arg0){}
	public void windowClosed(WindowEvent arg0){}
	public void windowClosing(WindowEvent arg0){
			System.exit(0);
		}
	public void windowDeactivated(WindowEvent arg0){}
	public void windowDeiconified(WindowEvent arg0){}
	public void windowIconified(WindowEvent arg0){}
	public void windowOpened(WindowEvent arg0){}

	//Item Listener Method
	public void itemStateChanged(ItemEvent ie)
	{
		if("Diésel".equals(ie.getItem())) {
			motor = 8000;
		}else if("Gasolina".equals(ie.getItem())){
			motor = 7000;
		}else if("Híbrido".equals(ie.getItem())){
			motor = 9000;
		}else if("Eléctrico".equals(ie.getItem())){
			motor = 8500;
		} else if("3 puertas".equals(ie.getItem())) {
			puertas = 2000;
		}else if("4 puertas".equals(ie.getItem())) {
			puertas = 3000;
		}else if("5 puertas".equals(ie.getItem())) {
			puertas = 2500;
		}else if("Pintura normal".equals(ie.getItem())) {
			pintura = 0;
		}else if("Pintura metalizada".equals(ie.getItem())) {
			pintura = 1500;
		}
	}
	
	//Action Listener Method
	public void actionPerformed(ActionEvent ae)
	{
		txtTotal.setText("El valor es de " + (motor+pintura+puertas) + " Euros");
	}
}