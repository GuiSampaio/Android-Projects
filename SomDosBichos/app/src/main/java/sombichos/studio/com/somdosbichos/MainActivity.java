package sombichos.studio.com.somdosbichos;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

    private ImageView cao;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView ovelha;
    private ImageView vaca;
    private ImageView sonic;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cao = (ImageView) findViewById(R.id.caoId);
        gato = (ImageView) findViewById(R.id.gatoId);
        leao = (ImageView) findViewById(R.id.leaoId);
        macaco = (ImageView) findViewById(R.id.macacoId);
        ovelha = (ImageView) findViewById(R.id.ovelhaId);
        vaca = (ImageView) findViewById(R.id.vacaId);
        sonic = (ImageView) findViewById(R.id.sonicId);

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        ovelha.setOnClickListener(this);
        vaca.setOnClickListener(this);
        sonic.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

       switch ( view.getId() ){

           case R.id.caoId:
               mediaPlayer = MediaPlayer.create(this, R.raw.cao);
               tocarSom();
               break;
           case R.id.gatoId:
               mediaPlayer = MediaPlayer.create(this, R.raw.gato);
               tocarSom();
               break;
           case R.id.leaoId:
               mediaPlayer = MediaPlayer.create(this, R.raw.leao);
               tocarSom();
               break;
           case R.id.macacoId:
               mediaPlayer = MediaPlayer.create(this, R.raw.macaco);
               tocarSom();
               break;
           case R.id.ovelhaId:
               mediaPlayer = MediaPlayer.create(this, R.raw.ovelha);
               tocarSom();
               break;
           case R.id.vacaId:
               mediaPlayer = MediaPlayer.create(this, R.raw.vaca);
               tocarSom();
               break;
           case R.id.sonicId:
               mediaPlayer = MediaPlayer.create(this, R.raw.sonic);
               tocarSom();
               break;

       }


    }

    public void tocarSom(){
        if(mediaPlayer != null ){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(mediaPlayer != null ){
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }
}
