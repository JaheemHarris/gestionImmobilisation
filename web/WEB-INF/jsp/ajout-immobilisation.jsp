<%-- 
    Document   : test
    Created on : May 24, 2022, 12:56:45 PM
    Author     : jaheem
--%>
<%@page import="mg.gestion.immobilisation.model.TypeAmmortissement"%>
<%@page import="java.util.List"%>
<%@page import="mg.gestion.immobilisation.model.Article"%>
<% List<Article> articleList = (List<Article>)request.getAttribute("articles"); %>
<% List<TypeAmmortissement> typeList = (List<TypeAmmortissement>)request.getAttribute("types"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>GestionImmobilisation</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="ressources/assets/img/favicon.png" rel="icon">
    <link href="ressources/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="ressources/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="ressources/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="ressources/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="ressources/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="ressources/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="ressources/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="ressources/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="ressources/assets/css/style.css" rel="stylesheet">

    <!-- =======================================================
    * Template Name: NiceAdmin - v2.2.2
    * Template URL: https://bootstrapmade.com/nice-admin-bootstrap-admin-html-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== -->
</head>

<body>

<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
        <a href="/" class="logo d-flex align-items-center">
            <img src="assets/img/logo.png" alt="">
            <span class="d-none d-lg-block">GestionImmobilisation</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->
</header>
<!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed" href="home">
                <i class="bi bi-grid"></i>
                <span>Home</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="liste">
                <i class="bi bi-question-circle"></i>
                <span>Liste - Immobilisation</span>
            </a>
        </li><!-- End F.A.Q Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="page-ajout-immobilisation">
                <i class="bi bi-envelope"></i>
                <span>Ajout Immobilisation</span>
            </a>
        </li><!-- End Contact Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="details">
                <i class="bi bi-card-list"></i>
                <span>Ammortissement - Annee</span>
            </a>
        </li><!-- End Register Page Nav -->
    </ul>

</aside>
<!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Ajout-Immobilisation</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/">Acceuil</a></li>
                <li class="breadcrumb-item">Ajout-Immobilisation</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->
    <section class="section">
        <div class="row justify-content-center">

            <div class="col-lg-8">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Ajout - Immobilisation</h5>

                        <!-- Vertical Form -->
                        <form class="row g-3" method="POST" action="ajoutImmobilisation">
                            <div class="col-12">
                                <div class="form-floating mb-3">
                                    <select class="form-select" id="article" aria-label="State" name="idArticle">
                                        <% for(Article article : articleList) { %>
                                            <option value="<%=article.getId() %>"><%=article.getDesignation() %></option>
                                        <% } %>
                                    </select>
                                    <label for="article">Article</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <div class="form-floating mb-3">
                                    <select class="form-select" id="type" aria-label="State" name="idTypeAmmortissement">
                                        <% for(TypeAmmortissement type : typeList) { %>
                                            <option value="<%=type.getId() %>"><%=type.getType() %></option>
                                        <% } %>
                                    </select>
                                    <label for="type">Type d'ammortissement</label>
                                </div>
                            </div>
                            <div class="col-12">
                                <label for="prix" class="form-label">Prix d'acquisition </label>
                                <input type="number" min="0" class="form-control" id="prix" name="prixAcquisition">
                            </div>
                            <div class="col-12">
                                <label for="achat" class="form-label">Date d'achat </label>
                                <input type="date" class="form-control" id="dateAchat" name="achat">
                            </div>
                            <div class="col-12">
                                <label for="service" class="form-label">Date de mise en service </label>
                                <input type="date" class="form-control" id="service" name="service">
                            </div>
                            <div class="col-12">
                                <label for="duree" class="form-label">Duree d'ammortissement </label>
                                <input type="number" min="0" class="form-control" id="duree" name="dureeAmmortissement">
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Ajouter</button>
                                <button type="reset" class="btn btn-secondary">Annuler</button>
                            </div>
                        </form><!-- Vertical Form -->

                    </div>
                </div>

            </div>
        </div>
    </section>

</main><!-- End #main -->

<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright &copy; 2022 <strong><span>GestionImmobilisation</span></strong>. Tous droits réservés
    </div>
</footer><!-- End Footer -->

<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="ressources/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="ressources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="ressources/assets/vendor/chart.js/chart.min.js"></script>
<script src="ressources/assets/vendor/echarts/echarts.min.js"></script>
<script src="ressources/assets/vendor/quill/quill.min.js"></script>
<script src="ressources/assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="ressources/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="ressources/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="ressources/assets/js/main.js"></script>

</body>

</html>