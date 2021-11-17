package archivosJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import instancias.Equipo;

public class EquipoJSON {
	private ArrayList<Equipo> equiposJson;
	
	public EquipoJSON() {
		this.equiposJson = new ArrayList<Equipo>();
	}
	
	public ArrayList<Equipo> dame() {
		return equiposJson;
	}
	
	public void agregarAEquiposJson(Equipo equipo) {
		equiposJson.add(equipo);
	}
	
	public ArrayList<Equipo> equiposJson(){
		return equiposJson;
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
	
	
	public static EquipoJSON leerJSON(String archivo)
	{
		Gson gson = new Gson();
		EquipoJSON ret = null;
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, EquipoJSON.class);
		} 
		catch (IOException e){
			
			e.printStackTrace();
		}
		
		return ret;
	}
}
