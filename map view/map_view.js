// Step 1: Initialize map
const map = L.map('map').setView([23.2599, 77.4126], 5); // India center

// Step 2: Add OpenStreetMap layer
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: "© OpenStreetMap"
}).addTo(map);

// Store markers and devices data
let allMarkers = [];
let allDevices = [];
let currentFilter = 'all';

// Step 3: Marker colors (based on alert status)
function getMarkerColor(status) {
    if (status === "ALERT") return "red";
    if (status === "WARNING") return "orange";
    return "green";
}

// Step 4: Clear all markers from map
function clearMarkers() {
    allMarkers.forEach(marker => map.removeLayer(marker));
    allMarkers = [];
}

// Step 5: Display markers based on filter
function displayMarkers(filter) {
    clearMarkers();
    
    allDevices.forEach(device => {
        if (filter === 'all' || device.status === filter) {
            const color = getMarkerColor(device.status);
            
            const marker = L.circleMarker(
                [device.latitude, device.longitude],
                {
                    color: color,
                    radius: 8
                }
            ).addTo(map);
            
            marker.bindPopup(`
                <b>Device ID:</b> ${device.deviceId} <br>
                <b>Water Level:</b> ${device.waterLevel} <br>
                <b>Battery:</b> ${device.batteryLevel} <br>
                <b>Status:</b> ${device.status}
            `);
            
            allMarkers.push(marker);
        }
    });
}

// Step 6: Fetch data from backend (API)
fetch("http://localhost:8080/api/devices")
    .then(response => response.json())
    .then(data => {
        allDevices = data;
        displayMarkers('all');
    })
    .catch(error => console.error("Error:", error));

// Step 7: Button event listeners
document.getElementById('btnAll').addEventListener('click', function() {
    currentFilter = 'all';
    updateButtonStyles();
    displayMarkers('all');
});

document.getElementById('btnAlert').addEventListener('click', function() {
    currentFilter = 'ALERT';
    updateButtonStyles();
    displayMarkers('ALERT');
});

document.getElementById('btnWarning').addEventListener('click', function() {
    currentFilter = 'WARNING';
    updateButtonStyles();
    displayMarkers('WARNING');
});

document.getElementById('btnNormal').addEventListener('click', function() {
    currentFilter = 'NORMAL';
    updateButtonStyles();
    displayMarkers('NORMAL');
});

document.getElementById('btnReset').addEventListener('click', function() {
    map.setView([23.2599, 77.4126], 5);
});

// Step 8: Update button styles based on current filter
function updateButtonStyles() {
    document.getElementById('btnAll').classList.remove('active');
    document.getElementById('btnAlert').classList.remove('active');
    document.getElementById('btnWarning').classList.remove('active');
    document.getElementById('btnNormal').classList.remove('active');
    
    if (currentFilter === 'all') {
        document.getElementById('btnAll').classList.add('active');
    } else if (currentFilter === 'ALERT') {
        document.getElementById('btnAlert').classList.add('active');
    } else if (currentFilter === 'WARNING') {
        document.getElementById('btnWarning').classList.add('active');
    } else if (currentFilter === 'NORMAL') {
        document.getElementById('btnNormal').classList.add('active');
    }
}