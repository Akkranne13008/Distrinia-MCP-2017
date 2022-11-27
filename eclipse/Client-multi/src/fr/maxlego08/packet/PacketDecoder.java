package fr.maxlego08.packet;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class PacketDecoder {

	   private static PacketDecoder instance = new PacketDecoder();

	    private Gson gson = new GsonBuilder().create();

	    private Type mapType = new TypeToken<Map<String, Object>>() {

	    }.getType();

	    private Map<String, Object> descriptions = new HashMap();

	    public static PacketDecoder getInstance() {

	        return instance;
	    }

	    public Map<String, Object> getDescriptions() {

	        return this.descriptions;
	    }

	    public void setContent(Map<String, Object> descriptions) {

	        this.descriptions = descriptions;
	    }


	    public Gson getGson() {

	        return this.gson;
	    }

	    public Type getMapType() {

	        return this.mapType;
	    }

	    public String getValue(String entityName) {       
	        return String.valueOf(this.descriptions.get(entityName));
	    }
	    
	    /*
	     * All Getter
	     * */
	    
	    public Map<String, String> getMapString(){
	    	Map<String, String> map = new HashMap();
	    	for(Entry<String, Object> entry : descriptions.entrySet()){
	    		map.put(entry.getKey(), (String)entry.getValue());
	    	}
	    	return map;
	    }
	    
	    public String getString(String string){
	    	return getValue(string);
	    }
	    
	    public int getInt(String string){
	    	try {
	    		return Integer.parseInt(getValue(string));
	    	}catch (Exception e) { }
			throw new IllegalArgumentException("Le string '" + getValue(string) + "' n'est pas un int !");
	    }  
	    
	    public double getDouble(String string){
	    	try {
	    		return Double.parseDouble(getValue(string));
	    	}catch (Exception e) { }
	    	throw new IllegalArgumentException("Le string '" + getValue(string) + "' n'est pas un double !");
	    }
	    
	    public long getLong(String string){
	    	try {
	    		return Long.parseLong(getValue(string));
	    	}catch (Exception e) { }
	    	throw new IllegalArgumentException("Le string '" + getValue(string) + "' n'est pas un long !");
	    }
	    
	    public float getFloat(String string){
	    	try {
	    		return Float.parseFloat(getValue(string));
	    	}catch (Exception e) { }
	    	throw new IllegalArgumentException("Le string '" + getValue(string) + "' n'est pas un float !");
	    }
	    
	    public boolean getBoolean(String string){
	    	try {
	    		return Boolean.parseBoolean(getValue(string));
	    	}catch (Exception e) { }
	    	throw new IllegalArgumentException("Le string '" + getValue(string) + "' n'est pas un boolean !");
	    }
	
}
