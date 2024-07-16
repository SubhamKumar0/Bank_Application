<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Data</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #34495e;
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #2980b9;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .no-data {
            text-align: center;
            color: #e74c3c;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Customer Data</h1>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Mobile</th>
                    <th>Email</th>
                    <th>Account Number</th>
                    <th>Account Type</th>
                    <th>Balance</th>
                    <th>DOB</th>
                    <th>ID Proof</th>
                    <th>Account Status</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    @SuppressWarnings("unchecked")
                    List<Map<String, String>> customerData = (List<Map<String, String>>) request.getAttribute("customerData");
                    if (customerData != null) {
                        for (Map<String, String> row : customerData) {
                %>
                <tr>
                    <td><%= row.get("fullname") %></td>
                    <td><%= row.get("address") %></td>
                    <td><%= row.get("mobile") %></td>
                    <td><%= row.get("email") %></td>
                    <td><%= row.get("account_number") %></td>
                    <td><%= row.get("account_type") %></td>
                    <td><%= row.get("balance") %></td>
                    <td><%= row.get("dob") %></td>
                    <td><%= row.get("id_proof") %></td>
                    <td><%= row.get("account_status") %></td>
                </tr>
                <%
                        }
                    } else {
                        out.println("<tr><td colspan='10' class='no-data'>No data available</td></tr>");
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>