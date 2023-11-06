import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class test_client {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter opsw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(opsw);
            bw.write("hello world\n");
            bw.flush();
        } catch (IOException e) {
            System.out.println("连接服务器失败");
        }
    }
}
