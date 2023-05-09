<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Записатися на прийом</title>

    <#include "../a-assets/styles/bootstrap5.ftlh">
    <#include "../a-assets/styles/bootstrap.ftlh">
    <#include "styles/examination-form-styles.ftlh">
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
            <h2>Записатися на прийом</h2>
        </div>

        <div class="row g-5">

            <div class="">
                <form class="needs-validation" name="examination" method="post" novalidate>
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">Ім'я</label>
                            <input type="text" class="form-control" name="firstName" id="firstName" disabled placeholder="" value="${examination.firstName}" required>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Прізвище</label>
                            <input type="text" class="form-control" name="lastName" id="lastName" disabled placeholder="" value="${examination.lastName}" required>
                        </div>

                        <div class="col-12">
                            <label for="service" class="form-label">Напрямок</label>
                            <@spring.formSingleSelect "examination.qualification", qualifications, "class='form-select'"/>
                            <div class="invalid-feedback">
                                Будь ласка, виберіть лікаря
                            </div>
                        </div>

                        <div class="col-md-5">
                            <label for="country" class="form-label">Лікар</label>
                            <#if examination.qualification == doctors.qualification.name>
                                <@spring.formSingleSelect "examination.doctor", doctors, "class='form-select'"/>
                            </#if>
                            <div class="invalid-feedback">
                                Будь ласка, виберіть лікаря
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label for="state" class="form-label">Послуга</label>
                            <@spring.formSingleSelect "examination.qualificationPrice", services, "class='form-select'"/>
                            <div class="invalid-feedback">
                                Будь ласка, виберіть послугу
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="examinationTime" class="form-label">Бажаний час прийому</label>
                            <input type="datetime-local" class="form-control" name="examinationTime" id="examinationTime" placeholder="" required>
                            <div class="invalid-feedback">
                                Будь ласка, введіть час
                            </div>
                        </div>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn dangerCustom btn-lg" type="submit">Продовжити</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="text-muted text-center text-small">
        <p class="mt-5 mb-3 body-font">&copy; 2017–2022 Solus Solutions</p>
    </footer>
</div>


<#--<#include "styles/examination-form-js.ftlh"/>-->
</body>
</html>