<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        .box { border: 1px solid black; padding: 20px; width: 300px; }
    </style>
</head>

<body>
    <div class="box">
        <form id="loginField" action="login.jsp" method="POST">
            User ID: <input type="text" name="userID" id="userID"><br><br>

            Password: <input type="password" name="password" id="password"><br><br>

            <button type="submit">Login</button>
        </form>
    </div>

    <script>
        $(document).ready(function () {
            $("loginField").submit(function (e) {
                if ($("userID").val() === "" || $("password").val() === "") {
                    alert("User ID and Password must not be empty!");
                    e.preventDefault();
                }
            })
        })
    </script>
</body>
</html>