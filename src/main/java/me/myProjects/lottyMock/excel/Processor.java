package me.myProjects.lottyMock.excel;

import me.myProjects.lottyMock.bean.LotteryTicket;
import me.myProjects.lottyMock.bean.LottyNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by CD on 2017/2/7.
 * <p>
 * process data list
 */
public class Processor {

    private static Integer[] getSequence(List<LotteryTicket> dataList, int number, boolean isBlue) {
        return dataList
                .stream()
                .filter(lotteryTicket -> Stream.of(lotteryTicket.toArray(isBlue)).collect(toList()).contains(number))
                .map(LotteryTicket::getId)
                .sorted()
                .toArray(Integer[]::new);
    }

    private static Integer[] getDifSequence(Integer[] sequence) {
        Integer[] difSequence = new Integer[sequence.length - 1];
        for (int i = 0; i < sequence.length - 1; i++) {
            difSequence[i] = (Math.abs(sequence[i] - sequence[i + 1]));
        }
        return difSequence;
    }

    private static double getAD(double variance) {
        return Math.sqrt(variance);
    }

    private static double getVariance(Integer[] sequence, double average) {
        double total = 0D;
        for (Integer integer : sequence) {
            double t = (integer - average);
            total += (t * t);
        }
        return total / sequence.length;
    }

    private static double getAverage(Integer[] sequence) {
        return Arrays.stream(sequence).mapToDouble(Integer::doubleValue).sum() / sequence.length;
    }

    private static LottyNumber[] setLotty(List<LotteryTicket> data, int size, boolean isBlue) {
        LottyNumber[] lottyNumbers = new LottyNumber[size];
        for (int i = 1; i <= size; i++) {
            LottyNumber lottyNumber = new LottyNumber(i);
            Integer[] sequence = Processor.getSequence(data, i, isBlue);
            lottyNumber.setSequence(sequence);
            lottyNumber.setDiffSequence(getDifSequence(sequence));
            lottyNumber.setAverage(getAverage(lottyNumber.getDiffSequence()));
            lottyNumber.setVariance(getVariance(lottyNumber.getDiffSequence(), lottyNumber.getAverage()));
            lottyNumber.setAd(getAD(lottyNumber.getVariance()));
            lottyNumbers[i - 1] = lottyNumber;
        }
        return lottyNumbers;
    }

    public static LottyNumber[] getRedLotty(List<LotteryTicket> data) {
        return setLotty(data, 33, false);
    }

    public static LottyNumber[] getBlueLotty(List<LotteryTicket> data) {
        return setLotty(data, 16, true);
    }
}
