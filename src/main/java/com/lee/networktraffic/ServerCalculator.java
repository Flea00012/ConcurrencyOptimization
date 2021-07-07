package com.lee.networktraffic;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ServerCalculator {

    private static final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws IOException {
        String string = "lee";
            startServer(string);

        System.out.printf("Num of Threads %s", NUMBER_OF_THREADS);

    }

    public static void startServer(String string) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/word", new CalculationHandler(string));
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();

    }

    private static class CalculationHandler implements HttpHandler {
        private String string;

        public CalculationHandler(String string) {
            this.string = string;
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String query = httpExchange.getRequestURI().getQuery();



            if(!query.equals("lee")){
                httpExchange.sendResponseHeaders(400, 1);
                return;
            }


            byte[] response = Long.toString(Long.parseLong(query)).getBytes();
            httpExchange.sendResponseHeaders(200, response.length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();

        }
    }


}



