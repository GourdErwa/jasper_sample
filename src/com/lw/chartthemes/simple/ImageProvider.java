
package com.lw.chartthemes.simple;

import net.sf.jasperreports.engine.JasperReportsContext;

import java.awt.*;
import java.io.Serializable;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: ImageProvider.java 7199 2014-08-27 13:58:10Z teodord $
 */
public interface ImageProvider extends Serializable
{

	/**
	 *
	 */
	public Image getImage(JasperReportsContext jasperReportsContext);

}
