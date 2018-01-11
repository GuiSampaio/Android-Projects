package linguagens.studio.com.linguagens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Infos extends AppCompatActivity {

    private TextView texto;
    private ImageView langImage;
    private int[] imagensId = new int[] {

            R.drawable.go,
            R.drawable.js,
            R.drawable.ruby,
            R.drawable.java,
            R.drawable.c,
            R.drawable.swift,
            R.drawable.python,
            R.drawable.cpp,
            R.drawable.csharp,
            R.drawable.php,
            R.drawable.perl,
            R.drawable.vb,
            R.drawable.r,
            R.drawable.objective_c
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);


        texto = (TextView) findViewById(R.id.textViewId);
        langImage = (ImageView) findViewById(R.id.imageViewLogoId);

        Bundle extra = getIntent().getExtras();
        if( extra != null ){

            String linguagemEscolhida = extra.getString("descText");
            int pic = extra.getInt("imagensId", 0);
            
            langImage.setImageResource(imagensId[pic]);
            texto.setText(linguagemEscolhida);

        }


    }
}
