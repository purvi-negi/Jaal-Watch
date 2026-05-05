<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Your CSS (MUST be last) -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/ProjectCSS/Dashboard.css?v=1">

<!-- Favicon -->
<link rel="icon"
	href="${pageContext.request.contextPath}/Images/logo.png">
</head>
<body>
<nav id="sidebar">

			<div
				class="sidebar-header d-flex justify-content-center align-items-center">
				<img src="${pageContext.request.contextPath}/Images/logo.png"
					alt="Jal Watch Logo" class="img-fluid" style="max-width: 180px;">
			</div>

			<ul class="list-unstyled mt-4">

				<li><a href="ShowChartCtl" class="nav-link "> <i
						class="fa-solid fa-border-all"></i> Dashboard
				</a></li>

				<li><a href="${pageContext.request.contextPath}/ShowDevices"
					class="nav-link"> <i class="fa-solid fa-server"></i> Devices
				</a></li>

				<li><a href="${pageContext.request.contextPath}/ShowAlarm"
					class="nav-link"> <i class="fa-solid fa-triangle-exclamation"></i>
						Alerts
				</a></li>

				<li><a href="${pageContext.request.contextPath}/ShowDataCtrl"
					class="nav-link"> <i class="fa-solid fa-chart-simple "></i>
						Show Data
				</a></li>

				<li><a href="${pageContext.request.contextPath}/addData.jsp"
					class="nav-link"> <i class="fa-solid fa-plus"></i> Add Data
				</a></li>



			</ul>

			<div class="sidebar-bottom">
				<a href="${pageContext.request.contextPath}/LogoutCtl"
					class="nav-link"> <i class="fa-solid fa-gear"></i> Logout
				</a>
			</div>
		</nav>
</body>
</html>