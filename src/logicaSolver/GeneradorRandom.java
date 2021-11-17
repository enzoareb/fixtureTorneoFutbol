package logicaSolver;

import java.util.Random;

public class GeneradorRandom implements Generador{
	private Random random;
	
	public GeneradorRandom() {
		random = new Random();
	}
	
	@Override
	public int nextInt(int rango) {
		return random.nextInt(rango);
	}

}
