package tranquvis.simplesmsremote.CommandManagement.Commands;

import android.content.Context;
import android.support.annotation.Nullable;

import tranquvis.simplesmsremote.CommandManagement.CommandExecResult;
import tranquvis.simplesmsremote.CommandManagement.CommandInstance;
import tranquvis.simplesmsremote.CommandManagement.Modules.Module;
import tranquvis.simplesmsremote.R;
import tranquvis.simplesmsremote.Utils.Device.BluetoothUtils;
import tranquvis.simplesmsremote.Utils.Regex.MatchType;
import tranquvis.simplesmsremote.Utils.Regex.PatternTreeNode;



public class CommandGetBluetoothState extends Command {

    private static final String
            PATTERN_ROOT = GetPatternFromTemplate(PATTERN_TEMPLATE_GET_STATE_ON_OFF, "bluetooth");

    public CommandGetBluetoothState(@Nullable Module module) {
        super(module);

        this.titleRes = R.string.command_title_get_bluetooth_state;
        this.syntaxDescList = new String[]{
                "is bluetooth enabled"
        };
        this.patternTree = new PatternTreeNode("root",
                PATTERN_ROOT,
                MatchType.DO_NOT_MATCH
        );
    }


    @Override
    public void execute(Context context, CommandInstance commandInstance,
                        CommandExecResult result) throws Exception {
        boolean isBluetoothEnabled = BluetoothUtils.IsBluetoothEnabled();
        result.setCustomResultMessage(context.getString(
                isBluetoothEnabled ? R.string.result_msg_bluetooth_is_enabled_true
                        : R.string.result_msg_bluetooth_is_enabled_false));
        result.setForceSendingResultSmsMessage(true);
    }
}
