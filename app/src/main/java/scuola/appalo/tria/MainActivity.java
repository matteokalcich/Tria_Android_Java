package scuola.appalo.tria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView img11;
    ImageView img12;
    ImageView img13;
    ImageView img21;
    ImageView img22;
    ImageView img23;
    ImageView img31;
    ImageView img32;
    ImageView img33;

    Button reset;

    TextView txtRisultato;

    Boolean player = false;

    Boolean finito = false;
    private ArrayList<String> tria               = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.resetBtn);

        img11        = findViewById(R.id.img11);
        img12        = findViewById(R.id.img12);
        img13        = findViewById(R.id.img13);
        img21        = findViewById(R.id.img21);
        img22        = findViewById(R.id.img22);
        img23        = findViewById(R.id.img23);
        img31        = findViewById(R.id.img31);
        img32        = findViewById(R.id.img32);
        img33        = findViewById(R.id.img33);
        txtRisultato = findViewById(R.id.txtRisultato);

        for(int i =0; i< 9; i++) {
            tria.add("-1");
        }

        txtRisultato.setText("GIOCA");

        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!finito){

                    mossa(0);
                }

            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!finito){

                    mossa(1);
                }
            }
        });
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!finito){

                    mossa(2);
                }
            }
        });
        img21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!finito){

                    mossa(3);
                }
            }
        });
        img22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!finito){

                    mossa(4);
                }
            }
        });
        img23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!finito){

                    mossa(5);
                }
            }
        });
        img31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!finito){

                    mossa(6);
                }
            }
        });
        img32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!finito){

                    mossa(7);
                }
            }
        });
        img33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!finito){

                    mossa(8);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clearAll();
            }
        });

    }

    public void clearAll(){
        for (int i = 0; i<9; i++){

            tria.set(i, "-1");

            img11.setImageDrawable(getDrawable(R.drawable.android));
            img12.setImageDrawable(getDrawable(R.drawable.android));
            img13.setImageDrawable(getDrawable(R.drawable.android));
            img21.setImageDrawable(getDrawable(R.drawable.android));
            img22.setImageDrawable(getDrawable(R.drawable.android));
            img23.setImageDrawable(getDrawable(R.drawable.android));
            img31.setImageDrawable(getDrawable(R.drawable.android));
            img32.setImageDrawable(getDrawable(R.drawable.android));
            img33.setImageDrawable(getDrawable(R.drawable.android));

        }

        txtRisultato.setText("GIOCA");
        finito = false;
    }

    public void mossa(int m) {
        if(tria.get(m).equals("-1")) {
            if (player) {
                switch (m) {
                    case 0:
                        img11.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 1:
                        img12.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 2:
                        img13.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 3:
                        img21.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 4:
                        img22.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 5:
                        img23.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 6:
                        img31.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 7:
                        img32.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 8:
                        img33.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                }
                tria.set(m, "1");
            } else {
                switch (m) {
                    case 0:
                        img11.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 1:
                        img12.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 2:
                        img13.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 3:
                        img21.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 4:
                        img22.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 5:
                        img23.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 6:
                        img31.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 7:
                        img32.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 8:
                        img33.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                }
                tria.set(m, "0");
            }
            player = !player;
        }

        vit();


    }

    public void vit(){

        int[][] winningCombinations = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };

        for (int[] combination : winningCombinations) {

            if (tria.get(combination[0]).equals("1") && tria.get(combination[1]).equals("1") && tria.get(combination[2]).equals("1")) {
                txtRisultato.setText("Vittoria di X");
                finito = true;
                break;
            }
            else if (tria.get(combination[0]).equals("0") && tria.get(combination[1]).equals("0") && tria.get(combination[2]).equals("0")) {
                txtRisultato.setText("Vittoria di 0");
                finito = true;
                break;
            }
        }

    }
}