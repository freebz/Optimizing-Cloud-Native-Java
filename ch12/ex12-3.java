String fileName = // ... 일부 JFR 파일
var recording = new RecordingFile(Paths.get(fileName));
while (recording.hasMoreEvents()) {
    var event = recording.readEvent();
    if (event != null) {
        var details = decodeEvent(event);
        if (details == null) {
            System.err.println("Failed to recognize details");
        } else {
            // 세부 정보를 처리할 예정이지만, 지금은 로그만 남김
            System.out.println(details);
        }
    }
}