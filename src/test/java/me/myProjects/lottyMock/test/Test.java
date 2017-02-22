package me.myProjects.lottyMock.test;

import me.myProjects.lottyMock.bean.LotteryTicket;
import me.myProjects.lottyMock.bean.LottyNumber;
import me.myProjects.lottyMock.excel.Processor;
import me.myProjects.lottyMock.excel.ReadLottyDataExcel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chendong on 2017/1/22.
 * <p>
 * test to use different api
 */
public class Test {

    private static void print(Object object) {
        System.out.println(object);
    }

    public static void main(String[] args) throws Exception {
        print("great zhong le !!!");
        List<LotteryTicket> dataList = ReadLottyDataExcel.readData("E://ssq1.xls");
        LottyNumber[] blue = Processor.getBlueLotty(dataList);
        LottyNumber[] red = Processor.getRedLotty(dataList);

        Arrays.stream(blue).forEach(lottyNumber -> print(lottyNumber.getAd()));
        Arrays.stream(red).forEach(lottyNumber -> print(lottyNumber.getAd()));
    }

}
