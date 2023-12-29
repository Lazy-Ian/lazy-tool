pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://maven.aliyun.com/repository/public/")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/google")
        }

        mavenLocal()
        mavenCentral()
        maven { url = uri("https://repo1.maven.org/maven2/") }
        maven { url = uri("https://maven.google.com") }
        maven { url = uri("https://download.linphone.org/maven_repository") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io") }
        maven {
            url = uri("https://github.com/jitsi/jitsi-maven-repository/raw/master/releases")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/public/")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/google")
        }
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://repo1.maven.org/maven2/") }
        // fcm
        maven { url = uri("https://maven.google.com") }
        maven { url = uri("https://download.linphone.org/maven_repository") }
    }
}

rootProject.name = "lazy-tool"
include(":app")
include(":lib-tool")

