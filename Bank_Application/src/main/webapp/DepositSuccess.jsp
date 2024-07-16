<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deposit Success</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .container h1 {
            color: #27ae60;
            margin-bottom: 20px;
        }
        .container form {
            margin-bottom: 20px;
        }
        .container label {
            display: block;
            margin-bottom: 5px;
            color: #34495e;
        }
        .container input[type="text"],
        .container input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .container input[type="submit"] {
            background-color: #2980b9;
            color: white;
            border: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .container input[type="submit"]:hover {
            background-color: #1abc9c;
        }
        .container a {
            text-decoration: none;
        }
        .container button {
            background-color: #2980b9;
            color: white;
            padding: 15px 32px;
            font-size: 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .container button:hover {
            background-color: #1abc9c;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>DEPOSIT SUCCESS</h1>
        <form action="ViewOneCustomerDetailServlet">
            <label for="account_number">Account No:</label>
            <input type="text" id="account_number" name="account_number" required>
            <input type="submit" value="Login">
        </form>
        <a href="CustomerDashboard.jsp"><button>BACK</button></a>
    </div>
</body>
</html>
