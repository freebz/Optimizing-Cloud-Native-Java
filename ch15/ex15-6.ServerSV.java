public class ServerSV {
    private final static ScopedValue<Scoket> SOCKETSV =
        ScopedValue.newInstance();
    
    void serve(ServerSocket serverSocket) throws IOException,
        InterruptedException {
            while (true) {
                var socket = serverSocket.accept();
                ScopedValue.where(SOCKETSV, socket)
                           .run(() -> handle())
            }
        }
    
    private void handle() {
        var socket = SOCKETSV.get();
        // 발생하는 트래픽 처리
    }
}