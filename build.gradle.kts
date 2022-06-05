import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    id("com.google.protobuf") version "0.8.15" // 추가
    idea
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    group = "spring.grpc.kt.starter"
    version = "0.0.1-SNAPSHOT"

    apply(plugin = "kotlin") // 추가

    repositories {
        mavenCentral()
    }
}

val grpcKotlinVersion = "1.0.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation(project(":protobuf"))

    implementation("io.grpc:grpc-kotlin-stub:$grpcKotlinVersion")
    implementation("io.github.lognet:grpc-spring-boot-starter:4.7.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
