
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Особистий кабінет | Solus Solutions</title>
    <#include "../../a-assets/styles/common-styles.ftlh">
    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "../../services/styles/services-styles.ftlh">

    <style>
        .containerService {
            --bs-gutter-x:1.5rem;
            --bs-gutter-y:0;
            width:100%;
            /*    padding-right:calc(var(--bs-gutter-x) * .5);
                padding-left:calc(var(--bs-gutter-x) * .5);*/
            margin-right:auto;
            margin-left:auto
        }

        @media (min-width:576px) {
            .containerService {
                max-width:540px
            }
        }

        @media (min-width:768px) {
            .containerService {
                max-width:720px
            }
        }

        @media (min-width:992px) {
            .containerService {
                max-width:960px
            }
        }

        @media (min-width:1200px) {
            .containerService {
                max-width:1140px
            }
        }

        @media (min-width:1000px) {
            .containerService {
                max-width:1220px
            }
        }

        .table .thead-info th {
            color: white;
            background-color: #17a2b8;
            border-color: #dee2e6;
        }
    </style>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body class="bg-light">

<div class="bg-light">

    <div class="body-font">

        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-info">

            <a class="navbar-brand name-font" href="/"><img class="rounded-lg-3" src="/assets/logo-cropped.png" alt="" width="50px" height="50px"></a>
            <a class="navbar-brand name-font" href="/">SOLUS SOLUTIONS</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" href="/about-us" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Про нас</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="dropdownItemCustom" href="/doctors">Фахівці</a>
                            <a class="dropdownItemCustom" href="/about-us#we-offer">Послуги</a>
                        </div>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/prices">Ціни <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" href="/services" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Напрямки</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="dropdownItemCustom" href="/services/vaccination">Вакцинація</a>
                            <a class="dropdownItemCustom" href="/services/mrt">МРТ</a>
                            <a class="dropdownItemCustom" href="/services/ophthalmology">Офтальмологія</a>
                            <a class="dropdownItemCustom" href="/services/surgery">Хірургія</a>
                            <a class="dropdownItemCustom" href="/services/stomatology">Стоматологія</a>
                            <a class="dropdownItemCustom" href="/services/cardiology">Кардіологія</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdownItemCustom btn-light" href="/services">Більше &raquo;</a>
                        </div>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/contact-us">Контакти <span class="sr-only">(current)</span></a>
                    </li>
                </ul>

                <span class="name-font nav-item active nav-link" style="color: white; padding-right: 50px">Гаряча лінія: +38 (095)-000-00-00</span>
                <form class="form-inline my-2 my-lg-0">
                    <a class="btn btn-dark my-2 my-sm-2" href="/classifier">Онлайн-діагноз</a>
                    &nbsp;
                    <a class="btn dangerCustom my-2 my-sm-2" href="/online-zapys">Онлайн-запис</a>
                    &nbsp;&nbsp;&nbsp;
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" style="font-size: 1.25rem;" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${username}</a>
                            <div class="dropdown-menu" style="min-width: 1rem; width: 100%;" aria-labelledby="dropdown01">
                                <a class="dropdownItemCustom" href="/cabinet">Кабінет</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdownItemCustom" href="/settings">Настройки</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdownItemCustom btn-light" href="/logOut">Вийти</a>
                            </div>
                        </li>
                    </ul>
                </form>
            </div>
        </nav>

        <main role="main">

            <div class="jumbotronCustom">
                <div style="margin-left: 100px;"> <!--class="px-4 py-5"-->
                    <div class="containerHeader">
                        <div class="row align-items-center ">
                            <div >
                                <h1 class="display-6 fw-bold lh-1">Вітаємо, ${firstName}</h1>
                            </div>

                            <br><br><br><br>

                            <ul style="list-style-type: none; font-size: 1.2rem;">
                                <li style="margin-bottom: 15px;"><span >Ім'я користувача:</span> ${patient.username} &nbsp;&nbsp;&nbsp; <a href="/settings" class="fw-bold" style="color: #0f4696">Змінити ім'я?</a></li>
                                <li style="margin-bottom: 15px;"><span >Повне ім'я:</span> ${patient.name}</li>
                                <li style="margin-bottom: 15px;"><span >День народження:</span> ${patient.birthday}</li>
                                <li style="margin-bottom: 15px;"><span >Пошта:</span> ${patient.email}</li>
                                <li style="margin-bottom: 15px;"><span >Телефон:</span> ${patient.phone}</li>
                                <li style="margin-bottom: 15px;"><span >Категорія:</span>
                                    <#if patient.category == "II"> ${patient.category} - знижка 30%
                                    <#elseif patient.category == "III"> ${patient.category} - знижка 50%
                                    <#else> Немає
                                </#if>
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>
            </div>

            <div class="containerBS5 py-4">
                <div class="rowBS5 align-items-md-stretch">
                    <div class="form-check-inline">
                        <input type="button" id="showExaminations" value="Обстеження" class="btn dangerCustom my-2 my-sm-2 ">
                        &nbsp;&nbsp;
                        <input type="button" id="showResults" value="Результати" class="btn btn-info my-2 my-sm-2 ">
                        &nbsp;&nbsp;
                        <input type="button" id="showDiagnoses" value="Попередні діагнози" class="btn btn-info my-2 my-sm-2 ">
                    </div>

                    <div class="col-12" id="examinations">

                            <table class="table table-hover" >
                                <thead class="thead-info">
                                <tr>
                                    <th scope="col">Номер</th>
                                    <th scope="col">Лікар</th>
                                    <th scope="col">Послуга</th>
                                    <th scope="col">Час прийому</th>
                                    <th scope="col">Ціна</th>
                                    <th scope="col">Оплата</th>
                                </tr>
                                </thead>

                                <tbody>
                                <#list examinations as examination>
                                    <tr>
                                        <td>${examination.examinationId}</td>
                                        <td>${examination.doctor.name}</td>
                                        <td>${examination.qualification.name}</td>
                                        <td>${examination.examinationTime}</td>
                                        <td>${examination.price} грн.</td>
                                        <td>
                                            <#if examination.status ??> <span style="margin-left: 10px">${examination.status}</span>
                                            <#else> <a href="/checkout/${examination.examinationId}" class="btn dangerCustom my-2 my-sm-2 ">
                                                Оплатити
                                            </a>
                                            </#if>
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                    </div>

                    <div class="col-12" style="display: none;" id="results">
                            <table class="table table-hover" >
                                <thead class="thead-info">
                                <tr>
                                    <th scope="col">Номер</th>
                                    <th scope="col">Послуга</th>
                                    <th scope="col">Час прийому</th>
                                    <th scope="col">Лікування</th>
                                </tr>
                                </thead>

                                <tbody>
                                <#list results as result>
                                    <tr>
                                        <td>${result.examinationId}</td>
                                        <td>${result.qualification.name}</td>
                                        <td>${result.examinationDate}</td>
                                        <td>${result.prescription}</td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                    </div>

                    <div class="col-12" style="display: none;" id="diagnoses">
                        <table class="table table-hover" >
                            <thead class="thead-info">
                            <tr>
                                <th scope="col">Знімок</th>
                                <th scope="col">Класифіковано як</th>
                                <th scope="col">Діагноз</th>
                                <th scope="col"></th>
                            </tr>
                            </thead>

                            <tbody>
                            <#list diagnoses as diagnosis>
                                <tr>
                                    <td><img src="/diagnosis/${diagnosis.filename}" width="150px" height="150px"></td>
                                    <td>${diagnosis.label}</td>
                                    <td>${diagnosis.diagnosis}</td>
                                    <td><a href="/deleteDiagnosis/${diagnosis.filename}" class="btn dangerCustom my-2 my-sm-2 ">
                                            Видалити знімок?
                                        </a></td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </main>

    </div>
