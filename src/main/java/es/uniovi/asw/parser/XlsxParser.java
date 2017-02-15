package es.uniovi.asw.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.Citizen;
import es.uniovi.asw.letters.SendLetters;

/**
 * Created by Carla on 08/02/2017.
 */
public class XlsxParser implements Parser {
	SendLetters letter = new SendLetters();

	@Override
	public List<Citizen> parseFile(File file) {
		List<Citizen> users = new ArrayList<Citizen>();

		try {
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row;

			int rows; // No of rows
			rows = sheet.getPhysicalNumberOfRows();

			int cols = 0; // No of columns
			int tmp = 0;

			// This trick ensures that we get the data properly even if it
			// doesn't start from first few rows
			for (int i = 0; i < 10 || i < rows; i++) {
				row = sheet.getRow(i);
				if (row != null) {
					tmp = sheet.getRow(i).getPhysicalNumberOfCells();
					if (tmp > cols)
						cols = tmp;
				}
			}

			parseUsers(users, sheet, rows);
			wb.close();

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}

		return users;

	}

	private void parseUsers(List<Citizen> users, XSSFSheet sheet, int rows) throws IOException {
		XSSFRow row;// se salta la primera línea
		for (int r = 1; r < rows; r++) {
			row = sheet.getRow(r);
			if (row != null) {
				String nombre = row.getCell(0).getStringCellValue();
				String apellidos = row.getCell(1).getStringCellValue();
				String email = row.getCell(2).getStringCellValue();
				Date nacimiento = row.getCell(3).getDateCellValue();
				String direccion = row.getCell(4).getStringCellValue();
				String nacionalidad = row.getCell(5).getStringCellValue();
				String dni = row.getCell(6).getStringCellValue();
				int polling = (int) row.getCell(7).getNumericCellValue();

				Citizen citizen = new Citizen(dni, nombre, apellidos, nacimiento, direccion, email, nacionalidad, polling);

				// create a random alphanumeric password and persists the user
				citizen.setPassword(RandomStringUtils.randomAlphanumeric(10));
				
				letter.send(citizen);

				users.add(citizen);
			}
		}
	}
}
