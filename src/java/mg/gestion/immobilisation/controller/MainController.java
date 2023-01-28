/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gestion.immobilisation.controller;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import mg.gestion.immobilisation.model.AmmortissementImmobilisation;
import mg.gestion.immobilisation.model.Article;
import mg.gestion.immobilisation.model.DetailsAmmortissement;
import mg.gestion.immobilisation.model.DetailsImmobilisation;
import mg.gestion.immobilisation.model.Immobilisation;
import mg.gestion.immobilisation.model.TypeAmmortissement;
import mg.gestion.immobilisation.service.ImmobilisationService;
import mg.gestion.immobilisation.utility.AmmortToPdf;
import mg.gestion.immobilisation.utility.CsvExportService;
import mg.gestion.immobilisation.utility.DetailsAmmortToPdf;
import mg.gestion.immobilisation.utility.OpenPdfExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jaheem
 */

@Controller
public class MainController {
    
    @Autowired
    private ImmobilisationService immoService;
    
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public String home(){
        return "home";
    }
    
    @RequestMapping(value="/page-ajout-immobilisation",method=RequestMethod.GET)
    public String liste(Model model) throws Exception{
        List<Article> listeArticles = immoService.getAllArticles();
        List<TypeAmmortissement> listeTypes = immoService.getAllTypes();
        model.addAttribute("articles", listeArticles);
        model.addAttribute("types", listeTypes);
        return "ajout-immobilisation";
    }
    
    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String test() throws Exception{
        Immobilisation immobilisation = immoService.getImmobilisation(6);
        List<DetailsAmmortissement> listAmmort = immoService.getDetailsAmmortissement("2017",0);
        return "test";
    }
    
    @RequestMapping(value="/ajoutImmobilisation",method=RequestMethod.POST)
    public String ajoutImmobilisation(@ModelAttribute Immobilisation immobilisation,@RequestParam("achat") String dateAchat,@RequestParam("service") String dateMiseEnService) throws Exception{
        try{
            if(dateAchat==null && dateMiseEnService==null){
                return "redirect:/page-ajout-immobilisation?error=1";
            }
            if(dateAchat.isEmpty() && dateMiseEnService.isEmpty()){
                return "redirect:/page-ajout-immobilisation?error=1";
            }
            Immobilisation immo = immoService.ajouterImmobilisation(immobilisation,dateAchat,dateMiseEnService);
        }catch(Exception e){
            throw e;
        }
        return "redirect:/page-ajout-immobilisation";
    }
    
    @RequestMapping(value={"/","liste"},method=RequestMethod.GET)
    public String listeImmobilisation(Model model) throws Exception{
        try{
            List<DetailsImmobilisation> liste = new ArrayList<DetailsImmobilisation>();
            model.addAttribute("listeDetails", liste);
            model.addAttribute("currentPage", 0);
            model.addAttribute("nombrePage",0);
            model.addAttribute("somme",0.0);
        }catch(Exception e){
            throw e;
        }
        return "liste-immobilisation";
    }
    
    @RequestMapping(value="/liste",method=RequestMethod.POST)
    public String rechercheListeImmobilisation(@RequestParam(value="date1",required=false) String date1,@RequestParam(value="date2",required=false) String date2,@RequestParam(value="article",required=false) String article,@RequestParam(value="page",required=false) Integer page ,Model model) throws Exception{
        try{
            
            if(article.isEmpty() && date1.isEmpty() && date2.isEmpty())
                return "redirect:/";
            List<DetailsImmobilisation> liste = new ArrayList<DetailsImmobilisation>();
            if(page==null)
                page = 1;
            ///get list code here
            liste = immoService.getListDetailsImmobilisation(article,date1,date2,page);
            double somme = immoService.getSommePrixAcquisiton(liste);
            int nombrePage = immoService.getCountDetailsImmobilisation(article,date1,date2);
            model.addAttribute("date1", date1);
            model.addAttribute("date2", date2);
            model.addAttribute("article",article);
            model.addAttribute("somme",somme);
            model.addAttribute("listeDetails", liste);
            model.addAttribute("currentPage", (int)page);
            model.addAttribute("nombrePage",nombrePage);
        }catch(Exception e){
            throw e;
        }
        return "liste-immobilisation";
    }
    
    @RequestMapping(value="/tableau",method=RequestMethod.GET)
    public String tableauAmmortissement(@RequestParam(value="id",required=true) int id,Model model) throws Exception{
        DetailsImmobilisation immobilisation = immoService.getDetailsImmobilisation(id);
        List<AmmortissementImmobilisation> tableauAmmortissement = immoService.getTableau(id);
        model.addAttribute("immobilisation", immobilisation);
        model.addAttribute("tableau", tableauAmmortissement);
        return "tableau";
    }
    
