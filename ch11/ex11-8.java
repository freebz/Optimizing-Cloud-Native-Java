// 내부 지표가 공개되지 않도록 방지
this.registry.config()
    .meterFilter(MeterFilter.denyNameStartsWith("internal"));