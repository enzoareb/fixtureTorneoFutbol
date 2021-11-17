package archivosJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import instancias.Torneo;


public class ArbitrajesEquiposJSON {
private int[][] arbitrajesEquiposJson;
	
	public ArbitrajesEquiposJSON(Torneo torneo) {
		
		this.arbitrajesEquiposJson = torneo.getArbitrajesPorEquipo();
	}
	
	public int[][] dame() {
		return arbitrajesEquiposJson;
	}
	
	
	private String generarJSONPretty()
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		
		return json;
	}
	
	public void generarJSON(String archivo)
	{
		String json = this.generarJSONPretty();
		
		try{
			FileWriter writer = new FileWriter(archivo);
			writer.write(json);
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static ArbitrajesEquiposJSON leerJSON(String archivo)
	{
		Gson gson = new Gson();
		ArbitrajesEquiposJSON ret = null;
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, ArbitrajesEquiposJSON.class);
		} 
		catch (IOException e){
			
			e.printStackTrace();
		}
		
		return ret;
	}
}
