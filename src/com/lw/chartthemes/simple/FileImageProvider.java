
package com.lw.chartthemes.simple;

import java.awt.Image;

import net.sf.jasperreports.engine.JRConstants;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.util.JRImageLoader;
import net.sf.jasperreports.repo.RepositoryUtil;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: FileImageProvider.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class FileImageProvider implements ImageProvider
{
	/**
	 * 
	 */
	private static final long serialVersionUID = JRConstants.SERIAL_VERSION_UID;

	/**
	 *
	 */
	private String file;

	
	/**
	 *
	 */
	public FileImageProvider()
	{
	}
	
	
	/**
	 *
	 */
	public FileImageProvider(String file)
	{
		this.file = file;
	}
	
	
	/**
	 *
	 */
	public Image getImage(JasperReportsContext jasperReportsContext)
	{
		try
		{
			return
				JRImageLoader.getInstance(jasperReportsContext).loadAwtImageFromBytes(
					RepositoryUtil.getInstance(jasperReportsContext).getBytesFromLocation(file)
					);
		}
		catch (JRException e)
		{
			throw new JRRuntimeException(e);
		}
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}

}
