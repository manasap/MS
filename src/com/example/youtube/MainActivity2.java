package com.example.youtube;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

	static private final String DEVELOPER_KEY = "AIzaSyAfnzhBO-Nzj119V3gdV4LpWaTRGGSyE0A";
	static private final String VIDEO = "4SK0cUNMnMM";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//YouTubePlayerView youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
	    //youTubeView.initialize(DEVELOPER_KEY, this);
	  
		 Intent videoIntent = YouTubeStandalonePlayer.createVideoIntent(MainActivity2.this, DEVELOPER_KEY, VIDEO, 0, true, false);

		    startActivityForResult(videoIntent, 1);
	
	}

	@Override
	public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
		Toast.makeText(this, "Oh no! "+error.toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
		Bundle b = getIntent().getExtras();
		String value = b.getString("key");
	

	   
	         
	    
		
	    
		player.loadVideo(value);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);

	    if (requestCode == 1 && resultCode != RESULT_OK) {
	        YouTubeInitializationResult errorReason = YouTubeStandalonePlayer.getReturnedInitializationResult(data);
	        if (errorReason.isUserRecoverableError()) {
	            errorReason.getErrorDialog(this, 0).show();
	        } else {
	            String errorMessage = String.format("PLAYER ERROR!!", errorReason.toString());
	            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
	        }
	    }
	}

}
