package tranquvis.simplesmsremote.CommandManagement.Modules;

import android.Manifest;

import tranquvis.simplesmsremote.CommandManagement.Commands.CommandGetWifiState;
import tranquvis.simplesmsremote.CommandManagement.Commands.CommandSetWifiState;
import tranquvis.simplesmsremote.R;



public class ModuleWifi extends Module {
    public final CommandSetWifiState commandSetWifiState = new CommandSetWifiState(this);
    public final CommandGetWifiState commandGetWifiState = new CommandGetWifiState(this);

    public ModuleWifi() {
        this.titleRes = R.string.control_module_title_wifi;
        this.descriptionRes = R.string.control_module_desc_wifi;
        this.iconRes = R.drawable.ic_signal_wifi_2_bar_grey_700_36dp;

        this.requiredPermissions = new String[]{
                Manifest.permission.CHANGE_WIFI_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.WRITE_SETTINGS
        };
    }
}
