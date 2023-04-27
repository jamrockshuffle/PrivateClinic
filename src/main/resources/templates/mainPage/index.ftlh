<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Головна | Solus Solutions</title>

    <#include "../a-assets/styles/common-styles.ftlh">
    <#include "../a-assets/styles/bootstrap5.ftlh">
    <#include "../a-assets/styles/bootstrap.ftlh">
    <#include "../a-assets/styles/mainPage/index-style.ftlh">

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

            <a class="navbar-brand name-font" href="#"><img class="rounded-lg-3" src="/assets/logo-cropped.png" alt="" width="50px" height="50px"></a>
            <a class="navbar-brand name-font" href="#">SOLUS SOLUTIONS</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Про нас</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="dropdownItemCustom" href="#">Фахівці</a>
                            <a class="dropdownItemCustom" href="#">Послуги</a>
                        </div>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Ціни <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" href="#" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Напрямки</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown01">
                            <a class="dropdownItemCustom" href="#">Вакцинація</a>
                            <a class="dropdownItemCustom" href="#">МРТ</a>
                            <a class="dropdownItemCustom" href="#">Офтальмологія</a>
                            <a class="dropdownItemCustom" href="#">Гінекологія</a>
                            <a class="dropdownItemCustom" href="#">Хірургія</a>
                            <a class="dropdownItemCustom" href="#">Стоматологія</a>
                            <a class="dropdownItemCustom" href="#">Кардіологія</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdownItemCustom btn-light" href="#">Більше &raquo;</a>
                        </div>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Контакти <span class="sr-only">(current)</span></a>
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
                <!--<div class="containerCustomFlex">
                    <div class="logoContainer"></div>
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <h1 class="displayCustom name-font" >ПРИВАТНА КЛІНІКА №1 У ЧЕРНІВЦЯХ</h1>
                </div>

                <div class="container">
                    <div class="logoContainer"></div>
                    <h1 class="displayCustom name-font" >ПРИВАТНА КЛІНІКА №1 У ЧЕРНІВЦЯХ</h1>
                </div>

                <div class="container">
                    <div class="logoContainer" style="margin: auto; width: 300px; height: 300px"></div>
                </div>

                <div class="container">
                    <div class="logoContainer" style="margin: auto"></div>
                    <h1 class="displayCustom name-font" align="center">ПРИВАТНА КЛІНІКА №1 У ЧЕРНІВЦЯХ</h1>
                </div>
                -->

                <!--<div class="containerCustomFlex">
                    <div class="logoContainerCropped"></div>
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                    <h1 class="displayCustom name-font" >ПРИВАТНА КЛІНІКА №1 У ЧЕРНІВЦЯХ</h1>
                </div>

                <div class="container">
                    <div class="logoContainerCropped"></div>
                    <h1 class="displayCustom name-font" >ПРИВАТНА КЛІНІКА №1 У ЧЕРНІВЦЯХ</h1>
                </div>-->

                <!--<div class="container">
                    <div class="logoContainerCropped" style="margin: auto"></div>
                    <h1 class="displayCustom name-font" align="center">ПРИВАТНА КЛІНІКА №1 У ЧЕРНІВЦЯХ</h1>
                </div>

                <br>
                <hr style="height:2.1px;border-width:0;background-color:white">
                <br>

                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <h2 align="center"><img src="../a-assets/24%207%20help.png" height="260px" width="260px"></h2>
                            <h4 align="center">ДОПОМОГА <span class="name-font">24/7</span></h4>
                        </div>
                        <div class="col-md-4">
                            <h2 align="center"><img src="../a-assets/stetoscope.png" height="260px" width="260px"></h2>
                            <h4 align="center">КВАЛІФІКОВАНІ ФАХІВЦІ</h4>
                        </div>
                        <div class="col-md-4">
                            <h2 align="center"><img src="../a-assets/fast%20service.png" height="260px" width="260px"></h2>
                            <h4 align="center">ШВИДКЕ ОБСЛУГОВУВАННЯ</h4>
                        </div>
                    </div>
                </div>-->

                <div class="containerCarousel">

                    <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
                        <div class="carousel-indicators">
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
                            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="3" aria-label="Slide 4"></button>
                        </div>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <svg class="bd-placeholder-img" width="100%" height="100%" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#17a2b8"/></svg>

                                <div class="container">
                                    <div class="carousel-caption text-start ">
                                        <h1>Solus Solutions - приватна клініка №1 у Чернівцях</h1>
                                        <p class="text-muted-custom">Дізнайтеся, що пропонує наша клініка</p>
                                        <p><a href="#" class="btn dangerCustom btn-lg">Більше &raquo;</a></p>
                                    </div>
                                </div>

                            </div>
                            <div class="carousel-item">
                                <svg class="bd-placeholder-img" width="100%" height="100%" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#17a2b8"/></svg>

                                <div class="container">
                                    <div class="carousel-caption text-start">
                                        <h1>Напрямки</h1>
                                        <p class="text-muted-custom">Куди можна записатися?</p>
                                        <p><a href="#" class="btn dangerCustom btn-lg">Більше &raquo;</a></p>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item">
                                <svg class="bd-placeholder-img" width="100%" height="100%" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#17a2b8"/></svg>

                                <div class="container">
                                    <div class="carousel-caption text-start">
                                        <h1>Фахівці</h1>
                                        <p class="text-muted-custom">Лікарі, які можуть вам допомогти</p>
                                        <p><a href="#" class="btn dangerCustom btn-lg">Більше &raquo;</a></p>
                                    </div>
                                </div>
                            </div>

                            <div class="carousel-item">
                                <svg class="bd-placeholder-img" width="100%" height="100%" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#17a2b8"/></svg>

                                <div class="container">
                                    <div class="carousel-caption text-start">
                                        <h1>Ціни</h1>
                                        <p class="text-muted-custom">Вартість за кожну послугу</p>
                                        <p><a href="#" class="btn dangerCustom btn-lg">Більше &raquo;</a></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>

                <!--<div style="margin-left: 130px;"> &lt;!&ndash;class="px-4 py-5"&ndash;&gt;
                    <div class="containerHeader my-5">
                        <div class="row  align-items-center ">
                            <div class="col-lg-7 p-3 p-lg-5 pt-lg-3">
                                <h1 class="display-4 fw-bold lh-1">Якість, гарантія, [...]</h1>
                                <p class="lead text-muted-custom">Заснована у 2015 у Чернівцях,
                                    Solus Solutions швидко стала провідною по всій області. Ми пропонуємо широкий спектр послуг,
                                    низькі ціни та досвідчених фахівців, які вам допоможуть. Solus Solutions - це вибір №1 у сфері медичного
                                    обслуговування.</p>
                            </div>
                            <div class="col-lg-4 offset-lg-1 p-0 overflow-hidden ">
                                <img class="rounded-lg-3" src="../a-assets/SOLUS%20SOLUTIONS.png" alt="" width="250px" height="250px">
                            </div>
                        </div>
                    </div>
                </div>-->


            </div>

            <div class="container px-4 py-5">
                <h2 class="pb-2 fw-bold" align="center">Solus Solutions: піклуємося про ваше здоров'я з 2015!</h2> <!-- name-font -->
                <p class="text-muted border-bottom" align="center"></p>

                <div class="row row-cols-1 row-cols-md-2 align-items-md-center g-5 py-5">
                    <div class="d-flex flex-column align-items-start gap-2">
                        <h3 class="fw-bold">Наші переваги</h3>
                        <p class="text-muted">Чому ви маєте обрати саме нас? </p>
                        <a href="#" class="btn btn-info btn-lg">Більше &raquo;</a>
                    </div>
                    <div class="row row-cols-1 row-cols-sm-2 g-4">
                        <div class="d-flex flex-column gap-2">
                            <div class="feature-icon-small d-inline-flex align-items-center justify-content-center textBgCustom bg-gradient fs-4 rounded-3">
                        <span class="bi" width="1em" height="1em">
                            1
                        </span>
                            </div>
                            <h4 class="fw-semibold mb-0">Ми завжди готові допомогти</h4>
                            <p class="text-muted">Наша команда швидкого реагування завжди прибуде на місце у будь-який час</p>
                        </div>

                        <div class="d-flex flex-column gap-2">
                            <div class="feature-icon-small d-inline-flex align-items-center justify-content-center textBgCustom bg-gradient fs-4 rounded-3">
                        <span class="bi" width="1em" height="1em">
                            2
                        </span>
                            </div>
                            <h4 class="fw-semibold mb-0">Широкий спектр послуг</h4>
                            <p class="text-muted">Діагностика, профілактика, лікування - все, що вам потрібно</p>
                        </div>

                        <div class="d-flex flex-column gap-2">
                            <div class="feature-icon-small d-inline-flex align-items-center justify-content-center textBgCustom bg-gradient fs-4 rounded-3">
                        <span class="bi" width="1em" height="1em">
                            3
                        </span>
                            </div>
                            <h4 class="fw-semibold mb-0">Низькі ціни</h4>
                            <p class="text-muted">У <span class="name-font">кожного</span> обстеження - фіксована ціна. На неї будуть впливати лише знижки, або фахівець.</p>
                        </div>

                        <div class="d-flex flex-column gap-2">
                            <div class="feature-icon-small d-inline-flex align-items-center justify-content-center textBgCustom bg-gradient fs-4 rounded-3">
                        <span class="bi" width="1em" height="1em">
                            4
                        </span>
                            </div>
                            <h4 class="fw-semibold mb-0">Досвідчений персонал</h4>
                            <p class="text-muted">У нас працюють тільки кращі - у цьому можете не сумніватися</p>
                        </div>
                    </div>
                </div>
            </div>

            <hr style="height:1px;border-width:0;background-color:black;width:95.8%; margin: auto">

            <div class="container  col-xxl-8 px-4 py-5 ">
                <div class="row align-items-center g-lg-5 py-5">
                    <div class="col-lg-7 text-center text-lg-start">
                        <h1 class="display-5 fw-bold lh-1 mb-3">Бажаєте безкоштовну консультацію?</h1>
                        <p class="col-lg-11 text-muted">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            Заповніть форму, і з вами зв'яжуться якнайшвидше</p>
                    </div>

                    <div class="col-md-10 mx-auto col-lg-5">
                        <form class="p-4 p-md-5 border rounded-3 bg-light">
                            <div class="form-floating mb-3">
                                <input type="text" class="form-control bg-white" id="name" name="text" placeholder="Василь" required>
                                <small class="text-muted">Наприклад: Василь</small>
                                <label for="name">Як до вас звертатися?</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input type="tel" class="form-control bg-white" id="phone" name="phone" placeholder="+380XXXXXXXXX" title="Номер повинен починатися на +380" required>
                                <small class="text-muted">Наприклад: +38095xxxxxxx</small>
                                <label for="phone">Ваш номер телефону</label>
                            </div>
                            <button class="w-100 btn btn-lg btn-info" type="submit">Надіслати</button>
                        </form>
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
