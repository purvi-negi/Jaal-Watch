<%@page import="java.util.ArrayList" %>
<%@page import="com.dwlr.dto.Alarm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f7fb;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            margin: 30px auto;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        .card {
            background: #fff;
            padding: 20px;
            margin-top: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th {
            background: #007bff;
            color: white;
            padding: 12px;
        }

        td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background: #f1f1f1;
        }

        .status-active {
            color: red;
            font-weight: bold;
        }

        .status-resolved {
            color: green;
            font-weight: bold;
        }

        .badge {
            padding: 5px 10px;
            border-radius: 5px;
            color: white;
        }

        .low-battery {
            background-color: #dc3545;
        }

        .normal {
            background-color: #28a745;
        }

        .header {
            background: #007bff;
            color: white;
            padding: 15px;
            border-radius: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<%ArrayList<Alarm> al  = (ArrayList<Alarm>) request.getAttribute("AlarmList"); %>
<div class="container">

    <div class="header">
        <h1>🚨 DWLR Alarm Monitoring System</h1>
    </div>

    <div class="card">
        <h2>Active Alarms</h2>

        <table>
            <tr>
                <th>DWLR ID</th>
                <th>Type</th>
                <th>Message</th>
                <th>Time</th>
                <th>Status</th>
            </tr>

            <%
            if(al != null){
                for(Alarm a : al){
            %>

            <tr>
                <td><%= a.getDwlrId() %></td>

                <td>
                    <span class="badge low-battery">
                        <%= a.getAlarmtype() %>
                    </span>
                </td>

                <td><%= a.getAlarmMessage() %></td>

                <td><%= a.getAlarmTime() %></td>

                <td class="status-active">
                    <%= a.getStatus() %>
                </td>
            </tr>

            <%
                }
            }
            %>

        </table>
    </div>

</div>

</body>
</html>