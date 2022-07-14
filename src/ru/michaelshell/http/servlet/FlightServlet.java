package ru.michaelshell.http.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.michaelshell.http.service.FlightService;
import ru.michaelshell.http.util.JspHelper;

import java.io.IOException;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("flights", flightService.findAll());

        req.getRequestDispatcher(JspHelper.getPath("flights"))
                        .forward(req, resp);

//        resp.setContentType("text/html");
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//
//        var writer = resp.getWriter();
//        writer.write("<h1>Список перелётов:</h1>");
//        writer.write("<ul>");
//        flightService.findAll().forEach(flightDto ->
//                writer.write("""
//                        <li>
//                            <a href="/tickets?flightId=%d">%s</a>
//                        </li>
//                        """.formatted(flightDto.getId(), flightDto.getDescription())));
//        writer.write("</ul>");

    }
}
