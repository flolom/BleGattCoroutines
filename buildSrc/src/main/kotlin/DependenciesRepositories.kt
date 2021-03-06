import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.maven

fun RepositoryHandler.setupForProject() {

    mavenCentral().ensureGroupsStartingWith("com.jakewharton.", "com.squareup.")

    google()
    jcenter()

    maven(url = "https://maven.fabric.io/public").ensureGroups("io.fabric.tools")

    maven(
        url = "https://dl.bintray.com/louiscad/splitties-dev"
    ).ensureGroups("com.louiscad.splitties")

    if ("eap" in Versions.kotlin) maven(
        url = "https://dl.bintray.com/kotlin/kotlin-eap"
    ).ensureGroups("org.jetbrains.kotlin")

    maven(
        url = "https://kotlin.bintray.com/kotlinx"
    ).ensureModulesByRegexp("org.jetbrains.kotlinx:kotlinx-serialization\\-.*")

    maven(
        url = "https://oss.sonatype.org/content/repositories/snapshots"
    ).ensureGroups("org.androidannotations")
}
