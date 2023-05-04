<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<div style="margin-top: 90px; width:100%">
    <fieldset style=" margin-left: auto; margin-right: auto">

        <#--Username:<@spring.formInput "request.username" "" "text"/>-->

        <legend style="text-align: center;">Login</legend>
        <hr>

        <form name="login" action="" method="post">
            Username:<input type="text" id="username" name="username" value="">
            <br>
            <br>
            Password:<input type="text" id="password" name="password" value="">
            <br>
            <br>
            <button type="submit" id="create">Create</button>
        </form>
    </fieldset>
</div>


</body>
</html>