<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Змінити ім'я користувача</title>
    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "styles/change-username-styles.ftlh">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>
</head>
<body class="bg-info body-font">


<div class="container">
    <main>
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="/assets/logo-cropped.png" alt="" width="100px" height="100px">
            <h2>Змінити ім'я користувача</h2>
        </div>

        <div class="row g-5">

            <div class="">
                <form class="needs-validation" name="changeUsername" method="post" novalidate>
                    <div class="row g-3">
                        <div class="col-12">
                            <label for="username" class="form-label">Старе ім'я користувача</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text">@</span>
                                <input type="text" class="form-control" minlength="8" maxlength="20" id="username" value="${request.username}" readonly name="username" placeholder="username-placeholder" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть ім'я користувача (від 8 до 20 символів)
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="newUsername" class="form-label">Нове ім'я користувача</label>
                            <div class="input-group has-validation">
                                <span class="input-group-text">@</span>
                                <input type="text" class="form-control" minlength="8" maxlength="20" id="newUsername" name="newUsername" placeholder="username-placeholder" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть ім'я користувача (від 8 до 20 символів)
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="password" class="form-label">Пароль</label>
                            <div class="input-group has-validation">
                                <input type="password" class="form-control pass1" name="password" id="password" required>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть пароль
                                </div>
                            </div>
                        </div>

                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn dangerCustom btn-lg" type="submit">Змінити</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="text-muted text-center text-small">
        <p class="mt-5 mb-3 body-font">&copy; 2015–2023 Solus Solutions</p>
    </footer>
</div>


<#include "styles/change-username-js.ftlh"/>
</body>
</html>