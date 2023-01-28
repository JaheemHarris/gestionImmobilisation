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
import mg.gestion.immobilisation.model.AmmortissementImmobilisation;
import mg.gestion.immobilisation.model.DetailsImmobilisation;
 
 
public class AmmortToPdf {
    private List<AmmortissementImmobilisation> ammort;

    public AmmortToPdf(List<AmmortissementImmobilisation> ammort) {
        this.ammort = ammort;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Annee", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Prix d'achat", font));
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
        for(AmmortissementImmobilisation am : ammort){
            table.addCell(am.getAnnee());
            table.addCell(String.valueOf(am.getPrixAcquisition())+" Ar");
            table.addCell(String.valueOf(am.getAnterieur())+" Ar");
            table.addCell(String.valueOf(am.getExercice())+" Ar");
            table.addCell(String.valueOf(am.getCumulee())+" Ar");
            table.addCell(String.valueOf(am.getValeurNetComptable())+" Ar");
    }
}
     
    public void export(HttpServletResponse response,DetailsImmobilisation immo) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("Ammortissement", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
        
        Paragraph phr1 = new Paragraph();
        phr1.add("Article : "+immo.getArticle());
        document.add(phr1);
        
        Paragraph phr4 = new Paragraph();
        phr4.add("Prix d'achat  : "+String.valueOf(immo.getPrixAcquisition())+" Ar");
        document.add(phr4);
        
        Paragraph phr2 = new Paragraph();
        phr2.add("Date de mise en service  : "+immo.getDateMiseEnService().toString().substring(0, 10));
        document.add(phr2);
        
        
        
        Paragraph phr3 = new Paragraph();
        phr3.add("Duree  : "+String.valueOf(immo.getDureeAmmortissement()));
        document.add(phr3);
         
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {0.4f, 1f, 1f, 1f, 1f,1f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}

