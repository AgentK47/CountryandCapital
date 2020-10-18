package com.agentk.countryandcapital;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.agentk.countryandcapital.Model.Country;

import agentk.com.countryandcapital.R;

public class CountryActivity extends AppCompatActivity {

    static ArrayList<Country> Countries= new ArrayList<Country>();
    ArrayList<Integer>Size=new ArrayList<Integer>();
    int[] puzzleState = new int[16];
    int rCountry;
    int tap;
    boolean tour=true;

    public void clickIn(View view) {
        ImageView counter = (ImageView) view;
       final int tappedView = Integer.parseInt(counter.getTag().toString());
   final     Country c=Countries.get(puzzleState[tappedView]);

        counter.setRotation(-90);
        int resID = getResources().getIdentifier(c.getFlag() , "drawable", getPackageName());
        counter.setImageResource(resID);
        counter.animate().rotation(0).setDuration(300);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
        if(tour){
            tap=tappedView;
            tour=!tour;
        }
        else{
            GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);
            ((ImageView) gridLayout.getChildAt(tap)).setRotation(-90);
            ((ImageView) gridLayout.getChildAt(tappedView)).setRotation(-90);
            if(puzzleState[tappedView]==puzzleState[tap]){
                Toast.makeText(getApplicationContext(),c.getName()+" "+c.getCapital(), Toast.LENGTH_LONG).show();

                ((ImageView) gridLayout.getChildAt(tap)).setImageResource(0);
                ((ImageView) gridLayout.getChildAt(tappedView)).setImageResource(0);

                ((ImageView) gridLayout.getChildAt(tap)).animate().rotation(0).setDuration(300);
                ((ImageView) gridLayout.getChildAt(tappedView)).animate().rotation(0).setDuration(300);

            }else {
                ((ImageView) gridLayout.getChildAt(tap)).setImageResource(R.drawable.motif);
                ((ImageView) gridLayout.getChildAt(tappedView)).setImageResource(R.drawable.motif);

                ((ImageView) gridLayout.getChildAt(tap)).animate().rotation(0).setDuration(300);
                ((ImageView) gridLayout.getChildAt(tappedView)).animate().rotation(0).setDuration(300);
            }
            tour=!tour;
        }
            }
        }, 2000);

    }

    private void applyRotation(float start, float end) {
// Find the center of image
        final float centerX = image1.getWidth() / 2.0f;
        final float centerY = image1.getHeight() / 2.0f;

// Create a new 3D rotation with the supplied parameter
// The animation listener is used to trigger the next animation
        final Flip3dAnimation rotation =
                new Flip3dAnimation(start, end, centerX, centerY);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(isFirstImage, image1, image2));

        if (isFirstImage)
        {
            image1.startAnimation(rotation);
        } else {
            image2.startAnimation(rotation);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        AddCountries();
        Arrays.fill(puzzleState, 0);
        fillPuzzle();

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout);

        for (int i = 0; i< gridLayout.getChildCount(); i++) {

            ((ImageView) gridLayout.getChildAt(i)).setImageResource(R.drawable.motif);

        }




    }

    public void imageGrid(){
        Random rand = new Random();
        Size.add(rCountry);
        for(int j=0;j<2;j++) {
            int a = rand.nextInt(puzzleState.length);
            if (puzzleState[a] == 0) {
                puzzleState[a] = rCountry;
            } else {
                a = rand.nextInt(puzzleState.length);
                while (puzzleState[a] != 0) {
                    a = rand.nextInt(puzzleState.length);
                }
                puzzleState[a] = rCountry;
            }
        }
    }

    public void fillPuzzle(){
        for(int i=0;i<puzzleState.length/2;i++) {
            Random rand = new Random();
            rCountry = rand.nextInt(18);
            if(Size.contains(rCountry)){
                rCountry = rand.nextInt(18);
                while (Size.contains(rCountry)){
                    rCountry = rand.nextInt(18);
                }
                imageGrid();
            }
            else{
                imageGrid();
            }
        }
    }

    public void AddCountries(){
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("United Arab Emirates","Abu Dhabi","ae"));
        Countries.add(new Country("Afghanistan","Kabul","af"));
        Countries.add(new Country("Antigua and Barbuda","St. John's","ag"));
        Countries.add(new Country("Albania","Tirana","al"));
        Countries.add(new Country("Armenia","Yerevan","am"));
        Countries.add(new Country("Angola","Luanda","ao"));
        Countries.add(new Country("Argentina","Buenos Aires","ar"));
        Countries.add(new Country("Austria","Vienna","at"));
        Countries.add(new Country("Australia","Canberra","au"));
        Countries.add(new Country("Azerbaijan","Baku","az"));
        Countries.add(new Country("Bosnia and Herzegovina","Sarajevo","ba"));
        Countries.add(new Country("Barbados","Bridgetown","bb"));
        Countries.add(new Country("Bangladesh","Dhaka","bd"));
        Countries.add(new Country("Belgium","Brussels","be"));
        Countries.add(new Country("Burkina Faso","Ouagadougou","bf"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
        Countries.add(new Country("Andorra","Andorra la Vella","ad"));
    }
}
