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
        <% if ("1".equals(request.getParameter("error"))) { %>
        <p style="color: red; font-size: 14px;">Wrong User ID or Password</p>
        <% } %>
        <form id="loginField" action="login" method="POST">
            User ID: <input type="text" name="userId" id="userId"><br><br>

            Password: <input type="password" name="password" id="password"><br><br>

            <button type="submit">Login</button>
        </form>
    </div>

    <script>
        $(document).ready(function () {
            $("#loginField").submit(function (e) {
                if ($("#userId").val() === "" || $("#password").val() === "") {
                    alert("User ID and Password must not be empty!");
                    e.preventDefault();
                }
            })
        })
    </script>
</body>
</html>