/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.utility;

/**
 *
 * @author jaheem
 */
 
import java.awt.Color;
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import mg.gestion.immobilisation.model.DetailsImmobilisation;
 
 
public class OpenPdfExporter {
    private List<DetailsImmobilisation> detailsList;
     
    public OpenPdfExporter(List<DetailsImmobilisation> detailsList) {
        this.detailsList = detailsList;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Article", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Prix d'achat", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Date d'achat", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Mise en service", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Durée", font));
        table.addCell(cell);       
    }
     
    private void writeTableData(PdfPTable table) {
        for (DetailsImmobilisation details : detailsList) {
            table.addCell(details.getArticle());
            table.addCell(String.valueOf(details.getPrixAcquisition())+" Ar");
            table.addCell(details.getDateAchat().toString().substring(0,10));
            table.addCell(details.getDateMiseEnService().toString().substring(0,10));
            table.addCell(String.valueOf(details.getDureeAmmortissement())+" an(s)");
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Liste des immobilisations", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
