private volatile boolean isShutdown = false;

void handle(Socket socket) {
    // 들어오는 요청을 처리
}

void serveVT(ServerSocket serverSocket) throws IOException,
    InterruptedException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            try {
                while (!isShutdown) {
                    var socket = serverSocket.accept();
                    executor.submit(() -> handle(socket));
                }
            } finally {
                // 오류가 발생했거나 인터럽트되었을 경우, 요청 수신을 중단
                executor.shutdown();
            }
        }
    }

public shutdown() {
    isShutdown = true;
}