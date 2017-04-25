package com.example.yuans.testapplication.anim;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * 动画估值器
 * Created by yuans on 2017/3/2.
 */

public class AnimEvaluator implements TypeEvaluator<AnimPoint> {
    private String TAG="AnimEvaluator";
    @Override
    public AnimPoint evaluate(float t, AnimPoint startValue, AnimPoint endValue) {
        Log.e(TAG, "evaluate: startVaule x="+startValue.x+"  endValue x="+endValue.x+"   t="+t);
        float x = endValue.x;
        float y = endValue.y;
        switch (endValue.type) {
            case AnimPoint.MOVE_TO:
                x = endValue.x;
                y = endValue.y;
                break;
            case AnimPoint.LINE_TO:
                x = startValue.x + (endValue.x - startValue.x) * t;
                y = startValue.y + (endValue.y - startValue.y) * t;
                break;
            case AnimPoint.CURVE_TO:
                x = startValue.x * (1 - t) * (1 - t) * (1 - t)
                        + 3 * endValue.c0x * t * (1 - t) * (1 - t)
                        + 3 * endValue.c1x * t * t * (1 - t)
                        + endValue.x * t * t * t;

                y = startValue.y * (1 - t) * (1 - t) * (1 - t)
                        + 3 * endValue.c0y * t * (1 - t) * (1 - t)
                        + 3 * endValue.c1y * t * t * (1 - t)
                        + endValue.y * t * t * t;
                break;
        }
        return AnimPoint.moveTo(x, y);
    }
}
