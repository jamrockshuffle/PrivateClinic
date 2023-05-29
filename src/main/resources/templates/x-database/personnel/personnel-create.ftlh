<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Внести лікаря</title>
    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "../db-form-styles.ftlh">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body class="bg-dark body-font">

<a href="/database/personnel/find/all" class="fa fa-reply" title="Назад"></a>


<div class="container">
    <main>

        <div class="row g-5">

            <div class="py-5 text-center">
                <h2>Внести лікаря</h2>
            </div>

            <div class="">
                <form class="needs-validation" name="createQualification" method="post" novalidate>
                    <div class="row g-3">
                        <div class="col-12">
                            <label for="name" class="form-label">Ім'я</label>
                            <div class="input-group has-validation">
                                <@spring.formInput "personnel.name" "class='form-control' required" "text"/>
                                <div class="invalid-feedback">
                                    Будь ласка, введіть ім'я лікаря
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="personnelCategory" class="form-label">Категорія</label>
                            <div class="input-group has-validation">
                                <@spring.formSingleSelect "personnel.personnelCategory", personnelCategory, "class='form-select' required"/>
                                <div class="invalid-feedback">
                                    Будь ласка, виберіть назву категорію
                                </div>
                            </div>
                        </div>

                        <div class="col-12">
                            <label for="qualification" class="form-label">Напрямок</label>
                            <div class="input-group has-validation">
                                <@spring.formSingleSelect "personnel.qualification", qualification, "class='form-select' required"/>
                                <div class="invalid-feedback">
                                    Будь ласка, виберіть напрямок
                                </div>
                            </div>
                        </div>

                    </div>

                    <hr class="my-4">

                    <button class="w-100 btn btn-success btn-lg" type="submit">Внести</button>
                </form>
            </div>
        </div>
    </main>

    <footer class="text-muted text-center text-small">
        <p class="mt-5 mb-3 body-font">&copy; 2015–2023 Solus Solutions</p>
    </footer>
</div>

<script>

    var selectCategory = document.getElementById("personnelCategory");
    var option = new Option("...", "");
    option.disabled = true;
    option.selected = true;
    selectCategory.insertBefore(option, selectCategory.firstChild);

    var selectQualif = document.getElementById("qualification");
    var option = new Option("...", "");
    option.disabled = true;
    option.selected = true;
    selectQualif.insertBefore(option, selectQualif.firstChild);

</script>

<#include "../db-js.ftlh"/>
</body>
</html>