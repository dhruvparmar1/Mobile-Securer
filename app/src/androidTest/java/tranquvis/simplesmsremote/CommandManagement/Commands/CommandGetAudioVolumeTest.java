package tranquvis.simplesmsremote.CommandManagement.Commands;

import org.junit.Test;

import tranquvis.simplesmsremote.Utils.Device.AudioUtils;

import static tranquvis.simplesmsremote.CommandManagement.Commands.CommandGetAudioVolume.PARAM_AUDIO_TYPE;

/**
 * Created by Andreas Kaltenleitner on 31.10.2016.
 */

public class CommandGetAudioVolumeTest extends CommandTest {
    @Override
    @Test
    public void testPattern() throws Exception {
        // check special chars and arrangement
        assertThat("\n get  Volume for Ring \r").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.RING);
        assertThat("fetch music volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.MUSIC);
        assertThat("retrieve volume of dtmf").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.DTMF);

        // check audio types
        assertThat("fetch ring volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.RING);
        assertThat("fetch ringtone volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.RING);

        assertThat("fetch music volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.MUSIC);

        assertThat("fetch alarm volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.ALARM);

        assertThat("fetch notifications volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.NOTIFICATION);
        assertThat("fetch notify volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.NOTIFICATION);

        assertThat("fetch system volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.SYSTEM);

        assertThat("fetch voicecall volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.VOICECALL);
        assertThat("fetch phonecall volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.VOICECALL);
        assertThat("fetch call volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.VOICECALL);

        assertThat("fetch dtmf volume").matches()
                .has(PARAM_AUDIO_TYPE, AudioUtils.AudioType.DTMF);
    }

    @Override
    @Test
    public void testExecution() throws Exception {
        assertThat("get volume for ring").matches().executes();
        assertThat("get volume for music").matches().executes();
        assertThat("get volume for alarm").matches().executes();
        assertThat("get volume for notify").matches().executes();
        assertThat("get volume for system").matches().executes();
        assertThat("get volume for call").matches().executes();
        assertThat("get volume for dtmf").matches().executes();
    }
}