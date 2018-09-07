package preferenciacorusuario.cursoandroid.com.preferenciacorusuario;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RadioGroup group;
    private Button botao;
    private RadioButton radio;
    private static final String ARQUIVO_PREFERENCIA = "ArqPreferencia";
    private RelativeLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (RelativeLayout) findViewById(R.id.layoutId);

        botao = (Button) findViewById(R.id.btnSalvaId);

        group = (RadioGroup) findViewById(R.id.rdgCorId);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRaioEsco = group.getCheckedRadioButtonId();




                if(idRaioEsco > 0){


                    radio = (RadioButton) findViewById(idRaioEsco);

                    SharedPreferences sharedPreferences  = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String corEscolhida = radio.getText().toString();
                    editor.putString("corEscolhida", corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);








                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("corEscolhida")){
            String corRecuperada = sharedPreferences.getString("corEscolhida","Laranja");

            setBackground(corRecuperada);
        }

    }

    private  void setBackground(String cor){


        if(cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#FF2447D4"));

        }else if(cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#009670"));


        }else if(cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ffce26"));
        }


    }


}
