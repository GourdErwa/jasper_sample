
package com.lw.chartthemes.simple.handlers;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.jfree.chart.axis.AxisLocation;


/**
 * @author sanda zaharia (shertage@users.sourceforge.net)
 * @version $Id: AxisLocationHandler.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class AxisLocationHandler extends GeneralizedFieldHandler
{
	/**
	 *
	 */
	public AxisLocationHandler()
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
		return ((AxisLocation)value).toString();
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
		AxisLocation.BOTTOM_OR_LEFT.toString().equals(value) 
		? AxisLocation.BOTTOM_OR_LEFT 
		: AxisLocation.BOTTOM_OR_RIGHT.toString().equals(value)
		? AxisLocation.BOTTOM_OR_RIGHT
		: AxisLocation.TOP_OR_LEFT.toString().equals(value)
		? AxisLocation.TOP_OR_LEFT
		: AxisLocation.TOP_OR_RIGHT.toString().equals(value)
		? AxisLocation.TOP_OR_RIGHT : null;
	}
	
	/**
	 *
	 */
	public Class<?> getFieldType()
	{
		return AxisLocation.class;
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
