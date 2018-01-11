package listview.studio.com.listview;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView listaDeItens;
    private String[] itens =    {   "Angra","Caldas","Campos","Costa","Ilheus",
                                    "Porto","Rio de Janeiro","Tiradentes","Praga","Santiago",
                                    "Zurique"
                                };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaDeItens = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.activity_list_item,
                android.R.id.text1,
                itens

        );

        listaDeItens.setAdapter(adaptador);

        listaDeItens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                int codPosicao = position;
                String valorClicado = (String) listaDeItens.getItemAtPosition(codPosicao);

                Toast.makeText(getApplicationContext(), valorClicado, Toast.LENGTH_SHORT ).show();

            }
        });

    }
}
