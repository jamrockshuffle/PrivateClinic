<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form name="login" action="" method="post">
    <input type="text" name="user" id="user" value="${response.jwt}"/>
    <br><br>
    <input type="submit" value="Create" id="create" onclick="store();"/>
</form>

<script>

    function store() {
        window.localStorage.setItem('token', JSON.stringify('Authorization: Bearer ' + document.getElementById('user').value));
    }

</script>


</body>
</html>