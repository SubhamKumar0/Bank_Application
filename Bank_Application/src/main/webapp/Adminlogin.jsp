<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Admin Bank Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            height: 100vh;
            align-items: center;
            justify-content: center;
            background-image: url('https://images.designtrends.com/wp-content/uploads/2016/03/29115235/Abstract-Plain-White-Wallpaper-.jpg'); 
            background-size: cover;
            background-position: center;
        }
        .login-container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            width: 80%;
            height: 80%;
            background: rgba(255, 255, 255, 0.9);
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            padding: 20px;
        }
        .login-box {
            flex: 1;
            text-align: center;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .login-box h2 {
            margin-bottom: 20px;
            color: #333;
        }
        .login-box .input-container {
            position: relative;
            margin: 10px 0;
            width: 100%;
        }
        .login-box .input-container input {
            width: calc(100% - 22px);
            padding: 10px 40px;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
        }
        .login-box .input-container i {
            position: absolute;
            top: 50%;
            left: 10px;
            transform: translateY(-50%);
            color: #007BFF;
        }
        .login-box input[type="submit"],
        .login-box input[type="reset"] {
            background-color: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
            width: 48%;
            margin: 1%;
            padding: 10px;
            border-radius: 5px;
            outline: none;
        }
        .login-box input[type="submit"]:hover,
        .login-box input[type="reset"]:hover {
            background-color: #0056b3;
        }
        @media (max-width: 768px) {
            .login-container {
                flex-direction: column;
                justify-content: center;
                align-items: center;
                width: 100%;
                height: 100%;
            }
            .login-box {
                width: 90%;
            }
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="login-box">
            <h1> Admin Bank Login</h1>
            <form action="AdminLoginServlet" method="POST">
                <div class="input-container">
                    <i class="fas fa-user"></i>
                    <input type="text" name="txtName" placeholder="Username" required>
                </div>
                <div class="input-container">
                    <i class="fas fa-lock"></i>
                    <input type="password" name="txtPwd" placeholder="Password" required>
                </div>
                <div style="display: flex; justify-content: space-between;">
                    <input type="submit" value="Login">
                    <input type="reset" value="Reset">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
o