package scuola.appalo.tria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
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

    TextView txtRisultato;

    Boolean player = false;

    private ArrayList<String> tria               = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                mossa(0);
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(1);
            }
        });
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(2);
            }
        });
        img21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(3);
            }
        });
        img22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(4);
            }
        });
        img23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(5);
            }
        });
        img31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(6);
            }
        });
        img32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(7);
            }
        });
        img33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mossa(8);
            }
        });

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
                break;
            }
            else if (tria.get(combination[0]).equals("0") && tria.get(combination[1]).equals("0") && tria.get(combination[2]).equals("0")) {
                txtRisultato.setText("Vittoria di 0");
                break;
            }
        }

    }


    public void vittoria(){

        //riga 1

        if((tria.get(0).equals("0") && tria.get(1).equals("0") && tria.get(2).equals("0"))){

            txtRisultato.setText("Vittoria di 0");

        }

        //riga 2

        else if((tria.get(3).equals("0") && tria.get(4).equals("0") && tria.get(5).equals("0"))){

            txtRisultato.setText("Vittoria di 0");
        }

        //riga 3

        else if((tria.get(6).equals("0") && tria.get(7).equals("0") && tria.get(8).equals("0"))){

            txtRisultato.setText("Vittoria di 0");
        }

        //colonna 1

        else if((tria.get(0).equals("0") && tria.get(3).equals("0") && tria.get(6).equals("0"))){

            txtRisultato.setText("Vittoria di 0");
        }

        //colonna 2

        else if((tria.get(1).equals("0") && tria.get(4).equals("0") && tria.get(7).equals("0"))){

            txtRisultato.setText("Vittoria di 0");
        }

        //colonna 3

        else if((tria.get(2).equals("0") && tria.get(5).equals("0") && tria.get(8).equals("0"))){

            txtRisultato.setText("Vittoria di 0");
        }


        //diagonale 1

        else if((tria.get(0).equals("0") && tria.get(4).equals("0") && tria.get(8).equals("0"))){

            txtRisultato.setText("Vittoria di 0");
        }

        //diagonale 2

        else if((tria.get(2).equals("0") && tria.get(4).equals("0") && tria.get(6).equals("0"))){

            txtRisultato.setText("Vittoria di 0");
        }





        //riga 1

        if((tria.get(0).equals("1") && tria.get(1).equals("1") && tria.get(2).equals("1"))){

            txtRisultato.setText("Vittoria di X");

        }

        //riga 2

        else if((tria.get(3).equals("1") && tria.get(4).equals("1") && tria.get(5).equals("1"))){

            txtRisultato.setText("Vittoria di X");
        }

        //riga 3

        else if((tria.get(6).equals("1") && tria.get(7).equals("1") && tria.get(8).equals("1"))){

            txtRisultato.setText("Vittoria di X");
        }

        //colonna 1

        else if((tria.get(0).equals("1") && tria.get(3).equals("1") && tria.get(6).equals("1"))){

            txtRisultato.setText("Vittoria di X");
        }

        //colonna 2

        else if((tria.get(1).equals("1") && tria.get(4).equals("1") && tria.get(7).equals("1"))){

            txtRisultato.setText("Vittoria di X");
        }

        //colonna 3

        else if((tria.get(2).equals("1") && tria.get(5).equals("1") && tria.get(8).equals("1"))){

            txtRisultato.setText("Vittoria di X");
        }


        //diagonale 1

        else if((tria.get(0).equals("1") && tria.get(4).equals("1") && tria.get(8).equals("1"))){

            txtRisultato.setText("Vittoria di X");
        }

        //diagonale 2

        else if((tria.get(2).equals("1") && tria.get(4).equals("1") && tria.get(6).equals("1"))){

            txtRisultato.setText("Vittoria di X");
        }


    }
}