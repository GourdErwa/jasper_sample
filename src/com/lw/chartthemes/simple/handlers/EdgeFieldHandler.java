
package com.lw.chartthemes.simple.handlers;

import net.sf.jasperreports.charts.type.EdgeEnum;

import org.exolab.castor.mapping.GeneralizedFieldHandler;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: EdgeFieldHandler.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class EdgeFieldHandler extends GeneralizedFieldHandler
{
	/**
	 *
	 */
	public EdgeFieldHandler()
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
//		return JRXmlConstants.getChartEdgeMap().get(value);
//		return EdgeEnum.getByName((String)value);
		return ((EdgeEnum)value).getName();
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
//		return JRXmlConstants.getChartEdgeMap().get(value);
		return EdgeEnum.getByName((String)value);
	}
	
	/**
	 *
	 */
	public Class<?> getFieldType()
	{
		return EdgeEnum.class;
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
