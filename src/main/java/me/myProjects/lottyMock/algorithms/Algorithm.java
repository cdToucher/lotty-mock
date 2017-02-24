package me.myProjects.lottyMock.algorithms;

import me.myProjects.lottyMock.bean.LotteryTicket;
import me.myProjects.lottyMock.bean.LottyNumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chendong on 2017/2/21.
 * <p>
 * 算法基础类
 */
public abstract class Algorithm {

    List<LotteryTicket> dataList;

    LottyNumber[] blue;

    LottyNumber[] red;

    Algorithm() {
    }

    Algorithm(List<LotteryTicket> dataList) {
        this.dataList = dataList;
    }

    Algorithm(List<LotteryTicket> dataList, int fetchSize) {
        this.dataList = dataList.subList(dataList.size() - fetchSize, dataList.size());
    }

    public void setDataList(List<LotteryTicket> dataList) {
        this.dataList = dataList;
    }

    public LotteryTicket getMatch() {

        List<LottyNumber> top6 = Arrays.stream(this.red)
                .sorted(Comparator.comparing(LottyNumber::getScore))
                .collect(Collectors.toList())
                .subList(0, 6);
        LottyNumber top1 = Arrays.stream(this.blue)
                .sorted(Comparator.comparing(LottyNumber::getScore))
                .collect(Collectors.toList()).get(0);

        return new LotteryTicket(top1, top6);
    }

    public void mock() {
    }

    public abstract LotteryTicket calculation(boolean mock, int fetchSize);

}
