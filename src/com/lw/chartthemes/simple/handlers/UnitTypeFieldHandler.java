
package com.lw.chartthemes.simple.handlers;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.jfree.util.UnitType;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: UnitTypeFieldHandler.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class UnitTypeFieldHandler extends GeneralizedFieldHandler
{
	/**
	 *
	 */
	public UnitTypeFieldHandler()
	{
		super();
	}
	
	/**
	 *
	 */
	public Object convertUponGet(Object value)
	{
		if (value == null)
		{
			return null;
		}
		return ((UnitType)value).toString();
	}

	/**
	 *
	 */
	public Object convertUponSet(Object value)
	{
		if (value == null)
		{
			return null;
		}
		return 
			UnitType.RELATIVE.toString().equals(value) 
			? UnitType.RELATIVE 
			: UnitType.ABSOLUTE.toString().equals(value)
			? UnitType.ABSOLUTE : null;
	}
	
	/**
	 *
	 */
	public Class<?> getFieldType()
	{
		return UnitType.class;
	}

	/**
	 *
	 */
	public Object newInstance(Object parent) throws IllegalStateException
	{
		//-- Since it's marked as a string...just return null,
		//-- it's not needed.
		return null;
	}
}
