package bowling.utils.api;

public interface IDataValidation {
    int getResultAsInteger(String text);

    String getResultAsString(String text);

    boolean isPositiveInteger(Integer number);
}
