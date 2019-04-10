package tranquvis.simplesmsremote.CommandManagement.Params;


import tranquvis.simplesmsremote.Utils.UnitTools.Unit;


public class CommandParamUnit extends CommandParam<Unit> {
    public CommandParamUnit(String id) {
        super(id);
    }

    /**
     * Get unit from input.
     *
     * @param input unit string
     * @throws Exception
     */
    @Override
    public Unit getValueFromInput(String input) throws Exception {
        for (Unit unit : Unit.values()) {
            if (input.matches(unit.getPattern()))
                return unit;
        }
        throw new IllegalArgumentException("unsupported unit");
    }
}
