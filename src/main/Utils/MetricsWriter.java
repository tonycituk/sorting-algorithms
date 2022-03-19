package main.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import main.Entities.Report;

public class MetricsWriter {

    ArrayList<Report> reports;
    String path;
    public MetricsWriter(ArrayList<Report> reports, String path) {
        this.reports = reports;
        this.path = path;
    }

    public void writeToTXTFromArray(String path, String nombre) throws FileNotFoundException {
        List<String> dataLines = new ArrayList<>();

        for (Report xReporte : reports) {
            dataLines.add(xReporte.toString());
            System.out.println(dataLines);
        }

        File txtOutputFile = new File(path + nombre);
        try (PrintWriter pw = new PrintWriter(txtOutputFile)) {
            dataLines.stream()
                    .map(this::convertToTXT).forEach(pw::println);
            ;

        }
    }

    private String convertToTXT(String data) {
        return data;
    }
}
