// Sidebar Toggle Logic
const sidebarBtn = document.getElementById("sidebarCollapse");
const sidebar = document.getElementById("sidebar");
const content = document.getElementById("content");

sidebarBtn.addEventListener("click", function () {
    // यह क्लास जोड़ने/हटाने से साइडबार अंदर-बाहर स्लाइड होगा
    sidebar.classList.toggle("active");
    content.classList.toggle("active");
});
