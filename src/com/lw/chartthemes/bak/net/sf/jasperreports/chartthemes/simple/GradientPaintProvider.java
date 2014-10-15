/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package com.lw.chartthemes.bak.net.sf.jasperreports.chartthemes.simple;

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
