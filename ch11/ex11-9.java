new MeterFilter() {
      @Override
      public MeterFilterReply accept(Meter.Id id) {
        if (id.getName().startsWith("internal")) {
          return MeterFilterReply.DENY;
        }
        return MeterFilterReply.NEUTRAL;
      }
    };