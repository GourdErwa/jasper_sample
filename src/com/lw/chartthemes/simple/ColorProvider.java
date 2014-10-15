
package com.lw.chartthemes.simple;

import java.awt.Color;
import java.awt.Paint;

import net.sf.jasperreports.engine.JRConstants;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: ColorProvider.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class ColorProvider implements PaintProvider
{
	/**
	 * 
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	/**
	 *
	 */
	private Color color;

	
	/**
	 *
	 */
	public ColorProvider()
	{
	}
	
	
	/**
	 *
	 */
	public ColorProvider(Color color)
	{
		this.color = color;
	}
	
	
	/**
	 *
	 */
	public Paint getPaint()
	{
		return color;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}

}
