package me.myProjects.lottyMock;

import me.myProjects.lottyMock.algorithms.Normal;
import me.myProjects.lottyMock.bean.LotteryTicket;

import java.io.IOException;

/**
 * Created by chendong on 2017/2/21.
 * <p>
 * 实际使用类
 */
public class Entry {


    private static void print(Object object) {
        System.out.println(object);
    }

    public static void main(String[] args) throws IOException {
        print("great zhong le !!!");
        String path = "E://ssq1.xls";
        LotteryTicket ticket = LottyMock.Builder().setMock(false).process(path);
        print(ticket.toString());
    }
}
