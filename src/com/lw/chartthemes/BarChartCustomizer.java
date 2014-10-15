package com.lw.chartthemes;
import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRChartCustomizer;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.category.BarRenderer;

import java.awt.*;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: BarChartCustomizer.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class BarChartCustomizer implements JRChartCustomizer
{

	public void customize(JFreeChart chart, JRChart jasperChart)
	{
		BarRenderer renderer = (BarRenderer) chart.getCategoryPlot().getRenderer();
		renderer.setSeriesPaint(0, Color.green);
		renderer.setSeriesPaint(1, Color.orange);
	}
}