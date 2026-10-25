@ConditionOnClass(LoggerContext.class)
@ConditionOnProperty(name="otel.instrumentation.logback.enabled",
                     matchIfMissing=true)
@Configuration
static class LogbackAppendConfig {
  @Bean
  ApplicationListener<ApplicationReadyEvent> logbackOtelAppenderInitializer(
      OpenTelemetry openTelemetry) {
    return event -> OpenTelemetryAppender.install(openTelemetry);
  }
}