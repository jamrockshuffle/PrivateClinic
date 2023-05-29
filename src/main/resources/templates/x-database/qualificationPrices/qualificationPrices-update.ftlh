<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Оновити ціну</title>
    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "../db-form-styles.ftlh">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="bg-dark body-font">

<a href="/database/qualificationPrices/find/all" class="fa fa-reply" title="Назад"></a>


<div class="container">
    <main>

        <div class="row g-5">

            <div class="py-5 text-center">
                <h2>Оновити ціну</h2>
            </div>

            <div class="">
                <form class="needs-validation" name="createQualification" method="post" novalidate>
                    <div class="row g-3">
                        <div class="col-12">
                            <label for="id" class="form-label">ID</label>
                            <div class="input-group has-validation">
                                <input type="text" class="form-control" id="id" name="id" value="#{qualificationPrices.id?number}" readonly required>
                                <div class="invalid-feedback">
                                    ID
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="name" class="form-label">Назва послуги</label>
                            <div class="input-group has-validation">
                                <@spring.formInput "qualificationPrices.name" "class='form-control' required" "text"/>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть назву послуги
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="qualification" class="form-label">Назва напрямку</label>
                            <div class="input-group has-validation">
                                <@spring.formSingleSelect "qualificationPrices.qualification", qualification, "class='form-select' required"/>
                                <div class="invalid-feedback">
                                    Будь ласка, виберіть назву напрямку
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="price" class="form-label">Ціна</label>
                            <div class="input-group has-validation">
                                <@spring.formInput "qualificationPrices.price" "class='form-control' required" "text"/>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть ціну
                                </div>
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