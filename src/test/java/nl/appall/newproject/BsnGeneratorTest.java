package nl.appall.newproject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static nl.appall.newproject.BsnGenerator.isValidBsn;
import static org.junit.jupiter.api.Assertions.*;

class BsnGeneratorTest {


    @ParameterizedTest
    @ValueSource(strings = {
            "72599950", "23674696", "45190146", "36185019",
            "97780150", "68479612", "31996218", "71181538",
            "63140071", "57490792", "000000000"
    })
    public void testBsnNumbers(String bsn) {
        assertTrue(BsnGenerator.isValidBsn(bsn), "BSN " + bsn + " did not pass the elfproef");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123456789", "987654321"
    })
    public void testWrongBsnNumbers(String bsn) {
        assertFalse(BsnGenerator.isValidBsn(bsn), "BSN " + bsn + " did not pass the elfproef");
    }
}
