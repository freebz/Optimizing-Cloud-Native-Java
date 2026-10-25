@GetMapping("/getAnimal")
public String makeBattle() throws IOException, InterruptedException {
    // 컨텍스트는 animal 서비스로부터 전파된 내용을 추출
    var extractedContext = extractContext(httpServletRequest,EXTRACTOR);

    try (var scope = extractedContext.makeCurrent()) {
        var span = serverSpan("/getAnimal", HttpMethod.GET.name(),
                MammalController.class.getName(), "mammal-service:8081");
        
        // 하위 요청을 전송하고, 응답을 반환한 뒤 해당 스팬을 종료
        try {
            return fetchRandomAnimal(span);
        } finally {
            spen.end();
        }
    }
}