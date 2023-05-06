/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL.ExportExcel;

import DAL.NhanVienDAO;
import DTO.NhanVien;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author apple
 */
public class WriteExcelNhanVien {
    private NhanVienDAO DAO;
    public void export() 
    {
        DAO = new NhanVienDAO();
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");
        var i = 1;
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
  
        data.put(Integer.toString(i), new Object[] {"MaNV", "MaDV", "MaLoaiNV","MaChucVu","Ten","GioiTinh","NgSinh","SDT","SoNha","Duong","NgCap","NoiCap","NgVaoLam"});
        
        for (NhanVien nv : DAO.selectAll()) {
            data.put(Integer.toString(i), new Object[] {Integer.toString(i),nv.getMaNV(),nv.getMaDV(),nv.getMaLoaiNV(),nv.getMaChucVu(),
                nv.getTen(),nv.getGioiTinh(),nv.getNgSinh(),nv.getSDT(),nv.getSoNha(),nv.getDuong(),
                nv.getPhuong_Xa(),nv.getPhuong_Xa(),nv.getQuan_Huyen(),nv.getTP_Tinh(),nv.getCCCD(),
                nv.getNgCap(),nv.getNoiCap(),nv.getNgVaoLam()});
        }         
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
