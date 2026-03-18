import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URLEncoder;

//编译： javac HttpClient.java --enable-preview
//运行： java HttpClient

public class HttpClient {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 8080;

        String name = "张三";
        String encodedName = URLEncoder.encode(name, "UTF-8");
        String path = "/hi?name=" + encodedName;
        
        try (Socket socket = new Socket(host, port);
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            
            // 发送HTTP GET请求
            String request = "GET " + path + " HTTP/1.1\r\n" +
                           "Host: " + host + "\r\n" +
                           "\r\n";
            outputStream.write(request.getBytes());
            outputStream.flush();
            
            // 读取并解析响应
            System.out.println("HTTP响应解析结果:");
            System.out.println("====================================");
            
            // 1. 解析状态行
            String statusLine = reader.readLine();
            System.out.println("[状态行]");
            System.out.println(statusLine);
            System.out.println();
            
            // 2. 解析响应头时记录 Content-Length
            int contentLength = 0;
            System.out.println("[响应头]");
            String headerLine;
            while ((headerLine = reader.readLine()) != null && !headerLine.isEmpty()) {
                System.out.println(headerLine);
                // 解析 Content-Length
                if (headerLine.toLowerCase().startsWith("content-length:")) {
                    contentLength = Integer.parseInt(headerLine.split(":")[1].trim());
                }
            }
            System.out.println();

            // 3. 解析响应体（基于 Content-Length）
            System.out.println("[响应体]");
            if (contentLength > 0) {
                // 根据 Content-Length 读取指定长度的内容
                char[] buffer = new char[contentLength];
                int read = reader.read(buffer, 0, contentLength);
                System.out.println(new String(buffer, 0, read));
            } else {
                // 回退到原方式
                String bodyLine;
                while ((bodyLine = reader.readLine()) != null) {
                    System.out.println(bodyLine);
                }
            }
            
            System.out.println("====================================");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}