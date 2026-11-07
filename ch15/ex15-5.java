void serveScope(ServerSocket serverSocket) throws IOException,
    InterruptedException {
        try (var scope = new StructuredTaskScope<Void>()) {
            try {
                while (true) {
                    final var socket = serverSocket.accept();
                    Callable<Void> task = () -> {
                        handle(socket);
                        return null;
                    };
                    scope.fork(task);
                }
            } finally {
                // 오류가 발생했거나 인터럽트된 경우, 요청 수신을 중단
                scope.shutdown();   // 모든 활성 연결을 종료
                scope.join();
            }
        }
    }