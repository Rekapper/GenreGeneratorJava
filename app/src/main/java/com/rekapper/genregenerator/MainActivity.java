package com.rekapper.genregenerator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.newrelic.agent.android.NewRelic;
import java.util.Random;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       NewRelic.withApplicationToken(
               "AA73f27d11d8831436998c93ef190d43f0def5c6af"
       ).start(this.getApplication());

       //ads
       AdView mAdView = (AdView) findViewById(R.id.adView);
       AdRequest adRequest = new AdRequest.Builder().build();
       mAdView.loadAd(adRequest);

       //button trigger genre
       Button buttonGen = (Button) findViewById(R.id.buttonGenerator);
        buttonGen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TextView textGenre = (TextView) findViewById(R.id.textGenre);
                String[] preText = {
                        "Art", "Alternative", "College", "Experimental", "African", "Asian", "American",
                        "Caribbean", "Comedy", "Easy", "Electronic", "Ambient", "Acid", "Electro", "Nu",
                        "Italo", "Dub", "New", "Drum", "Trip", "Dark", "Liquid", "Neuro", "Bouncy", "Old", "Tech",
                        "Ragga", "Field", "Live", "Tape", "Berlin", "Seattle", "LA", "Micro", "Free", "Speed",
                        "Hard", "Deep", "Chicago", "Diva", "Dutch", "French", "Funky", "Ghetto", "Hip", "Latin",
                        "Minimal", "Prog", "Rave", "UK", "J", "US", "Aggro", "Industrial", "Post", "Space", "Dream",
                        "Uplifting", "Crunk", "East Coast", "Grime", "Trap", "West Coast", "Bossa", "Adult",
                        "Bubblegum", "K", "Surf", "Psychedelic", "Teen", "Wonky", "Soul", "Bass", "Doom", "Slow",
                        "Epic", "Punk", "Groove","Jazz","Arctic","Tribal","Country","Boogie","Hill Country",
                        "Medieval","Piano","Future","Classic","Chamber","Neo","Opera","Orchestra",
                        "Spanish","Disco","Funk","Digital","Liquid","Bro","Chill","Euro","Intelligent",
                        "Turntable","Nature","Anti","Traditional","Abstract","Cloud","Instrumental",
                        "Afro","Plunderphonic","Sunshine","Rhythm","Regional","Sludge","Symphonic",
                        "Thrash","Beat","Glam","Ska"
                };
                int idxPre = new Random().nextInt(preText.length);
                String[] postText = {
                        "Alternative", "Classical", "Jazz", "Pop", "House", "Noise", "Metal", "Hop", "HipHop",
                        "Trance", "Techno", "Lowercase", "Chiptune", "Garage", "Folk", "Nova", "Samba", "Salsa",
                        "Blues", "Funk", "Disco", "Swing", "Soul", "Core","Dub","Country","Waltz","Choral",
                        "Opera","Music","Beat","Club","Step","Jungle","Tronica","Gabber","Garage","Wave",
                        "Synth","Tune","Recordings","Dance","Gaze"
                };
                int idxPost = new Random().nextInt(postText.length);
                String Genre = (preText[idxPre] + "-" + postText[idxPost]);
                textGenre.setText(Genre);
            }
        });

       Button buttonTweet = (Button) findViewById(R.id.Tweet);
       final Context context = this;
           buttonTweet.setOnClickListener(new View.OnClickListener() {
               public void onClick(View view) {
                   TweetComposer.Builder builder = new TweetComposer.Builder(context)
                           .text("#" + ((TextView) findViewById(R.id.textGenre)).getText().toString() + " @Genre_Generator");
                   builder.show();
               }
           });

       Button buttonYT = (Button) findViewById(R.id.buttonYT);
       buttonYT.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
               Intent intent = new Intent(Intent.ACTION_SEARCH);
               intent.setPackage("com.google.android.youtube");
               intent.putExtra("query", ((TextView) findViewById(R.id.textGenre)).getText().toString());
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               startActivity(intent);
           }
       });
       Button buttonFB = (Button) findViewById(R.id.buttonFB);
       buttonFB.setOnClickListener(new View.OnClickListener(){
           public void onClick(View view){
               Intent share = new Intent(Intent.ACTION_SEND);
               share.setType("text/plain");
               share.putExtra(Intent.EXTRA_TEXT, ((TextView) findViewById(R.id.textGenre)).getText().toString());
               startActivity(Intent.createChooser(share, "Share"));
           }
       });
    }
}
