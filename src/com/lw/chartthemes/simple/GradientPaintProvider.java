
package com.lw.chartthemes.simple;

import net.sf.jasperreports.engine.JRConstants;

import java.awt.*;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: GradientPaintProvider.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class GradientPaintProvider implements PaintProvider
{
	/**
	 * 
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	/**
	 *
	 */
	private Color color1;
	private Color color2;

	
	/**
	 *
	 */
	public GradientPaintProvider()
	{
	}
	
	
	/**
	 *
	 */
	public GradientPaintProvider(Color color1, Color color2)
	{
		this.color1 = color1;
		this.color2 = color2;
	}
	
	
	/**
	 *
	 */
	public Paint getPaint()
	{
		return new GradientPaint(0, 0, color1, 0, 0, color2);
	}


	public Color getColor1() {
		return color1;
	}


	public void setColor1(Color color1) {
		this.color1 = color1;
	}


	public Color getColor2() {
		return color2;
	}


	public void setColor2(Color color2) {
		this.color2 = color2;
	}

}
