package com.ithinksky.java.n06concurrency.ch002threadpool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 一个基于线程池技术的简单Web服务器
 *
 * @author tengpeng.gao
 * @since 2019/3/10
 */
public class SimpleHttpServer {

    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>();
    static String basePath;
    static ServerSocket serverSocket;
    static int port = 8080;

    public static void setPort(int port) {
        if (port > 0) {
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath) {
        if (basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()) {
            SimpleHttpServer.basePath = basePath;
        }
    }

    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }

    public static void close(Closeable... closeables) {
        if (closeables != null) {
            for (Closeable closeable : closeables) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class HttpRequestHandler implements Runnable {

        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            String line = null;
            BufferedReader bf = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;

            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();
                String filePath = basePath + header.split(" ")[1];
                out = new PrintWriter(socket.getOutputStream());
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")) {
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read()) != -1) {
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-Length: " + array.length);
                    out.println("");
                    socket.getOutputStream().write(array, 0, array.length);
                } else {
                    bf = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: Molly");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line = bf.readLine()) != null) {
                        out.println(line);
                    }
                }
                out.flush();
            } catch (IOException e) {
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(bf, in, reader, out, socket);
            }
        }
    }

}
