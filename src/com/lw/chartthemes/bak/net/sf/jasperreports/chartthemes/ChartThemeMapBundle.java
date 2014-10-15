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
package com.lw.chartthemes.bak.net.sf.jasperreports.chartthemes;

import net.sf.jasperreports.charts.ChartTheme;
import net.sf.jasperreports.charts.ChartThemeBundle;

import java.util.Map;

/**
 * @author Lucian Chirita (lucianc@users.sourceforge.net) 
 * @version $Id: ChartThemeMapBundle.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class ChartThemeMapBundle implements ChartThemeBundle
{

	private Map<String, ChartTheme> themes;
	
	public ChartTheme getChartTheme(String themeName)
	{
		return themes.get(themeName);
	}

	public String[] getChartThemeNames()
	{
		return themes.keySet().toArray(new String[themes.size()]);
	}

	/**
	 * @return the themes
	 */
	public Map<String, ChartTheme> getThemes()
	{
		return themes;
	}

	/**
	 * @param themes the themes to set
	 */
	public void setThemes(Map<String, ChartTheme> themes)
	{
		this.themes = themes;
	}

}
