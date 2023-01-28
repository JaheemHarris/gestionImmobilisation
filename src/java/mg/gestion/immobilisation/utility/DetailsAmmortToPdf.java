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
import mg.gestion.immobilisation.model.DetailsAmmortissement;
import mg.gestion.immobilisation.model.DetailsImmobilisation;
 
 
public class DetailsAmmortToPdf {
    private List<DetailsAmmortissement> detailsList;
     
    public DetailsAmmortToPdf(List<DetailsAmmortissement> detailsList) {
        this.detailsList = detailsList;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Annee", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Article", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Prix d'achat", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Mise en service", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Anterieur", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("Exercice", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("Cumulee", font));
        table.addCell(cell); 
        
        cell.setPhrase(new Phrase("VNC", font));
        table.addCell(cell); 
    }
     
    private void writeTableData(PdfPTable table) {
        for (DetailsAmmortissement details : detailsList) {
            table.addCell(details.getAnnee());
            table.addCell(details.getArticle());
            table.addCell(details.getPrixAcquisition()+" Ar");
            table.addCell(details.getDateMiseEnService().toString());
            table.addCell(String.valueOf(details.getAnterieur())+" Ar");
            table.addCell(String.valueOf(details.getExercice())+" Ar");
            table.addCell(String.valueOf(details.getCumulee())+" Ar");
            table.addCell(String.valueOf(details.getValeurNetComptable())+" Ar");
        }
    }
     
    public void export(HttpServletResponse response,String annee) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        document.newPage();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Liste des ammortissements en "+annee, font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {0.4f,0.5f,1,0.8f,1,1.3f,1.3f,1.3f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
