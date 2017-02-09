package es.uniovi.asw.parser;

import es.uniovi.asw.RandomPasswordGenerator;
import es.uniovi.asw.User;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Carla on 08/02/2017.
 */
public class XlsxParser implements Parser {
    @Override
    public List<User> parseFile(File file) {
        List users = new ArrayList<User>();

        try {
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for (int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if (tmp > cols) cols = tmp;
                }
            }

            parseUsers(users, sheet, rows);


        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

        return users;

    }

    private void parseUsers(List users, XSSFSheet sheet, int rows) {
        XSSFRow row;// se salta la primera línea
        for (int r = 1; r < rows; r++) {
            row = sheet.getRow(r);
            User user = new User();
            if (row != null) {
                String nombre = row.getCell(0).getStringCellValue();
                user.setNombre(nombre);
                String apellidos = row.getCell(1).getStringCellValue();
                user.setApellidos(apellidos);
                String email = row.getCell(2).getStringCellValue();
                user.setEmail(email);
                Date nacimiento = row.getCell(3).getDateCellValue();
                user.setNacimiento(nacimiento);
                String direccion = row.getCell(4).getStringCellValue();
                user.setDireccion(direccion);
                String nacionalidad = row.getCell(5).getStringCellValue();
                user.setNacionalidad(nacionalidad);
                String dni = row.getCell(6).getStringCellValue();
                user.setDNI(dni);

                user.setPassword(RandomPasswordGenerator.generatePassword());

                users.add(user);
            }
        }
    }
}
