pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "Modern Android Development"
include(":app")
include(":uistate")
include(":xmlcompose")
include(":androidtest")
include(":navigation")
include(":samplelogin")
include(":datastore")
include(":roomdatabase")
include(":workmanager")
include(":pagination")
