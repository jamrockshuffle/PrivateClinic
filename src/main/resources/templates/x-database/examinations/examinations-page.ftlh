<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Обстеження</title>

    <#include "../../a-assets/styles/common-styles.ftlh">
    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "../db-styles.ftlh">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>

        body{
            background: #212529;
        }

        a{
            text-decoration: none;
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
    <a class="navbar-brand name-font" href="/database/main">SOLUS DATABASE &bullet; Обстеження</a>

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

<a href="/database/main" class="fa fa-reply" title="Назад"></a>

<div style="margin: 0 auto; width: 100%;">
    <table class="table table-dark table-hover" id="examinations">
        <thead>
        <tr>
            <th><input type="hidden" onkeyup="search();"></th>
            <th><input type="text" class="form-control" id="searchByUniqueId" onkeyup="search();" placeholder="Введіть номер"></th>
            <th><input type="text" class="form-control" id="searchByPatient" onkeyup="search();" placeholder="Введіть пацієнта"></th>
            <th><input type="text" class="form-control" id="searchByDoctor" onkeyup="search();" placeholder="Введіть лікаря"></th>
            <th><input type="hidden" onkeyup="search();"></th>
            <th><input type="hidden" onkeyup="search();"></th>
            <th><input type="hidden" onkeyup="search();"></th>
            <th><input type="text" class="form-control" id="searchByPayment" onkeyup="search();" placeholder="Введіть оплату"></th>
            <th colspan="2"><a class="btn btn-light" style="color: black" onclick="reset()">Скинути</a></th>
        </tr>
        <tr>
            <th>ID</th>
            <th>Номер</th>
            <th><a href="/database/patients/find/all">Пацієнт</a></th>
            <th><a href="/database/personnel/find/all">Лікар</a></th>
            <th>Час</th>
            <th><a href="/database/qualificationPrices/find/all">Послуга</a></th>
            <th>Ціна</th>
            <th>Оплата</th>
            <th></th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <#list examinations as examination>
            <tr>
                <td>${examination.id}</td>
                <td>${examination.examinationId}</td>
                <td>${examination.patient.name}</td>
                <td>${examination.doctor.name}</td>
                <td>${examination.examinationTime}</td>
                <td>${examination.qualification.name}</td>
                <td>${examination.price} грн.</td>
                <td>
                    <#if examination.status ??> <span>${examination.status}</span>
                    <#else> Немає
                    </#if>
                </td>
                <td>
                    <a href="/database/examinations/update/${examination.id}">
                        <button class="btn btn-light btn-sm">Update</button>
                    </a>
                </td>
                <td>
                    <a href="/database/examinations/delete/${examination.id}">
                        <button class="btn dangerCustom btn-sm">Delete</button>
                    </a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>

<script>
    function search() {
        const query = q => document.querySelectorAll(q);
        const filters = [...query('th input')].map(e => new RegExp(e.value, 'i'));

        query('tbody tr').forEach(row => row.style.display =
            filters.every((f, i) => f.test(row.cells[i].textContent)) ? '' : 'none');
    }

    function reset() {
        const searches = document.getElementsByTagName("input");

        for (let i = 0; i < searches.length; i++) {
            searches[i].value = "";
        }

        const query = q => document.querySelectorAll(q);
        const filters = [...query('th input')].map(e => new RegExp(e.value, 'i'));

        query('tbody tr').forEach(row => row.style.display =
            filters.every((f, i) => f.test(row.cells[i].textContent)) ? '' : 'none');
    }
</script>

</body>
</html>