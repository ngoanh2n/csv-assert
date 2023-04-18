package com.github.ngoanh2n.csv;

import com.github.ngoanh2n.Commons;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.io.File;

/**
 * This interface should be used to provide comparison source for {@link CsvComparator}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public interface CsvComparisonSource {
    /**
     * Creates a comparison source and make sure it is not null.
     *
     * @param exp the expected CSV.
     * @param act the actual CSV needs to compare.
     * @return {@link CsvComparisonSource}
     */
    static CsvComparisonSource create(@Nonnull File exp, @Nonnull File act) {
        CsvComparisonSource source = new CsvComparisonSource() {
            @Nonnull
            @Override
            public File exp() {
                return Preconditions.checkNotNull(exp, "Expected source cannot be null");
            }

            @Nonnull
            @Override
            public File act() {
                return Preconditions.checkNotNull(act, "Actual source cannot be null");
            }
        };

        log.debug("Exp CSV {}", Commons.getRelative(source.exp()));
        log.debug("Act CSV {}", Commons.getRelative(source.act()));
        return source;
    }

    //-------------------------------------------------------------------------------//

    /**
     * Provides expected CSV file.
     *
     * @return Expected CSV file.
     */
    @Nonnull
    File exp();

    /**
     * Provides actual CSV file needs to compare.
     *
     * @return Actual CSV file.
     */
    @Nonnull
    File act();

    //-------------------------------------------------------------------------------//

    /**
     * Default Logger for {@link  CsvComparisonSource}.
     */
    Logger log = LoggerFactory.getLogger(CsvComparisonSource.class);
}
