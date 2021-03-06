package me.myProjects.lottyMock.excel;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import me.myProjects.lottyMock.bean.LotteryTicket;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by CD on 2017/2/6.
 * <p>
 * 读取excel
 */
public class ReadLottyDataExcel {

    private static final String xlsUrl = "http://www.17500.cn/getData/ssq.xls";

    public static List<LotteryTicket> readDataFromExcel(String path) throws IOException {
        ByteArrayInputStream stream = new ByteArrayInputStream(Files.toByteArray(new File(path)));
        return readData(stream);
    }

    public static List<LotteryTicket> readDataFromNet() throws IOException {
        System.out.println("start to download latest data from net...");
        HttpUriRequest request = new HttpGet(xlsUrl);
        CloseableHttpResponse closeableHttpResponse = HttpClients.createDefault().execute(request);
        InputStream inputStream = closeableHttpResponse.getEntity().getContent();
        return readData(inputStream);
    }

    private static List<LotteryTicket> readData(InputStream inputStream) throws IOException {
        HSSFSheet sheet = new HSSFWorkbook(inputStream).getSheetAt(0);
        List<LotteryTicket> dataList = Lists.newArrayList();
        for (int i = 2; i < sheet.getLastRowNum(); i++) {
            LotteryTicket ticket = new LotteryTicket();
            HSSFRow row = sheet.getRow(i);
            if ((int) (row.getCell(2).getNumericCellValue()) == 0)
                continue;
            ticket.setId(i - 1);
            ticket.setIssue(String.valueOf(row.getCell(0).getNumericCellValue()));
            ticket.setDate(row.getCell(1).getStringCellValue());
            ticket.setRed1((int) (row.getCell(2).getNumericCellValue()));
            ticket.setRed2((int) row.getCell(3).getNumericCellValue());
            ticket.setRed3((int) row.getCell(4).getNumericCellValue());
            ticket.setRed4((int) row.getCell(5).getNumericCellValue());
            ticket.setRed5((int) row.getCell(6).getNumericCellValue());
            ticket.setRed6((int) row.getCell(7).getNumericCellValue());
            ticket.setBlue((int) row.getCell(8).getNumericCellValue());
            dataList.add(ticket);
        }
        System.out.println("read lotty data finished.");
        return dataList;
    }
}
