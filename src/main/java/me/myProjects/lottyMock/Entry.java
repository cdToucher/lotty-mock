package me.myProjects.lottyMock;

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
        final String path = "E://ssq.xls";

        print("great price !!!");
        LotteryTicket ticket = LottyMock.Builder().setFetchSize(230).process(path);
        print("this term's answer is "+ticket.toString());
    }
}
