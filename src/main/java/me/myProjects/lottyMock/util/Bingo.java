package me.myProjects.lottyMock.util;

import me.myProjects.lottyMock.bean.LotteryTicket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chendong on 2017/2/21.
 * <p>
 * check whether the lottery ticket bingo or not
 */
public class Bingo {

    public enum AwardsLevel {
        _1,
        _2,
        _3,
        _4,
        _5,
        _6,
        _0;
    }

    public static AwardsLevel bingoOrNot(LotteryTicket right, LotteryTicket ticket) {
        List<Integer> red = Arrays.stream(right.toArray(false)).collect(Collectors.toList());
        int hitTimes = 0;
        for (Integer redBoll : ticket.toArray(false)) {
            if (red.contains(redBoll))
                hitTimes++;
        }
        boolean hitBlue = right.getBlue() == ticket.getBlue();

        AwardsLevel awardsLevel;
        if (hitTimes == 6 && hitBlue)
            awardsLevel = AwardsLevel._1;
        else if (hitTimes == 6)
            awardsLevel = AwardsLevel._2;
        else if (hitTimes == 5 && hitBlue)
            awardsLevel = AwardsLevel._3;
        else if ((hitTimes == 4 && hitBlue) || (hitTimes == 5))
            awardsLevel = AwardsLevel._4;
        else if ((hitTimes == 4) || (hitTimes == 3 && hitBlue))
            awardsLevel = AwardsLevel._5;
        else if (hitBlue)
            awardsLevel = AwardsLevel._6;
        else
            awardsLevel = AwardsLevel._0;
        return awardsLevel;
    }

}
