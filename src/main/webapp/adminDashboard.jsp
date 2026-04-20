<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jal Watch Sys. Monitor</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">

    <!-- Your CSS (MUST be last) -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/ProjectCSS/Dashboard.css?v=1">

    <!-- Favicon -->
    <link rel="icon" href="${pageContext.request.contextPath}/Images/logo.png">
</head>

<body>

    <div class="wrapper">

        <!-- SIDEBAR -->
        <nav id="sidebar">
            <div class="sidebar-header d-flex justify-content-center align-items-center">
                <img src="${pageContext.request.contextPath}/Images/logo.png"
                     alt="Jal Watch Logo"
                     class="img-fluid"
                     style="max-width: 180px;">
            </div>

            <ul class="list-unstyled mt-4">

                <li>
                    <a href="#" class="nav-link active">
                        <i class="fa-solid fa-border-all"></i> Dashboard
                    </a>
                </li>

                <li>
                    <a href="#" class="nav-link">
                        <i class="fa-solid fa-server"></i> Devices
                    </a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/ShowAlarm" class="nav-link">
                        <i class="fa-solid fa-triangle-exclamation"></i> Alerts
                    </a>
                </li>

                <li>
                    <a href="#" class="nav-link">
                        <i class="fa-solid fa-chart-simple"></i> Reports
                    </a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/addData.jsp" class="nav-link">
                        <i class="fa-solid fa-plus"></i> Add Data
                    </a>
                </li>
                
                 <li>
                    <a href="${pageContext.request.contextPath}/ShowDataCtrl" class="nav-link">
                        <i class="fa-solid "></i> Show Data
                    </a>
                </li>

            </ul>

            <div class="sidebar-bottom">
                <a href="#" class="nav-link">
                    <i class="fa-solid fa-gear"></i> Settings
                </a>
            </div>
        </nav>

        <!-- MAIN CONTENT -->
        <div id="content">

            <!-- HEADER -->
            <div class="top-header">

                <div class="header-title">
                    <button id="sidebarCollapse">
                        <i class="fa-solid fa-bars"></i>
                    </button>
                    <span class="ms-2 d-none d-md-inline">DASHBOARD</span>
                </div>

                <div class="d-flex align-items-center gap-3">

                    <div class="search-bar">
                        <i class="fa-solid fa-magnifying-glass"></i>
                        <input type="text" placeholder="Search Device ID...">
                    </div>

                    <i class="fa-regular fa-bell"
                       style="font-size: 18px; cursor: pointer;"></i>

                </div>
            </div>

            <!-- MAIN BOX -->
            <div class="p-3"
                 style="border: 1px dashed var(--border-color); border-radius: 10px; text-align: center;">
                Main Content
            </div>

        </div>
    </div>

    <!-- JS -->
    <script src="${pageContext.request.contextPath}/JavaScript/Dashboard.js"></script>

</body>
</html>