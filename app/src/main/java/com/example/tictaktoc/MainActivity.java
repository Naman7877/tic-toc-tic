package com.example.tictaktoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    boolean gameactive=true;


    // 0- x
    // 1- o
    int activeplayer=0;

    int [] gamestate={2,2,2,2,2,2,2,2,2};
    //state mean
    //0 - X
    //1 - o
    //2 - blank
    int [][] winpos= {{0,1,2}, {3,4,5}, {6,7,8},
                        {0,3,6}, {1,4,7}, {2,5,8},
                      {0,4,8}, {2,4,6}};

    public void playertap(View view)
    {
        ImageView img=(ImageView) view;
        int tappedimage=Integer.parseInt(img.getTag().toString());
        if(!gameactive)
        {
            gamereset(view);
        }

        if (gamestate[tappedimage]==2)
        {
            gamestate[tappedimage]=activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer==1)
            {
                img.setImageResource(R.drawable.x);
                activeplayer=0;
                TextView status=findViewById(R.id.status);
                status.setText("o's turn tap to play");
            }
            else
            {
                img.setImageResource(R.drawable.o);
                activeplayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("x's turn tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] winposition:winpos)
        {
            if (gamestate[winposition[0]]== gamestate[winposition[1]] && gamestate[winposition[1]]== gamestate[winposition[2]] && gamestate[winposition[0]]!=2)
            {
                String winnnerstr;
                gameactive=false;
                if(gamestate[winposition[0]]==0)
                {
                    winnnerstr=" o has won !";

                }
                else {
                    winnnerstr=" X has won !";
                }

                TextView status=findViewById(R.id.status);
                status.setText(winnnerstr);


            }

        }

    }

      public void gamereset(View view)
      {
          gameactive=true;
          activeplayer=0;
          for (int i=0;i<gamestate.length;i++)
          {
              gamestate[i]=2;
          }

          ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
          ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);



      }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView reset=findViewById(R.id.reset);
        getSupportActionBar().hide();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                gameactive=true;
                activeplayer=0;
                for (int i=0;i<gamestate.length;i++)
                {
                    gamestate[i]=2;
                }

                ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);

            }
        });
    }
}