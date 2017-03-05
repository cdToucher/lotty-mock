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
        List<LottyNumber> lottyRed = Arrays.stream(this.red)
                .sorted(Comparator.comparing(LottyNumber::getScore))
                .collect(Collectors.toList());
        List<LottyNumber> top6 = lottyRed.subList(0, 6);
        List<LottyNumber> lottyBlue = Arrays.stream(this.blue)
                .sorted(Comparator.comparing(LottyNumber::getScore))
                .collect(Collectors.toList());
        lottyRed.forEach(row -> System.out.print(row.getNum() + " "));
        System.out.println();
        lottyBlue.forEach(row -> System.out.print(row.getNum() + " "));
        System.out.println();
        return new LotteryTicket(lottyBlue.get(0), top6);
    }

    public void mock() {
    }

    public abstract LotteryTicket calculation(boolean mock, int fetchSize);

}
