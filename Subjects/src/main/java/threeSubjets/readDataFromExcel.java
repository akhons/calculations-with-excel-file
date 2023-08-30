package threeSubjets;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class readDataFromExcel {
    public static void main(String[] args) throws IOException {
        try{List<Student> studentsdata = readStudentDataFromExcel(".\\mydata\\Book2.xlsx");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name to search: ");
        String searchKey = scanner.nextLine();

        List<Student> foundStudentsdata = new ArrayList<>();

        for (Student studentdata : studentsdata) {
            if (studentdata.name.equalsIgnoreCase(searchKey)) {
                foundStudentsdata.add(studentdata);
            }
        }

        for (Student studentdata : foundStudentsdata) {
            System.out.println("Name: " + studentdata.name);
            System.out.println("------------------");
            System.out.println("Maths: " + studentdata.maths);
            System.out.println("Grade: " + studentdata.getGrade(studentdata.maths));
            System.out.println("Gradepoint: " + studentdata.calculateGradePoint(studentdata.maths));
            System.out.println("------------------");
            System.out.println("Physics: " + studentdata.physics);
            System.out.println("Grade: " + studentdata.getGrade(studentdata.physics));
            System.out.println("Gradepoint: " + studentdata.calculateGradePoint(studentdata.physics));
            System.out.println("------------------");
            System.out.println("Chemistry: " + studentdata.chemistry);
            System.out.println("Grade: " + studentdata.getGrade(studentdata.chemistry));
            System.out.println("Gradepoint: " + studentdata.calculateGradePoint(studentdata.chemistry));
            System.out.println("------------------");
            System.out.println("Perceentage" + studentdata.percentage(studentdata.maths,studentdata.physics,studentdata.chemistry) +"%");
            System.out.println();
        }}catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while reading the Excel file.");
        }
    }

    public static List<Student> readStudentDataFromExcel(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        System.out.println(sheet.getLastRowNum());
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null && hasDataInRow(row)) {
            String name = row.getCell(0).getStringCellValue();
            int physics = (int) row.getCell(1).getNumericCellValue();
            int chemistry = (int) row.getCell(2).getNumericCellValue();
            int maths = (int) row.getCell(3).getNumericCellValue();
            
            students.add(new Student(name, maths, physics, chemistry));}
            else {
            	System.out.print("row is null");
            }
        }

        workbook.close();
        fileInputStream.close();

        return students;
    }
    private static boolean hasDataInRow(Row row) {
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Cell cell = row.getCell(j);
            if (cell == null ) {
                return false;
            }
        }
        return true;
    }

}


