package tranquvis.simplesmsremote.CommandManagement.Params;


public class CommandParamEmpty extends CommandParam<Void> {
    public CommandParamEmpty(String id) {
        super(id);
    }

    @Override
    public Void getValueFromInput(String input) throws Exception {
        return null;
    }
}
