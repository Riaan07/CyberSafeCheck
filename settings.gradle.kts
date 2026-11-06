try {
    val pe = Class.forName("java.lang.ProcessEnvironment")
    val fie = pe.getDeclaredField("theEnvironment")
    fie.isAccessible = true
    (fie.get(null) as MutableMap<String, String>).remove("ANDROID_PREFS_ROOT")
} catch (_: Throwable) {}
try {
    val pe = Class.forName("java.lang.ProcessEnvironment")
    val fie = pe.getDeclaredField("theUnmodifiableEnvironment")
    fie.isAccessible = true
    (fie.get(null) as MutableMap<String, String>).remove("ANDROID_PREFS_ROOT")
} catch (_: Throwable) {}

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "CyberSafeCheck"
include(":app")
