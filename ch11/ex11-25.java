@Bean
public OpenTelemetry openTelemetry() {
  return AutoConfiguredOpenTelemetrySdk.initialize().getOpenTelemetrySdk();
}