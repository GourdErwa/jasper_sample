
package com.lw.chartthemes.simple;

import com.lw.chartthemes.ChartThemeMapBundle;
import net.sf.jasperreports.charts.ChartTheme;
import net.sf.jasperreports.engine.JRPropertiesMap;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JRPropertiesUtil.PropertySuffix;
import net.sf.jasperreports.extensions.DefaultExtensionsRegistry;
import net.sf.jasperreports.extensions.ExtensionsRegistry;
import net.sf.jasperreports.extensions.ExtensionsRegistryFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Lucian Chirita (lucianc@users.sourceforge.net)
 * @version $Id: XmlChartThemeExtensionsRegistryFactory.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class XmlChartThemeExtensionsRegistryFactory implements
		ExtensionsRegistryFactory
{

	/**
	 * 
	 */
	public final static String XML_CHART_THEME_PROPERTY_PREFIX = 
		JRPropertiesUtil.PROPERTY_PREFIX + "xml.chart.theme.";
	public final static String PROPERTY_XML_CHART_THEME_REGISTRY_FACTORY =
		DefaultExtensionsRegistry.PROPERTY_REGISTRY_FACTORY_PREFIX + "xml.chart.themes";
	
	/**
	 * 
	 */
	public ExtensionsRegistry createRegistry(String registryId,
			JRPropertiesMap properties)
	{
		List<PropertySuffix> themeProperties = JRPropertiesUtil.getProperties(properties, 
				XML_CHART_THEME_PROPERTY_PREFIX);
		Map<String, ChartTheme> themes = new HashMap<String, ChartTheme>();
		for (Iterator<PropertySuffix> it = themeProperties.iterator(); it.hasNext();)
		{
			PropertySuffix themeProp = it.next();
			String themeName = themeProp.getSuffix();
			String themeLocation = themeProp.getValue();
			XmlChartTheme theme = new XmlChartTheme(themeLocation);
			themes.put(themeName, theme);
		}
		
		ChartThemeMapBundle bundle = new ChartThemeMapBundle();
		bundle.setThemes(themes);
		return new ChartThemeBundlesExtensionsRegistry(bundle);
	}

	/**
	 * 
	 */
	public static void saveToJar(ChartThemeSettings settings, String themeName, File file) throws IOException
	{
		FileOutputStream fos = null;

		try
		{
			fos = new FileOutputStream(file);
			ZipOutputStream zipos = new ZipOutputStream(fos);
			zipos.setMethod(ZipOutputStream.DEFLATED);
			
			ZipEntry propsEntry = new ZipEntry("jasperreports_extension.properties");
			zipos.putNextEntry(propsEntry);
			Properties props = new Properties();
			props.put(PROPERTY_XML_CHART_THEME_REGISTRY_FACTORY, XmlChartThemeExtensionsRegistryFactory.class.getName());
			props.put(XML_CHART_THEME_PROPERTY_PREFIX + themeName, themeName + ".jrctx");
			props.store(zipos, null);

			ZipEntry jrctxEntry = new ZipEntry(themeName + ".jrctx");
			zipos.putNextEntry(jrctxEntry);
			XmlChartTheme.saveSettings(settings, new OutputStreamWriter(zipos));

			zipos.flush();
			zipos.finish();
		}
		finally
		{
			if (fos != null)
			{
				try
				{
					fos.close();
				}
				catch (IOException e)
				{
				}
			}
		}
	}

}
