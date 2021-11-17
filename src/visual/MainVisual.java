package visual;


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import visual.MainVisual;
import java.awt.SystemColor;

public class MainVisual {

	private JFrame frameMenuPrincipal;
	
	private VentanaFixture fixtureVisual;
	private VentanaEquipos ventanaEquipos;
	private VentanaArbitros ventanaArbitros;
	private Fondo fondo;
	
	private JLabel lblTorneoJLabel;
	
	private JButton jButtonverFixture;
	private JButton jButtonverEquipos;
	private JButton jButtonverArbitros;
	
	
	
	public MainVisual() {
		this.fondo= new Fondo();
		this.fixtureVisual = new VentanaFixture();
		this.ventanaEquipos = new VentanaEquipos();
		this.ventanaArbitros = new VentanaArbitros();
	}
	
	
	
	
		public void initialize() {
			mostrarPantallaPrincipal();

	
		}

	public void mostrarPantallaPrincipal() {
		frameMenuPrincipal= new JFrame();
		frameMenuPrincipal.setContentPane(fondo);
		frameMenuPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frameMenuPrincipal.getContentPane().setLayout(null);
		frameMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenuPrincipal.setTitle("Torneo football 2021" );
		frameMenuPrincipal.setVisible(true);
		
		
	
		/*------------Boton para ver fixture--------------------*/
		jButtonverFixture= new JButton("Ver fixture");
		jButtonverFixture.setBackground(new Color(0, 0, 0));
		jButtonverFixture.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jButtonverFixture.setBounds(0,0, 300, 80);
		jButtonverFixture.setLocation((frameMenuPrincipal.getWidth()/2-jButtonverFixture.getWidth()/2),
									(frameMenuPrincipal.getHeight()/2 + jButtonverFixture.getHeight()/2) + 100 );
		
		
		jButtonverFixture.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
			
				frameMenuPrincipal.setVisible(false);
				mostrarFixture();
				}
			});
	
		/*------------Boton para ver equipos--------------------*/
		jButtonverEquipos= new JButton("Ver equipos");
		jButtonverEquipos.setBackground(new Color(0, 0, 0));
		jButtonverEquipos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jButtonverEquipos.setBounds(0,0, 300, 80);
		jButtonverEquipos.setLocation((frameMenuPrincipal.getWidth()/2-jButtonverEquipos.getWidth()/2) - 500,
									(frameMenuPrincipal.getHeight()/2 + jButtonverEquipos.getHeight()/2) + 100 );
		
		jButtonverEquipos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				frameMenuPrincipal.setVisible(false);
				mostrarEquipos();
				}
			});
		
		/*------------Boton para ver Arbitros--------------------*/
		jButtonverArbitros= new JButton("Ver arbitros");
		jButtonverArbitros.setBackground(new Color(0, 0, 0));
		jButtonverArbitros.setFont(new Font("Tahoma", Font.PLAIN, 25));
		jButtonverArbitros.setBounds(0,0, 300, 80);
		jButtonverArbitros.setLocation((frameMenuPrincipal.getWidth()/2-jButtonverArbitros.getWidth()/2) + 500,
									(frameMenuPrincipal.getHeight()/2 + jButtonverArbitros.getHeight()/2) + 100 );
		
		jButtonverArbitros.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				frameMenuPrincipal.setVisible(false);
				mostrarArbitros();
				}
			});
		
		lblTorneoJLabel = new JLabel("Torneo Fuchiball 2021");
		lblTorneoJLabel.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		lblTorneoJLabel.setForeground(SystemColor.textHighlightText);
		lblTorneoJLabel.setBounds(0, 0, 1000, 150);
		
		lblTorneoJLabel.setLocation((frameMenuPrincipal.getWidth()/2-jButtonverFixture.getWidth()/2) -90,
									(frameMenuPrincipal.getHeight()/2 + jButtonverFixture.getHeight()/2) -300);
		
		/*--------------------Agrego botones al frame-----------------------------*/
		frameMenuPrincipal.getContentPane().add(jButtonverFixture);
		frameMenuPrincipal.getContentPane().add(jButtonverEquipos);
		frameMenuPrincipal.getContentPane().add(jButtonverArbitros);
		fondo.add(lblTorneoJLabel);
	}
	
	public void mostrarFixture() {
		fixtureVisual.mostrar();			
	}
	
	public void mostrarEquipos() {
		ventanaEquipos.mostrar();
	}
	
	
	public void mostrarArbitros() {
		ventanaArbitros.mostrar();
	}

	
}
