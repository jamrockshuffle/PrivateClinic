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
            <a href="/"><img class="d-block mx-auto mb-4" src="/assets/logo-cropped.png" alt="" width="100px" height="100px"></a>
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
                                <input type="text" class="form-control" minlength="8" maxlength="20" id="username" name="username" placeholder="username-placeholder" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть ім'я користувача (від 8 до 20 символів)
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="password" class="form-label">Пароль</label>
                            <div class="input-group has-validation">
                                <input type="password" class="form-control pass1" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="password" id="password" required>
                                <div class="invalid-feedback">
                                    Пароль повинен мати хоча б 1 велику букву, 1 маленьку букву, 1 цифру та не менше 8 знаків
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="repeatpass" class="form-label">Повторіть пароль</label>
                            <div class="input-group has-validation">
                                <input type="password" class="form-control pass2" name="repeatpass" id="repeatpass" required>
                                <div class="invalid-feedback">
                                    Паролі не збігаються
                                </div>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <label for="phone" class="form-label">Номер телефону</label>
                            <div class="input-group has-validation">
                                <input type="text" class="form-control" id="phone" pattern="^\+380\d{9}$" name="phone" placeholder="+380950000000" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть номер телефону так: +380ххххххххх
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
                            <@spring.formSingleSelect "request.illnesses", illnesses, "class='form-select' required"/>
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


<script>

    var selectIllness = document.getElementById("illnesses");
    var option = new Option("...", "");
    option.disabled = true;
    option.selected = true;
    selectIllness.insertBefore(option, selectIllness.firstChild);

    var password = document.getElementById("password");
    var repeatPassword = document.getElementById("repeatpass");

    function confirmPassword(){
        if(password.value != repeatPassword.value) {
            repeatPassword.setCustomValidity("Confirmed");
        } else {
            repeatPassword.setCustomValidity('');
        }
    }

    password.onchange = confirmPassword;
    repeatPassword.onkeyup = confirmPassword;

</script>

<#include "styles/sign-up-js.ftlh"/>
</body>
</html>