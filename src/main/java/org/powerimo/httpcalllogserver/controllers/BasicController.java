package org.powerimo.httpcalllogserver.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/basic")
@Slf4j
public class BasicController {

    @PostMapping
    public ResponseEntity<String> postBasic(HttpServletRequest request) {
        log.info("==========");
        log.info("Basic call");
        var headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {
            var header = headers.nextElement();
            log.info("{}: {}", header, request.getHeader(header));
        }

        try {
            String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            log.info("Body: {}", body);
        } catch (IOException e) {
            log.error("Failed to read request body", e);
        }

        return ResponseEntity.ok("OK");
    }
}
