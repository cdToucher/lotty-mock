package me.myProjects.lottyMock.bean;

import java.util.Arrays;
import java.util.List;

/**
 * Created by CD on 2017/2/6.
 * <p>
 * lotty bean
 */
public class LotteryTicket {

    public LotteryTicket(){}

    public LotteryTicket(LottyNumber blue, List<LottyNumber> red) {
        this.red1 = red.get(0).getNum();
        this.red2 = red.get(1).getNum();
        this.red3 = red.get(2).getNum();
        this.red4 = red.get(3).getNum();
        this.red5 = red.get(4).getNum();
        this.red6 = red.get(5).getNum();
        this.blue = blue.getNum();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed1() {
        return red1;
    }

    public void setRed1(int red1) {
        this.red1 = red1;
    }

    public int getRed2() {
        return red2;
    }

    public void setRed2(int red2) {
        this.red2 = red2;
    }

    public int getRed3() {
        return red3;
    }

    public void setRed3(int red3) {
        this.red3 = red3;
    }

    public int getRed4() {
        return red4;
    }

    public void setRed4(int red4) {
        this.red4 = red4;
    }

    public int getRed5() {
        return red5;
    }

    public void setRed5(int red5) {
        this.red5 = red5;
    }

    public int getRed6() {
        return red6;
    }

    public void setRed6(int red6) {
        this.red6 = red6;
    }

    private int id;

    private String issue;

    private String date;

    private int blue;

    private int red1;

    private int red2;

    private int red3;

    private int red4;

    private int red5;

    private int red6;

    public Integer[] toArray(boolean isBlue) {
        if (isBlue)
            return new Integer[]{blue};
        return new Integer[]{red1, red2, red3, red4, red5, red6};
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(toArray(false)).sorted().toArray()) + Arrays.toString(toArray(true));
    }

}
