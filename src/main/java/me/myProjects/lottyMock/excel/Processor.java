package me.myProjects.lottyMock.excel;

import me.myProjects.lottyMock.bean.LotteryTicket;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by CD on 2017/2/7.
 * <p>
 * process data list
 */
public class Processor {

    public static Stream<Integer> getSequence(List<LotteryTicket> dataList, int number) {
        return dataList
                .stream()
                .filter(lotteryTicket -> Stream.of(lotteryTicket.toArray()).collect(toList()).contains(number))
                .map(LotteryTicket::getId)
                .sorted();
    }

    public static Stream<Integer> getDifSequence(Stream<Integer> sequence) {
        return sequence.reduce(((integer, integer2) -> integer2 - integer))
    }
}
