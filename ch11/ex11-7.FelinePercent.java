public final class FelinePercent extends Number {
  private volatile double value;

  public FelinePercent(double v) {
    if (v < 0.0 || v > 1.0) {
      throw new IllegalArgumentException("Require 0 < felinePercent < 1");
    }
    value = v;
  }

  public void setValue(double v) {
    if (v < 0.0 || v > 1.0) {
      throw new IllegalArgumentException("Require 0 < felinePercent < 1");
    }
    value = v;
  }

  @Override
  public int intValue() {
    return (int) value;
  }

  @Override
  public long longValue() {
    return (long) value;
  }

  @Override
  public float floatValue() {
    return (float) value;
  }

  @Override
  public double doubleValue() {
    return value;
  }
}