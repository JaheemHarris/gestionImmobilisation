<%-- 
    Document   : test
    Created on : May 24, 2022, 12:56:45 PM
    Author     : jaheem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>MilkIt</title>
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
        <a href="index.html" class="logo d-flex align-items-center">
            <img src="assets/img/logo.png" alt="">
            <span class="d-none d-lg-block">MilkIt</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

    <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">

            <li class="nav-item dropdown pe-3">

                <a class="nav-link nav-profile d-flex align-items-center pe-0" href="#" data-bs-toggle="dropdown">
                    <img src="assets/img/profile-img.jpg" alt="Profile" class="rounded-circle">
                    <span class="d-none d-md-block dropdown-toggle ps-2">K. Anderson</span>
                </a><!-- End Profile Iamge Icon -->

                <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
                    <li class="dropdown-header">
                        <h6>Kevin Anderson</h6>
                        <span>Web Designer</span>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="bi bi-person"></i>
                            <span>My Profile</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="users-profile.html">
                            <i class="bi bi-gear"></i>
                            <span>Account Settings</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="pages-faq.html">
                            <i class="bi bi-question-circle"></i>
                            <span>Need Help?</span>
                        </a>
                    </li>
                    <li>
                        <hr class="dropdown-divider">
                    </li>

                    <li>
                        <a class="dropdown-item d-flex align-items-center" href="#">
                            <i class="bi bi-box-arrow-right"></i>
                            <span>Sign Out</span>
                        </a>
                    </li>

                </ul><!-- End Profile Dropdown Items -->
            </li><!-- End Profile Nav -->

        </ul>
    </nav><!-- End Icons Navigation -->

</header><!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">
            <a class="nav-link collapsed" href="/home">
                <i class="bi bi-grid"></i>
                <span>Home</span>
            </a>
        </li><!-- End Dashboard Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-menu-button-wide"></i><span>Etat de stock</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/etatStockMatiere">
                        <i class="bi bi-circle"></i><span>MatiÃ¨re premiÃ¨re</span>
                    </a>
                </li>
                <li>
                    <a href="/etatStockProduit">
                        <i class="bi bi-circle"></i><span>Produit</span>
                    </a>
                </li>
            </ul>
        </li><!-- End Components Nav -->

        <li class="nav-heading">Pages</li>

        <li class="nav-item">
            <a class="nav-link collapsed" href="/nonValidated">
                <i class="bi bi-person"></i>
                <span>Comptes non validÃ©es</span>
            </a>
        </li><!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="/faireAchat">
                <i class="bi bi-person"></i>
                <span>Achat - MatiÃ¨re PremiÃ¨re</span>
            </a>
        </li><!-- End Profile Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="/listeAchat">
                <i class="bi bi-question-circle"></i>
                <span>Liste - Achats<</span>
            </a>
        </li><!-- End F.A.Q Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="/listeProduit">
                <i class="bi bi-envelope"></i>
                <span>Liste - Produits</span>
            </a>
        </li><!-- End Contact Page Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" href="/voirFormule">
                <i class="bi bi-card-list"></i>
                <span>Formule Produit</span>
            </a>
        </li><!-- End Register Page Nav -->
    </ul>

</aside><!-- End Sidebar-->

<main id="main" class="main">

    <div class="pagetitle">
        <h1>Acceuil</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="/">Acceuil</a></li>
            </ol>
        </nav>
    </div><!-- End Page Title -->

    <section class="section">
        <div class="row">
            <div class="col-lg-12">

                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title" th:utext="| Bonjour ${name}|"></h5>
                        <p>Bienvenue sur le site de la sociÃ©tÃ© MilkIt.</p>
                    </div>
                </div>

            </div>
        </div>
    </section>

</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer" class="footer">
    <div class="copyright">
        &copy; Copyright &copy; 2022 <strong><span>MilkIt</span></strong>. All Rights Reserved
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