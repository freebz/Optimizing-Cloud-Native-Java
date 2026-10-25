// 스프링이 아닌 애플리케이션 테스트용
MeterRegistry myRegistry = new SimpleMeterRegistry();

// 일부 출력 결과 생성
MeterRegistry withOutput = new LoggingMeterRegistry();