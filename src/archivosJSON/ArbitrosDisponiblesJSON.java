package archivosJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import instancias.Fecha;
import instancias.Torneo;


public class ArbitrosDisponiblesJSON {

private HashMap<Fecha, ArrayList<Integer>> arbitrosDisponibles;
	
	public ArbitrosDisponiblesJSON(Torneo torneo) {
		this.arbitrosDisponibles = torneo.getArbitrosDisponibles();
	}
	
	public HashMap<Fecha, ArrayList<Integer>> dame(){
		return arbitrosDisponibles;
	}
	
	private String generarJSONPretty()
	{//Habilitamos la serializacion de la clave del map
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().setPrettyPrinting().create();
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
	
	
	public static ArbitrosDisponiblesJSON leerJSON(String archivo)
	{
		Gson gson = new Gson();
		ArbitrosDisponiblesJSON ret = null;
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, ArbitrosDisponiblesJSON.class);
		} 
		catch (IOException e){
			
			e.printStackTrace();
		}
		
		return ret;
	}
}
