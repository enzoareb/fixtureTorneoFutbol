package archivosJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NombresArbitrosJSON {
	ArrayList<String> nombresArbitros;
	
	public NombresArbitrosJSON() {
		this.nombresArbitros = new ArrayList<String>();
	}
	
	public void agregarNombre(String nombre) {
		nombresArbitros.add(nombre);
	}
	
	public ArrayList<String> dame() {
		return nombresArbitros;
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
	
	public static NombresArbitrosJSON leerJSON(String archivo)
	{
		Gson gson = new Gson();
		 NombresArbitrosJSON ret = null;
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br,  NombresArbitrosJSON.class);
		} 
		catch (IOException e){
			
			e.printStackTrace();
		}
		return ret;
	}
}
