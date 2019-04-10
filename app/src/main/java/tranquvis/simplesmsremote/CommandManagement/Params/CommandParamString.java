package tranquvis.simplesmsremote.CommandManagement.Params;


public class CommandParamString extends CommandParam<String> {
    public CommandParamString(String id) {
        super(id);
    }

    @Override
    public String getValueFromInput(String input) {
        return input;
    }
}
