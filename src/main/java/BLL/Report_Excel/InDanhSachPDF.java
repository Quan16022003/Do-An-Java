package BLL.Report_Excel;

import DTO.NhanVien;
import com.itextpdf.html2pdf.HtmlConverter;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InDanhSachPDF {
    private static String getHTMLTemplate(String listds, String ngayIn) {
        String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Document</title>
                    <style>
                        * {
                            padding: 0;
                            margin: 0;
                            box-sizing: border-box;
                            font-weight: normal;
                            font-family: sans-serif;
                        }
                        table {
                            border-collapse: collapse;
                            width: 700px;
                        } 
                        td,
                        th {
                            border: 1px solid rgb(213, 227, 237);
                            text-align: left;
                            padding: 8px;
                        }
                        tr:nth-child(even) {
                            background-color: rgb(213, 230, 234);
                        }
                        .header{
                            color:rgb(119, 185, 232);
                            font-weight: bold;
                            font-size: 25px;
                            text-align: center;
                            margin-bottom: 20px;
                        }
                        .in {
                            color:rgb(120, 173, 210);
                            font-weight: inherit;
                            font-size: 15px;
                            text-align: right;
                            padding-top: 10px;
                        }
                    </style>
                </head>
                <body>
                    <div class="header">DANH SÁCH NHÂN VIÊN</div>
                    <div class="content">
                        <table>
                            <tr>
                                <td style="font-weight: bold;"">STT</td>
                                <td style="font-weight: bold;">Mã nhân viên</td>
                                <td style="font-weight: bold;">Tên nhân viên</td>
                                <td style="font-weight: bold;">Đơn vị</td>
                                <td style="font-weight: bold;">Chức vụ</td>
                                <td style="font-weight: bold;">Số điện thoại</td>
                            </tr>
                            %s
                        </table>
                    </div>
                    <div class="in">
                        In ngày: %s
                    </div>
                </body>
                </html>
                """.formatted(listds, ngayIn);
        return html;
    }
    private static String convertDsNhanVienToHTML(List<NhanVien> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        String content = "";
        int index = 1;
        for (var nhanVien : list) {
            content += """
                    <tr>
                        <td>%d</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    """.formatted(index++, nhanVien.getMaNV(), nhanVien.getTen(), nhanVien.getMaDV(), nhanVien.getMaChucVu(),
                    nhanVien.getSDT());
        }
        return content;
    }

    private static void createDirectoryIfNotExist(String dirname){
        File f = new File("./"+dirname);
        if (!f.exists()){
            boolean isSuccess = f.mkdir();
            if (isSuccess)
                System.out.println("Create successfully directory " + f.getAbsolutePath());
            else
                System.out.println("Can't create " + f.getAbsolutePath());
        }
    }

    private static void HTMLStringToPDF(String html, String outputPath){
        try {
            HtmlConverter.convertToPdf(html,
                    new FileOutputStream(outputPath));
            System.out.println("Success!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void renderPDF(List<NhanVien> list){
        String timeNow = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        createDirectoryIfNotExist("Report");
        String outputFolder = "./Report/DanhSachNhanVien_"+timeNow+".pdf";
        String listNhanVienContent = convertDsNhanVienToHTML(list);
        String html = getHTMLTemplate(listNhanVienContent, timeNow);
        HTMLStringToPDF(html, outputFolder);
    }
}
