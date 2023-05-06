package BLL.Report_Excel;

import DTO.Luong;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ExportDataLuong {
    public static void Export(Map<String, List<Luong>> datas) {
        final String excelFilePath = "./books.xlsx";
        writeExcel(datas, excelFilePath);
    }
    private static void writeExcel(Map<String, List<Luong>> datas, String excelFilePath) {
        // Create workbook
        Workbook workbook = new XSSFWorkbook();

        // Create sheet
        for (var key : datas.keySet()) {
            createSheet(workbook, key, datas.get(key));
        }

        // Create file excel
        try (OutputStream out = new FileOutputStream(excelFilePath)) {
            workbook.write(out);
            System.out.println("Success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createSheet(Workbook workbook, String sheetName, List<Luong> luongs) {
        String[] header = {"STT", "Mã NV", "Tên NV", "Ngày Công QĐ", "Ngay Công TT", "Lương cơ bản", "Hệ số lương",
                "Lương Hưởng", "Mức PC", "Mức đóng BH", "Thực lĩnh"};
        Sheet sheet = workbook.createSheet(sheetName);
        int rowIndex = 0;

        // Create style
        Font titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBold(true);
        CellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFont(titleFont);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);

        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 13);
        headerFont.setBold(true);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        CellStyle style = workbook.createCellStyle();
        style.setFont(font);

        // Create title
        Row row = sheet.createRow(rowIndex++);
        Cell cell = row.createCell(0);
        cell.setCellValue("Bảng lương tháng " + sheetName);
        cell.setCellStyle(titleStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, header.length-1));

        // Create header
        row = sheet.createRow(rowIndex++);
        for (int h = 0; h < header.length; h++) {
            cell = row.createCell(h);
            cell.setCellValue(header[h]);
            cell.setCellStyle(headerStyle);
        }
        if (luongs.size() > 0) {
            int stt = 1;
            for (var luong : luongs) {
                row = sheet.createRow(rowIndex++);
                int colIndex = 0;
                // stt
                cell = row.createCell(colIndex++);
                cell.setCellValue(stt++);
                cell.setCellStyle(style);
                // Mã
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getMaNV());
                cell.setCellStyle(style);
                // Họ tên
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getTenNV());
                cell.setCellStyle(style);
                // Ngày Công QĐ
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getNgayCongQD());
                cell.setCellStyle(style);
                // Ngày Công TT
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getNgayCongTT());
                cell.setCellStyle(style);
                // Lương Cơ bản
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getLuongCB());
                cell.setCellStyle(style);
                // Hệ số lương
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getHsLuong());
                cell.setCellStyle(style);
                // Lương Hưởng
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getLuongHuong());
                cell.setCellStyle(style);
                // Mức Phụ cấp
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getMucPC());
                cell.setCellStyle(style);
                // Mức đóng BH
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getMucBH());
                cell.setCellStyle(style);
                // Thực lĩnh
                cell = row.createCell(colIndex++);
                cell.setCellValue(luong.getThucLinh());
                cell.setCellStyle(style);
            }

        } else {
            row = sheet.createRow(rowIndex);
            cell = row.createCell(0);
            cell.setCellValue("No data");
            style.setAlignment(HorizontalAlignment.CENTER);
            cell.setCellStyle(style);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, 0, header.length-1));
        }
        // Auto resize column width
        for (int columnIndex = 0; columnIndex < header.length; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

}
