<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Оновити пацієнта</title>
    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "../db-form-styles.ftlh">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="bg-dark body-font">


<a href="/database/patients/find/all" class="fa fa-reply" title="Назад"></a>

<div class="container">
    <main>
        <div class="py-5 text-center">
            <h2>Оновити пацієнта</h2>
        </div>

        <div class="row g-5">

            <div class="">
                <form class="needs-validation" name="signUp" method="post" novalidate>
                    <div class="row g-3">

                        <div class="col-12">
                            <label for="id" class="form-label">ID</label>
                            <div class="input-group has-validation">
                                <input type="text" class="form-control" id="id" name="id" value="#{patients.id?number}" readonly required>
                                <div class="invalid-feedback">
                                    ID
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">Ім'я</label>
                            <@spring.formInput "patients.firstName" "class='form-control' required" "text"/>
                            <div class="invalid-feedback">
                                Будь ласка, введіть ім'я
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Прізвище</label>
                            <@spring.formInput "patients.lastName" "class='form-control' required" "text"/>
                            <div class="invalid-feedback">
                                Будь ласка, введіть прізвище
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="username" class="form-label">Ім'я користувача</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text">@</span>
                                <@spring.formInput "patients.username" "class='form-control' required readonly minlength='8' maxlength='20' placeholder='username-placeholder'" "text"/>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть ім'я користувача (від 8 до 20 символів)
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="email" class="form-label">Електронна пошта</label>
                            <div class="input-group has-validation">
                                <@spring.formInput "patients.email" "class='form-control' required  placeholder='you@example.com'" "email"/>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть електронну пошту
                                </div>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <label for="phone" class="form-label">Номер телефону</label>
                            <div class="input-group has-validation">
                                <@spring.formInput "patients.phone" "class='form-control' required placeholder='+380950000000' minlength='13'" "text"/>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть номер телефону так: +380ххххххххх
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label for="birthday" class="form-label">День народження</label>
                            <@spring.formInput "patients.birthday" "class='form-control' required" "date"/>
                            <div class="invalid-feedback">
                                Будь ласка, введіть дату народження
                            </div>
                        </div>


                        <div class="col-md-3">
                            <label for="illnesses" class="form-label">Хронічні захворювання</label>
                            <@spring.formSingleSelect "patients.illnesses", illnesses, "class='form-select' required"/>
                            <div class="invalid-feedback">
                                Будь ласка, заповніть це поле
                            </div>
                        </div>
                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-success btn-lg" type="submit">Змінити</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="text-muted text-center text-small">
        <p class="mt-5 mb-3 body-font">&copy; 2015–2023 Solus Solutions</p>
    </footer>
</div>

<#include "../db-js.ftlh"/>
</body>
</html>