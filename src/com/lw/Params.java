package com.lw;

/**
 * @author wei.Li by 14/10/15.
 */
public class Params {

    //当前工作空间目录
    public static final String WORK_PATH
            = "/lw/Information/my_Information/framework_technology/JasperReport/jasper_sample/";


    /**
     * 获取 iReport 的.jasper 文件目录
     *
     * @param packageName 实例java 文件所在包名
     * @param fileName    获取的文件名称
     * @return 最终路径
     */
    public static String getReportPath(String packageName, String fileName) {

        return WORK_PATH + "reports/" + packageName + "/" + fileName;

    }

    /**
     * 设置数据 data 所在目录
     *
     * @param packageName 文件所在包名
     * @return 最终路径
     */
    public static String getReportDataPath(String packageName) {

        return WORK_PATH + "reports/" + packageName + "/data/";

    }

}
