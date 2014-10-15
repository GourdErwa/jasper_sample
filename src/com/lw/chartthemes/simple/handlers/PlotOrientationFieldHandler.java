
package com.lw.chartthemes.simple.handlers;

import org.exolab.castor.mapping.GeneralizedFieldHandler;
import org.jfree.chart.plot.PlotOrientation;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PlotOrientationFieldHandler.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class PlotOrientationFieldHandler extends GeneralizedFieldHandler
{
	/**
	 *
	 */
	public PlotOrientationFieldHandler()
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
		return ((PlotOrientation)value).toString();
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
			PlotOrientation.HORIZONTAL.toString().equals(value) 
			? PlotOrientation.HORIZONTAL 
			: PlotOrientation.VERTICAL.toString().equals(value)
			? PlotOrientation.VERTICAL : null;
	}
	
	/**
	 *
	 */
	public Class<?> getFieldType()
	{
		return PlotOrientation.class;
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
