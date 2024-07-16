<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modify Customer Details</title>
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
            width: 300px;
        }
        .container h2 {
            color: #2980b9;
            text-align: center;
            margin-bottom: 20px;
        }
        .container label {
            display: block;
            margin-bottom: 5px;
            color: #34495e;
        }
        .container input[type="text"],
        .container input[type="email"],
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
    </style>
</head>
<body>
    <div class="container">
        <h2>Modify Customer Details</h2>
        <form action="ModifyCustomerDetailsServlet" method="post">
            <label for="account_number">Account Number:</label>
            <input type="text" id="account_number" name="account_number" required>
            
            <label for="uname">User Name:</label>
            <input type="text" id="uname" name="uname" required>
            
            <label for="uaddress">Address:</label>
            <input type="text" id="uaddress" name="uaddress" required>
            
            <label for="umobile">Mobile:</label>
            <input type="text" id="umobile" name="umobile" required>
            
            <label for="umail">E-mail:</label>
            <input type="text" id="umail" name="umail" required>
            
            <label for="uacc_type">Account Type:</label>
            <input type="text" id="uacc_type" name="uacc_type" required>
            
            <label for="udob">D.O.B:</label>
            <input type="text" id="udob" name="udob" required>
            
            <label for="uid_proof">ID Proof:</label>
            <input type="text" id="uid_proof" name="uid_proof" required>
            
            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>
