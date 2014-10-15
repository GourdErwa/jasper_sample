
package com.lw.chartthemes.simple.handlers;

import java.awt.Color;

import net.sf.jasperreports.engine.util.JRColorUtil;

import org.exolab.castor.mapping.GeneralizedFieldHandler;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: ColorFieldHandler.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class ColorFieldHandler extends GeneralizedFieldHandler
{
	/**
	 *
	 */
	public ColorFieldHandler()
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
		return "#" + JRColorUtil.getColorHexa((Color)value);
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
		return JRColorUtil.getColor((String)value, null);
	}
	
	/**
	 *
	 */
	public Class<?> getFieldType()
	{
		return Color.class;
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
