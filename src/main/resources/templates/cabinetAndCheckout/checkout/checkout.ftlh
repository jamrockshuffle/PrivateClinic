<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Оплата</title>

    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "styles/checkout-styles.ftlh">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="bg-info body-font">

<!--
<a onclick="history.back()" href="" class="fa fa-reply link-light fs-5" title="Назад"> Назад</a>
-->

<div class="container">
    <main>

        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="/assets/logo-cropped.png" alt="" width="100px" height="100px">
            <h2>Оплатити послугу</h2>
        </div>


        <div class="row g-5">

            <div class="">
                <form class="needs-validation" name="examination" method="post" novalidate>
                    <div class="row g-3">
                        <#--<div class="col-sm-6">
                            <label for="firstName" class="form-label">Ім'я</label>
                            <input type="text" class="form-control" name="firstName" id="firstName" readonly placeholder="" value="${firstName}" required>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Прізвище</label>
                            <input type="text" class="form-control" name="lastName" id="lastName" readonly placeholder="" value="${lastName}" required>
                        </div>-->

                        <div class="col-sm-6">
                            <label for="examinationId" class="form-label">Номер</label>
                            <input type="text" class="form-control" name="examinationId" id="examinationId" readonly placeholder="" value="${examinationId}" required>
                        </div>

                        <div class="col-sm-6">
                            <label for="service" class="form-label">Послуга</label>
                            <input type="text" class="form-control" name="service" id="service" readonly placeholder="" value="${service}" required>
                        </div>

                        <h4 class="mb-3" style="padding-top: 20px">Оплата</h4>

                        <div style="margin-left: 10px;" class="form-check-inline">
                            <div class="form-check">
                                <input id="visa" name="paymentMethod" type="radio" class="form-check-input" checked required>
                                <label class="form-check-label" for="visa">Visa</label>
                            </div>
                            <div class="form-check">
                                <input id="mastercard" name="paymentMethod" type="radio" class="form-check-input" required>
                                <label class="form-check-label" for="mastercard">MasterCard</label>
                            </div>
                            <div class="form-check">
                                <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required>
                                <label class="form-check-label" for="paypal">PayPal</label>
                            </div>
                        </div>

                        <div class="row gy-3">
                            <div class="col-md-6">
                                <label for="cc-name" class="form-label">Ім'я на картці</label>
                                <input type="text" class="form-control" id="cc-name" placeholder="" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть ім'я
                                </div>
                            </div>

                            <div class="col-md-6">
                                <label for="cc-number" class="form-label">Номер картки</label>
                                <input type="text" class="form-control" id="cc-number" placeholder="" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть номер картки
                                </div>
                            </div>

                            <div class="col-md-3">
                                <label for="cc-expiration" class="form-label">Закінчення дії</label>
                                <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть термін закінчення дії
                                </div>
                            </div>

                            <div class="col-md-3">
                                <label for="cc-cvv" class="form-label">Код безпеки</label>
                                <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть код безпеки
                                </div>
                            </div>
                        </div>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn dangerCustom btn-lg" type="submit">Оплатити</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="text-muted text-center text-small">
        <p class="mt-5 mb-3 body-font">&copy; 2017–2022 Solus Solutions</p>
    </footer>
</div>


<#include "styles/checkout-js.ftlh"/>

</body>
</html>