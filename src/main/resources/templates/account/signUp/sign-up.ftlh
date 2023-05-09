<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Створити акаунт</title>
    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "styles/sign-up-styles.ftlh">
</head>
<body class="bg-info body-font">


<div class="container">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="/assets/logo-cropped.png" alt="" width="100px" height="100px">
            <h2>Створіть новий акаунт</h2>
            <p class="fs-5">Вже є акаунт? <a href="/logIn" class="fw-bold" style="color: #0f4696">Увійти</a></p>
        </div>

        <div class="row g-5">

            <div class="">
                <form class="needs-validation" name="signUp" method="post" novalidate>
                    <div class="row g-3">
                        <div class="col-sm-6">
                            <label for="firstName" class="form-label">Ім'я</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" placeholder="" value="" required>
                            <div class="invalid-feedback">
                                Будь ласка, введіть ім'я
                            </div>
                        </div>

                        <div class="col-sm-6">
                            <label for="lastName" class="form-label">Прізвище</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" placeholder="" value="" required>
                            <div class="invalid-feedback">
                                Будь ласка, введіть прізвище
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="email" class="form-label">Електронна пошта</label>
                            <div class="input-group has-validation">
                                <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть електронну пошту
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="username" class="form-label">Ім'я користувача</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text">@</span>
                                <input type="text" class="form-control" id="username" name="username" placeholder="user22322342" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть ім'я користувача
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="password" class="form-label">Пароль</label>
                            <div class="input-group has-validation">
                                <input type="password" class="form-control" name="password" id="password" minlength="8" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть пароль (не менше 8 символів)
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="repeatpass" class="form-label">Повторіть пароль</label>
                            <div class="input-group has-validation">
                                <input type="password" class="form-control" name="repeatpass" id="repeatpass" minlength="8" required>
                                <div class="invalid-feedback">
                                    Паролі не збігаються
                                </div>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <label for="phone" class="form-label">Номер телефону</label>
                            <div class="input-group has-validation">
                                <input type="text" class="form-control" id="phone" name="phone" placeholder="+38 (095)-000-00-00" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть номер телефону
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label for="birthday" class="form-label">День народження</label>
                            <input type="date" class="form-control" id="birthday" name="birthday" placeholder="" required>
                            <div class="invalid-feedback">
                                Будь ласка, введіть дату народження
                            </div>
                        </div>


                        <div class="col-md-3">
                            <label for="illnesses" class="form-label">Хронічні захворювання</label>
                            <@spring.formSingleSelect "request.illnesses", illnesses, "class='form-select'"/>
                            <div class="invalid-feedback">
                                Будь ласка, заповніть це поле
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
        <p class="mt-5 mb-3 body-font">&copy; 2015–2023 Solus Solutions</p>
    </footer>
</div>

<#--
<script src="../../a-assets/styles/bootstrap5.js"></script>-->

<#include "styles/sign-up-js.ftlh"/>
</body>
</html>