new MeterFilter() {
    @Override
    public DistributionStatisticConfig configure(Meter.Id id,
                DistributionStatisticConfig config) {
        if (id.getName().startsWith("jvm")) {
            return DistributionStatisticConfig.builder()
                    .publishPercentiles(0.9, 0.99, 0.999, 0.9999)
                    .build()
                    .merge(config);
        }
        return config;
    }
};