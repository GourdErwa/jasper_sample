
package com.lw.chartthemes.simple;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.charts.ChartThemeBundle;
import net.sf.jasperreports.extensions.ExtensionsRegistry;

/**
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: ChartThemeBundlesExtensionsRegistry.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class ChartThemeBundlesExtensionsRegistry implements ExtensionsRegistry
{

	private final List<ChartThemeBundle> chartThemeBundles;
	
	public ChartThemeBundlesExtensionsRegistry(List<ChartThemeBundle> chartThemeBundles)
	{
		this.chartThemeBundles = chartThemeBundles;
	}
	
	public ChartThemeBundlesExtensionsRegistry(ChartThemeBundle chartThemeBundle)
	{
		this.chartThemeBundles = new ArrayList<ChartThemeBundle>(1);
		this.chartThemeBundles.add(chartThemeBundle);
	}
	
	public <T> List<T> getExtensions(Class<T> extensionType)
	{
		if (ChartThemeBundle.class.equals(extensionType)) 
		{
			@SuppressWarnings("unchecked")
			List<T> extensions = (List<T>)chartThemeBundles;
			return extensions;
		}
		return null;
	}

}
