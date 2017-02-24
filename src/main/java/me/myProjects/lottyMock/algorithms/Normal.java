package me.myProjects.lottyMock.algorithms;

import me.myProjects.lottyMock.bean.LotteryTicket;
import me.myProjects.lottyMock.bean.LottyNumber;
import me.myProjects.lottyMock.excel.Processor;

import java.util.List;

/**
 * Created by chendong on 2017/2/16.
 * <p>
 * normal algorithm
 */
public class Normal extends Algorithm {

    public Normal() {
        super();
    }

    public Normal(List<LotteryTicket> dataList) {
        super(dataList);
    }

    public Normal(List<LotteryTicket> dataList, int fetchSize) {
        super(dataList, fetchSize);
    }

    @Override
    public LotteryTicket calculation(boolean mock, int fetchSize) {
        if (mock) {

        }
        this.dataList = this.dataList.subList(this.dataList.size() - fetchSize, this.dataList.size());
        this.blue = Processor.getBlueLotty(dataList);
        this.red = Processor.getRedLotty(dataList);
        int newterm = dataList.get(dataList.size() - 1).getId() + 1;
        for (LottyNumber lottyNumber : blue) {
            setScore(newterm, lottyNumber);
        }
        for (LottyNumber lottyNumber : red) {
            setScore(newterm, lottyNumber);
        }
        return getMatch();
    }

    private void setScore(int newterm, LottyNumber lottyNumber) {
        int lastShow = lottyNumber.getSequence()[lottyNumber.getSequence().length - 1];
        double average = lottyNumber.getAverage();
        double ad = lottyNumber.getAd();
        double score1 = lastShow + average + ad;
        double score2 = lastShow + average - ad;
        double score = Math.min(Math.abs(newterm - score1), Math.abs(newterm - score2));
        lottyNumber.setScore(score);
    }


}
