
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Особистий кабінет | Solus Solutions</title>
    <#include "../a-assets/styles/common-styles.ftlh">
    <#include "../a-assets/styles/bootstrap5.ftlh">
    <#include "../a-assets/styles/bootstrap.ftlh">
    <#include "../services/styles/services-styles.ftlh">

    <style>
        .containerBS5 {
            --bs-gutter-x:1.5rem;
            --bs-gutter-y:0;
            width:100%;
            /*    padding-right:calc(var(--bs-gutter-x) * .5);
                padding-left:calc(var(--bs-gutter-x) * .5);*/
            margin-right:auto;
            margin-left:auto
        }

        @media (min-width:576px) {
            .containerBS5 {
                max-width:540px
            }
        }

        @media (min-width:768px) {
            .containerBS5 {
                max-width:720px
            }
        }

        @media (min-width:992px) {
            .containerBS5 {
                max-width:960px
            }
        }

        @media (min-width:1200px) {
            .containerBS5 {
                max-width:1140px
            }
        }

        @media (min-width:1500px) {
            .containerBS5 {
                max-width:1920px
            }
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

            <div class="containerBS5 px-4 py-5">

                <ul style="list-style-type: none">
                    <li style="margin-bottom: 15px">
                        <a href="/changeusername">Змінити ім'я користувача</a>
                    </li>
                    <li>
                        <a href="/changepassword">Змінити пароль</a>
                    </li>
                </ul>

            </div>
        </main>

    </div>
</div>

<script>
    var examinations = document.getElementById("examinations");
    var results = document.getElementById("results");

    var showExaminations = document.getElementById("showExaminations");
    var showResults = document.getElementById("showResults");

    showExaminations.onclick = function () {
        examinations.style.display = "table";
        results.style.display = "none";

        showResults.className = "btn btn-info my-2 my-sm-2 ";
        showExaminations.className = "btn dangerCustom my-2 my-sm-2 ";

    }
    showResults.onclick = function () {
        examinations.style.display = "none";
        results.style.display = "table";

        showExaminations.className = "btn btn-info my-2 my-sm-2 ";
        showResults.className = "btn dangerCustom my-2 my-sm-2 ";
    }

</script>

</body>
</html>

