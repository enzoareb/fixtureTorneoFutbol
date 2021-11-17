package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.Controlador;

public class VentanaFixtureResuelto{
	private JFrame frameFixtureResuelto;
	private JPanel panel;
	private JScrollPane scroll;
	private Controlador controlador;
	private FondoFixture fondo;
	private JButton btnVolverAFixture;
	
	public VentanaFixtureResuelto() {
		this.fondo = new FondoFixture();
		this.controlador = new Controlador();
		this.frameFixtureResuelto = new JFrame();
	}
	
	public void mostrar() {		
		
		frameFixtureResuelto.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameFixtureResuelto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFixtureResuelto.getContentPane().setLayout(new BorderLayout());
		
		frameFixtureResuelto.setTitle("Fixture");
		frameFixtureResuelto.setVisible(true);
		//-----------------------------------------------------------------------//
		panel = fondo;
		panel.setLayout(new GridLayout(controlador.cantFechas()/2+1, 2));
		
		//-----------------------------------------------------------------------//
		scroll = new JScrollPane(panel,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		iniciarBoton();
		frameFixtureResuelto.getContentPane().add(btnVolverAFixture,BorderLayout.NORTH);
		frameFixtureResuelto.add(scroll);	
		
		crearEspacios(panel);
		
				
	}	
	
	public void crearEspacios(JPanel panel) {
		controlador.asignarArbitros();
		for (int i = 0; i < controlador.cantFechas(); i++) {
			JPanel panelFecha = new JPanel();
			panelFecha.setBounds(0, 0, frameFixtureResuelto.getWidth(), frameFixtureResuelto.getHeight());
			panelFecha.setLayout(new GridLayout(controlador.cantPartidos()*2,2));
			panelFecha.setBackground(new Color(1.0f, 1.0f, 1.0f, 0));
			panel.add(panelFecha);
			agregarFecha(panelFecha, i);
		}

	}
		
			
	
	private void agregarFecha(JPanel espacio, int fecha) {
		int num = fecha + 1;
		JLabel numeroFecha = new JLabel(" Fecha " + num + ": ",SwingConstants.CENTER);
		numeroFecha.setFont(new Font("Tahoma", Font.BOLD, 20));
		numeroFecha.setForeground(Color.WHITE);
		espacio.add(numeroFecha);
		agregarPartido(espacio, fecha);
		
	}
	
	private void agregarPartido(JPanel espacio, int fecha) {
		JLabel partido = new JLabel("", SwingConstants.CENTER);
		espacio.add(partido);
		
		for ( int i = 0; i < controlador.cantPartidos(); i++) {
			
			partido = new JLabel(controlador.darPartido(fecha, i),SwingConstants.CENTER);
			partido.setFont(new Font("Tahoma", Font.ITALIC, 18));
			partido.setForeground(Color.white);
			
			JLabel arbitro = new JLabel(controlador.darArbitro(fecha, i), SwingConstants.CENTER);
			arbitro.setForeground(Color.white);
			arbitro.setFont(new Font("Tahoma", Font.ITALIC, 18));
			
			
			espacio.add(partido);	
			espacio.add(arbitro);
			
			
		}
	}
	
	private void iniciarBoton() {
		
		this.btnVolverAFixture = new JButton("Volver a Fixture");
		btnVolverAFixture.setBackground(new Color(1.0f, 1.0f, 1.0f, 0));
		btnVolverAFixture.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVolverAFixture.setBounds(0,0, 300, 80);
		btnVolverAFixture.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnVolverAFixture.addActionListener(new ActionListener() {		
	
			public void actionPerformed(ActionEvent e) {
				frameFixtureResuelto.setVisible(false);;
				VentanaFixture frameFixture = new VentanaFixture();
				frameFixture.mostrar();
				}

			
			});
	}
}
