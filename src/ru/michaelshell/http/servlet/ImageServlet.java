package ru.michaelshell.http.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import ru.michaelshell.http.service.ImageService;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/images/*")
public class ImageServlet extends HttpServlet {

    private final ImageService imageService = ImageService.getINSTANCE();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var requestURI = req.getRequestURI();
        var imagePath = requestURI.replace("/images", "");

        imageService.get(imagePath)
                .ifPresentOrElse(imageInputStream -> {
                    resp.setContentType("application/octet-stream");
                    writeImage(imageInputStream, resp);
                }, () -> resp.setStatus(404));
    }

    @SneakyThrows
    private void writeImage(InputStream imageInputStream, HttpServletResponse resp) {
        try (imageInputStream; var outputStream = resp.getOutputStream()) {
            int currentByte;
            while ((currentByte = imageInputStream.read()) != -1 ) {
                outputStream.write(currentByte);
            }
        }
    }
}
