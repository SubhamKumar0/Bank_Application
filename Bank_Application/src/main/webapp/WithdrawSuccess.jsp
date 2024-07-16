<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Withdraw Success</title>
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
        .container input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: calc(100% - 24px);
            margin-bottom: 10px;
        }
        .container input[type="submit"] {
            background-color: #2980b9;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .container input[type="submit"]:hover {
            background-color: #1abc9c;
        }
        .container a button {
            background-color: #2980b9;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            text-decoration: none;
            display: inline-block;
        }
        .container a button:hover {
            background-color: #1abc9c;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>WITHDRAW SUCCESS</h1>
        <form action="ViewOneCustomerDetailServlet">
            Account no:<input type="text" name="account_number" required>
            <input type="submit" value="login">
        </form>
        <a href="CustomerDashboard.jsp"><button>BACK</button></a>
    </div>
</body>
</html>
