
package com.lw.chartthemes.simple.handlers;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.jfree.ui.VerticalAlignment;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: VerticalAlignmentFieldHandler.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class VerticalAlignmentFieldHandler extends GeneralizedFieldHandler
{
	/**
	 *
	 */
	public VerticalAlignmentFieldHandler()
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
		return ((VerticalAlignment)value).toString();
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
			VerticalAlignment.TOP.toString().equals(value) 
			? VerticalAlignment.TOP 
			: VerticalAlignment.CENTER.toString().equals(value)
			? VerticalAlignment.CENTER
			: VerticalAlignment.BOTTOM.toString().equals(value)
			? VerticalAlignment.BOTTOM : null;
	}
	
	/**
	 *
	 */
	public Class<?> getFieldType()
	{
		return VerticalAlignment.class;
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
