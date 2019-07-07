package me.bo0tzz.granddigital.gson;

public class WithYearExclusionStrategy extends BaseExclusionStrategy {

    public WithYearExclusionStrategy() {
        super();
        wantedFields.add("year");
    }
}