    @RequestMapping(value="/details")
    public String getDetailsAmmortissement(@RequestParam(value="annee",required=false) String annee,@RequestParam(value="page",required=false) Integer page,Model model) throws Exception{
        List<DetailsAmmortissement> detailsAmmort = new ArrayList<DetailsAmmortissement>();
        int nombrePage = 0;
        double somme = 0.0;
        if(page==null)
                page = 1;
        if(annee!=null){
            detailsAmmort = immoService.getDetailsAmmortissement(annee,page);
            if(detailsAmmort.size()>0){
                nombrePage = immoService.getCountDetailsAmmortissement(annee);
                somme = immoService.getSommeExercice(detailsAmmort);
            }
            model.addAttribute("annee",annee);
        }
        model.addAttribute("currentPage", (int)page);
        model.addAttribute("somme", somme);
        model.addAttribute("nombrePage",nombrePage);
        model.addAttribute("detailsAmmort", detailsAmmort);
        return "details-ammortissement";
    }
    
    @RequestMapping(value="/liste/pdf",method=RequestMethod.POST)
    public void exportToPdf(@RequestParam(value = "date1", required = true) String date1, @RequestParam(value = "date2", required = true) String date2, @RequestParam(value = "article", required = true) String article, @RequestParam(value = "page", required = true) Integer page, HttpServletResponse response) throws DocumentException, IOException, Exception {
        List<DetailsImmobilisation> liste = new ArrayList<DetailsImmobilisation>();
        if (page == null) {
            page = 1;
        }
        ///get list code here
        liste = immoService.getListDetailsImmobilisation(article, date1, date2, page);
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=immobilisations_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        OpenPdfExporter exporter = new OpenPdfExporter(liste);
        exporter.export(response);
    }
    
    @RequestMapping(value="/tableau/pdf",method=RequestMethod.GET)
    public void exportAmmortToPdf(@RequestParam(value="id",required=true) int id,HttpServletResponse response,Model model) throws Exception{
        DetailsImmobilisation immobilisation = immoService.getDetailsImmobilisation(id);
        List<AmmortissementImmobilisation> tableauAmmortissement = immoService.getTableau(id);
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ammortissement_immo" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        AmmortToPdf exporter = new AmmortToPdf(tableauAmmortissement);
        exporter.export(response,immobilisation);
    }
    
    
    
    @RequestMapping(value="/details/pdf",method=RequestMethod.POST)
    public void exportDetailsToPdf(HttpServletResponse response,@RequestParam(value="annee",required=false) String annee,@RequestParam(value="page",required=false) Integer page,Model model) throws Exception{
        List<DetailsAmmortissement> detailsAmmort = new ArrayList<DetailsAmmortissement>();
        int nombrePage = 0;
        double somme = 0.0;
        if(page==null)
                page = 1;
        if(annee!=null){
            detailsAmmort = immoService.getDetailsAmmortissement(annee,page);
            if(detailsAmmort.size()>0){
                nombrePage = immoService.getCountDetailsAmmortissement(annee);
                somme = immoService.getSommeExercice(detailsAmmort);
            }
        }
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ammortissements" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        DetailsAmmortToPdf exporter = new DetailsAmmortToPdf(detailsAmmort);
        exporter.export(response,annee);
    }
    
    @RequestMapping(value="/liste/csv",method=RequestMethod.POST)
    public void exportToCsv(@RequestParam(value = "date1", required = true) String date1, @RequestParam(value = "date2", required = true) String date2, @RequestParam(value = "article", required = true) String article, @RequestParam(value = "page", required = true) Integer page, HttpServletResponse response) throws DocumentException, IOException, Exception {
        List<DetailsImmobilisation> liste = new ArrayList<DetailsImmobilisation>();
        if (page == null) {
            page = 1;
        }
        ///get list code here
        liste = immoService.getListDetailsImmobilisation(article, date1, date2, page);
        response.setContentType("application/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=immobilisations_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        CsvExportService csvExport = new CsvExportService(liste);
        csvExport.writeToCsv(response.getWriter());
    }
    
//    @GetMapping("/users/export/pdf")
//    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
//        response.setContentType("application/pdf");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        String currentDateTime = dateFormatter.format(new Date());
//         
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
//        response.setHeader(headerKey, headerValue);
//         
//        List<User> listUsers = service.listAll();
//         
//        UserPDFExporter exporter = new UserPDFExporter(listUsers);
//        exporter.export(response);
//         
//    }
}