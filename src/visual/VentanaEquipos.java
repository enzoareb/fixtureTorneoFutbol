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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controlador.Controlador;


public class VentanaEquipos {
	private JFrame frameEquipos;
	private JPanel panel;
	private Controlador controlador;
	private JButton btnVolver;
	private FondoEquipos fondo;
	
	public VentanaEquipos() {
		this.fondo = new FondoEquipos();
		this.controlador = new Controlador();
		this.panel = new JPanel();
		this.frameEquipos = new JFrame();
	}

	
	public void mostrar() {
		frameEquipos.setBackground(Color.white);
		frameEquipos.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameEquipos.getContentPane().setLayout(new BorderLayout());
		frameEquipos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameEquipos.setTitle("Equipos" );
		frameEquipos.setVisible(true);
		
		panel = fondo;
		panel.setLayout(new GridLayout(5, 4));
		crearGrillaDeEquipos();
		
		iniciarBoton();
		frameEquipos.add(btnVolver,BorderLayout.NORTH);
		frameEquipos.add(panel,BorderLayout.CENTER);
	}
	
	public void iniciarBoton() {
		this.btnVolver = new JButton("Volver");
		btnVolver.setBackground(new Color(1.0f, 1.0f, 1.0f, 0));
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnVolver.setBackground(Color.black);
		btnVolver.setBorder(new LineBorder(Color.BLACK, 2, true));
		btnVolver.addActionListener(new ActionListener() {		
					
			public void actionPerformed(ActionEvent e) {
				MainVisual frameMainVisual = new MainVisual();
				frameEquipos.setVisible(false);
				frameMainVisual.initialize();
			
				}
			});	
	}
	
	public void crearGrillaDeEquipos() {
		for (int i = 0; i < controlador.cantEquipos(); i++) {
			JPanel panelEquipo= new JPanel();
			panelEquipo.setLayout(new BorderLayout());
			panelEquipo.setBackground(new Color(1.0f, 1.0f, 1.0f, 0));
			String equipoActual = controlador.getEquipos().get(i);
			panel.add(panelEquipo,BorderLayout.CENTER);
			agregarEquipoAPanel(panelEquipo, equipoActual);
		}
	}
	
	private void agregarEquipoAPanel(JPanel panel, String equipoAAgregar) {
		JLabel equipo = new JLabel(equipoAAgregar,SwingConstants.CENTER);
		equipo.setFont(new Font("Tahoma", Font.ITALIC, 20));
		equipo.setForeground(Color.WHITE);
		panel.add(equipo);
		
	}

}
