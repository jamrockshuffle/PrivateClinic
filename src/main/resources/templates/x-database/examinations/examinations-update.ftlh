<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Оновити обстеження</title>
    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "../db-form-styles.ftlh">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="bg-dark body-font">

<a href="/database/examinations/find/all" class="fa fa-reply" title="Назад"></a>

<div class="container">
    <main>
        <div class="py-5 text-center">
            <h2>Оновити обстеження</h2>
        </div>

        <div class="row g-5">
                <form class="needs-validation" name="examination" method="post" novalidate>

                    <div class="row g-3">

                        <span hidden id="hiddenDoctor">${examination.doctor}</span>
                        <span hidden id="hiddenQualifPrice">${examination.qualificationPrice}</span>
                        <input hidden value="${username}" id="username" name="username">

                        <div class="col-12">
                            <label for="id" class="form-label">ID</label>
                            <div class="input-group has-validation">
                                <input type="text" class="form-control" id="id" name="id" value="#{examination.id?number}" readonly required>
                                <div class="invalid-feedback">
                                    ID
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="examinationID" class="form-label">Номер обстеження</label>
                            <div class="input-group has-validation">
                                <@spring.formInput "examination.examinationId" "class='form-control' required readonly" "text"/>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть номер
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">Ім'я</label>
                            <@spring.formInput "examination.firstName" "class='form-control' required readonly" "text"/>
                            <div class="invalid-feedback">
                                Будь ласка, введіть ім'я
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Прізвище</label>
                            <@spring.formInput "examination.lastName" "class='form-control' required readonly" "text"/>
                            <div class="invalid-feedback">
                                Будь ласка, введіть прізвище
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="qualification" class="form-label">Напрямок</label>
                            <input type="text" id="qualification" name="qualification" class="form-control" value="${examination.qualification}" readonly required>
                            <div class="invalid-feedback">
                                Будь ласка, виберіть напрямок
                            </div>
                        </div>

                        <div class="col-md-5">
                            <label for="doctor" class="form-label">Лікар</label>
                            <@spring.formSingleSelect "examination.doctor", doctors, "class='form-select' required"/>
                            <div class="invalid-feedback">
                                Будь ласка, виберіть лікаря
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label for="qualificationPrice" class="form-label">Послуга</label>
                            <@spring.formSingleSelect "examination.qualificationPrice", services, "class='form-select' required"/>
                            <div class="invalid-feedback">
                                Будь ласка, виберіть послугу
                            </div>
                        </div>

                        <div class="col-md-3">
                            <label for="examinationTime" class="form-label">Бажаний час прийому</label>
                            <@spring.formInput "examination.examinationTime" "class='form-control' required" "datetime-local"/>
                            <div class="invalid-feedback">
                                Будь ласка, введіть час
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="price" class="form-label">Ціна (у грн)</label>
                            <@spring.formInput "examination.price" "class='form-control' required readonly" "text"/>
                            <div class="invalid-feedback">
                                Введіть ціну
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="status" class="form-label">Оплата</label>
                            <@spring.formInput "examination.status" "class='form-control' required readonly placeholder='Немає'" "text"/>
                            <div class="invalid-feedback">
                                Оплата
                            </div>
                        </div>

                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-success btn-lg" type="submit">Змінити</button>
                </form>
        </div>
    </main>

    <footer class="text-muted text-center text-small">
        <p class="mt-5 mb-3 body-font">&copy; 2017–2022 Solus Solutions</p>
    </footer>
</div>

<script>

    // doctors
    var arrName=[<#list doctors as doctor>"${doctor.name}", </#list>];
    var arrQualif=[<#list doctors as doctor>"${doctor.qualification.name}", </#list>];
    var arrDoctor = arrName.reduce((obj, key, index) => ({ ...obj, [key]: arrQualif[index] }), {});
    var filteredDoctor = Object.keys(arrDoctor).filter(function(key) {
        return arrDoctor[key] === document.getElementById("qualification").value;
    });

    var select = document.getElementById("doctor");
    var i, L = select.options.length - 1;
    for(i = L; i >= 0; i--) {
        select.remove(i);
    }

    for(index in filteredDoctor) {
        select.options[select.options.length] = new Option(filteredDoctor[index], filteredDoctor[index]);
    }

    // qualification prices
    var priceName=[<#list services as service>"${service.name}", </#list>];
    var priceQualif=[<#list services as service>"${service.qualification.name}", </#list>];
    var arrPrice = priceName.reduce((obj, key, index) => ({ ...obj, [key]: priceQualif[index] }), {});
    var filteredPrice = Object.keys(arrPrice).filter(function(key) {
        return arrPrice[key] === document.getElementById("qualification").value;
    });

    var selectPrice = document.getElementById("qualificationPrice");
    var j, K = selectPrice.options.length - 1;
    for(j = K; j >= 0; j--) {
        selectPrice.remove(j);
    }

    for(index in filteredPrice) {
        selectPrice.options[selectPrice.options.length] = new Option(filteredPrice[index], filteredPrice[index]);
    }

    var hiddenDoctor = "${examination.doctor}";
    var hiddenQualif = "${examination.qualificationPrice}";

    document.getElementById("doctor").value = hiddenDoctor;
    document.getElementById("qualificationPrice").value = hiddenQualif;


</script>

<#include "../db-js.ftlh"/>

</body>
</html>