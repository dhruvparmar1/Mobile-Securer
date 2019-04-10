package tranquvis.simplesmsremote.CommandManagement.Modules;

import tranquvis.simplesmsremote.CommandManagement.Commands.CommandGetBatteryLevel;
import tranquvis.simplesmsremote.CommandManagement.Commands.CommandGetBatteryStatus;
import tranquvis.simplesmsremote.R;



public class ModuleBattery extends Module {
    public final CommandGetBatteryLevel commandGetBatteryLevel =
            new CommandGetBatteryLevel(this);
    public final CommandGetBatteryStatus commandGetBatteryStatus =
            new CommandGetBatteryStatus(this);

    public ModuleBattery() {
        this.titleRes = R.string.control_module_title_battery;
        this.descriptionRes = R.string.control_module_desc_battery;
        this.iconRes = R.drawable.ic_battery_50_grey_700_36dp;
    }
}
