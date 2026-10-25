// 로그 노이즈를 줄이기 위해 bean을 제거
@Bean
public MeterRegistry basicRegistry() {
  return new LoggingMeterRegistry();
}