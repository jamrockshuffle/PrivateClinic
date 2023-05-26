<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Увійти в акаунт</title>
    <#include "../../a-assets/styles/bootstrap5.ftlh">
    <#include "../../a-assets/styles/bootstrap.ftlh">
    <#include "styles/db-log-in-styles.ftlh">


    <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
           rel="stylesheet"
           integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
           crossorigin="anonymous"> -->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body class="text-center bg-dark">

<main class="form-signin w-100 m-auto">
    <form class="" name="login" action="" method="post">
        <h1 class="h3 mb-3 fw-normal body-font">SOLUS DATABASE</h1>

        <div class="form-floating">
            <input type="text" autocomplete="on" class="form-control" id="username" name="username" placeholder="login name">
            <label for="username">Ім'я користувача</label>
        </div>
        <br>

        <div class="form-floating">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
            <label for="password">Пароль</label>
        </div>

        <button class="w-100 btn btn-lg btn-success" type="submit" id="login">Увійти</button>
            <p class="mt-3 mb-3 body-font">&copy; 2015–2023 Solus Solutions</p>
    </form>
</main>


</body>
<body>

</body>
</html>