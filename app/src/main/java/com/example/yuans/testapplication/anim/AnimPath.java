package com.example.yuans.testapplication.anim;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 自定义动画框架的动画路径类(用于封装一系列动画的起始点信息)
 * Created by yuans on 2017/3/2.
 */

public class AnimPath {
    private ArrayList<AnimPoint> mPaths = new ArrayList<>();

    public void moveTo(int x, int y) {
        mPaths.add(AnimPoint.moveTo(x, y));
    }

    public void lineTo(int x, int y) {
        mPaths.add(AnimPoint.lineTo(x, y));
    }

    public void curveTo(int c0x, int c0y, int c1x, int c1y, int x, int y) {
        mPaths.add(AnimPoint.curveTo(c0x, c0y, c1x, c1y, x, y));
    }

    public Collection<AnimPoint> getPoints() {
        return mPaths;
    }
}
