LDUser user = new LDUser("authors");
boolean mammalService =
    launchDarklyClient.boolVariation("user.enabled.mammals", user, false);
if (mammalService) {
  // Retrieves the mammal from the modern environment
}
else {
  // Retrieves the mammal from the existing monolithic codebase
}