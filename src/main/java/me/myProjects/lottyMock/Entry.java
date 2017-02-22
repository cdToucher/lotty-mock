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

    public static void main(String[] args) throws IOException {
        LotteryTicket ticket = LottyMock.Builder().setAlgorithm(new Normal()).setMock(true).setPath("").process();
        System.out.println(ticket);
    }
}
