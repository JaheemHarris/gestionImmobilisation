/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.utility;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import mg.gestion.immobilisation.model.DetailsImmobilisation;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;


/**
 *
 * @author jaheem
 */
public class CsvExportService {

    private List<DetailsImmobilisation> detailsList;

    public CsvExportService(List<DetailsImmobilisation> detailsList) {
        this.detailsList = detailsList;
    }
    
    
    public void writeToCsv(Writer writer) throws Exception{
        
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (DetailsImmobilisation details : detailsList) {
                csvPrinter.printRecord(details.getArticle(),details.getPrixAcquisition(),details.getType(),details.getDateAchat().toString().substring(0, 10),details.getDateMiseEnService().toString().substring(0, 10),details.getDureeAmmortissement());
            }
        } catch (IOException e) {
            throw e;
        } finally{
            writer.close();
        }
    }
}