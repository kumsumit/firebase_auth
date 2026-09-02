import java.util.regex.Pattern

val libraryName = "flutter-fire-auth"
val pubspec = project.projectDir.parentFile.resolve("pubspec.yaml")
val libraryVersionName =
    if (pubspec.exists()) {
        Pattern.compile(
            "^version:\\s*['|\"]?([^\\n|'|\"]*)['|\"]?$",
            Pattern.MULTILINE,
        ).matcher(pubspec.readText()).let { matcher ->
            if (matcher.find()) matcher.group(1).replace("+", "-") else "UNKNOWN"
        }
    } else {
        "UNKNOWN"
    }

android {
    defaultConfig {
        buildConfigField("String", "LIBRARY_VERSION", "\"$libraryVersionName\"")
        buildConfigField("String", "LIBRARY_NAME", "\"$libraryName\"")
    }
}
