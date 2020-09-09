package com.example.yuans.testapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.yuans.testapplication.anim.AnimEvaluator;
import com.example.yuans.testapplication.anim.AnimPath;
import com.example.yuans.testapplication.anim.AnimPoint;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * 类注释
 */
public class ScrollingActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startAnimation();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //com.eric.kotlin.demo.HelloKotlinKt.main(new String[]{"eric"});
        //startAnimation();
    }

    private void startAnimation() {
        fab.setVisibility(View.VISIBLE);
        AnimPath animPath = new AnimPath();
        animPath.moveTo(0, 0);
        animPath.curveTo(-100, -250, -200, -260, -300, -50);
        animPath.curveTo(-450, -250, -500, -260, -600, 0);

        final ObjectAnimator fabAnim = ObjectAnimator.ofObject(this, "transFab", new AnimEvaluator(), animPath.getPoints().toArray()).setDuration(1000);
        fabAnim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(ScrollingActivity.this, DataBindActivity.class));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        fabAnim.start();
    }

    public void setTransFab(AnimPoint point) {
        fab.setTranslationX(point.x);
        fab.setTranslationY(point.y);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
