public static Span serverSpan(Tracer tracer, String path, String method, String serviceName) {
  return tracer
      .spanBuilder(path)
      .setSpanKind(SpanKind.SERVER)
      .setAttribute(SemanticAttributes.HTTP_METHOD, method)
      .setAttribute(SemanticAttributes.HTTP_SCHEME, "http")
      .setAttribute(SemanticAttributes.HTTP_HOST, serviceName)
      .setAttribute(SemanticAttributes.HTTP_TARGET, path)
      .startSpan();
}