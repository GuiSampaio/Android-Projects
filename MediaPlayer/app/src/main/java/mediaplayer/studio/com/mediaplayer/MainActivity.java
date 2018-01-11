package mediaplayer.studio.com.mediaplayer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button botaoTocar;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoTocar = (Button) findViewById(R.id.botaoTocarId);
        mediaPlayer = MediaPlayer.create(this, R.raw.musica);

        botaoTocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mediaPlayer.isPlaying()){
                    pausarMusica();
                }else{
                    tocarMusica();
                }

            }
        });


    }

    private void tocarMusica(){

       if( mediaPlayer != null ){

           mediaPlayer.start();
           botaoTocar.setText("Pausar");
       }

    }

    private void pausarMusica(){

        if(mediaPlayer != null){

            mediaPlayer.pause();
            botaoTocar.setText("Tocar");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }
}
