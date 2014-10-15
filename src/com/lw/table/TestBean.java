package com.lw.table;

/**
 * @author wei.Li by 14/10/14.
 */
public class TestBean {

    private String systemName;  //系统名称
    private int totalTransactionNum; //交易总笔数
    private int transactionOfSucceedNum;//交易成功笔数
    private String transactionOfSucceedRate;//交易成功率
    private int systemOfSucceedNum;//系统交易笔数
    private String systemOfSucceedRate;//系统交易成功率

    public TestBean(String systemName, int totalTransactionNum, int transactionOfSucceedNum, String transactionOfSucceedRate, int systemOfSucceedNum, String systemOfSucceedRate) {
        this.systemName = systemName;
        this.totalTransactionNum = totalTransactionNum;
        this.transactionOfSucceedNum = transactionOfSucceedNum;
        this.transactionOfSucceedRate = transactionOfSucceedRate;
        this.systemOfSucceedNum = systemOfSucceedNum;
        this.systemOfSucceedRate = systemOfSucceedRate;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public int getTotalTransactionNum() {
        return totalTransactionNum;
    }

    public void setTotalTransactionNum(int totalTransactionNum) {
        this.totalTransactionNum = totalTransactionNum;
    }

    public int getTransactionOfSucceedNum() {
        return transactionOfSucceedNum;
    }

    public void setTransactionOfSucceedNum(int transactionOfSucceedNum) {
        this.transactionOfSucceedNum = transactionOfSucceedNum;
    }

    public String getTransactionOfSucceedRate() {
        return transactionOfSucceedRate;
    }

    public void setTransactionOfSucceedRate(String transactionOfSucceedRate) {
        this.transactionOfSucceedRate = transactionOfSucceedRate;
    }

    public int getSystemOfSucceedNum() {
        return systemOfSucceedNum;
    }

    public void setSystemOfSucceedNum(int systemOfSucceedNum) {
        this.systemOfSucceedNum = systemOfSucceedNum;
    }

    public String getSystemOfSucceedRate() {
        return systemOfSucceedRate;
    }

    public void setSystemOfSucceedRate(String systemOfSucceedRate) {
        this.systemOfSucceedRate = systemOfSucceedRate;
    }
}
