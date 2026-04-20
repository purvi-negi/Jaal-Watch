<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/ProjectCSS/dataForm.css">
</head>
<body>
<body>
    <div class="form-container">
        <div class="logo-container">
        <img src="${pageContext.request.contextPath}/Images/logo.png" alt="Jal Watch Logo">
     </div>
<center>
<div class="form-header">
            DWLR Device Data Entry
        </div>
</center>
        <form action="DataCtrl" method="POST">


            <div class="form-group">
                <label for="dwlr-id">DWLR ID</label>
                <input type="text" id="dwlr-id" name="dwlr-id" placeholder="Enter DWLR ID" required>
            </div>

            <div class="form-group">
                <label for="timestamp">Time Stamp</label>
                <input type="datetime-local" id="timestamp" name="timestamp" required>
            </div>

            <div class="form-group">
                <label for="water-level">Water Level (m)</label>
                <input type="number" step="0.01" id="water-level" name="water-level" placeholder="Enter Water Level"
                    required>
            </div>

            <div class="form-group">
                <label for="battery-level">Battery Level (%)</label>
                <input type="number" min="0" max="100" id="battery-level" name="battery-level"
                    placeholder="Enter Battery Level (0-100)" required>
            </div>

            <button type="submit" class="submit-btn">SUBMIT DATA</button>

        </form>
    </div>
</body>
</html>