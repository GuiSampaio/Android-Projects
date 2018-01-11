package linguagens.studio.com.linguagens;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listaLingua;
    private String[] linguagens = {
            "Go","JavaScript","Ruby",
            "Java","C","Swift","Python",
            "C++","C#","PHP","PERL","Visual Basic",
            "R","Ojective-C"
    };
    private String[] descText = {
            "Go info","JavaScript info","Ruby info",
            "Java info","C info","Swift info","Python info",
            "C++ info","C# info","PHP info","PERL info","Visual Basic info",
            "R info","Ojective-C info"
    };

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
        setContentView(R.layout.activity_main);

        listaLingua = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.activity_list_item,
                android.R.id.text1,
                linguagens
        );

        listaLingua.setAdapter(adaptador);

        listaLingua.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                int codPos = position;
                Intent intent = new Intent(MainActivity.this, Infos.class);

                intent.putExtra("descText", descText[codPos]);
                intent.putExtra("imagensId", codPos);

                startActivity( intent );

            }
        });



    }
}
