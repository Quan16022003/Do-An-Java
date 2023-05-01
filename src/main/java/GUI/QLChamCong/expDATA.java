/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.QLChamCong;

//import com.mysql.cj.result.Row;
import DTO.ChamCong;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.record.RowRecord;
import static org.apache.poi.hssf.record.aggregates.RowRecordsAggregate.createRow;
import org.apache.poi.sl.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author ADMIN
 */
public class expDATA {

    public static void exp(ArrayList<ChamCong> x, String[] header, String namef, String path, String sheetname) throws FileNotFoundException, IOException {

        //        phần đầu vào giả , tự điều chỉnh cho hợp lí nha
        
        header = new String[]{"Cột a", "Cột b","Cột a", "Cột b", "Cột b"};
        path = "C:\\Users\\ADMIN\\Documents\\NetBeansProJects\\";
        namef = "tenfile";
        sheetname = "sheet aaa";
        path = path + (namef + ".xlsx");
        //        phần đầu vào giả , tự điều chỉnh cho hợp lí nha      

        
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetname);
        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setBold(true);

        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);

        XSSFRow row = sheet.createRow(3);
        XSSFCell cell;

        for (int h = 0; h < header.length; h++) {
            cell = row.createCell(h);
            cell.setCellValue(header[h]);
            cell.setCellStyle(style);
        }

        for (int k = 1; k <= x.size(); k++) {
            // doi tuong co 2 thuoc tinh a va b
            row = sheet.createRow(k);

            String gtcot1 = x.get(k - 1).getMaNV();
            cell = row.createCell(0);
            cell.setCellValue(gtcot1);

            String gtcot2 = x.get(k - 1).getNgayThang()+"";
            cell = row.createCell(1);
            cell.setCellValue(gtcot2);
            String gtcot3 = x.get(k - 1).getTimeIn();
            cell = row.createCell(2);
            cell.setCellValue(gtcot3);

            String gtcot4 = x.get(k - 1).getTimeOut();
            cell = row.createCell(3);
            cell.setCellValue(gtcot4);
            String gtcot5 = x.get(k - 1).getxacNhan();
            cell = row.createCell(4);
            cell.setCellValue(gtcot5);

        }
        for (int colNum = 0; colNum < row.getLastCellNum(); colNum++) {
            sheet.autoSizeColumn((short) (colNum));
        }
        FileOutputStream out = new FileOutputStream(new File(path));
        workbook.write(out);
        out.close();
        System.out.println("Sus");

    }
}
