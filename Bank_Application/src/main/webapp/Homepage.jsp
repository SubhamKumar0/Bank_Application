<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bank Login Portal</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #2c3e50;
            padding: 10px 20px;
            color: white;
            text-align: center;
        }
        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 80vh;
            background-color: #ecf0f1;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .container h1 {
            color: #34495e;
            margin-bottom: 20px;
        }
        .container a {
            text-decoration: none;
            margin: 10px;
        }
        .container button {
            background-color: #2980b9;
            color: white;
            padding: 15px 32px;
            font-size: 16px;
            margin: 10px;
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
    <div class="navbar">
        <h2>Banking Portal</h2>
    </div>
    <div class="container">
        <h1>Welcome to Our Bank</h1>
        <a href="Adminlogin.jsp"><button>Admin Login</button></a>
        <a href="Customerlogin.jsp"><button>User Login</button></a>
    </div>
</body>
</html>
