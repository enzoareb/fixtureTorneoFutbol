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

public class VentanaFixture {
	private JFrame frameFixture;
	private JPanel panelFixture;
	private JPanel panelBotones;
	private JScrollPane scroll;
	private JButton btnAsignarArbitros;
	private JButton btnVolver;
	
	private Controlador controlador;
	private FondoFixture fondo;
	
	public VentanaFixture() {	
		this.fondo = new FondoFixture();
		this.controlador = new Controlador();
		this.frameFixture = new JFrame();
	}	
	
	public void mostrar() {				
		frameFixture.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameFixture.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameFixture.getContentPane().setLayout(new BorderLayout());
		frameFixture.setBackground(Color.black);
		frameFixture.setTitle("Fixture");
		frameFixture.setVisible(true);
		//-----------------------------------------------------------------------//
		panelFixture = fondo;
		panelFixture.setLayout(new GridLayout(controlador.cantFechas()/2+1, 2));
		panelFixture.setBackground(Color.black);
		//-----------------------------------------------------------------------//
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.black);
		panelBotones.setLayout(new BorderLayout());
		//-----------------------------------------------------------------------//
		scroll = new JScrollPane(panelFixture,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//-----------------------------------------------------------------------//
		iniciarBotones();
		//-----------------------------------------------------------------------//
		panelBotones.add(btnAsignarArbitros, BorderLayout.NORTH);
		panelBotones.add(btnVolver,BorderLayout.CENTER);		
		frameFixture.add(panelBotones,BorderLayout.NORTH);
		frameFixture.add(scroll);		
		crearEspacios(panelFixture);		
				
	}	
	private void iniciarBotones() {
		this.btnAsignarArbitros = new JButton("Asignar Arbitros");
		btnAsignarArbitros.setBackground(new Color(1.0f, 1.0f, 1.0f, 0));
		btnAsignarArbitros.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnAsignarArbitros.setBackground(Color.black);
		btnAsignarArbitros.addActionListener(new ActionListener() {		
					
			public void actionPerformed(ActionEvent e) {
				frameFixture.setVisible(false);
				VentanaFixtureResuelto fixtureResuelto = new VentanaFixtureResuelto();	
				fixtureResuelto.mostrar();
			
				}
			});	
	
		this.btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(1.0f, 1.0f, 1.0f, 0));
		btnVolver.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVolver.setBackground(Color.black);
		btnVolver.addActionListener(new ActionListener() {		
					
			public void actionPerformed(ActionEvent e) {
				MainVisual frameMainVisual = new MainVisual();
				frameFixture.setVisible(false);
				frameMainVisual.initialize();
			
				}
			});	
	}

	public void crearEspacios(JPanel panel) {
		for (int i = 0; i < controlador.cantFechas(); i++) {
			JPanel panelFecha = new JPanel();
			panelFecha.setBounds(0, 0, frameFixture.getWidth(), frameFixture.getHeight());
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
}
