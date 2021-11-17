package visual;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel{
	private static final long serialVersionUID = 1L;
	private Image imagenImage;
	@Override
	public void paint(Graphics g) {
		imagenImage = new ImageIcon(getClass().getResource("/imagenes/estadio.jpg")).getImage();
		g.drawImage(imagenImage, 0, 0, getWidth(), getHeight(), this);
		//desctivamos fondo por defecto
		setOpaque(false);
		//dibuja los elementos sobre el fondo
		super.paint(g);
	}
}
