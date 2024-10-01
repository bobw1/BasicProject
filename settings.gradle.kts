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
    includeBuild("build-logic/convention")
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "basic"
include(":app")
include(":data:repository")
include(":data:local-datasource")
include(":data:remote-datasource")
include(":data:dto")
include(":domain")
include(":domain:model")
include(":domain:usecase")
include(":features")
include(":features:testing")
include(":repository-contract")
