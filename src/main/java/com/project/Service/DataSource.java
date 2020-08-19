package com.project.Service;

import java.util.OptionalDouble;

public interface DataSource {
    public OptionalDouble getAverageRange(String start, String end, String ticker);
}
