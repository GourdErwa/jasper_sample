
package com.lw.chartthemes.simple;

import java.awt.Paint;
import java.io.Serializable;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PaintProvider.java 7199 2014-08-27 13:58:10Z teodord $
 */
public interface PaintProvider extends Serializable
{

	/**
	 *
	 */
	public Paint getPaint();

}
