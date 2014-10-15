
package com.lw.chartthemes.simple.handlers;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.jfree.ui.HorizontalAlignment;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: HorizontalAlignmentFieldHandler.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class HorizontalAlignmentFieldHandler extends GeneralizedFieldHandler
{
	/**
	 *
	 */
	public HorizontalAlignmentFieldHandler()
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
		return ((HorizontalAlignment)value).toString();
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
			HorizontalAlignment.LEFT.toString().equals(value) 
			? HorizontalAlignment.LEFT 
			: HorizontalAlignment.CENTER.toString().equals(value)
			? HorizontalAlignment.CENTER
			: HorizontalAlignment.RIGHT.toString().equals(value)
			? HorizontalAlignment.RIGHT : null;
	}
	
	/**
	 *
	 */
	public Class<?> getFieldType()
	{
		return HorizontalAlignment.class;
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
