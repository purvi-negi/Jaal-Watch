// Step 1: Initialize map
const map = L.map('map').setView([23.2599, 77.4126], 5); // India center

// Step 2: Add OpenStreetMap layer
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: "© OpenStreetMap"
}).addTo(map);

// Step 3: Marker colors (based on alert status)
function getMarkerColor(status) {
    if (status === "ALERT") return "red";
    if (status === "WARNING") return "orange";
    return "green";
}

// Step 4: Fetch data from backend (API)
fetch("http://localhost:8080/api/devices")
    .then(response => response.json())
    .then(data => {
        data.forEach(device => {

            const color = getMarkerColor(device.status);

            // Create circle marker
            const marker = L.circleMarker(
                [device.latitude, device.longitude],
                {
                    color: color,
                    radius: 8
                }
            ).addTo(map);

            // Popup info
            marker.bindPopup(`
                <b>Device ID:</b> ${device.deviceId} <br>
                <b>Water Level:</b> ${device.waterLevel} <br>
                <b>Battery:</b> ${device.batteryLevel} <br>
                <b>Status:</b> ${device.status}
            `);
        });
    })
    .catch(error => console.error("Error:", error));