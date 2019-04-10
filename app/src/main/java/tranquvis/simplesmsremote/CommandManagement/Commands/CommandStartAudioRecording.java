package tranquvis.simplesmsremote.CommandManagement.Commands;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import tranquvis.simplesmsremote.CommandManagement.CommandExecResult;
import tranquvis.simplesmsremote.CommandManagement.CommandInstance;
import tranquvis.simplesmsremote.CommandManagement.Modules.Module;
import tranquvis.simplesmsremote.R;
import tranquvis.simplesmsremote.Utils.Regex.MatchType;
import tranquvis.simplesmsremote.Utils.Regex.PatternTreeNode;


public class CommandStartAudioRecording extends Command {
    private static final String PATTERN_ROOT = AdaptSimplePattern(
            "(?:(?:start|begin) (?:audio )?(?:recording))|(?:record audio)");

    public CommandStartAudioRecording(@NonNull Module module) {
        super(module);

        this.titleRes = R.string.command_title_start_audio_recording;
        this.syntaxDescList = new String[]{
                "start audio recording"
        };
        this.patternTree = new PatternTreeNode("root",
                PATTERN_ROOT,
                MatchType.DO_NOT_MATCH
        );
    }

    @Override
    public void execute(Context context, CommandInstance commandInstance,
                        CommandExecResult result) throws Exception {
        Intent startIntent = new Intent();
        startIntent.setComponent(new ComponentName("com.github.axet.audiorecorder",
                "com.github.axet.audiorecorder.activities.RecordingActivity"));
        context.startActivity(startIntent);
    }
}