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


        <legend style="text-align: center;">Add User</legend>
        <hr>

        <form name="signup" action="" method="post">
            Username:<@spring.formInput "request.username" "" "text"/>
            <br>
            <br>
            Password:<@spring.formInput "request.password" "" "text"/>
            <br>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>