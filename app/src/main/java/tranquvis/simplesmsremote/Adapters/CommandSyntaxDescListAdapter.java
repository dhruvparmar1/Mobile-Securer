package tranquvis.simplesmsremote.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import tranquvis.simplesmsremote.CommandManagement.Commands.Command;
import tranquvis.simplesmsremote.R;


public class CommandSyntaxDescListAdapter extends ArrayAdapter<Command> {
    private static final int LAYOUT_RES = R.layout.listview_item_commands;

    public CommandSyntaxDescListAdapter(Context context, List<Command> commands) {
        super(context, LAYOUT_RES, commands);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(LAYOUT_RES, parent, false);
        }

        Command command = getItem(position);
        if (command == null)
            return convertView;

        ((TextView) convertView.findViewById(R.id.textView_command_template))
                .setText(StringUtils.join(command.getSyntaxDescList(), "\r\n"));

        return convertView;
    }
}
