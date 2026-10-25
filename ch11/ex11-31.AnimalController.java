public class AnimalController {
  // ...

  private final OpenTelemetry sdk;

  private final Meter appMeter;
  private final Meter memoryMeter;
  private final LongCounter battlesTotal;
  private final ObservableDoubleGauge cpuTotal;


  public AnimalController(OpenTelemetry sdk) {
    this.sdk = sdk;

    Meter appMeter = sdk.getMeter(INSTRUMENTATION_SCORE + ".app");
    this.appMeter = appMeter;
    this.battlesTotal = createCounter(appMeter);

    Meter memoryMeter = sdk.getMeter(INSTRUMENTATION_SCORE + ".memory");
    this.memoryMeter = memoryMeter;
    this.cpuTotal = createGauge(memoryMeter);
  }


  static LongCounter createCounter(Meter meter) {
    return meter
        .counterBuilder("battles.total")
        .setDescription("Counts total battles fought.")
        .build();
  }

  static ObservableDoubleGauge createGauge(Meter meter) {
    return meter
        .guageBuilder("jvm.memory.total")
        .setDescription("Reports JVM memory usage.")
        .setUnit("By")
        .buildWithCallback(
            result -> result.record(Runtime.getRuntime().totalMemory(),
            Attributes.empty()));
  }
}