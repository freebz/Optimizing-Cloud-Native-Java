@SpringBootApplication
public class AnimalApplication {

  @Bean
  public MeterRegistry basicRegistry() {
    return new LoggingMeterRegistry();
  }

  public static void main(String[] args) {
    SpringApplication.run(AnimalApplication.class, args);
  }
}