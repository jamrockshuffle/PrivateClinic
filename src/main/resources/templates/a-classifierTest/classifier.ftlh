<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Онлайн-діагноз</title>

    <#include "../a-assets/styles/bootstrap5.ftlh">
    <#include "../a-assets/styles/bootstrap.ftlh">

    <style>
        html,
        body {
            height: 100%;
            padding-top: 3rem;
        }

        body {
            display: flex;
            align-items: center;
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .body-font {
            color: white;
            font-weight: 200;
            font-family: Montserrat, "Open Sans", Helvetica, Arial, sans-serif;
        }


        .dangerCustom {
            color: #fff;
            background-color: #dc3545;
            border-color: #bd3e47;
        }

        .dangerCustom:hover {
            color: #fff;
            background-color: #bd3e47;
            border-color: #963239;
        }

        .dangerCustom:focus, .dangerCustom.focus {
            box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.5);
        }

        .dangerCustom.disabled, .dangerCustom:disabled {
            color: #fff;
            background-color: #bd3e47;
            border-color: #dc3545;
        }

        .dangerCustom:not(:disabled):not(.disabled):active, .dangerCustom:not(:disabled):not(.disabled).active,
        .show > .dangerCustom.dropdown-toggle {
            color: #fff;
            background-color: #b83740;
            border-color: #b21f2d;
        }

        .dangerCustom:not(:disabled):not(.disabled):active:focus, .dangerCustom:not(:disabled):not(.disabled).active:focus,
        .show > .dangerCustom.dropdown-toggle:focus {
            box-shadow: 0 0 0 0.2rem rgba(220, 53, 69, 0.5);
        }
    </style>

</head>
<body class="text-center bg-info">

<main class="m-auto">
    <main class="form-signin w-100 m-auto">
        <form class="" enctype="multipart/form-data" action="" method="post">
            <a href="/"><img class="d-block mx-auto mb-4" src="/assets/logo-cropped.png" alt="" width="100px" height="100px"></a>
            <h1 class="h3 mb-3 fw-normal body-font">Завантажте медичний знімок</h1>

                <input type="file" required accept="image/*" class="form-control" id="imageSent" name="imageSent">
                <label for="imageSent" style="color: white">Підтримувані категорії: COVID19, Туберкульоз, Пневмонія, немає відхилень</label>

            <br>
            <br>

            <button class="w-100 btn btn-lg dangerCustom" type="submit" id="login">Надіслати</button>
            <p class="mt-3 mb-3 body-font">Зауважте, що отриманий результат
                не може бути інтерпретований як діагноз, поки не буде підтверджений фахівцем.</p>
        </form>
    </main>
</main>
</body>
</html>