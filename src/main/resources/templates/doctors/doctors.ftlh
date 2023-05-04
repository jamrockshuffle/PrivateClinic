<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Лікарі | Solus Solutions</title>
    <#include "../a-assets/styles/common-styles.ftlh">
    <#include "../a-assets/styles/bootstrap5.ftlh">
    <#include "../a-assets/styles/bootstrap.ftlh">
    <#include "styles/doctors-styles.ftlh">

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
                            <a class="dropdownItemCustom" href="#">Вакцинація</a>
                            <a class="dropdownItemCustom" href="#">МРТ</a>
                            <a class="dropdownItemCustom" href="#">Офтальмологія</a>
                            <a class="dropdownItemCustom" href="#">Гінекологія</a>
                            <a class="dropdownItemCustom" href="#">Хірургія</a>
                            <a class="dropdownItemCustom" href="#">Стоматологія</a>
                            <a class="dropdownItemCustom" href="#">Кардіологія</a>
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
                    <button class="btn dangerCustom my-2 my-sm-2" type="submit">Онлайн-запис</button>
                    &nbsp;&nbsp;&nbsp;
                    <button class="btn btn-info my-2 my-sm-0 btn-lg" type="submit">Увійти</button>
                </form>
            </div>
        </nav>

        <main role="main">

            <div class="jumbotronCustom">
                <!--<section class="py-5 text-center container">
                  <div class="row ">
                    <div class="col-lg-6 col-md-8 mx-auto">
                      <h1 class="fw-bold displayCustom">НАШІ ЛІКАРІ</h1>
                    </div>
                  </div>
                </section>-->

                <div style="margin-left: 100px;"> <!--class="px-4 py-5"-->
                    <div class="containerHeader my-5">
                        <div class="row  align-items-center ">
                            <div class="col-lg-7 p-3 p-lg-5 pt-lg-3">
                                <h1 class="display-4 fw-bold lh-1">Майстерність та досвід</h1>
                                <p class="lead text-muted-custom">Перед вами - працівники нашої клініки, кращі з кращих,
                                    з якими ми маємо честь працювати. Тут ви можете дізнатися їхню спеціальність, посаду та категорію.</p>
                            </div>
                            <div class="col-lg-4 offset-lg-1 p-0 overflow-hidden ">
                                <img class="rounded-lg-3" src="/assets/SOLUS%20SOLUTIONS.png" alt="" width="250px" height="250px">
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="album py-5 bg-light">

                <div class="containerBS5">

                    <h2 class="pb-2  name-font" align="center">Наші лікарі:</h2>
                    <p class="text-muted border-bottom" align="center"></p>

                    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                        <div class="colBS5">
                            <div class="card shadow-sm border border-info">

                                <img src="/assets/logo-cropped.png" width="465px" height="225px">
                                <div class="card-bodyBS5">
                                    <p class="card-text">wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww</p>
                                </div>
                            </div>
                        </div>

                        <div class="colBS5">
                            <div class="card shadow-sm border border-info">

                                <svg class="bd-placeholder-img card-img-top" width="100%" height="225" role="img"
                                     aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice"
                                     focusable="false"><title>Placeholder</title><rect width="100%" height="100%"
                                                                                       fill="#55595c"/><text x="50%" y="50%" fill="#eceeef"
                                                                                                             dy=".3em">Thumbnail</text></svg>
                                <div class="card-bodyBS5">
                                    <p class="card-text">Посада <br> напрямки <br> категорія</p>
                                </div>
                            </div>
                        </div>

                        <div class="colBS5">
                            <div class="card shadow-sm border border-info">

                                <svg class="bd-placeholder-img card-img-top" width="100%" height="225" role="img"
                                     aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice"
                                     focusable="false"><title>Placeholder</title><rect width="100%" height="100%"
                                                                                       fill="#55595c"/><text x="50%" y="50%" fill="#eceeef"
                                                                                                             dy=".3em">Thumbnail</text></svg>
                                <div class="card-bodyBS5">
                                    <p class="card-text">Посада <br> напрямки <br> категорія</p>
                                </div>
                            </div>
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
