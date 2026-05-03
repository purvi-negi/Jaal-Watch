@WebServlet("/api/devices")
public class DeviceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        // Example (replace with DB query)
        String json = "[{\"deviceId\":\"DWLR001\",\"latitude\":23.25,\"longitude\":77.41,\"waterLevel\":15.5,\"batteryLevel\":3.1,\"status\":\"ALERT\"}]";

        out.print(json);
    }
}