package archivosJSON;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import instancias.Arbitro;
import java.util.ArrayList;

public class ArbitroJSON {

private ArrayList<Arbitro> arbitrosJson;
	
	public ArbitroJSON() {
		this.arbitrosJson = new ArrayList<Arbitro>();
	}
	
	public ArrayList<Arbitro> dame() {
		return arbitrosJson;
	}
	
	public void agregarAArbitrosJson(Arbitro arbitro) {
		arbitrosJson.add(arbitro);
	}
	
	public ArrayList<Arbitro> arbitroJson(){
		return arbitrosJson;
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
	
	
	public static ArbitroJSON leerJSON(String archivo)
	{
		Gson gson = new Gson();
		ArbitroJSON ret = null;
		
		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, ArbitroJSON.class);
		} 
		catch (IOException e){
			
			e.printStackTrace();
		}
		
		return ret;
	}
}
