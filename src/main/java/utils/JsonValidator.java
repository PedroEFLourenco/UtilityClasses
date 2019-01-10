package utils;

import org.json.*;

public class JsonValidator
{

	public static boolean isValidJSON(String test) 
	{
		try 
		{
			new JSONObject(test);
		} 
		catch (JSONException ex) 
		{
			try 
			{
				new JSONArray(test);
			} 
			catch (JSONException ex1) 
			{
				return false;
			}
		}
		return true;
	}

}
