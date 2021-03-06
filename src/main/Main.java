package main;

import java.awt.EventQueue;
import javax.swing.UIManager;
import visual.MainVisual;

public class Main {

public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) 
		{}
		
		EventQueue.invokeLater(new Runnable() {
			
			//Creamos lo visual
			MainVisual ventana = new MainVisual();
			
			public void run() {
				try {
					ventana.initialize();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
