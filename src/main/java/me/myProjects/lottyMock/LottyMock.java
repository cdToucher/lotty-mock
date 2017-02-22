package me.myProjects.lottyMock;

import me.myProjects.lottyMock.algorithms.Algorithm;
import me.myProjects.lottyMock.bean.LotteryTicket;
import me.myProjects.lottyMock.excel.ReadLottyDataExcel;

import java.io.IOException;
import java.util.List;

/**
 * Created by chendong on 2017/2/21.
 * <p>
 * builder class
 */
public class LottyMock {

    private Builder builder;

    public static LottyMock Builder() {
        LottyMock lottyMock = new LottyMock();
        lottyMock.builder = new Builder();
        return lottyMock;
    }

    public LottyMock setMock(boolean mock) {
        builder.mock = mock;
        return this;
    }

    public LottyMock setAlgorithm(Algorithm algorithm) {
        builder.algorithm = algorithm;
        return this;
    }

    public LottyMock setFetchSize(int fetchSize) {
        builder.fetchSize = fetchSize;
        return this;
    }

    public LottyMock setPath(String path) {
        builder.path = path;
        return this;
    }

    public LotteryTicket process() throws IOException {
        List<LotteryTicket> data = ReadLottyDataExcel.readData(builder.path);
        builder.algorithm.setDataList(data);
        return builder.algorithm.calculation(builder.mock, builder.fetchSize);
    }

    private static class Builder {

        private String path;

        private boolean mock = false;

        private int fetchSize = 212;

        private Algorithm algorithm;

    }

}
