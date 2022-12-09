package strategies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaturdayAssumingConverterTest {

    private final String[] DAYS_OF_WEEK = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private final SaturdayAssumingConverter converter = new SaturdayAssumingConverter();

    @Test
    void convertDayNameToIndex() {
        for(int i = 0; i < 7; i++){
            assertEquals(converter.convertDayNameToIndex(DAYS_OF_WEEK[i]), i);
        }
    }
}