<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Banking Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f2f2f2;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            padding: 20px;
        }
        .dashboard-title {
            text-align: center;
            margin-bottom: 20px;
        }
        .module {
            border-bottom: 1px solid #ddd;
            padding: 20px 0;
            display: flex;
            align-items: center;
            justify-content: space-between;
            cursor: pointer;
        }
        .module h2 {
            margin: 0;
            color: #333;
        }
        .module button {
            background-color: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
            padding: 10px 20px;
            border-radius: 5px;
            display: flex;
            align-items: center;
            font-size: 16px;
        }
        .module button i {
            margin-right: 10px;
        }
        .module button:hover {
            background-color: #0056b3;
        }
        .form-container {
            display: none;
            margin-top: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .form-container.active {
            display: block;
        }
        .form-container form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .form-container form .input-container {
            margin-bottom: 10px;
            width: 100%;
            max-width: 300px;
        }
        .form-container form .input-container input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
        }
        .form-container form .input-container input[type="submit"] {
            background-color: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
        }
        .form-container form .input-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const modules = document.querySelectorAll('.module');

            modules.forEach(module => {
                const button = module.querySelector('button');
                const formContainer = module.querySelector('.form-container');

                button.addEventListener('click', function() {
                    // Hide all form containers
                    document.querySelectorAll('.form-container').forEach(container => {
                        container.classList.remove('active');
                    });

                    // Show current form container
                    formContainer.classList.add('active');
                });
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <h1 class="dashboard-title">Admin Dashboard</h1>
        
        <!-- Module 1: Add account -->
        <div class="module">
            <h2>Add Account</h2>
            <a href="AddNewCustomer.jsp"><button><i class="fas fa-user-plus"></i> Add </button></a>
            
        </div>
        
        <!-- Module 2: Delete  Account -->
        <div class="module">
            <h2>Delete Account</h2>
            <button><i class="fas fa-user-minus"></i> Delete </button>
            <div class="form-container">
                <form action="CustomerDeleteServlet" method="post">
                    <div class="input-container">
                        <label for="accountNumberDeposit">Account Number:</label>
                        <input type="number" name="del_account_number" placeholder="Enter Account Number" required>
                    </div>
                    
                    <div class="input-container">
                        <input type="submit" value="Delete">
                    </div>
                </form>
            </div>
            
        </div>
        
        <!-- Module 3: MOdify Account -->
        <div class="module">
            <h2>Modify Account</h2>
            <a href="CustomerModify.jsp"><button><i class="fas fa-user-edit"></i> Modify </button></a>
            
        </div>
        
        <div class="module">
            <h2>View User Info</h2>
            <button><i class="fas fa-wallet"></i> View</button>
            <div class="form-container">
                <form action="ViewOneCustomerDetailServlet" method="post">
                    <div class="input-container">
                        <label for="accountNumberView">Account Number:</label>
                        <input type="number" name="account_number" placeholder="Enter Account Number" required>
                    </div>
                    <div class="input-container">
                        <input type="submit" value="View">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
