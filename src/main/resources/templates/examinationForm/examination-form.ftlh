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

                        <#--<div class="col-12">
                            <label for="service" class="form-label">Напрямок</label>
                            <@spring.formSingleSelect "examination.qualification", qualifications, "class='form-select' onmouseout='test()'"/>
                            <div class="invalid-feedback">
                                Будь ласка, виберіть напрямок
                            </div>
                        </div>
-->
                        <div class="col-12">
                            <label for="qualification" class="form-label">Напрямок</label>
                            <#--<@spring.formSingleSelect "examination.qualification", qualifications, "class='form-select' onmouseout='test()'"/>-->
                            <select id="qualification" name="qualification" class="form-select" onchange="fill(this);" required>
                            </select>
                            <div class="invalid-feedback">
                                Будь ласка, виберіть напрямок
                            </div>
                        </div>

                        <div class="col-md-5">
                            <label for="doctor" class="form-label">Лікар</label>
                            <select id="doctor" name="doctor" class="form-select" required>
                            </select>
                            <div class="invalid-feedback">
                                Будь ласка, виберіть лікаря
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label for="qualificationPrice" class="form-label">Послуга</label>
                            <select id="qualificationPrice" name="qualificationPrice" class="form-select" required>
                            </select>
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

<script>

    var qualification=[<#list qualifications as qualification>"${qualification.name}",</#list>]

    var selectQualification = document.getElementById("qualification");
    selectQualification.options[selectQualification.options.length] = new Option("...", "...");
    for(index in qualification) {
        selectQualification.options[selectQualification.options.length] = new Option(qualification[index], index);
    }

    function fill(qualif) {
        var text = qualif.options[qualif.selectedIndex].text;

        // doctors
        var arrName=[<#list doctors as doctor>"${doctor.name}", </#list>];
        var arrQualif=[<#list doctors as doctor>"${doctor.qualification.name}", </#list>];
        var arrDoctor = arrName.reduce((obj, key, index) => ({ ...obj, [key]: arrQualif[index] }), {});
        var filteredDoctor = Object.keys(arrDoctor).filter(function(key) {
            return arrDoctor[key] === text;
        });

        var select = document.getElementById("doctor");
        var i, L = select.options.length - 1;
        for(i = L; i >= 0; i--) {
            select.remove(i);
        }

        select.options[select.options.length] = new Option("...", "...");
        for(index in filteredDoctor) {
            select.options[select.options.length] = new Option(filteredDoctor[index], filteredDoctor[index]);
        }

        // qualification prices
        var priceName=[<#list services as service>"${service.name}", </#list>];
        var priceQualif=[<#list services as service>"${service.qualification.name}", </#list>];
        var arrPrice = priceName.reduce((obj, key, index) => ({ ...obj, [key]: priceQualif[index] }), {});
        var filteredPrice = Object.keys(arrPrice).filter(function(key) {
            return arrPrice[key] === text;
        });

        var selectPrice = document.getElementById("qualificationPrice");
        var j, K = selectPrice.options.length - 1;
        for(j = K; j >= 0; j--) {
            selectPrice.remove(j);
        }

        selectPrice.options[selectPrice.options.length] = new Option("...", "...");
        for(index in filteredPrice) {
            selectPrice.options[selectPrice.options.length] = new Option(filteredPrice[index], filteredPrice[index]);
        }
    }
</script>

<#include "styles/examination-form-js.ftlh"/>

</body>
</html>