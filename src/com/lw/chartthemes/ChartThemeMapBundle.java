
package com.lw.chartthemes;

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
