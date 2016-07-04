package www.godchin.tool.media;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import java.io.IOException;

public class PlaySound {
    private static MediaPlayer player;
    private boolean flag;

    private PlaySound() {
    }//构造方法是私有的，从而避免外界利用构造方法直接创建任意多实例。

    public static PlaySound getInstance() {
        return Holder.SINGLETON;
    }

    private static class Holder {
        private static final PlaySound SINGLETON = new PlaySound();
    }

    /**
     * 调用方式:play("across.mp3",getResources().getAssets());
     *
     * @param filename 要播放的音频文件名
     * @param asm      AssetManager
     * @throws IOException
     */
    public void play(String filename, AssetManager asm) throws IOException {
        if (!flag) {
            flag = true;
            AssetFileDescriptor afd = asm.openFd(filename);
            player = new MediaPlayer();
            player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            player.prepare();
            player.start();
            player.setOnCompletionListener(new OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                    flag = false;
                }
            });
        }
    }
}
