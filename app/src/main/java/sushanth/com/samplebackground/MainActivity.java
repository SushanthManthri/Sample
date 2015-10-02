package sushanth.com.samplebackground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private int currImage =0;
 int[] images={R.mipmap.wallpaper_3,R.mipmap.wallpaper_4,R.mipmap.wallpaper_6,R.mipmap.wallpaper_7,R.mipmap.wallpaper_8,R.mipmap.wallpaper_9,R.mipmap.wallpaper_10};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeImageSwitcher();
        setInitialImage();
        setImageRotate();
    }

    private void intializeImageSwitcher() {
        final ImageSwitcher imageswitch= (ImageSwitcher)findViewById(R.id.imageSwitcher);
        imageswitch.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                return imageView;
            }
        });
        imageswitch.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        imageswitch.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right));
    }

    private void setImageRotate() {
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                currImage++;
                if(currImage==7){
                    currImage=0;
                }
             setCurrentImage();
            }
        });
    }

    private void setInitialImage() {
        setCurrentImage();
    }

    private void setCurrentImage() {
        final ImageSwitcher imageswitch= (ImageSwitcher)findViewById(R.id.imageSwitcher);
        imageswitch.setImageResource(images[currImage]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
