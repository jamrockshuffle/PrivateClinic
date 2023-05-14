<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Про нас | Solus Solutions</title>
    <#include "../a-assets/styles/common-styles.ftlh">
    <#include "../a-assets/styles/bootstrap5.ftlh">
    <#include "../a-assets/styles/bootstrap.ftlh">
    <#include "styles/about-us-styles.ftlh">



    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
           rel="stylesheet"
           integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
           crossorigin="anonymous"> -->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body class="bg-info">

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
                    <a class="btn dangerCustom my-2 my-sm-2" href="/online-zapys">Онлайн-запис</a>
                    &nbsp;&nbsp;&nbsp;
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" style="font-size: 1.25rem;" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${username}</a>
                            <div class="dropdown-menu" style="min-width: 1rem; width: 100%;" aria-labelledby="dropdown01">
                                <a class="dropdownItemCustom" href="#">Кабінет</a>
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

                <!--<section class="py-5 text-center container">
                  <div class="row ">
                    <div class="col-lg-6 col-md-8 mx-auto">
                      <h1 class="fw-bold displayCustom">ПРО НАС</h1>
                    </div>
                  </div>
                </section>-->

                <div style="margin-left: 100px;"> <!--class="px-4 py-5"-->
                    <div class="containerHeader my-5">
                        <div class="row  align-items-center ">
                            <div class="col-lg-7 p-3 p-lg-5 pt-lg-3">
                                <!--<h1 class="display-4 fw-bold lh-1">Надійність та досягнення</h1>
                                <p class="lead text-muted-custom">Для нас завжди були важливими комфорт та якість лікування наших пацієнтів, тому
                                  клініка Solus Solutions отримала міжнародний стандарт якості ДСТУ ISO-9001,
                                  що тільки закріпляє нас як кращих у своїй справі.</p>-->
                                <h1 class="display-4 fw-bold lh-1">Якість, гарантія, [...]</h1>
                                <p class="lead text-muted-custom">Заснована у 2015 у Чернівцях,
                                    Solus Solutions швидко стала провідною по всій області. Ми пропонуємо широкий спектр послуг,
                                    низькі ціни та досвідчених фахівців, які вам допоможуть. Solus Solutions - це вибір №1 у сфері медичного
                                    обслуговування.</p>
                            </div>
                            <div class="col-lg-4 offset-lg-1 p-0 overflow-hidden ">
                                <img class="rounded-lg-3" src="/assets/SOLUS%20SOLUTIONS.png" alt="" width="250px" height="250px">
                            </div>
                        </div>
                    </div>
                </div>

                <a name="we-offer"></a>

            </div>


            <div class="containerService px-4 py-5">

                <h2 class="pb-2  name-font" align="center">Наші послуги:</h2>
                <p class="text-muted border-bottom" align="center"></p>
                <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
                    <div class="">
                        <div class="card mb-4 rounded-3 shadow-sm border border-info">
                            <div class="card-header py-3">
                                <h4 class="my-0 fw-normal">
                                    <img src="/assets/teds1.png" height="80px" width="80px">
                                    Допомога <span class="name-font"> 24/7</span> </h4>
                            </div>
                            <div class="card-bodyBS5">
                <span class="text-muted fsCustom">
                  Варто лише подзвонити - і наша команда швидкого реагування з'явиться до вашого будинку протягом 10 хвилин!
                  <br><br>
                  Вам нададуть необхідну допомогу або заберуть до стаціонару - все це по низькій ціні.
                </span>
                            </div>
                        </div>
                    </div>

                    <div class="">
                        <div class="card mb-4 rounded-3 shadow-sm border border-info">
                            <div class="card-header py-3">
                                <h4 class="my-0 fw-normal">
                                    <img src="/assets/teds2.png" height="80px" width="80px">
                                    Кваліфіковані фахівці </h4>
                            </div>
                            <div class="card-bodyBS5">
                <span class="text-muted fsCustom">
                  sdsffsdfsdsdfldfsfdsfsdfdsfdssdfdsssssdsdfssdfsdfjsdfsdjfl
                  <br><br>ksdjlkdsjsdlksjfklsjskljfskljsdfklj
                  <br>d'f;ldslkdl;gkd;flkgd;lkgd;lkg;dl
                  <br>sdflsdkf;dlsksf;lk;lskfslfd
                </span>
                            </div>
                        </div>
                    </div>

                    <div class="">
                        <div class="card mb-4 rounded-3 shadow-sm border border-info">
                            <div class="card-header py-3">
                                <h4 class="my-0 fw-normal">
                                    <img src="/assets/teds.png" height="80px" width="80px">
                                    Швидке обслуговування </h4>
                            </div>
                            <div class="card-bodyBS5">
                <span class="text-muted fsCustom">
                  sdsffsdfsdsdfldfsfdsfsdfdsfdssdfdsssssdsdfssdfsdfjsdfsdjfl
                  <br><br>ksdjlkdsjsdlksjfklsjskljfskljsdfklj
                  <br>d'f;ldslkdl;gkd;flkgd;lkgd;lkg;dl
                  <br>sdflsdkf;dlsksf;lk;lskfslfd
                </span>
                            </div>
                        </div>
                    </div>

                    <div class="">
                        <div class="card mb-4 rounded-3 shadow-sm border border-info">
                            <div class="card-header py-3">
                                <h4 class="my-0 fw-normal">
                                    <img src="/assets/teds.png" height="80px" width="80px">
                                    Безкоштовні консультації </h4>
                            </div>
                            <div class="card-bodyBS5">
                <span class="text-muted fsCustom">
                  sdsffsdfsdsdfldfsfdsfsdfdsfdssdfdsssssdsdfssdfsdfjsdfsdjfl
                  <br><br>ksdjlkdsjsdlksjfklsjskljfskljsdfklj
                  <br>d'f;ldslkdl;gkd;flkgd;lkgd;lkg;dl
                  <br>sdflsdkf;dlsksf;lk;lskfslfd
                </span>
                            </div>
                        </div>
                    </div>

                    <div class="">
                        <div class="card mb-4 rounded-3 shadow-sm border border-info">
                            <div class="card-header py-3">
                                <h4 class="my-0 fw-normal">
                                    <img src="/assets/teds.png" height="80px" width="80px">
                                    Ми по всій області </h4>
                            </div>
                            <div class="card-bodyBS5">
                <span class="text-muted fsCustom">
                  sdsffsdfsdsdfldfsfdsfsdfdsfdssdfdsssssdsdfssdfsdfjsdfsdjfl
                  <br><br>ksdjlkdsjsdlksjfklsjskljfskljsdfklj
                  <br>d'f;ldslkdl;gkd;flkgd;lkgd;lkg;dl
                  <br>sdflsdkf;dlsksf;lk;lskfslfd
                </span>
                            </div>
                        </div>
                    </div>

                    <div class="">
                        <div class="card mb-4 rounded-3 shadow-sm border border-info">
                            <div class="card-header py-3">
                                <h4 class="my-0 fw-normal">
                                    <img src="/assets/teds.png" height="80px" width="80px">
                                    Багатопрофільність </h4>
                            </div>
                            <div class="card-bodyBS5">
                <span class="text-muted fsCustom">
                  sdsffsdfsdsdfldfsfdsfsdfdsfdssdfdsssssdsdfssdfsdfjsdfsdjfl
                  <br><br>ksdjlkdsjsdlksjfklsjskljfskljsdfklj
                  <br>d'f;ldslkdl;gkd;flkgd;lkgd;lkg;dl
                  <br>sdflsdkf;dlsksf;lk;lskfslfd
                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <div class="containerBS5 px-4 py-5" id="icon-grid">

                <h2 class="pb-2  name-font" align="center">Історія:</h2>
                <p class="text-muted border-bottom" align="center"></p>

                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-4 g-4 py-5">

                    <div class=" d-flex align-items-start">
                        <div>
                            <h1 class="fw-bold mb-0 ">2015</h1>
                            <p class="text-muted fsCustom">Клініка заснована. Був прийнятий перший пацієнт.</p>
                        </div>
                    </div>

                    <div class=" d-flex align-items-start">
                        <div>
                            <h1 class="fw-bold mb-0 ">2016</h1>
                            <p class="text-muted fsCustom">Клініка заснована. Був прийнятий перший пацієнт.</p>
                        </div>
                    </div>

                    <div class=" d-flex align-items-start">
                        <div>
                            <h1 class="fw-bold mb-0 ">2017</h1>
                            <p class="text-muted fsCustom">Клініка заснована. Був прийнятий перший пацієнт.</p>
                        </div>
                    </div>

                    <div class=" d-flex align-items-start">
                        <div>
                            <h1 class="fw-bold mb-0 ">2018</h1>
                            <p class="text-muted fsCustom">Клініка заснована. Був прийнятий перший пацієнт.</p>
                        </div>
                    </div>

                    <div class=" d-flex align-items-start">
                        <div>
                            <h1 class="fw-bold mb-0 ">2019</h1>
                            <p class="text-muted fsCustom">Клініка заснована. Був прийнятий перший пацієнт.</p>
                        </div>
                    </div>

                    <div class=" d-flex align-items-start">
                        <div>
                            <h1 class="fw-bold mb-0 ">2020</h1>
                            <p class="text-muted fsCustom">Клініка заснована. Був прийнятий перший пацієнт.</p>
                        </div>
                    </div>

                    <div class=" d-flex align-items-start">
                        <div>
                            <h1 class="fw-bold mb-0 ">2021</h1>
                            <p class="text-muted fsCustom">Клініка заснована. Був прийнятий перший пацієнт.</p>
                        </div>
                    </div>

                    <div class=" d-flex align-items-start">
                        <div>
                            <h1 class="fw-bold mb-0 ">2022</h1>
                            <p class="text-muted fsCustom">Клініка заснована. Був прийнятий перший пацієнт.</p>
                        </div>
                    </div>

                    <div class=" d-flex align-items-start">
                        <div>
                            <h1 class="fw-bold mb-0 ">2023</h1>
                            <p class="text-muted fsCustom">Клініка заснована. Був прийнятий перший пацієнт.</p>
                        </div>
                    </div>

                </div>
            </div>


        </main>

        <br>

        <hr style="height:1px;border-width:0;background-color:black;width:95.8%; margin: auto">

        <footer>
            <div class="container">
                <footer class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5">
                    <div class="col mb-3">
                <span class="d-flex align-items-center mb-5 link-dark text-decoration-none h3 fw-bold">
                    Де нас знайти?
                </span>
                    </div>

                    <div class="col mb-3">

                    </div>

                    <div class="col mb-3">
                        <h5 class="fw-bold">вул. Університетська</h5>
                        <ul class="nav flex-column">
                            <li class="nav-item mb-2"><span class="nav-link p-0 text-muted">+38 (095)-000-00-00</span></li>
                            <li class="nav-item mb-2"><span href="#" class="nav-link p-0 text-muted">Пн-Сб: 9:00-21:00</span></li>
                            <li class="nav-item mb-2"><span href="#" class="nav-link p-0 text-muted">Нд: 10:00-18:00</span></li>
                            <li class="nav-item mb-2"><a href="https://goo.gl/maps/KxG5tKoZyd1DfamQ9" class="nav-link p-0 text-muted text-decoration-underline" target="_blank">Дивитися на карті</a></li>
                        </ul>
                    </div>

                    <div class="col mb-3">
                        <h5 class="fw-bold">вул. Кобилянської</h5>
                        <ul class="nav flex-column">
                            <li class="nav-item mb-2"><span class="nav-link p-0 text-muted">+38 (095)-000-00-00</span></li>
                            <li class="nav-item mb-2"><span href="#" class="nav-link p-0 text-muted">Пн-Сб: 9:00-21:00</span></li>
                            <li class="nav-item mb-2"><span href="#" class="nav-link p-0 text-muted">Нд: 10:00-18:00</span></li>
                            <li class="nav-item mb-2"><a href="https://goo.gl/maps/KxG5tKoZyd1DfamQ9" class="nav-link p-0 text-muted text-decoration-underline" target="_blank">Дивитися на карті</a></li>
                        </ul>
                    </div>
                </footer>
            </div>


            <div class="bg-info">
                <div class="container">
                    <footer class="py-3 my-4">
                        <div class="footerLogoContainerCropped" style="margin: auto"></div>
                        <hr style="height:2.1px;border-width:0;background-color:white">
                        <p class="text-center" style="color: white">&copy; 2022 Solus Solutions</p>
                    </footer>
                </div>
            </div>
        </footer>

    </div>
</div>

</body>
</html>
