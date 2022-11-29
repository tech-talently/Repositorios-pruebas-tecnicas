package bowling.utils.impl;

import bowling.utils.api.IInputValidation;
import org.apache.commons.lang3.StringUtils;

public class InputValidation implements IInputValidation {

    public boolean isEmptyLine(String line) {
        return StringUtils.isBlank(line);
    }
}
