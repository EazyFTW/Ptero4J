package com.stanjg.ptero4j.entities.objects.server;

import java.util.Arrays;

public enum MinecraftVersion {

    V1_8_8("1.8.8"),
    V1_9_4("1.9.4"),
    V1_10_2("1.10.2"),
    V1_11_2("1.11.2"),
    V1_12_2("1.12.2"),
    V1_13_2("1.13.2"),
    V1_14_4("1.14.4"),
    V1_15("1.15"),
    V1_15_1("1.15.1"),
    V1_15_2("1.15.2");

    private String version;

    MinecraftVersion(String version) {
        this.version = version;
    }

    public boolean isAboveOrEqual(MinecraftVersion compare) {
        return this.ordinal() >= compare.ordinal();
    }

    public String getVersion() {
        return version;
    }

    public static MinecraftVersion getLatestVersion() {
        return MinecraftVersion.values()[MinecraftVersion.values().length - 1];
    }

    public static boolean isVersion(String version) {
        return Arrays.stream(MinecraftVersion.values()).anyMatch(mcv -> mcv.getVersion().equalsIgnoreCase(version));
    }

    public static MinecraftVersion getByVersion(String version) {
        return Arrays.stream(MinecraftVersion.values()).filter(mcv -> mcv.getVersion().equalsIgnoreCase(version)).findFirst().orElse(V1_15_2);
    }
}