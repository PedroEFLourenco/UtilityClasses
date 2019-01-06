package utils;

import java.util.Optional;


public class NullSaver 
{


/**
 * 
 * @param possiblyNullObject
 * @return
 */
	public static <T> boolean verifyExistance( T possiblyNullObject)
	{
		return Optional.ofNullable(possiblyNullObject).isPresent();
	}
	
	/**
	 * 
	 * @param possiblyNullObject - Object which existence is to be validated
	 * @param classOfObject - Class of the possiblyNullObject argument
	 * 
	 *  * This method validates the existence of the possiblyNullObject argument and tries to avoid returning a null object. 
	 * 
	 * That being said, it will return a null object if:
	 * - possiblyNullObject is not present and T has no default constructor or its definition out of reach.
	 * 
	 * 
	 * Ideally this method returns either:
	 * - The same as possiblyNullObject, if it is not null.
	 * - A new instance of the T class.
	 * 
	 * @return possiblyNullObject if it is not null, a new instance of classOfObject if possiblyNullObject is null, null if 
	 * it fails to instantiate classOfObject.
	 */
	public static <T> T avoidNullObject( T possiblyNullObject, Class<T> classOfObject)
	{
		T toReturn = null;
		
		if (!Optional.ofNullable(possiblyNullObject).isPresent())
		{
			try {
				toReturn = classOfObject.newInstance();
			} 
			catch (InstantiationException e) 
			{	
				System.err.println("Issues with instantiaton of a new Object for class " + classOfObject.toString());
			} 
			catch (IllegalAccessException e) 
			{
				System.err.println("Issues with reaching the definition of class " + classOfObject.toString());
			}
		}
		else 
		{
			toReturn = possiblyNullObject;
		}
		
		return toReturn;
	}
	
	
}
