package bowling.utils.impl;

import bowling.utils.api.Constants;
import bowling.utils.api.IDataValidation;
import org.apache.commons.lang3.math.NumberUtils;

public class DataValidation implements IDataValidation {

    public int getResultAsInteger(String text) {
        if (NumberUtils.isParsable(text)) {
            return Integer.parseInt(text);
        } else {
            if (text.equals("F"))
                return 0;
            else
                return Constants.INTEGER_FOR_CHAR_IDENTIFIER;
        }
    }

    public String getResultAsString(String text) {
        if (NumberUtils.isParsable(text)) {
            return text;
        } else {
            if (text.equals("F"))
                return text;
            else
                return Constants.INTEGER_FOR_CHAR_IDENTIFIER.toString();
        }
    }

    public boolean isPositiveInteger(Integer number) {
        return Integer.signum(number) >= 0;
    }
}
