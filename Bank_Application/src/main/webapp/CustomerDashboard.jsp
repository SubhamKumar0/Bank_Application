<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> User Banking Dashboard</title>
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
        <h1 class="dashboard-title">User Dashboard</h1>
        
        <div class="module">
            <h2>Change Password</h2>
            <button><i class="fas fa-wallet"></i> Change </button>
            <div class="form-container">
                <form action="ChangePasswordServlet" method="post">
                    <div class="input-container">
                        <label for="accountNumberCheck">Account Number:</label>
                        <input type="text"  name="account_number" placeholder="Enter Account Number" required>
                    </div>
                    <div class="input-container">
                        <label for="accountNumberCheck">Temporary Password:</label>
                        <input type="text"  name="temp_pass" placeholder="Enter Temporary Password" required>
                    </div>
                    <div class="input-container">
                        <label for="accountNumberCheck">New Password:</label>
                        <input type="text"  name="new_password" placeholder="Enter New Password" required>
                    </div>
                    <div class="input-container">
                        <input type="submit" value="Change">
                    </div>
                </form>
            </div>
        </div>
     
        
        <!-- Module 1: Check Balance -->
        <div class="module">
            <h2>Check Balance</h2>
            <button><i class="fas fa-wallet"></i> Check Balance</button>
            <div class="form-container">
                <form action="CheckBalanceServlet" method="post">
                    <div class="input-container">
                        <label for="accountNumberCheck">Account Number:</label>
                        <input type="number" name="account_number" placeholder="Enter Account Number" required>
                    </div>
                    <div class="input-container">
                        <input type="submit" value="Check Balance">
                    </div>
                </form>
            </div>
        </div>
        
        <!-- Module 2: Withdraw Money -->
        <div class="module">
            <h2>Withdraw Money</h2>
            <button><i class="fas fa-money-bill-wave"></i> Withdraw Money</button>
            <div class="form-container">
                <form action="WithdrawServlet" method="post">
                    <div class="input-container">
                        <label for="accountNumberWithdraw">Account Number:</label>
                        <input type="number" name="account_number" placeholder="Enter Account Number" required>
                    </div>
                    <div class="input-container">
                        <label for="amountWithdraw">Amount:</label>
                        <input type="number" name="amount" placeholder="Enter Amount" required>
                    </div>
                    <div class="input-container">
                        <input type="submit" value="Withdraw">
                    </div>
                </form>
            </div>
        </div>
        
        <!-- Module 3: Deposit Money -->
        <div class="module">
            <h2>Deposit Money</h2>
            <button><i class="fas fa-piggy-bank"></i> Deposit Money</button>
            <div class="form-container">
                <form action="DepositServlet" method="post">
                    <div class="input-container">
                        <label for="accountNumberDeposit">Account Number:</label>
                        <input type="number" id="accountNumberDeposit" name="account_number" placeholder="Enter Account Number" required>
                    </div>
                    <div class="input-container">
                        <label for="amountDeposit">Amount:</label>
                        <input type="number" id="amountDeposit" name="amount" placeholder="Enter Amount" required>
                    </div>
                    <div class="input-container">
                        <input type="submit" value="Deposit">
                    </div>
                </form>
            </div>
        </div>
        
        
        <div class="module">
            <h2>Transaction History</h2>
            <button><i class="fas fa-wallet"></i> View History</button>
            <div class="form-container">
                <form action="TransactionServlet" method="post">
                    <div class="input-container">
                        <label for="accountNumberCheck">Account Number:</label>
                        <input type="number" name="account_number" placeholder="Enter Account Number" required>
                    </div>
                    <div class="input-container">
                        <input type="submit" value="View Transaction">
                    </div>
                </form>
            </div>
        </div>
        
        <!-- Module 4: Close  Account -->
        <div class="module">
            <h2>Close Account</h2>
            <a href="Adminlogin.jsp"><button><i class="fas fa-user-minus"></i> Close </button></a>
            
    </div>
</body>
</html>
