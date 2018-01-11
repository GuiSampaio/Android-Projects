package sqlite.studio.com.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);


            //Tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
            //bancoDados.execSQL("DROP TABLE pessoas");
            //Inserir dados tabela
            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Mopa', 40)");
            //bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Ann', 25)");
            //bancoDados.execSQL("UPDATE pessoas SET idade = 28 WHERE nome = 'Marcos' ");
            //bancoDados.execSQL("DELETE FROM pessoas WHERE nome = 'Marcos'");

            Cursor cursor = bancoDados.rawQuery("SELECT * FROM pessoas  ", null);

            int indiceColunaNome = cursor.getColumnIndex("nome");
            int indiceColunaIdade = cursor.getColumnIndex("idade");
            int indiceColunaID = cursor.getColumnIndex("id");
            cursor.moveToFirst();

            while (cursor != null) {

                Log.i("Resultado - nome: ", cursor.getString(indiceColunaNome));
                Log.i("Resultado - idade: ", cursor.getString(indiceColunaIdade));
                Log.i("Resultado - id: ", cursor.getString(indiceColunaID));
                cursor.moveToNext();


            }
        }catch (Exception e){

            e.printStackTrace();

        }


    }
}
