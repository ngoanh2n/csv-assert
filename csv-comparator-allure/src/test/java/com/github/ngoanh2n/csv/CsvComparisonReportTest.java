package com.github.ngoanh2n.csv;

import com.github.ngoanh2n.Resource;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
@Epic("CSV Comparator: Has Differences")
@Feature("CSV Comparator: Demo Test")
public class CsvComparisonReportTest {
    @Test
    void test() {
        File exp = Resource.getFile("com/github/ngoanh2n/csv/exp/combine2.csv");
        File act = Resource.getFile("com/github/ngoanh2n/csv/act/combine2.csv");

        CsvComparisonOptions options = CsvComparisonOptions
                .builder()
                .selectColumnId(0)
                .build();
        CsvComparator.compare(exp, act, options);
    }
}