</div>

<script>
    var examinations = document.getElementById("examinations");
    var results = document.getElementById("results");
    var diagnoses = document.getElementById("diagnoses");

    var showExaminations = document.getElementById("showExaminations");
    var showResults = document.getElementById("showResults");
    var showDiagnoses = document.getElementById("showDiagnoses");

    showExaminations.onclick = function () {
        examinations.style.display = "table";
        results.style.display = "none";
        diagnoses.style.display = "none";

        showResults.className = "btn btn-info my-2 my-sm-2 ";
        showDiagnoses.className = "btn btn-info my-2 my-sm-2 ";
        showExaminations.className = "btn dangerCustom my-2 my-sm-2 ";
    }

    showResults.onclick = function () {
        examinations.style.display = "none";
        diagnoses.style.display = "none";
        results.style.display = "table";

        showExaminations.className = "btn btn-info my-2 my-sm-2 ";
        showDiagnoses.className = "btn btn-info my-2 my-sm-2 ";
        showResults.className = "btn dangerCustom my-2 my-sm-2 ";
    }

    showDiagnoses.onclick = function () {
        diagnoses.style.display = "table";
        results.style.display = "none";
        examinations.style.display = "none";

        showResults.className = "btn btn-info my-2 my-sm-2 ";
        showExaminations.className = "btn btn-info my-2 my-sm-2 ";
        showDiagnoses.className = "btn dangerCustom my-2 my-sm-2 ";
    }

</script>

</body>
</html>

