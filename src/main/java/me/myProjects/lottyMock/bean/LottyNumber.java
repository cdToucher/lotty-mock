package me.myProjects.lottyMock.bean;

/**
 * Created by CD on 2017/2/7.
 * <p>
 * number
 */
public class LottyNumber {

    public LottyNumber() {

    }

    public LottyNumber(int num) {
        super();
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer[] getSequence() {
        return sequence;
    }

    public void setSequence(Integer[] sequence) {
        this.sequence = sequence;
    }

    public Integer[] getDiffSequence() {
        return diffSequence;
    }

    public void setDiffSequence(Integer[] diffSequence) {
        this.diffSequence = diffSequence;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getVariance() {
        return variance;
    }

    public void setVariance(double variance) {
        this.variance = variance;
    }

    public double getAd() {
        return ad;
    }

    public void setAd(double ad) {
        this.ad = ad;
    }

    private int num;

    private Integer[] sequence;

    private Integer[] diffSequence;

    private double average; // 平均数

    private double variance; // 方差

    private double ad; // 算数平均差

    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    private double close;

}
