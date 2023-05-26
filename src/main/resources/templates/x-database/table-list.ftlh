<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Solus Database</title>

    <#include "../a-assets/styles/common-styles.ftlh">
    <#include "../a-assets/styles/bootstrap5.ftlh">
    <#include "../a-assets/styles/bootstrap.ftlh">
    <#include "db-styles.ftlh">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>

        body{
            background: #212529;
        }

        a{
            color: white;
        }

        a:hover{
            transition: .1s;
            color: lightgrey;
        }

    </style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

    <a class="navbar-brand name-font" href="/database/main"><img class="rounded-lg-3" src="/assets/logo-dark.png" alt="" width="50px" height="50px"></a>
    <a class="navbar-brand name-font" href="/database/main">SOLUS DATABASE</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
        </ul>

        <form class="form-inline my-2 my-lg-0">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown active">
                    <a class="nav-link dropdown-toggle" style="font-size: 1.25rem;" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${username}</a>
                    <div class="dropdown-menu" style="min-width: 1rem; width: 100%;" aria-labelledby="dropdown01">
                        <a class="dropdownItemCustom btn-light" href="/database/logout">Вийти</a>
                    </div>
                </li>
            </ul>
        </form>
    </div>
</nav>

<br>

<div class="form-check-inline">
    <input type="button" id="forDoctors" value="Лікарям" class="btn btn-success btn-lg my-2 my-sm-2 ">
    &nbsp;&nbsp;
    <input type="button" id="forCalls" value="Кол-центр" class="btn btn-dark btn-lg my-2 my-sm-2 ">
    &nbsp;&nbsp;
    <input type="button" id="forAdmins" value="Адміністраторам" class="btn btn-dark btn-lg my-2 my-sm-2 ">
</div>

<div style="margin: 0 auto; width: 100%">
    <table class="table table-dark table-hover fs-5" id="doctors">

        <tr class="row-link" style="height: 100px;">
                <td style="vertical-align: middle">
                    <a href="/database/results/find/all" style="display: block; text-decoration: none;">
                        Результати
                    </a>
                </td>
        </tr>

    </table>

    <table class="table table-dark table-hover fs-5" style="display: none" id="calls">

        <tr class="row-link" style="height: 100px;">
            <td style="vertical-align: middle">
                <a href="/database/patients/find/all" style="display: block; text-decoration: none;">
                    Пацієнти
                </a>
            </td>
        </tr>


        <tr class="row-link" style="height: 100px;">
            <td style="vertical-align: middle">
                <a href="/database/examinations/find/all" style="display: block; text-decoration: none;">
                    Обстеження
                </a>
            </td>
        </tr>

    </table>

    <table class="table table-dark table-hover fs-5" style="display: none" id="admins">

        <tr class="row-link" style="height: 100px;">
            <td style="vertical-align: middle">
                <a href="/database/qualification/find/all" style="display: block; text-decoration: none;">
                    Напрямки
                </a>
            </td>
        </tr>

        <tr class="row-link" style="height: 100px;">
            <td style="vertical-align: middle">
                <a href="/database/qualificationPrices/find/all" style="display: block; text-decoration: none;">
                    Ціни
                </a>
            </td>
        </tr>

        <tr class="row-link" style="height: 100px;">
            <td style="vertical-align: middle">
                <a href="/database/personnel/find/all" style="display: block; text-decoration: none;">
                    Лікарі
                </a>
            </td>
        </tr>

        <tr class="row-link" style="height: 100px;">
            <td style="vertical-align: middle">
                <a href="/database/personnelCategory/find/all" style="display: block; text-decoration: none;">
                    Категорії
                </a>
            </td>
        </tr>

        <tr class="row-link" style="height: 100px;">
            <td style="vertical-align: middle">
                <a href="/database/illnesses/find/all" style="display: block; text-decoration: none;">
                    Захворювання
                </a>
            </td>
        </tr>

    </table>
</div>


<script>
    var doctors = document.getElementById("doctors");
    var calls = document.getElementById("calls");
    var admins = document.getElementById("admins");

    var forDoctors = document.getElementById("forDoctors");
    var forCalls = document.getElementById("forCalls");
    var forAdmins = document.getElementById("forAdmins");

    forDoctors.onclick = function () {
        doctors.style.display = "table";
        calls.style.display = "none";
        admins.style.display = "none";

        forDoctors.className = "btn btn-success btn-lg my-2 my-sm-2 ";
        forCalls.className = "btn btn-dark btn-lg my-2 my-sm-2 ";
        forAdmins.className = "btn btn-dark btn-lg my-2 my-sm-2 ";
    }

    forCalls.onclick = function () {
        doctors.style.display = "none";
        calls.style.display = "table";
        admins.style.display = "none";

        forDoctors.className = "btn btn-dark btn-lg my-2 my-sm-2 ";
        forCalls.className = "btn btn-success btn-lg my-2 my-sm-2 ";
        forAdmins.className = "btn btn-dark btn-lg my-2 my-sm-2 ";
    }

    forAdmins.onclick = function () {
        doctors.style.display = "none";
        calls.style.display = "none";
        admins.style.display = "table";

        forDoctors.className = "btn btn-dark btn-lg my-2 my-sm-2 ";
        forCalls.className = "btn btn-dark btn-lg my-2 my-sm-2 ";
        forAdmins.className = "btn btn-success btn-lg my-2 my-sm-2 ";
    }

</script>

</body>
</html>