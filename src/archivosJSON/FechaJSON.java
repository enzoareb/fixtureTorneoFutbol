package archivosJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import instancias.Fecha;

public class FechaJSON {

	private ArrayList<Fecha> fechasJson;
	
	public FechaJSON() {
		this.fechasJson = new ArrayList<Fecha>();
	}
	
	public ArrayList<Fecha> dame() {
		return fechasJson;
	}
	
	public void agregarAFechasJson(Fecha fecha) {
		fechasJson.add(fecha);
	}
	
	public ArrayList<Fecha> fechasJson(){
		return fechasJson;
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
	
	
	public static FechaJSON leerJSON(String archivo)
	{
		Gson gson = new Gson();
		FechaJSON ret = null;
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, FechaJSON.class);
		} 
		catch (IOException e){
			
			e.printStackTrace();
		}
		
		return ret;
	}
}
