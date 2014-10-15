
package com.lw.chartthemes.simple;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.util.JRLoader;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

import java.io.*;



/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: XmlChartTheme.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class XmlChartTheme extends SimpleChartTheme
{
	private static final String MAPPING_FILE = "/chart.theme.mapping.xml";
	
	/**
	 *
	 */
	private String file;
	
	/**
	 *
	 */
	public XmlChartTheme()
	{
	}
	
	/**
	 *
	 */
	public XmlChartTheme(String file)
	{
		this.file = file;
	}
	

	/**
	 *
	 */
	public void setFile(String file)
	{
		this.file = file;
		this.chartThemeSettings = null;
	}
	
	
	/**
	 *
	 */
	public ChartThemeSettings getChartThemeSettings()
	{
		if (chartThemeSettings == null)
		{
			chartThemeSettings = loadSettings(file);
		}
		return chartThemeSettings;
	}
	
	
	/**
	 *
	 */
	public static ChartThemeSettings loadSettings(String file)
	{
		InputStream is = null; 
		
		try
		{
			is = JRLoader.getLocationInputStream(file);
			return loadSettings(is);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
		finally
		{
			if (is != null)
			{
				try
				{
					is.close();
				}
				catch(IOException e)
				{
				}
			}
		}
	}
	
	
	/**
	 *
	 */
	public static ChartThemeSettings loadSettings(InputStream is)
	{
		ChartThemeSettings settings = null;
		
		InputStream mis = null;
		
		try
		{
			mis = JRLoader.getLocationInputStream(MAPPING_FILE);

			Mapping mapping = new Mapping();
			mapping.loadMapping(
				new InputSource(mis)
				);
			
			Unmarshaller unmarshaller = new Unmarshaller(mapping);
			settings = 
				(ChartThemeSettings)unmarshaller.unmarshal(
					new InputSource(is)
				);
		}
		catch (MappingException e)
		{
			throw new JRRuntimeException(e);
		}
		catch (MarshalException e)
		{
			throw new JRRuntimeException(e);
		}
		catch (ValidationException e)
		{
			throw new JRRuntimeException(e);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
		finally
		{
			if (mis != null)
			{
				try
				{
					mis.close();
				}
				catch(IOException e)
				{
				}
			}
		}
		
		return settings;
	}
	
	
	/**
	 *
	 */
	public static void saveSettings(ChartThemeSettings settings, Writer writer)
	{
		InputStream mis = null;
		
		try
		{
			mis = JRLoader.getLocationInputStream(MAPPING_FILE);

			Marshaller marshaller = new Marshaller(writer);

			Mapping mapping = new Mapping();
			mapping.loadMapping(
				new InputSource(mis)
				);
			marshaller.setMapping(mapping);

			marshaller.marshal(settings);
		}
		catch (IOException e)
		{
			throw new JRRuntimeException(e);
		}
		catch (MappingException e)
		{
			throw new JRRuntimeException(e);
		}
		catch (MarshalException e)
		{
			throw new JRRuntimeException(e);
		}
		catch (ValidationException e)
		{
			throw new JRRuntimeException(e);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
		finally
		{
			if (mis != null)
			{
				try
				{
					mis.close();
				}
				catch(IOException e)
				{
				}
			}
		}
	}
	

	/**
	 *
	 */
	public static void saveSettings(ChartThemeSettings settings, File file)
	{
		Writer writer = null;
		
		try
		{
			writer = new FileWriter(file);
			saveSettings(settings, writer);
		}
		catch (IOException e)
		{
			throw new JRRuntimeException(e);
		}
		finally
		{
			if (writer != null)
			{
				try
				{
					writer.close();
				}
				catch(IOException e)
				{
				}
			}
		}
	}
	

	/**
	 *
	 */
	public static String saveSettings(ChartThemeSettings settings)
	{
		StringWriter writer = new StringWriter();
		
		try
		{
			saveSettings(settings, writer);
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch(IOException e)
			{
			}
		}
		
		return writer.toString();
	}

}
