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
        for (int i = 1; i < 10000000; i++)
            startServer(i);

        System.out.printf("Num of Threads %s", NUMBER_OF_THREADS);

    }

    public static void startServer(int mass) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/calculation", new CalculationHandler(mass));
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        server.setExecutor(executor);
        server.start();

    }

    private static class CalculationHandler implements HttpHandler {
        private int mass;

        public CalculationHandler(int mass) {
            this.mass = mass;
        }

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            int query = Integer.parseInt(httpExchange.getRequestURI().getQuery());

            int energy = 0;
            energy += 10 * query;

            if(this.mass != 0){
                httpExchange.sendResponseHeaders(400, 0);
                return;
            }

            byte[] response = Long.toString(energy).getBytes();
            httpExchange.sendResponseHeaders(200, response.length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response);
            outputStream.close();

        }
    }


}



