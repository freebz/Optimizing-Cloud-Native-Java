@GetMapping("/battle")
public String makeBattle() throws IOException, InterruptedException {
  // 요청에서 전파된 컨텍스트를 추출. 이 경우, 요청에서 어떤 컨텍스트도 추출되지 않으며, 이는 루트 스팬임
  var extractedContext = extractContext(httpServletRequest,EXTRACTOR);

  try (var scope = extractedContext.makeCurrent()) {
    // 스팬 시작
    var span = serverSpan("/battle", HttpMethod.GET.name(),
        AnimalController.class.getName(), "animal-service:8080");
    
    // 두 개의 요청을 전송하고, 응답 본문을 응답으로 변환한 뒤 루트 스팬을 종료
    try {
      var good = fetchRandomAnimal(span);
      var evil = fetchRandomAnimal(span);
      return String.format("""
{ "good": "%s", "evil": "%s" }""", good, evil);
    } finally {
      span.end();
    }
  }
  // ...
}