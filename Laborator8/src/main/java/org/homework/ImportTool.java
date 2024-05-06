package org.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clasa ImportTool se ocupă de importul datelor dintr-un fișier în baza de date.
 */
public class ImportTool {
    private Connection connection;
    private SimpleDateFormat[] dateFormats = {
            new SimpleDateFormat("MM-dd-yyyy"),
            new SimpleDateFormat("M/dd/yyyy")
    };

    /**
     * Constructor pentru clasa ImportTool.
     *
     * @param db Obiectul Database pentru a obține conexiunea la baza de date.
     * @throws SQLException Dacă apare o excepție legată de baza de date.
     */
    public ImportTool(Database db) throws SQLException {
        this.connection = db.getConnection();
    }

    /**
     * Importă cărțile dintr-un fișier dat în baza de date.
     *
     * @param filePath Calea către fișierul de importat.
     * @throws IOException  Dacă apare o eroare la citirea fișierului.
     * @throws SQLException Dacă apare o eroare la interogarea bazei de date.
     */
    public void importBooks(String filePath) throws IOException, SQLException {
        String sql = "INSERT INTO books (title, language, publication_date, num_pages) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            reader.readLine(); // Omiterea antetului din fișier

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");

                String dateString = columns[10].trim();
                Date publicationDate = parseDate(dateString);

                String title = columns[1].trim();
                String language = columns[6].trim();
                Integer numPages = Integer.parseInt(columns[7].trim());

                statement.setString(1, title);
                statement.setString(2, language);
                statement.setDate(3, new java.sql.Date(publicationDate.getTime()));
                statement.setInt(4, numPages);
                statement.executeUpdate();
            }

            System.out.println("Books imported successfully");
        }
    }

    /**
     * Încearcă să parseze data din șirul dat conform diferitelor formate de dată.
     *
     * @param dateString Șirul ce reprezintă data.
     * @return Obiectul Date parsat din șir.
     * @throws IllegalArgumentException Dacă data nu poate fi parsată folosind niciunul din formatele de dată cunoscute.
     */
    private Date parseDate(String dateString) {
        for (SimpleDateFormat dateFormat : dateFormats) {
            try {
                return dateFormat.parse(dateString);
            } catch (ParseException e) {
                // Încercă următorul format de dată
            }
        }
        throw new IllegalArgumentException("Invalid date format: " + dateString);
    }
}
