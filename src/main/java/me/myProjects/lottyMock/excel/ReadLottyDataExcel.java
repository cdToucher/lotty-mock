package me.myProjects.lottyMock.excel;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import me.myProjects.lottyMock.bean.LotteryTicket;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by CD on 2017/2/6.
 * <p>
 * 读取excel
 */
public class ReadLottyDataExcel {

    public static List<LotteryTicket> readData(String path) throws IOException {
        ByteArrayInputStream stream = new ByteArrayInputStream(Files.toByteArray(new File(path)));
        HSSFSheet sheet = new HSSFWorkbook(stream).getSheetAt(0);
        List<LotteryTicket> dataList = Lists.newArrayList();
        for (int i = 2; i < sheet.getLastRowNum(); i++) {
            LotteryTicket ticket = new LotteryTicket();
            HSSFRow row = sheet.getRow(i);
            if ((int) (row.getCell(2).getNumericCellValue()) == 0)
                continue;
            ticket.setId(i - 2);
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
        return dataList;
    }

}
