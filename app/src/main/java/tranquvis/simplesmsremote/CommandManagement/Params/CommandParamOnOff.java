package tranquvis.simplesmsremote.CommandManagement.Params;


public class CommandParamOnOff extends CommandParam<Boolean> {
    public CommandParamOnOff(String id) {
        super(id);
    }

    @Override
    public Boolean getValueFromInput(String input) {
        return !input.matches("(?i)^(.*?(^|\\s+)(no|(disable(d)?)|off)($|\\s+)).*?");
    }
}
