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


public class VentanaArbitros {
	private JFrame frameArbitros;
	private JPanel panel;
	private Controlador controlador;
	private JButton btnVolver;
	private FondoArbitros fondo;
	
	public VentanaArbitros() {
		this.fondo = new FondoArbitros();
		this.controlador = new Controlador();
		this.frameArbitros = new JFrame();
		this.panel = new JPanel();
	}
	
	
	public void mostrar() {
		frameArbitros.setBackground(Color.white);
		frameArbitros.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameArbitros.getContentPane().setLayout(new BorderLayout());
		frameArbitros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameArbitros.setTitle("Equipos" );
		frameArbitros.setVisible(true);
		
		panel = fondo;
		panel.setBounds(0, 0, frameArbitros.getWidth(), frameArbitros.getHeight());
		panel.setLayout(new GridLayout(5, 4));
		crearGrillaDeArbitros();
		
		iniciarBoton();
		frameArbitros.add(btnVolver,BorderLayout.NORTH);
		frameArbitros.add(panel,BorderLayout.CENTER);
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
				frameArbitros.setVisible(false);
				frameMainVisual.initialize();
			
				}
			});	
	}

	public void crearGrillaDeArbitros() {
		for (int i = 0; i < controlador.cantArbitros(); i++) {
			JPanel panelArbitro= new JPanel();
			panelArbitro.setLayout(new BorderLayout());
			panelArbitro.setBackground(new Color(1.0f, 1.0f, 1.0f, 0));
			String arbitroActual = controlador.getArbitros().get(i);
			panel.add(panelArbitro,BorderLayout.CENTER);
			agregarArbitroAPanel(panelArbitro, arbitroActual);
		}
		
	}

	private void agregarArbitroAPanel(JPanel panel, String arbitroAAgregar) {
		JLabel arbitro = new JLabel(arbitroAAgregar,SwingConstants.CENTER);
		arbitro.setFont(new Font("Tahoma", Font.BOLD, 25));
		arbitro.setForeground(Color.WHITE);
		panel.add(arbitro);
		
	}
}
