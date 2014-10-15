
package com.lw.chartthemes.simple;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: EyeCandySixtiesSettingsFactory.java 7199 2014-08-27 13:58:10Z teodord $
 */
public class EyeCandySixtiesSettingsFactory extends SimpleSettingsFactory
{


	/**
	 *
	 *
	public static final ChartThemeSettings createChartThemeSettings()
	{
		ChartThemeSettings settings = new ChartThemeSettings();

		ChartSettings chartSettings = settings.getChartSettings();
		chartSettings.getFont().setBold(Boolean.TRUE);
		chartSettings.setBackgroundPaint(new GradientPaintProvider(10, 20, Color.green, 30, 40, Color.blue));
		//chartSettings.setBackgroundPaint(new ColorProvider(Color.red));
		chartSettings.setBorderVisible(Boolean.TRUE);
		chartSettings.setAntiAlias(Boolean.TRUE);
		chartSettings.setUnitType(UnitType.ABSOLUTE);
		chartSettings.setPadding(new Double(12.34));

		TitleSettings titleSettings = settings.getTitleSettings();
		titleSettings.setShowTitle(Boolean.TRUE);
		titleSettings.setPosition(new Byte(JRChart.EDGE_TOP));
		titleSettings.setForegroundPaint(new ColorProvider(Color.black));
		titleSettings.setBackgroundPaint(new GradientPaintProvider(10, 20, Color.green, 30, 40, Color.blue));
		titleSettings.getFont().setBold(Boolean.TRUE);
		
		TitleSettings subtitleSettings = settings.getSubtitleSettings();
		subtitleSettings.setShowTitle(Boolean.TRUE);
		subtitleSettings.setPosition(new Byte(JRChart.EDGE_TOP));
		subtitleSettings.setForegroundPaint(new ColorProvider(Color.black));
		subtitleSettings.setBackgroundPaint(new GradientPaintProvider(10, 20, Color.green, 30, 40, Color.blue));
		subtitleSettings.getFont().setBold(Boolean.TRUE);

		LegendSettings legendSettings = settings.getLegendSettings();
		legendSettings.setShowLegend(Boolean.TRUE);
		legendSettings.setPosition(new Byte(JRChart.EDGE_BOTTOM));
		legendSettings.setForegroundPaint(new ColorProvider(Color.black));
		legendSettings.setBackgroundPaint(new GradientPaintProvider(10, 20, Color.green, 30, 40, Color.blue));
		legendSettings.getFont().setBold(Boolean.TRUE);
		
		PlotSettings plotSettings = settings.getPlotSettings();
		plotSettings.setOutlineVisible(Boolean.TRUE);
		
		AxisSettings domainAxisSettings = settings.getDomainAxisSettings();
		domainAxisSettings.setAxisVisible(Boolean.TRUE);
		
		AxisSettings rangeAxisSettings = settings.getRangeAxisSettings();
		rangeAxisSettings.setAxisVisible(Boolean.TRUE);
		
		return settings;
	}
	*/
}
