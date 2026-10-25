@Nullable
public <T extends Number> T guage(String name, T number) {
    return this.guage((String)name, (Iterable)Collections.emptyList(),
      (Number)number);
}