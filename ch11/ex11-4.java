this.battlesTotal = Counter
        .builder("battles.total")
        .description("Total number of battles fought")
        .register(this.registry);